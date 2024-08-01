package com.test.checkListner.entity;


import java.sql.Timestamp;
import javax.persistence.*;


@Entity
@Table(name = "testListener")
public class TableData {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id")
private Long id;
@Column(name="data")
private String data;
@Column(name="processed")
private boolean processed;
@Column(name="updatedAt")
private java.sql.Timestamp updatedAt;

public TableData() {

}


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public boolean isProcessed() {
	return processed;
}

public void setProcessed(boolean processed) {
	this.processed = processed;
}

public Timestamp getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Timestamp updatedAt) {
	this.updatedAt = updatedAt;
}

public TableData(Long id, String data, boolean processed, Timestamp updatedAt) {
	this.id = id;
	this.data = data;
	this.processed = processed;
	this.updatedAt = updatedAt;
}

@Override
public String toString() {
	return "TableData{" +
		"id=" + id +
		", data='" + data + '\'' +
		", processed=" + processed +
		", updatedAt=" + updatedAt +
		'}';
}
}
