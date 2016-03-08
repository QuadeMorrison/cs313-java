/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quade
 */
public class CommentDataHandler {
	private static CommentDataHandler instance = null;
	private static List<Comment> comments = null;

	private CommentDataHandler() { }

	public static synchronized CommentDataHandler getInstance() {
		if (instance == null) {
			instance = new CommentDataHandler();
		}

		return instance;
	}

	public List<Comment> getComments() { return comments; }

	public void add(String username, String date, String comment) {
		if (comments == null) {
			comments = new ArrayList<>();
		}

		comments.add(new Comment(username, date, comment));
	}

}
