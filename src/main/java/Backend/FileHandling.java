package Backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandling {
	
	public static String USERS_FILE = "Users.json";
	
	/**
	 * Returns the content of the file as a string, utilizing java.nio
	 * @param fileName the path of the file, relative to the root. Not absolute path
	 * @return the full content of the file
	 */
	public static String getContentOfFile(String fileName) throws IOException {
		byte[] fileInBytes = Files.readAllBytes(Paths.get(getPath() + fileName));
		
		return new String(fileInBytes);
	}
	
	/**
	 * Tries to save the content parameter to the file with the file name
	 * @param content the content to save
	 * @param fileName the path of the file, relative to the root. Not absolute path
	 */
	public static void saveToFile(String content, String fileName){
		try{
			Files.write(Paths.get(getPath() + fileName), content.getBytes());
		}
		catch (Exception e){
		}
	}
	
	private static String getPath(){
		if(System.getProperty("os.name").toLowerCase().contains("linux")) {
			return "/NAS/NASDisk/Glenn/App1/";
		}
		else if(System.getProperty("os.name").toLowerCase().contains("mac os x")) {
			return "/Volumes/NASDisk/Glenn/App1/";
		}
		else {
			System.err.println("ERROR WITH OS NAME");
			return "";
		}
	}
	
}
