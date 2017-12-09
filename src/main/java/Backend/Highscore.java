package Backend;

import Game.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;

import static Backend.FileHandling.*;
import java.util.ArrayList;
import java.util.List;

public class Highscore {
	
	public static JsonObject getHighscore(){
		try{
			String contentOfFile = FileHandling.getContentOfFile(USERS_FILE);
			JsonObject jsonObject = JSON.parseStringToJSON(contentOfFile);
			JsonArray bigArray = jsonObject.getAsJsonArray("users");
			
			List<User> users = new ArrayList<>();
			
			for(JsonElement jsonElement : bigArray){
				JsonObject thisObject = jsonElement.getAsJsonObject();
				User thisUser = new User(thisObject);
				users.add(thisUser);
			}
			
			sort(users);
			
			JsonObject newObject = new JsonObject();
			JsonArray newArray = new JsonArray();
			
			int i = 0;
			while (i < 10 && i < users.size()) {
				JsonObject thisUserObject = new JsonObject();
				User thisUser = users.get(i);
				thisUserObject.addProperty("name", thisUser.getName());
				thisUserObject.addProperty("score", thisUser.getScore());
				
				newArray.add(thisUserObject);
				i++;
			}
			
			newObject.add("highscore", newArray);
			
			return newObject;
			
		}
		catch (Exception e){
			return new JsonObject();
		}
	}
	
	private static void sort(List<User> list){
		for(int i = 1; i < list.size(); i++){
			int j = i;
			while(j > 0 && list.get(j - 1).compareTo(list.get(j)) < 0){
				User temporaryUser = list.get(j);
				list.set(j, list.get(j - 1));
				list.set(j - 1, temporaryUser);
				j--;
			}
		}
	}
}
