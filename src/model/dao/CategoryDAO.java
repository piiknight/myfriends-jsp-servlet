package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import constant.Define;
import model.bean.Category;
import util.DatabaseConnection;

public class CategoryDAO {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ArrayList<Category> getItems() {
		ArrayList<Category> categories = new ArrayList<>();
		String sql = "SELECT fl_id, fl_name FROM friend_list";
		
		try {
			conn = DatabaseConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				categories.add(new Category(rs.getInt("fl_id"), rs.getString("fl_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return categories;
	}

	public int addItem(Category category) {
		int row = 0;
		String sql = "INSERT INTO friend_list(fl_name) VALUES (?)";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, category.getFl_name());
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
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

	public Category getItemByName(String name) {
		Category category = null;
		String sql = "SELECT fl_id, fl_name FROM friend_list WHERE fl_name = ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if (rs.next()) {
				category = new Category(rs.getInt("fl_id"), rs.getString("fl_name"));
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
		return category;
	}

	public Category getItem(int id) {
		Category category = null;
		String sql = "SELECT fl_id, fl_name FROM friend_list WHERE fl_id = ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				category = new Category(rs.getInt("fl_id"), rs.getString("fl_name"));
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
		return category;
	}

	public int editItem(Category category) {
		int row = 0;
		String sql = "UPDATE friend_list SET fl_name = ? WHERE fl_id = ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, category.getFl_name());
			pst.setInt(2, category.getFl_id());
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
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

	public int delItem(Category category) {
		int row = 0;
		String sql = "DELETE FROM friend_list WHERE fl_id = ?";
		
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, category.getFl_id());
			row = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
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
	
	public int countCat() {
		int result = 0;
		String sql = "SELECT COUNT(*) AS sumCat FROM friend_list";
	
		try {
			conn = DatabaseConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("sumCat");
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

	public ArrayList<Category> getItemsPagination(int offset) {
		ArrayList<Category> categories = new ArrayList<>();;
		String sql = "SELECT fl_id, fl_name FROM friend_list ORDER BY fl_id DESC LIMIT ?, ? ";
				
		try {
			conn = DatabaseConnection.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, Define.ROW_PAGINATION_CAT);
			rs = pst.executeQuery();
			while (rs.next()) {
				int fl_id = rs.getInt("fl_id");
				String fl_name = rs.getString("fl_name");
				Category category = new Category(fl_id, fl_name);
				categories.add(category);
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
		return categories;
	}
	
}
