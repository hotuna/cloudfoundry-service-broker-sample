package com.bong.calculator.model;

import java.util.HashMap;
import java.util.Set;

public class UserManager {

	public static HashMap<String, String> accountDB;
	public static HashMap<String, HashMap<String, String>> apikeyDB;

	public UserManager() {
		accountDB = new HashMap<String, String>();
		apikeyDB = new HashMap<String, HashMap<String, String>>();
	}

	public boolean login(String id, String pwd) {
		if (accountDB.containsKey(id)) {
			if (accountDB.get(id).equals(pwd)) {
				return true;
			}
		}

		return false;
	}

	public boolean createUser(String id, String pwd) {
		if (accountDB.containsKey(id)) {
			return false;
		}

		accountDB.put(id, pwd);
		apikeyDB.put(id, new HashMap<String, String>());

		return true;
	}

	public void createAPIKey(String id, String appId) {
		String apikey = String.valueOf(System.currentTimeMillis());
		apikeyDB.get(id).put(appId, apikey);
	}

	public String getAPIKey(String id, String appId) {
		createAPIKey(id, appId);
		return apikeyDB.get(id).get(appId);
	}

	public void deleteUser(String id) {
		accountDB.remove(id);
		apikeyDB.remove(id);
	}

	public boolean isAvailable(String apikey) {
		Set<String> keySet = apikeyDB.keySet();
		System.out.println("bong : param apikey = " + apikey);
		System.out.println("bong : param apikeyDB = " + apikeyDB.toString());
		for (String key : keySet) {
			if (apikeyDB.get(key).containsValue(apikey)) {
				return true;
			}
		}
		return false;
	}
}
