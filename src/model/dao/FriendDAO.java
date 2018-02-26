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

import constant.Define;
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
				" FROM friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id ORDER BY fid DESC";
		
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

	public int addItem(Friend friend) {
		int row = 0;
		String sql = "INSERT INTO friends(fname, preview, detail, date_create, fl_id, count_number, picture)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, friend.getFname());
			pst.setString(2, friend.getPreview());
			pst.setString(3, friend.getDetail());
			pst.setTimestamp(4, friend.getDate_create());
			pst.setInt(5, friend.getCategory().getFl_id());
			pst.setInt(6, friend.getCount_number());
			pst.setString(7, friend.getPicture());
			
			row = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if(pst !=null && conn !=null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return row;
	}

	public int editItem(Friend friend) {
		int row = 0;
		String sql = "UPDATE friends SET fname = ?, preview = ?, detail = ?, picture = ?, fl_id = ? WHERE fid = ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, friend.getFname());
			pst.setString(2, friend.getPreview());
			pst.setString(3, friend.getDetail());
			pst.setString(4, friend.getPicture());
			pst.setInt(5, friend.getCategory().getFl_id());
			pst.setInt(6, friend.getFid());
			
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null && pst != null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return row;
	}

	public int delItem(Friend friend) {
		int row = 0;
		String sql = "DELETE FROM friends WHERE fid = ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, friend.getFid());
			
			row = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if(pst !=null && conn !=null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return row;
	}

	public int countFriend() {
		int result = 0;
		String sql = "SELECT COUNT(*) AS sumFriend FROM "
				+ "friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id ";
	
		try {
			conn = DatabaseConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("sumFriend");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && st != null && rs != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return result;
	}
	
	public ArrayList<Friend> getItemsPagination(int offset) {
		ArrayList<Friend> friends = new ArrayList<>();;
		String sql = "SELECT fid, fname, preview, detail, date_create, count_number, picture, friend_list.fl_id AS cat_id, fl_name FROM "
				+ "friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id"
				+ " ORDER BY fid DESC LIMIT ?, ?";
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, Define.ROW_PAGINATION_FRIEND);
			rs = pst.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				Timestamp date_create = rs.getTimestamp("date_create");
				int count_number = rs.getInt("count_number");
				String fl_name = rs.getString("fl_name");
				int fl_id = rs.getInt("cat_id");
				Category category = new Category(fl_id, fl_name);
				Friend friend = new Friend(fid, fname, preview, detail, date_create, count_number, picture, category);
				friends.add(friend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null && rs != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return friends;
	}

	public ArrayList<Friend> getItemsPaginationByFlID(int id, int offset) {
		ArrayList<Friend> friends = new ArrayList<>();;
		String sql = "SELECT fid, fname, preview, detail, date_create, count_number, picture, friend_list.fl_id AS cat_id, fl_name FROM "
				+ "friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id WHERE friends.fl_id = ?"
				+ " ORDER BY fid DESC LIMIT ?, ?";
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, offset);
			pst.setInt(3, Define.ROW_PAGINATION_FRIEND);
			rs = pst.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				Timestamp date_create = rs.getTimestamp("date_create");
				int count_number = rs.getInt("count_number");
				String fl_name = rs.getString("fl_name");
				int fl_id = rs.getInt("cat_id");
				Category category = new Category(fl_id, fl_name);
				Friend friend = new Friend(fid, fname, preview, detail, date_create, count_number, picture, category);
				friends.add(friend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null && rs != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return friends;
	}
	
	public int countFriendByFlID(int id) {
		int result = 0;
		String sql = "SELECT COUNT(*) AS sumFriend FROM "
				+ "friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id WHERE friends.fl_id = ?";
	
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getInt("sumFriend");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null && rs != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return result;
	}
	
	public ArrayList<Friend> getItemsPaginationInvolve(int id_f, int id_fl , int offset) {
		ArrayList<Friend> friends = new ArrayList<>();;
		String sql = "SELECT fid, fname, preview, detail, date_create, count_number, picture, friend_list.fl_id AS cat_id, fl_name FROM "
				+ " friends INNER JOIN friend_list ON friends.fl_id = friend_list.fl_id WHERE friends.fl_id = ? AND fid != ?"
				+ " ORDER BY fid DESC LIMIT ?, ?";
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_fl);
			pst.setInt(2, id_f);
			pst.setInt(3, offset);
			pst.setInt(4, Define.ROW_PAGINATION_FRIEND_INVOLVE);
			rs = pst.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("fid");
				String fname = rs.getString("fname");
				String preview = rs.getString("preview");
				String detail = rs.getString("detail");
				String picture = rs.getString("picture");
				Timestamp date_create = rs.getTimestamp("date_create");
				int count_number = rs.getInt("count_number");
				String fl_name = rs.getString("fl_name");
				int fl_id = rs.getInt("cat_id");
				Category category = new Category(fl_id, fl_name);
				Friend friend = new Friend(fid, fname, preview, detail, date_create, count_number, picture, category);
				friends.add(friend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && pst != null && rs != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		return friends;
	}
}

