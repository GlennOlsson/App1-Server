import Backend.JSON;
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
		post("/App1/new", ((request, response) -> {
			System.out.println("/new : " + request.body());
			JsonObject bodyObject = JSON.parseStringToJSON(request.body());
			String name = bodyObject.get("name").getAsString();
			
			response = Game.createUser(name, response);
			
			System.out.println("Responding with: " + response.status() + ", " + response.body());
			System.out.println();
			
			return response.body();
		}));
		
		/*
		{
			"token" : "TOKEN",
			"score" : "NEW_SCORE"
		}
		 */
		post("/App1/update", ((request, response) -> {
			try{
				
				System.out.println("/update : " + request.body());
				JsonObject bodyObject = JSON.parseStringToJSON(request.body());
				String token = bodyObject.get("token").getAsString();
				int score = bodyObject.get("score").getAsInt();
				
				response = Game.updateScore(token, score, response);
			}
			catch (Exception e){
				e.printStackTrace();
			}
			
			System.out.println("Responding with: " + response.status() + ", " + response.body());
			System.out.println();
			
			return response.body();
		}));
		
		/*
		{
			"token" : "TOKEN"
		}
		 */
		post("/App1/start", (((request, response) -> {
			System.out.println("/start : " + request.body());
			JsonObject bodyObject = JSON.parseStringToJSON(request.body());
			String token = bodyObject.get("token").getAsString();
			
			response = Game.startUpdate(token, response);
			
			System.out.println("Responding with: " + response.status() + ", " + response.body());
			System.out.println();
			
			return response.body();
		})));
		
	}
	
}
