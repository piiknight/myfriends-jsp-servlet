package model.bean;

public class Category {
	private int fl_id;
	private String fl_name;

	public int getFl_id() {
		return fl_id;
	}

	public void setFl_id(int fl_id) {
		this.fl_id = fl_id;
	}

	public String getFl_name() {
		return fl_name;
	}

	public void setFl_name(String fl_name) {
		this.fl_name = fl_name;
	}

	public Category(int fl_id, String fl_name) {
		super();
		this.fl_id = fl_id;
		this.fl_name = fl_name;
	}

	public Category() {
		super();
	}

}
