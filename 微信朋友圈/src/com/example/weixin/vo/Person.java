package com.example.weixin.vo;

import java.io.Serializable;

public class Person implements Serializable{
	private String total,per_page,current_page;
	private String content,group_id,stickied,created_at,id,up,total_replies,visits;
	private String a_id,username,avatar,medal_id,medal_desc;
	private String g_id,title;
	private String replies;
	private String url,mime,width,hieght,thumb;
	private String last_id,last_username,last_avatar,last_medal_id,last_medal_desc;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getPer_page() {
		return per_page;
	}
	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}
	public String getCurrent_page() {
		return current_page;
	}
	public void setCurrent_page(String current_page) {
		this.current_page = current_page;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getStickied() {
		return stickied;
	}
	public void setStickied(String stickied) {
		this.stickied = stickied;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUp() {
		return up;
	}
	public void setUp(String up) {
		this.up = up;
	}
	public String getTotal_replies() {
		return total_replies;
	}
	public void setTotal_replies(String total_replies) {
		this.total_replies = total_replies;
	}
	public String getVisits() {
		return visits;
	}
	public void setVisits(String visits) {
		this.visits = visits;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getMedal_id() {
		return medal_id;
	}
	public void setMedal_id(String medal_id) {
		this.medal_id = medal_id;
	}
	public String getMedal_desc() {
		return medal_desc;
	}
	public void setMedal_desc(String medal_desc) {
		this.medal_desc = medal_desc;
	}
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String g_id) {
		this.g_id = g_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReplies() {
		return replies;
	}
	public void setReplies(String replies) {
		this.replies = replies;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMime() {
		return mime;
	}
	public void setMime(String mime) {
		this.mime = mime;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHieght() {
		return hieght;
	}
	public void setHieght(String hieght) {
		this.hieght = hieght;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getLast_id() {
		return last_id;
	}
	public void setLast_id(String last_id) {
		this.last_id = last_id;
	}
	public String getLast_username() {
		return last_username;
	}
	public void setLast_username(String last_username) {
		this.last_username = last_username;
	}
	public String getLast_avatar() {
		return last_avatar;
	}
	public void setLast_avatar(String last_avatar) {
		this.last_avatar = last_avatar;
	}
	public String getLast_medal_id() {
		return last_medal_id;
	}
	public void setLast_medal_id(String last_medal_id) {
		this.last_medal_id = last_medal_id;
	}
	public String getLast_medal_desc() {
		return last_medal_desc;
	}
	public void setLast_medal_desc(String last_medal_desc) {
		this.last_medal_desc = last_medal_desc;
	}
	@Override
	public String toString() {
		return "Person [total=" + total + ", per_page=" + per_page
				+ ", current_page=" + current_page + ", content=" + content
				+ ", group_id=" + group_id + ", stickied=" + stickied
				+ ", created_at=" + created_at + ", id=" + id + ", up=" + up
				+ ", total_replies=" + total_replies + ", visits=" + visits
				+ ", a_id=" + a_id + ", username=" + username + ", avatar="
				+ avatar + ", medal_id=" + medal_id + ", medal_desc="
				+ medal_desc + ", g_id=" + g_id + ", title=" + title
				+ ", replies=" + replies + ", url=" + url + ", mime=" + mime
				+ ", width=" + width + ", hieght=" + hieght + ", thumb="
				+ thumb + ", last_id=" + last_id + ", last_username="
				+ last_username + ", last_avatar=" + last_avatar
				+ ", last_medal_id=" + last_medal_id + ", last_medal_desc="
				+ last_medal_desc + "]";
	}
	
}
