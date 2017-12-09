package Backend;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JSON {
	/**
	 * Parses an input string as a JSON object
	 * @param theString the json to parse
	 * @return the object of the string
	 */
	public static JsonObject parseStringToJSON(String theString) throws JsonSyntaxException {
		JsonElement jElement = new JsonParser().parse(theString);
		return jElement.getAsJsonObject();
	}
}
