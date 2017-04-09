package com.tms.controller;

import java.util.List;

public class Table<T> {
	public Table() {
		
	}
	public Table(List<T> data) {
		this.data = data;
	}
private List<T> data;

public List<T> getData() {
	return data;
}

public void setData(List<T> data) {
	this.data = data;
}
}
