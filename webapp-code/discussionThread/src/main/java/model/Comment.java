/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

/**
 *
 * @author Quade
 */
public class Comment {
	String username = null;
	String date = null;
	String comment = null;
	
	private Comment() { }
	
	public Comment(String username, String date, String comment) {
		this.username = username;
		this.date = date;
		this.comment = comment;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "<span class='commentName'>" + username + "</span>" +
			   "<span class='commentDate'>" + date + "</span>" +
			   "<span class='comment'>" + comment + "</span>";
	}
}