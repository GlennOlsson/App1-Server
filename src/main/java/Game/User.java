package Game;

import com.google.gson.JsonObject;

@SuppressWarnings("CanBeFinal")
public class User implements Comparable<User>{
	private String name;
	private Integer score;
	private String token;
	
	public User(String name, Integer score, String token) {
		this.name = name;
		this.score = score;
	}
	
	public User(JsonObject object){
		name = object.get("name").getAsString();
		score = object.get("score").getAsInt();
		token = object.get("token").getAsString();
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public String getToken() {
		return token;
	}
	
	public int compareTo(User user){
		return score.compareTo(user.getScore());
	}
	
}
