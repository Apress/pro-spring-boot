package com.apress.spring.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Journal {
	
	private Long id;
	private String title;
	private Date created;
	private String summary;
	
	private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public Journal(Long id, String title, String summary, Date date){
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.created = date;
	}
	
	Journal(){}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getCreatedAsShort(){
		return format.format(created);
	}
	
	public String toString(){
		StringBuilder value = new StringBuilder("* JournalEntry(");
		value.append("Id: ");
		value.append(id);
		value.append(",Title: ");
		value.append(title);
		value.append(",Summary: ");
		value.append(summary);
		value.append(",Created: ");
		value.append(getCreatedAsShort());
		value.append(")");
		return value.toString();
	}
}
