import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This retrieves the data on childcare center inspections
 * from the NYC Open Data website,
 * then puts the data into a JSONArray.
 * 
 * Each inspection (i.e., each row in the datafile) is 
 * represented as a JSONObject.
 * 
 * As a test, the first 5 inspection records are printed out.
 * 
 * Anna and Xiaoya, you'll need to download the java-json.jar
 * 
 * 1. Go to http://www.java2s.com/Code/JarDownload/java/java-json.jar.zip
 *  and download the file
 *  
 * 2. Unzip the file.
 * 
 * 3. Right-click on your Project File in Eclipse and click "Properties" (at the bottom of the menu)
 * 
 * 4. Select "Java Build Path" on the left.
 * 
 * 5. Click on the "Libraries" tab in the center.
 * 
 * 6. Select "Add External JARs" on the right and then select "java-json.jar"
 * 
 * 7. You should see a "Referenced Libraries" folder in your Project File in Eclipse. If you click 
 * on it, you should see java-json.jar.
 *
 * @author stevenwang
 *
 */

public class JSONGetter {
	
	public static void main(String[] args) {
		
		try {
			// get JSON from URL
			// this results in a string (response.toString())
			String url = "https://data.cityofnewyork.us/resource/dsg6-ifza.json";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL: " + url);
			System.out.println("Response Code: " + responseCode);
			System.out.println();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			
			// convert string (response.toString()) to JSONArray
			JSONArray myResponseArray = new JSONArray(response.toString());
			
			//print out first 5 inspections
			for (int i = 0; i < 5; i++) {
				System.out.println("Inspection Number " + (i+1));
				JSONObject inspection = myResponseArray.getJSONObject(i);
				String[] names = JSONObject.getNames(inspection);
				for (String name : names) {
					System.out.println(name + ": " + inspection.get(name));
				}
				System.out.println();
			}

		} catch (Exception e){
			e.printStackTrace();
			
		}

}
}
