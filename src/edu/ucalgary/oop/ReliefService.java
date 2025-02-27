package edu.ucalgary.oop;

public class ReliefService {
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;



    /////////////////////////////////////////////////////
    //-------------- Constructor(s) ------------------//
    ///////////////////////////////////////////////////

    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date of inquiry format");
        }
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }


    /////////////////////////////////////////////
    //-------------- Getters ------------------//
    ////////////////////////////////////////////    

    public Inquirer getInquirer() {
        return inquirer;
    }
    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }
    public String getDateOfInquiry() {
        return dateOfInquiry;
    }
    public String getInfoProvided() {
        return infoProvided;
    }
    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }


    //////////////////////////////////////////////
    //-------------- Setters ------------------//
    ////////////////////////////////////////////

    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }
    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }

    public void setDateOfInquiry(String dateOfInquiry) {
        if (!isValidDateFormat(dateOfInquiry)) {
            throw new IllegalArgumentException("Invalid date of inquiry format");
        }
        this.dateOfInquiry = dateOfInquiry;
    }

    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }
    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }

   
    ///////////////////////////////////////////////////////
    //-------------- Helper Functions ------------------//
    /////////////////////////////////////////////////////    

    // Return a formatted log detail string
    public String getLogDetails() {
        return "Inquirer: " + inquirer.getFirstName() +
                ", Missing Person: " + missingPerson.getFirstName() +
                ", Date of Inquiry: " + dateOfInquiry +
                ", Info Provided: " + infoProvided +
                ", Last Known Location: " + lastKnownLocation.getName();
    }

    // Validate date format (YYYY-MM-DD)
    private boolean isValidDateFormat(String date) {
        if (date == null) return false;
        return date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }


}
