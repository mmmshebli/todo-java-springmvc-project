package com.in28minutes.todo;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {

	private int id;
	private String name;
	@Size( min=6, message="Enter at least 6 characters")
	private String desc;
	private Date targetDate;
	private boolean isDone;
	public int getId() {
		return id;
	}
	
	public Todo() {
		super();
	}
	
	public Todo(int id, String name, String desc, Date targetDate,
			boolean isDone) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}



	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", targetDate=" + targetDate + ", isDone=" + isDone + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
