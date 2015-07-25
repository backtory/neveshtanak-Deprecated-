package ir.pegahtech.neveshtanak.util.data;

import java.util.UUID;

import android.content.Context;
import android.content.SharedPreferences;

public class DataHandler {
	private static DataHandler _instance;
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;

	public DataHandler(Context context) {
		sp = context.getSharedPreferences("data", 0);
		editor = sp.edit();
	}

	public static DataHandler getInstance(Context context) {
		if (_instance == null)
			_instance = new DataHandler(context);
		return _instance;
	}

	public String getUserId() {
		if (sp.contains("user-id"))
			return sp.getString("user-id", null);
		UUID uuid = UUID.randomUUID();
		editor.putString("user-id", uuid.toString());
		editor.commit();
		return uuid.toString();
	}

	public void saveUserName(String name) {
		editor.putString("user-name", name);
		editor.commit();
	}

	public String getUserName() {
		return sp.getString("user-name", null);
	}
	
	public void save(String key, String val){
		editor.putString(key, val);
		editor.commit();
	}
	
	public String get(String key){
		return sp.getString(key, null);
	}
	
	public void remove(String key){
		editor.remove(key);
	}
	
	public void like(String id){
		id = id.toLowerCase();
		String likedString = sp.getString("likes", "");
		String[] strings = likedString.split(" ");
		for(String likeId : strings){
			if(likeId.equals(id)){
				return;
			}
		}
		if(likedString.equals("")){
			likedString = id;
		}
		else{
			likedString += " " + id;
		}
		editor.putString("likes", likedString);
		editor.commit();
	}
	
	public boolean isLiked(String id){
		id = id.toLowerCase();
		String likedString = sp.getString("likes", "");
		String[] strings = likedString.split(" ");
		for(String likedId: strings){
			if(likedId.equals(id))
				return true;
		}
		return false;
	}
}
