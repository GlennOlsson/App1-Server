package Game;

import com.google.gson.JsonObject;

public class User implements Comparable<User>{
	private String name;
	private Integer score;
	
	public User(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	public User(JsonObject object){
		name = object.get("name").getAsString();
		score = object.get("score").getAsInt();
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public int compareTo(User user){
		return score.compareTo(user.getScore());
	}
	
}
