package com.apress.spring.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JournalEntry {
	
	private String title;
	private Date created;
	private String summary;
	
	private final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	public JournalEntry(String title, String summary, String date) throws ParseException{
		this.title = title;
		this.summary = summary;
		this.created = format.parse(date);
	}
	
	JournalEntry(){}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(String date) throws ParseException{
		Long _date = null;
		try{
			_date = Long.parseLong(date);
			this.created = new Date(_date);
			return;
		}catch(Exception ex){}
		this.created = format.parse(date);
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String toString(){
		StringBuilder value = new StringBuilder("* JournalEntry(");
		value.append("Title: ");
		value.append(title);
		value.append(",Summary: ");
		value.append(summary);
		value.append(",Created: ");
		value.append(format.format(created));
		value.append(")");
		return value.toString();
	}
}
