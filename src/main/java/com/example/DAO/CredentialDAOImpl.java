package com.example.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.Credential;
import com.example.Utility.DBConnection;

public class CredentialDAOImpl implements CredentialDAO {

	public void addCredential(Credential credential) {
		String query = "INSERT into credentials (id, platform, username, password,date) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
			stmt.setInt(1, credential.getId());
			stmt.setString(2, credential.getPlatform());
			stmt.setString(3, credential.getUsername());
			stmt.setString(4, credential.getPassword());
			stmt.setString(5, credential.getDate());
			stmt.executeUpdate();
			System.out.println("\nCredential's Saved Successfully....");
			stmt.close();
		} catch (SQLException e) {
			System.out.println("\nError...Credentials not added ");
			e.printStackTrace();
		}
	}

	public List<Credential> getAllCredential() {
		String query = "SELECT * from credentials";
		List<Credential> credential = new ArrayList<Credential>();

		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String platform = rs.getString("platform");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String date = rs.getString("date");

				credential.add(new Credential(id, platform, username, password, date));

			}
		} catch (SQLException e) {
			System.out.println("Error Cannot Show Data...");
			e.printStackTrace();
		}

		return credential;
	}

	public void getByPlatform(String platform) {
		String query = "SELECT * from credentials where platform = ?";
		try {
			PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
			stmt.setString(1, platform);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("\nCredentials found.../n");
				int id = rs.getInt("id");
				String platform1 = rs.getString("platform");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String date = rs.getString("date");
				System.out.println("\nid: " + id + " platform: " + platform1 + " username: " + username + " password: "
						+ password + " date: " + date);
				stmt.close();
				rs.close();

			} else {
				System.out.println("Credentials not found...");
			}
		} catch (SQLException e) {
			System.out.println("Credentials not found...");
			e.printStackTrace();
		}

	}

	public void updatePassword(String platform, String password) {
		String query = "UPDATE credentials SET password = ? WHERE platform = ?";
		try {
			PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
			stmt.setString(1, password);
			stmt.setString(2, platform);
			stmt.executeUpdate();
			System.out.println("Student Updated Succesfully....");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletePlatform(String platform) {
		String query = "DELETE from credentials where platform = ?";
		try {
			PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
			stmt.setString(1, platform);
			stmt.executeUpdate();
			System.out.println("Password Delete Succesfully.....");
			stmt.close();

		} catch (SQLException e) {
			System.out.println("Error while deleting password");
			e.printStackTrace();
		}

	}

}
