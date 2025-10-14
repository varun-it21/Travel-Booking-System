package travel;

import java.sql.Date;

public class UserQuery {
	 private int enquiryId;
	    private String name;
	    private String city;
	    private String email;
	    private String phone;
	    private String travelDestination;
	    private Date travelDate;
	    private int numberOfPeople;
	    private String vacationType;
	    private Date enquiryDate;

	    // Constructor
	    public UserQuery(int enquiryId, String name, String city, String email, String phone,
	                     String travelDestination, Date travelDate, int numberOfPeople,
	                     String vacationType, Date enquiryDate) {
	        this.enquiryId = enquiryId;
	        this.name = name;
	        this.city = city;
	        this.email = email;
	        this.phone = phone;
	        this.travelDestination = travelDestination;
	        this.travelDate = travelDate;
	        this.numberOfPeople = numberOfPeople;
	        this.vacationType = vacationType;
	        this.enquiryDate = enquiryDate;
	    }

	    // Getters
	    public int getEnquiryId() { return enquiryId; }
	    public String getName() { return name; }
	    public String getCity() { return city; }
	    public String getEmail() { return email; }
	    public String getPhone() { return phone; }
	    public String getTravelDestination() { return travelDestination; }
	    public Date getTravelDate() { return travelDate; }
	    public int getNumberOfPeople() { return numberOfPeople; }
	    public String getVacationType() { return vacationType; }
	    public Date getEnquiryDate() { return enquiryDate; }
}
