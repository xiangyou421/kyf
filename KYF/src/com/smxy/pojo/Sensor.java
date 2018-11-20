package com.smxy.pojo;

public class Sensor {
	private int id;
	private String TEM;
	private String HUM;
	private String SMO;
	private String TIME;
	public Sensor() {
		super();
	}
	public Sensor(int id, String tEM, String hUM, String sMO, String tIME) {
		super();
		this.id = id;
		TEM = tEM;
		HUM = hUM;
		SMO = sMO;
		TIME = tIME;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTEM() {
		return TEM;
	}
	public void setTEM(String tEM) {
		TEM = tEM;
	}
	public String getHUM() {
		return HUM;
	}
	public void setHUM(String hUM) {
		HUM = hUM;
	}
	public String getSMO() {
		return SMO;
	}
	public void setSMO(String sMO) {
		SMO = sMO;
	}
	public String getTIME() {
		return TIME;
	}
	public void setTIME(String tIME) {
		TIME = tIME;
	}
	
}
