package com.rsy.entity;

public class Hero {
	
	private int id;
	private String head;
	private String hero;
	private String honor;
	private String local1;
	private String local2;
	private String local3;
	private String story;
	private String skin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getHero() {
		return hero;
	}
	public void setHero(String hero) {
		this.hero = hero;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getLocal1() {
		return local1;
	}
	public void setLocal1(String local1) {
		this.local1 = local1;
	}
	public String getLocal2() {
		return local2;
	}
	public void setLocal2(String local2) {
		this.local2 = local2;
	}
	public String getLocal3() {
		return local3;
	}
	public void setLocal3(String local3) {
		this.local3 = local3;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", head=" + head + ", hero=" + hero + ", honor=" + honor + ", local1=" + local1
				+ ", local2=" + local2 + ", local3=" + local3 + ", story=" + story + ", skin=" + skin + "]";
	}
	
	
}
