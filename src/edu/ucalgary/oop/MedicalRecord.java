package edu.ucalgary.oop;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;


    /////////////////////////////////////////////////////
    //-------------- Constructor(s) ------------------//
    ///////////////////////////////////////////////////
    
    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) {
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date of treatment format");
        }
        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }


    /////////////////////////////////////////////
    //-------------- Getters ------------------//
    ////////////////////////////////////////////

    public Location getLocation() {
        return location;
    }
    public String getTreatmentDetails() {
        return treatmentDetails;
    }
    public String getDateOfTreatment() {
        return dateOfTreatment;
    }



    //////////////////////////////////////////////
    //-------------- Setters ------------------//
    ////////////////////////////////////////////

    public void setLocation(Location location) {
        this.location = location;
    }
    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public void setDateOfTreatment(String dateOfTreatment) {
        if (!isValidDateFormat(dateOfTreatment)) {
            throw new IllegalArgumentException("Invalid date of treatment format");
        }
        this.dateOfTreatment = dateOfTreatment;
    }



    ///////////////////////////////////////////////////////
    //-------------- Helper Functions ------------------//
    /////////////////////////////////////////////////////

    // Validate date format (YYYY-MM-DD)
    private boolean isValidDateFormat(String date) {
        if (date == null) return false;
        return date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }




    
}
