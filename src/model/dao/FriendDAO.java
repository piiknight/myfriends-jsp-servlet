package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.Category;
import model.bean.Friend;
import util.DatabaseConnection;
import util.StringUtil;

public class FriendDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public ArrayList<Friend> getAnotherFriends (int id_fl, int id_f){
		ArrayList<Friend> items = new ArrayList<>();
		String sql = "SELECT fid, fname, preview, detail, date_create, count_number, picture, friend_list.fl_id, fl_name" + 
					" FROM friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id" + 
					" WHERE friend_list.fl_id = ? AND fid != ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_fl);
			pst.setInt(2, id_f);
			rs = pst.executeQuery();
			
			// Thêm sửa xóa category
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				Timestamp date_create = rs.getTimestamp("date_create");
				int count_number = rs.getInt("count_number");
				String fl_name = rs.getString("fl_name");
				Category category = new Category(id_fl, fl_name);
				Friend friend = new Friend(fid, fname, preview, detail, date_create, count_number, picture, category);
				items.add(friend);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if(rs != null && pst !=null && conn !=null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return items;
		
	}
	
	private Timestamp getDateCreate(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String time = sdf.format(timestamp);
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp ret = new Timestamp(date.getTime());
		return ret;
	}

	public ArrayList<Friend> getItemsByFlID(int fl_id) {
		ArrayList<Friend> items = new ArrayList<>();
		String sql = "SELECT fid, fname, preview, detail, date_create, count_number, picture, friend_list.fl_id, fl_name" + 
				" FROM friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id" + 
				" WHERE friend_list.fl_id = ?";
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, fl_id);
			rs = pst.executeQuery();
			
			// Thêm sửa xóa category
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				Timestamp date_create = rs.getTimestamp("date_create");
				int count_number = rs.getInt("count_number");
				String fl_name = rs.getString("fl_name");
				Category category = new Category(fl_id, fl_name);
				Friend friend = new Friend(fid, fname, preview, detail, date_create, count_number, picture, category);
				
				items.add(friend);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if(rs != null && pst !=null && conn !=null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}
	
	public Friend getItemByID(int id) {
		Friend item = null;
		String sql = "SELECT fid, fname, preview, detail, date_create, count_number, picture, friend_list.fl_id, fl_name" + 
				" FROM friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id" + 
				" WHERE fid = ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			// Thêm sửa xóa category
			if(rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				Timestamp date_create = rs.getTimestamp("date_create");
				int count_number = rs.getInt("count_number");
				int fl_id = rs.getInt("fl_id");
				String fl_name = rs.getString("fl_name");
				
				Category category = new Category(fl_id, fl_name);
				item = new Friend(fid, fname, preview, detail, date_create, count_number, picture, category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if(rs != null && pst !=null && conn !=null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return item;
	}
	
	public ArrayList<Friend> getItems() {
		ArrayList<Friend> items = new ArrayList<>();
		String sql = "SELECT fid, fname, preview, detail, date_create, count_number, picture, friend_list.fl_id, fl_name" + 
				" FROM friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id";
		
		try {
			// Tạo đường đi đến DB
			conn = DatabaseConnection.getConnection();
			// Tạo bộ thực thi câu lệnh sql
			st = conn.createStatement();
			// Thực thi truy vấn sql (select)
			rs = st.executeQuery(sql);
			
			// Thêm sửa xóa category
			while(rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				Timestamp date_create = rs.getTimestamp("date_create");
				int count_number = rs.getInt("count_number");
				int fl_id = rs.getInt("fl_id");
				String fl_name = rs.getString("fl_name");
				
				Category category = new Category(fl_id, fl_name);
				Friend friend = new Friend(fid, fname, preview, detail, date_create, count_number, picture, category);
				items.add(friend);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if(rs != null && st !=null && conn !=null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}
	
}

