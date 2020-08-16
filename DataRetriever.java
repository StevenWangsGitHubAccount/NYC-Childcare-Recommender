import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class DataRetriever {
	public String getJSONDataAsStringFromURL(String url) throws MalformedURIException, IOException {
		// get JSON from URL
		// this results in a string (response.toString())
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		//int responseCode = con.getResponseCode();
		//if successful response code should be 200 OK
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}
}
