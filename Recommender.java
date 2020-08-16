import java.util.*;

public class Recommender {
	
	/*
	 * The Recommender class's assignRatings method takes in an ArrayList of childcare center 
	 * inspection records (DayCareProviderModel)--the most recent inspection results of 
	 * each center within the specified zip code. (This ArrayList is generated by the Genie class.)
	 * 
	 * Recommender's assignRatings method partition the centers within the specified zip code 
	 * into three groups, each stored in an ArrayList:
	 * 
	 * Green: Centers whose overall violation rate, public health hazard violation rate, and 
	 * critical violation rate ("violation rates") are all less than 
	 * the citywide average rates.
	 * 
	 * Yellow: Centers with one violation rate that is above the corresponding citywide
	 * average rate.
	 * 
	 * Red: Centers with two or more violation rates that are above the citywide average rates.
	 * 
	 * Green centers are the top recommendations within that zip code, followed by Yellow Centers.
	 * Red centers are not recommended.
	 * 
	 * A helper method, compareAgainstCityAverage, is used to enable the comparison of each
	 * center's violation rate against the city average.
	 * 
	 * This is a first pass at a recommendation algorithm and is subject to change as the
	 * project evolves.
	 * 
	 * Within the NYC Childcare Center Inspections dataset, for each inspection, each 
	 * center has the following fields:
	 * 
	 * ViolationRatePercent: the percent of initial inspections of that center that resulted
	 * in at least one public health hazard or critical violation
	 * 
	 * PublicHealthHazardViolationRate: the percent of Public Health Hazard violations 
	 * among all violations issued at initial inspections of that center during the past 3 years. 
	 * 
	 * CriticalViolationRate: the percent of Critical violations among all violations 
	 * issued at initial inspections of that center during the past 3 years.
	 * 
	 * In addition, the record for each inspection also includes the citywide average rate for
	 * each violation category. Respectively, those are:
	 * violationAvgRatePercent
	 * AveragePublicHealthHazardViolationRate
	 * AvgCriticalViolationRate
	 * 
	 * 
	 * For each violation category, we compare the center's violation rate against the citywide
	 * average.
	 * 
	 * If a center's rates are lower than the citywide average in all three categories, it gets a 
	 * "Green" rating--i.e., the best.
	 * 
	 * If a center's rates are lower than the citywide average in two categories, but higher in one,
	 * it gets a "Yellow" rating.
	 * 
	 * Otherwise, the center gets a "Red" rating.
	 * 
	 * ArrayLists corresponding to each rating tier store the centers with that rating.
	 * 
	 * Each ArrayList will then be sorted by the centers' inspection date. For example, the
	 * top recommendation will be the center in GreenCenters with the most recent inspection date.
	 * This sorting function will be handled by the sortByInspectionDate method (to be written)
	 * 
	 */
	
	private ArrayList<DayCareProviderModel> GreenCenters = new ArrayList<DayCareProviderModel>(); 
	// ArrayList to store the best childcare centers
	
	private ArrayList<DayCareProviderModel> YellowCenters = new ArrayList<DayCareProviderModel>(); 
	// ArrayList to store middle-tier childcare centers
	
	private ArrayList<DayCareProviderModel> RedCenters = new ArrayList<DayCareProviderModel>(); 
	// ArrayList to store the worst childcare centers
	
	public int compareAgainstCityAverage(double violationRate, double cityAverageRate) {
		/*
		 * This method takes in a center's violation rate for a category (overall, 
		 * public health hazard, or critical) and the citywide average rate for that
		 * category.
		 * 
		 * If a center's violation rate is 0, then it returns 1.
		 * 
		 * It returns a 1 if the center's rate is lower than the citywide average, 
		 * and a 0 if it is not.
		 */
		
		if (violationRate == 0) {
			return 1;
		}
		 
		if (violationRate < cityAverageRate) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public void assignRatings(HashMap<String, DayCareProviderModel> centers) {
		
		/*
		 * This method assigns ratings to each center within a zip code.
		 * For each center in the ArrayList, it compares whether
		 * 1. The center's violation rate < citywide average
		 * 2. The center's public health hazard violation rate < citywide average
		 * 3. The center's critical violation rate < citywide average
		 * 
		 * Centers that do better than the citywide average in all 3 categories
		 * are added to the GreenCenters ArrayList.
		 * 
		 * Centers that do better than the citywide average in 2 categories
		 * are added to the YellowCenters ArrayList.
		 * 
		 * All other centers are added to the RedCenters ArrayList.
		 */

		
		for (String center : centers.keySet()) {
			int score = 0;
			
			// for debugging
//			System.out.println("Center: " + centers.get(center).getCenterName());
//			System.out.println("Avg Violation Rate v City Avg: " + centers.get(center).getViolationRatePercent() + " vs. " + centers.get(center).getViolationAvgRatePercent());
//			System.out.println("PHH Violation Rate v City Avg: " + centers.get(center).getPublicHealthHazardViolationRate() + " vs. " + centers.get(center).getAveragePublicHealthHazardViolationRate());
//			System.out.println("Critical Violation Rate v City Avg: " + centers.get(center).getCriticalViolationRate() + " vs. " + centers.get(center).getAvgCriticalViolationRate());
//			//
			
			
			score += compareAgainstCityAverage(centers.get(center).getViolationRatePercent(), 
					centers.get(center).getViolationAvgRatePercent());
			score += compareAgainstCityAverage(centers.get(center).getPublicHealthHazardViolationRate(), 
					centers.get(center).getAveragePublicHealthHazardViolationRate());
			score += compareAgainstCityAverage(centers.get(center).getCriticalViolationRate(), 
					centers.get(center).getAvgCriticalViolationRate());
			if (score == 3) {
				GreenCenters.add(centers.get(center));
			} else {
				if (score == 2) {
					YellowCenters.add(centers.get(center));
				} else {
					RedCenters.add(centers.get(center));
				}
			}
		}

	}
	
	public void sortByInspectionDate() {
		/*
		 * method to be written
		 * takes an ArrayList of centers (GreenCenters, YellowCenters, RedCenters)
		 * and sorts them by their inspection date--most recent to least recent
		 */
		Collections.sort(GreenCenters);
		Collections.sort(YellowCenters);
		Collections.sort(RedCenters);
	}

	public ArrayList<DayCareProviderModel> getGreenCenters() {
		return GreenCenters;
	}

	public void setGreenCenters(ArrayList<DayCareProviderModel> greenCenters) {
		GreenCenters = greenCenters;
	}

	public ArrayList<DayCareProviderModel> getYellowCenters() {
		return YellowCenters;
	}

	public void setYellowCenters(ArrayList<DayCareProviderModel> yellowCenters) {
		YellowCenters = yellowCenters;
	}

	public ArrayList<DayCareProviderModel> getRedCenters() {
		return RedCenters;
	}

	public void setRedCenters(ArrayList<DayCareProviderModel> redCenters) {
		RedCenters = redCenters;
	}
	
	
	

}