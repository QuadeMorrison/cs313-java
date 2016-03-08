/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;
import model.CommentDataHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Quade
 */
public class DatabaseUtil {
	private DatabaseUtil() { }
	public static List<Comment> load() {
		CommentDataHandler commentData = CommentDataHandler.getInstance();

		if (commentData == null) {
			loadComments(parseJSON());
		}

		return commentData.getComments();
	}

	public static void write() {
		writeComments(commentToJSON());
	}

	private static void writeComments(JSONArray commentsJSON) {
		try(FileWriter file = new FileWriter(getFilePath())) {
			file.write(commentsJSON.toJSONString());
		} catch (IOException ex) {
			Logger.getLogger(DatabaseUtil.class.getName()).
					log(Level.SEVERE, null, ex);
		}
	}

	private static JSONArray commentToJSON() {
		JSONArray commentsJSON = new JSONArray();
		CommentDataHandler commentData = CommentDataHandler.getInstance();

		if (commentData.getComments() != null) {
			for (Comment c : commentData.getComments()) {
				JSONObject o = new JSONObject();
				o.put("username", c.getUsername());
				o.put("date", c.getDate());
				o.put("comment", c.getComment());

				commentsJSON.add(o);
			}
		}

		return commentsJSON;
	}

	private static void loadComments(JSONArray commentsJSON) {
		if (commentsJSON != null) {

			for (Object o : commentsJSON) {
				JSONObject comment = (JSONObject) o;
				
				CommentDataHandler.getInstance()
						.add(comment.get("username").toString(),
							 comment.get("date").toString(),
							 comment.get("comment").toString());
			}
		}
	}

	private static JSONArray parseJSON() {
		try {
			JSONParser parser = new JSONParser();
			return (JSONArray) parser
					.parse(new FileReader(getFilePath()));
		} catch (IOException | ParseException ex) {
			Logger.getLogger(DatabaseUtil.class.getName())
					.log(Level.SEVERE, null, ex);
		} 

		return null;
	} 

	private static String getFilePath() {
		return DatabaseUtil.class.getClassLoader()
				.getResource("/model/commentDatabase.json")
				.toString().substring(5);
	}
}
