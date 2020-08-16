import java.util.Date;
import java.text.SimpleDateFormat;

public class DayCareProviderModel implements Comparable<DayCareProviderModel> {
	private String centerName;
	private String legalName;
	private String building;
	private String street;
	private String borough;
	private String zipcode;
	private String phone;
	private String permitNumber;
	private Date permitExp;
	private String status;
	private String ageRange;
	private int maximumCapacity;
	private String dcID;
	private String programType;
	private String facilityType;
	private String childCareType;
	private int bin;
	private String url;
	private Date datePermitted;
	private String actual;
	private double violationRatePercent;
	private double violationAvgRatePercent;
	private int totalEducationalWorkers;
	private double publicHealthHazardViolationRate;
	private double averagePublicHealthHazardViolationRate;
	private double criticalViolationRate;
	private double avgCriticalViolationRate;
	private Date inspectiondate;
	private String regulationSummary;
	private String violationCategory;
	private String healthCodeSubsection;
	private String violationStatus;
	private String inspectionSummaryResult;
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBorough() {
		return borough;
	}
	public void setBorough(String borough) {
		this.borough = borough;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPermitNumber() {
		return permitNumber;
	}
	public void setPermitNumber(String permitNumber) {
		this.permitNumber = permitNumber;
	}
	public Date getPermitExp() {
		return permitExp;
	}
	public void setPermitExp(Date permitExp) {
		this.permitExp = permitExp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public int getMaximumCapacity() {
		return maximumCapacity;
	}
	public void setMaximumCapacity(int maximumCapacity) {
		this.maximumCapacity = maximumCapacity;
	}
	public String getDcID() {
		return dcID;
	}
	public void setDcID(String dcID) {
		this.dcID = dcID;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getChildCareType() {
		return childCareType;
	}
	public void setChildCareType(String childCareType) {
		this.childCareType = childCareType;
	}
	public int getBin() {
		return bin;
	}
	public void setBin(int bin) {
		this.bin = bin;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDatePermitted() {
		return datePermitted;
	}
	public void setDatePermitted(Date datePermitted) {
		this.datePermitted = datePermitted;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	public double getViolationRatePercent() {
		return violationRatePercent;
	}
	public void setViolationRatePercent(double violationRatePercent) {
		this.violationRatePercent = violationRatePercent;
	}
	public double getViolationAvgRatePercent() {
		return violationAvgRatePercent;
	}
	public void setViolationAvgRatePercent(double violationAvgRatePercent) {
		this.violationAvgRatePercent = violationAvgRatePercent;
	}
	public int getTotalEducationalWorkers() {
		return totalEducationalWorkers;
	}
	public void setTotalEducationalWorkers(int totalEducationalWorkers) {
		this.totalEducationalWorkers = totalEducationalWorkers;
	}
	public double getPublicHealthHazardViolationRate() {
		return publicHealthHazardViolationRate;
	}
	public void setPublicHealthHazardViolationRate(double publicHealthHazardViolationRate) {
		this.publicHealthHazardViolationRate = publicHealthHazardViolationRate;
	}
	public double getAveragePublicHealthHazardViolationRate() {
		return averagePublicHealthHazardViolationRate;
	}
	public void setAveragePublicHealthHazardViolationRate(double averagePublicHealthHazardViolationRate) {
		this.averagePublicHealthHazardViolationRate = averagePublicHealthHazardViolationRate;
	}
	public double getCriticalViolationRate() {
		return criticalViolationRate;
	}
	public void setCriticalViolationRate(double criticalViolationRate) {
		this.criticalViolationRate = criticalViolationRate;
	}
	public double getAvgCriticalViolationRate() {
		return avgCriticalViolationRate;
	}
	public void setAvgCriticalViolationRate(double avgCriticalViolationRate) {
		this.avgCriticalViolationRate = avgCriticalViolationRate;
	}
	public Date getInspectiondate() {
		return inspectiondate;
	}
	public void setInspectiondate(Date inspectiondate) {
		this.inspectiondate = inspectiondate;
	}
	public String getRegulationSummary() {
		return regulationSummary;
	}
	public void setRegulationSummary(String regulationSummary) {
		this.regulationSummary = regulationSummary;
	}
	public String getViolationCategory() {
		return violationCategory;
	}
	public void setViolationCategory(String violationCategory) {
		this.violationCategory = violationCategory;
	}
	public String getHealthCodeSubsection() {
		return healthCodeSubsection;
	}
	public void setHealthCodeSubsection(String healthCodeSubsection) {
		this.healthCodeSubsection = healthCodeSubsection;
	}
	public String getViolationStatus() {
		return violationStatus;
	}
	public void setViolationStatus(String violationStatus) {
		this.violationStatus = violationStatus;
	}
	public String getInspectionSummaryResult() {
		return inspectionSummaryResult;
	}
	public void setInspectionSummaryResult(String inspectionSummaryResult) {
		this.inspectionSummaryResult = inspectionSummaryResult;
	}
	
	@Override
	public int compareTo(DayCareProviderModel otherInspection) {
		// sorts by the most recent inspection date
		return otherInspection.getInspectiondate().compareTo(getInspectiondate());
		
	}
}