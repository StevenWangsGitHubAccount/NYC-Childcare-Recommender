
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

public class DayCareGenie {
	//variable list
	private ArrayList <DayCareProviderModel> list; 
	
	//constructor for other code to pass the data in
	public DayCareGenie(ArrayList <DayCareProviderModel> data) {
		list = data;
	}
	
	//Method to retrieve inspections of all day care centers in a zipcode and under a specific daycare type 
	public ArrayList <DayCareProviderModel> getDayCaresByZipcode (String zipcode, String childcareType) {
		//methods to answer question using variable list
		ArrayList<DayCareProviderModel> result = new ArrayList<DayCareProviderModel>();
		
		for(DayCareProviderModel dc : list) {
			if (dc.getZipcode() != null && dc.getChildCareType() != null) {
				if (dc.getZipcode().equals(zipcode) && dc.getChildCareType().equals(childcareType)) {
					result.add(dc);
				}
			}
		}
		
		return result;
	}
		
	/**
	 * gets all day care providers with the specified zipcode and under a 
	 * specific childcare type whose last inspection date
	 * is greater than or equal to the specified inspection date.
	 * @param zipcode - a String representing the 5 digit zipcode to look for.
	 * @parm childcareType - a String representing the child care type 
	 * @param inspectionDate - a date representing the desired inspection date
	 * @return a list of Day Care Providers matching the passed parameters.
	 */
	public ArrayList <DayCareProviderModel> getDayCaresByZipcode (String zipcode, String childcareType, Date inspectionDate) {
		//methods to answer question using variable list
		ArrayList<DayCareProviderModel> result = new ArrayList<DayCareProviderModel>();
		
		for(DayCareProviderModel dc : list) {
			if (dc.getZipcode().equals(zipcode) == true  && dc.getChildCareType().equals(childcareType) && 
			    (dc.getInspectiondate().after(inspectionDate) || dc.getInspectiondate().equals(inspectionDate))) {
				result.add(dc);
			}
		}
		
		return result;
	}
	
	public HashMap<String, DayCareProviderModel> getMostRecentInspections(ArrayList<DayCareProviderModel> inspectionsByZipCode) {
		/**
		 * This method takes in an arraylist of all the inspections for a zip code.
		 * It iterates through those inspections and extracts the most recent inspection for
		 * each day care center.
		 * Each center and its most recent inspection are stored as key-values in a 
		 * hashmap, which is returned
		 */
		
		// hashmap to store the most recent inspections for the centers in the zip code
		HashMap<String, DayCareProviderModel> mostRecentInspections = new HashMap<String, DayCareProviderModel>();

		
		// iterate through inspections for a zipcode
		for (DayCareProviderModel inspection : inspectionsByZipCode) {
			// determine if a center is in the hashmap
			// if so, determine if this inspection record is more recent than 
			// the one stored in the hashmap; if so, replace the value in the hashmap
			// with this inspection record
			// else add the center and inspection record to the hashmap
			if (mostRecentInspections.containsKey(inspection.getCenterName())) {
				if (inspection.getInspectiondate() != null) {
					Date comparisonDate = mostRecentInspections.get(inspection.getCenterName()).getInspectiondate();
					if (inspection.getInspectiondate().after(comparisonDate)) {
					mostRecentInspections.put(inspection.getCenterName(), inspection);
					}
				}
				
			} else {
				if (inspection.getInspectiondate()!= null) {
					mostRecentInspections.put(inspection.getCenterName(), inspection);
				}
				
			}
		}
		
		return mostRecentInspections;
	}
}
