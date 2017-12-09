import Backend.JSON;
import Game.Game;
import com.google.gson.JsonObject;

import static spark.Spark.port;
import static spark.Spark.post;

public class HTTP {
	
	public HTTP(){
		port(8080);
		
		/*
		{
			"name" : "INPUT_NAME"
		}
		 */
		post("/App1/new", ((request, response) -> {
			JsonObject bodyObject = JSON.parseStringToJSON(request.body());
			String name = bodyObject.get("name").getAsString();
			
			response = Game.createUser(name, response);
			
			return response.body();
		}));
		
		/*
		{
			"token" : "TOKEN",
			"score" : "NEW_SCORE"
		}
		 */
		post("/App1/update", ((request, response) -> {
			JsonObject bodyObject = JSON.parseStringToJSON(request.body());
			String token = bodyObject.get("token").getAsString();
			int score = bodyObject.get("score").getAsInt();
			
			response = Game.updateScore(token, score, response);
			
			return response.body();
		}));
		
		/*
		{
			"token" : "TOKEN"
		}
		 */
		post("/App1/start", (((request, response) -> {
			JsonObject bodyObject = JSON.parseStringToJSON(request.body());
			String token = bodyObject.get("token").getAsString();
			
			response = Game.startUpdate(token, response);
			
			return response.body();
		})));
		
	}
	
}
