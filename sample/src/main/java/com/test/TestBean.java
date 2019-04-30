package com.test;

public class TestBean {
	private int id;
	private String name;
	private byte by;
	private short st;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private byte getBy() {
		return by;
	}

	private short getSt() {
		return st;
	}

	public void setId(int id,String sss) {
		this.id = id;
		this.name=sss;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBy(byte by) {
		this.by = by;
	}
	public void setSt(short st) {
		this.st = st;
	}


}
