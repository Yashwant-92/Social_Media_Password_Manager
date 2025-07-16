package com.example.Services;

import java.util.List;

import com.example.DAO.CredentialDAOImpl;
import com.example.Model.Credential;

public class PasswordService {

	CredentialDAOImpl credentialDAOImpl;

	void addCredential(Credential credential) {
		credentialDAOImpl.addCredential(credential);
	}

	List<Credential> getAllCredential() {
		return credentialDAOImpl.getAllCredential();
	}

	void getByPlatform(String platform) {
		credentialDAOImpl.getByPlatform(platform);
	}

	void updatePassword(String platform, String password) {
		credentialDAOImpl.updatePassword(platform, password);
	}

	void deletePlatform(String platform) {
		credentialDAOImpl.deletePlatform(platform);
	}
}
