/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Quade
 */
public class User {
	private String mUsername = null;

	private User() { }

	public User(String username, String password) {
			checkDatabase(username, password);
	}

	public String getUsername() { return mUsername; }

	private void checkDatabase(String username, String password) {
		JSONParser parser = new JSONParser();
		
		try {
			String filePath = this.getClass().getResource("userDatabase.json")
					.toString().substring(5);

			JSONArray users = (JSONArray) parser.parse(new FileReader(filePath));

			for (Object o : users) {
				JSONObject user = (JSONObject) o;

				if (user.get("username").equals(username) &&
						user.get("password").equals(password)) {
					mUsername = username;
					break;
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
