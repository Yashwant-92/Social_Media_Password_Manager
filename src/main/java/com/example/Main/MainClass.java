package com.example.Main;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.example.DAO.CredentialDAOImpl;
import com.example.Model.Credential;
import com.example.Utility.DBConnection;

public class MainClass {

	public static void main(String[] args) throws SQLException {

		CredentialDAOImpl credentialDAO = new CredentialDAOImpl();

		// Create DB and table if not exists
		String query1 = "CREATE DATABASE IF NOT EXISTS passwordManagerDB";
		String query2 = "USE passwordManagerDB";
		String query3 = "CREATE TABLE IF NOT EXISTS credentials (" + "id INT PRIMARY KEY, " + "platform VARCHAR(100), "
				+ "username VARCHAR(100), " + "password VARCHAR(100), " + "date VARCHAR(50))";

		Statement stmt = DBConnection.getConnection().createStatement();
		stmt.execute(query1);
		System.out.println("✅ Database created (or already exists)");

		stmt.execute(query2);
		System.out.println("📁 Using database: passwordDB");

		stmt.execute(query3);
		System.out.println("✅ Table created (or already exists)");

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n========= SOCIAL MEDIA PASSWORD MANAGER =========");
			System.out.println("1. Add Credential");
			System.out.println("2. View All Credentials");
			System.out.println("3. Search Credential by Platform");
			System.out.println("4. Update Password");
			System.out.println("5. Delete Credential");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); // clear buffer

			switch (choice) {
			case 1:
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Platform (e.g., Instagram): ");
				String platform = sc.nextLine();

				System.out.print("Enter Username: ");
				String username = sc.nextLine();

				System.out.print("Enter Password: ");
				String password = sc.nextLine();

				System.out.print("Enter Date (e.g., 2025-07-17): ");
				String date = sc.nextLine();

				Credential newCred = new Credential(id, platform, username, password, date);
				credentialDAO.addCredential(newCred);
				break;

			case 2:
				List<Credential> credentials = credentialDAO.getAllCredential();
				if (credentials.isEmpty()) {
					System.out.println("⚠️ No credentials found.");
				} else {
					for (Credential c : credentials) {
						System.out.println(c);
					}
				}
				break;

			case 3:
				System.out.print("Enter Platform to search: ");
				String searchPlatform = sc.nextLine();
				credentialDAO.getByPlatform(searchPlatform);
				break;

			case 4:
				System.out.print("Enter Platform to update password: ");
				String updatePlatform = sc.nextLine();

				System.out.print("Enter New Password: ");
				String newPassword = sc.nextLine();

				credentialDAO.updatePassword(updatePlatform, newPassword);
				break;

			case 5:
				System.out.print("Enter Platform to delete: ");
				String delPlatform = sc.nextLine();
				credentialDAO.deletePlatform(delPlatform);
				break;

			case 6:
				System.out.println("👋 Exiting Password Manager. Goodbye!");
				System.exit(0);
				break;

			default:
				System.out.println("❌ Invalid choice. Try again.");
			}
		}
	}
}
