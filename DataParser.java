import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DataParser {
	
	/*
	 * DataRetriever queries the URL for NYC's Open Data website and gets the
	 * childcare inspections dataset in the form of a string.
	 * 
	 * DataParser takes that string and parses it into JSONObjects, which 
	 * are stored in a JSONArray.
	 * 
	 * Each JSONObject (representing the results of one inspection of a 
	 * day care center) is then used to create a DayCareProviderModel object, which will
	 * be used by the other classes in this program.
	 * 
	 * These DayCareProviderModel objects are stored in an ArrayList.
	 * 
	 */
	
	private ArrayList<DayCareProviderModel> inspections = new ArrayList<DayCareProviderModel>();
	
	public JSONArray convertToJSONArray (String data) throws JSONException {
		/*
		 * Takes in a string (the result of DataRetriever
		 * querying the NYC Open Data site) and puts all of
		 * that data into a JSONArray
		 */
		JSONArray dataJSONArray = null;
		try {
			dataJSONArray = new JSONArray(data);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataJSONArray;
	}
	
	public void createInspectionsArrayList (JSONArray dataJSONArray) throws JSONException {
		/*
		 * This method iterates through a JSONArray containing the
		 * data on the city's inspections of day centers and builds
		 * Model objects.
		 * 
		 * Each inspection is a JSONObject stored in the JSONArray.
		 * This method extracts the data about that inspection from the
		 * JSONObject and uses that data to construct a Model object.
		 * 
		 * This Model object is then stored in the inspections ArrayList.
		 * 
		 * 
		 */
		for (int i = 0; i < dataJSONArray.length(); i++) {
			DayCareProviderModel model = new DayCareProviderModel();
			JSONObject row = dataJSONArray.getJSONObject(i);
			
			if (row.has("centername")) {
				model.setCenterName(row.getString("centername"));
			}
			if (row.has("legalname")) {
				model.setLegalName(row.getString("legalname"));
			}
			if (row.has("building")) {
				model.setBuilding(row.getString("building"));
			}
			if (row.has("street")) {
				model.setStreet(row.getString("street"));
			}
			if (row.has("borough")) {
				model.setBorough(row.getString("borough"));
			}
			if (row.has("zipcode")) {
				model.setZipcode(row.getString("zipcode"));
			}
			if (row.has("phone")) {
				model.setPhone(row.getString("phone"));
			}
			if (row.has("permitnumber")) {
				model.setPermitNumber(row.getString("permitnumber"));
			}
			if (row.has("permitexp")) {
				String d =  row.getString("permitexp");
				String month = d.substring(5, 7);
				String day = d.substring(8, 10);
				String year = d.substring(0, 4);
				String date = month + "/" + day + "/" + year;
				try {
					Date dt = new SimpleDateFormat("MM/dd/yyyy").parse(date);
					model.setPermitExp(dt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (row.has("status")) {
				model.setStatus(row.getString("status"));
			}
			if (row.has("agerange")) {
				model.setAgeRange(row.getString("agerange"));
			}
			if (row.has("maximumcapacity")) {
				model.setMaximumCapacity(row.getInt("maximumcapacity"));
			}
			if (row.has("dc_id")) {
				model.setDcID(row.getString("dc_id"));
			}
			if (row.has("programtype")) {
				model.setProgramType(row.getString("programtype"));
			}
			if (row.has("facilitytype")) {
				model.setFacilityType(row.getString("facilitytype"));
			}
			if (row.has("childcaretype")) {
				model.setChildCareType(row.getString("childcaretype"));
			}
			if (row.has("bin")) {
				model.setBin(row.getInt("bin"));
			}
			if (row.has("url")) {
				model.setUrl(row.getString("url"));
			}
			if (row.has("datepermitted")) {
				String d =  row.getString("datepermitted");
				String month = d.substring(5, 7);
				String day = d.substring(8, 10);
				String year = d.substring(0, 4);
				String date = month + "/" + day + "/" + year;
				try {
					Date dt = new SimpleDateFormat("MM/dd/yyyy").parse(date);
					model.setDatePermitted(dt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (row.has("actual")) {
				model.setActual(row.getString("actual"));
			}
			if (row.has("violationratepercent")) {
				model.setViolationRatePercent(row.getDouble("violationratepercent"));
			}
			if (row.has("violationavgratepercent")) {
				model.setViolationAvgRatePercent(row.getDouble("violationavgratepercent"));
			}
			if (row.has("totaleducationalworkers")) {
				model.setTotalEducationalWorkers(row.getInt("totaleducationalworkers"));
			}
			if (row.has("averagetotaleducationalworkers")) {
				model.setAveragePublicHealthHazardViolationRate(row.getDouble("averagetotaleducationalworkers"));
			}
			if (row.has("publichealthhazardviolationrate")) {
				model.setPublicHealthHazardViolationRate(row.getDouble("publichealthhazardviolationrate"));
			}
			if (row.has("averagepublichealthhazardiolationrate")) {
				model.setAveragePublicHealthHazardViolationRate(row.getDouble("averagepublichealthhazardiolationrate"));
			}
			if (row.has("criticalviolationrate")) {
				model.setCriticalViolationRate(row.getDouble("criticalviolationrate"));
			}
			if (row.has("avgcriticalviolationrate")) {
				model.setAvgCriticalViolationRate(row.getDouble("avgcriticalviolationrate"));
			}
			if (row.has("inspectiondate")) {
				String d =  row.getString("inspectiondate");
				String month = d.substring(5, 7);
				String day = d.substring(8, 10);
				String year = d.substring(0, 4);
				String date = month + "/" + day + "/" + year;
				try {
					Date dt = new SimpleDateFormat("MM/dd/yyyy").parse(date);
					model.setInspectiondate(dt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (row.has("regulationsummary")) {
				model.setRegulationSummary(row.getString("regulationsummary"));
			}
			if (row.has("violationcatetory")) {
				model.setViolationCategory(row.getString("violationcatetory"));
			}
			if (row.has("healthcodesubsection")) {
				model.setHealthCodeSubsection(row.getString("healthcodesubsection"));
			}
			if (row.has("violationstatus")) {
				model.setViolationStatus(row.getString("violationstatus"));
			}
			if (row.has("inspectionsummaryresult")) {
				model.setInspectionSummaryResult(row.getString("inspectionsummaryresult"));
			}
			inspections.add(model);
		}
	}

	public ArrayList<DayCareProviderModel> getInspections() {
		return inspections;
	}
	
}