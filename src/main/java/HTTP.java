import Backend.JSON;
import Backend.Logger;
import Game.Game;
import com.google.gson.JsonObject;

import static spark.Spark.port;
import static spark.Spark.post;

class HTTP {
	
	HTTP(){
		port(8181);
		
		/*
		{
			"name" : "INPUT_NAME"
		}
		 */
		post("/new", ((request, response) -> {
			try{
				Logger.print("/new : " + request.body());
				JsonObject bodyObject = JSON.parseStringToJSON(request.body());
				String name = bodyObject.get("name").getAsString();
				
				response = Game.createUser(name, response);
			}
			catch (Exception e){
				Logger.logError(e, "Error with /new", "Body of request was: " + request.body());
				response.status(560);
				response.body(Integer.toString(response.status()));
			}
			
			Logger.print("Responding to /new with: " + response.status() + ", " + response.body());
			
			return response.body();
		}));
		
		/*
		{
			"token" : "TOKEN",
			"score" : "NEW_SCORE"
		}
		 */
		post("/update", ((request, response) -> {
			try{
				Logger.print("/update : " + request.body());
				JsonObject bodyObject = JSON.parseStringToJSON(request.body());
				String token = bodyObject.get("token").getAsString();
				int score = bodyObject.get("score").getAsInt();
				
				response = Game.updateScore(token, score, response);
			}
			catch (Exception e){
				Logger.logError(e, "Error with /update", "Body of request was: " + request.body());
				response.status(560);
				response.body(Integer.toString(response.status()));
			}
			
			Logger.print("Responding to /update with: " + response.status() + ", " + response.body());
			
			return response.body();
		}));
		
		/*
		{
			"token" : "TOKEN"
		}
		 */
		post("/start", (((request, response) -> {
			try{
				Logger.print("/start : " + request.body());
				JsonObject bodyObject = JSON.parseStringToJSON(request.body());
				String token = bodyObject.get("token").getAsString();
				
				response = Game.startUpdate(token, response);
			}
			catch (Exception e){
				Logger.logError(e, "Error with /start", "Body of request was: " + request.body());
				response.status(560);
				response.body(Integer.toString(response.status()));
			}
			
			Logger.print("Responding to /start with: " + response.status() + ", " + response.body());
			
			return response.body();
		})));
	}
	
}
