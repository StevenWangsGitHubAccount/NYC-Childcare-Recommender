import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
class RecommenderTester {

	@Test
	/*
	 * JUnit test for the assignRatings method in Recommender class
	 * 
	 * First, the test creates a number of DayCareProviderModel objects and
	 * puts them into an ArrayList (centers).
	 * 
	 * Next, we instantiate a Recommender object and call the assignRatings
	 * method, passing the ArrayList (centers) to it
	 * 
	 * assignRatings should add only one of the DayCareProviderModel objects
	 * to the GreenCenters ArrayList in the Recommender class. (This the 
	 * ArrayList that stores the best childcare centers.) The test is set
	 * up so that this should be Center 4.
	 */
	void test() {
		// create DayCareProviderModel objects
		// add to ArrayList centers
		
		DayCareProviderModel center1 = new DayCareProviderModel();
		DayCareProviderModel center2 = new DayCareProviderModel();
		DayCareProviderModel center3 = new DayCareProviderModel();
		DayCareProviderModel center4 = new DayCareProviderModel();
		DayCareProviderModel center5 = new DayCareProviderModel();
		DayCareProviderModel center6 = new DayCareProviderModel();
		
		center1.setCenterName("Center 1");
		center2.setCenterName("Center 2");
		center3.setCenterName("Center 3");
		center4.setCenterName("Center 4");
		center5.setCenterName("Center 5");
		center6.setCenterName("Center 6");
		
		center1.setViolationRatePercent(0.56);
		center2.setViolationRatePercent(0.32);
		center3.setViolationRatePercent(0.38);
		center4.setViolationRatePercent(0.15);
		center5.setViolationRatePercent(0.73);
		center6.setViolationRatePercent(0.08);
		
		center1.setPublicHealthHazardViolationRate(0.90);
		center2.setPublicHealthHazardViolationRate(0.13);
		center3.setPublicHealthHazardViolationRate(0.18);
		center4.setPublicHealthHazardViolationRate(0.11);
		center5.setPublicHealthHazardViolationRate(0.67);
		center6.setPublicHealthHazardViolationRate(0.24);
		
		center1.setCriticalViolationRate(0.59);
		center2.setCriticalViolationRate(0.33);
		center3.setCriticalViolationRate(0.12);
		center4.setCriticalViolationRate(0.15);
		center5.setCriticalViolationRate(0.55);
		center6.setCriticalViolationRate(0.18);
		
		ArrayList<DayCareProviderModel> centers = new ArrayList<DayCareProviderModel>();
		centers.add(center1);
		centers.add(center2);
		centers.add(center3);
		centers.add(center4);
		centers.add(center5);
		centers.add(center6);
		
		for (DayCareProviderModel c : centers) {
			c.setViolationAvgRatePercent(0.37);
			c.setAveragePublicHealthHazardViolationRate(0.23);
			c.setAvgCriticalViolationRate(0.19);
		}
		
		// instantiate Recommender object
		Recommender r = new Recommender();
		r.assignRatings(centers);
		
		// extract r's GreenCenters ArrayList
		// should contain 1 center which is the best
		// that center should be Center 4
		
		ArrayList<DayCareProviderModel> rGreen = r.getGreenCenters();
		assertEquals(rGreen.size(), 1);
		assertEquals(rGreen.get(0).getCenterName(), "Center 4");
		
	}

}
