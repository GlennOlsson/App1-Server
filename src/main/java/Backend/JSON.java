package Backend;

import com.google.gson.*;
public class JSON {
	/**
	 * Parses an input string as a JSON object
	 * @param theString the json to parse
	 * @return the object of the string
	 */
	public static JsonObject parseStringToJSON(String theString) throws JsonSyntaxException {
		JsonElement jsonElement = new JsonParser().parse(theString.trim());
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		
		return jsonObject;
	}
}
