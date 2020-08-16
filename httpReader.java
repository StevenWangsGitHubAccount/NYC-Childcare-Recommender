
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStream; 
import java.net.HttpURLConnection; 
import java.net.URL; 

public class httpReader {
	/*
	 * Access data through its API, and download it into JSON format. Can add
	 * zipcode filter in while pulling the data, will decide later in the project the place to
	 * filter down qualified data, either here or in class - childCareGiene 
	 */
	
	public static void main(String args[]) throws IOException {
		URL url = new URL("https://data.cityofnewyork.us/resource/dsg6-ifza.json?zipcode=10023");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// set the request method and properties.
		// con.setRequestProperty("Accept", "application/json");

		InputStream ip = con.getInputStream();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));

		StringBuilder response = new StringBuilder();
		String responseSingle = null;
		int lineCount = 0;
		while ((responseSingle = br1.readLine()) != null) {
			lineCount++;
			response.append(responseSingle + "\n");
		}
		String xx = response.toString();
		System.out.println(xx);
		System.out.println("Line count:" + lineCount);
	}
}

// The method to parse JSON data is stored in another class - jsonParser   
