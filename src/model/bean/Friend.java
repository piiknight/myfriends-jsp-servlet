package model.bean;

import java.sql.Timestamp;

public class Friend {
	private int fid;
	private String fname;
	private String preview;
	private String detail;
	private Timestamp date_create;
	private int count_number;
	private String picture;
	private Category category;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getDate_create() {
		return date_create;
	}

	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

	public int getCount_number() {
		return count_number;
	}

	public void setCount_number(int count_number) {
		this.count_number = count_number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Friend(int fid, String fname, String preview, String detail, Timestamp date_create, int count_number,
			String picture, Category category) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.preview = preview;
		this.detail = detail;
		this.date_create = date_create;
		this.count_number = count_number;
		this.picture = picture;
		this.category = category;
	}

	public Friend() {
		super();
	}

	@Override
	public String toString() {
		return "Friend [fid=" + fid + ", fname=" + fname + ", preview=" + preview + ", detail=" + detail
				+ ", date_create=" + date_create + ", count_number=" + count_number + ", picture=" + picture
				+ ", category=" + category + "]";
	}

}
