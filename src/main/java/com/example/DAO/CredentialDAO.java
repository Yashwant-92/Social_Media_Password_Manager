package com.example.DAO;

import java.util.List;

import com.example.Model.Credential;

public interface CredentialDAO {

	void addCredential(Credential credential);

	List<Credential> getAllCredential();

	void getByPlatform(String platform);

	void updatePassword(String platform, String password);

	void deletePlatform(String platform);

}
