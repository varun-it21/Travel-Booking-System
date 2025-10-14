package travel;

public class Bookings {
	
	private int bookingId;
    private int userId;
    private String packageName;
    private String fullName;
    private String email;
    private String phone;
    private String travelDate;
    private int adults;
    private int children;
    private String specialRequests;
    private String bookingDate;
    private String bookingType;
    private double totalPrice;

    // Getters
    public int getBookingId() { return bookingId; }
    public int getUserId() { return userId; }
    public String getPackageName() { return packageName; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getTravelDate() { return travelDate; }
    public int getAdults() { return adults; }
    public int getChildren() { return children; }
    public String getSpecialRequests() { return specialRequests; }
    public String getBookingDate() { return bookingDate; }
    public String getBookingType() { return bookingType; }
    public double getTotalPrice() { return totalPrice; }

    // Setters
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setPackageName(String packageName) { this.packageName = packageName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setTravelDate(String travelDate) { this.travelDate = travelDate; }
    public void setAdults(int adults) { this.adults = adults; }
    public void setChildren(int children) { this.children = children; }
    public void setSpecialRequests(String specialRequests) { this.specialRequests = specialRequests; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }
    public void setBookingType(String bookingType) { this.bookingType = bookingType; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
	    
}
