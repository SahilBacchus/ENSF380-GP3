package edu.ucalgary.oop;


public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private String ENTRY_DATE;
    private String gender;
    private String comments;

    private static int counter = 0; // Shared counter for all instances of the class

    /////////////////////////////////////////////////////
    //-------------- Constructor(s) ------------------//
    ///////////////////////////////////////////////////

    // Constructor with first name and entry date only
    public DisasterVictim(String firstName, String ENTRY_DATE) {
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid entry date format");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    // Constructor with first name, entry date and birth date
    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) {
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid entry date format");
        }
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid birth date format");
        }
        if (convertDateStringToInt(dateOfBirth) > convertDateStringToInt(ENTRY_DATE)) {
            throw new IllegalArgumentException("Birth date cannot be after entry date");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.dateOfBirth = dateOfBirth;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }



    /////////////////////////////////////////////
    //-------------- Getters ------------------//
    ////////////////////////////////////////////
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }
    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }
    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }
    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }
    public String getEntryDate() {
        return ENTRY_DATE;
    }
    public String getComments() {
        return comments;
    }
    public String getGender() {
        return gender;
    }



    //////////////////////////////////////////////
    //-------------- Setters ------------------//
    ////////////////////////////////////////////

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid birth date format");
        }
        if (this.ENTRY_DATE != null && convertDateStringToInt(dateOfBirth) > convertDateStringToInt(this.ENTRY_DATE)) {
            throw new IllegalArgumentException("Birth date cannot be after entry date");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setPersonalBelongings(Supply[] belongings) {
        this.personalBelongings = belongings;
    }
    public void setFamilyConnections(FamilyRelation[] connections) {
        this.familyConnections = connections;
    }
    public void setMedicalRecords(MedicalRecord[] records) {
        this.medicalRecords = records;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setGender(String gender) {
        if (gender != null) {
            this.gender = gender.toLowerCase();
        } else {
            this.gender = null;
        }
    }

    /////////////////////////////////////////////////////////
    //-------------- Add/Remove Methods ------------------//
    ///////////////////////////////////////////////////////
    

    // Add a supply to personal belongings (dynamically resizing the array)
    public void addPersonalBelonging(Supply supply) {
        if (personalBelongings == null) {
            personalBelongings = new Supply[1];
            personalBelongings[0] = supply;
        } else {
            int len = personalBelongings.length;
            Supply[] newBelongings = new Supply[len + 1];
            for (int i = 0; i < len; i++) {
                newBelongings[i] = personalBelongings[i];
            }
            newBelongings[len] = supply;
            personalBelongings = newBelongings;
        }
    }

    // Remove a supply from personal belongings
    public void removePersonalBelonging(Supply unwantedSupply) {
        if (personalBelongings == null) return;
        int count = 0;
        for (Supply s : personalBelongings) {
            if (s == unwantedSupply) count++;
        }
        if (count == 0) return;
        Supply[] newBelongings = new Supply[personalBelongings.length - count];
        int index = 0;
        for (Supply s : personalBelongings) {
            if (s != unwantedSupply) {
                newBelongings[index++] = s;
            }
        }
        personalBelongings = newBelongings;
    }



    // Add a family connection by resizing the familyConnections array
    public void addFamilyConnection(FamilyRelation record) {
        if (familyConnections == null) {
            familyConnections = new FamilyRelation[1];
            familyConnections[0] = record;
        } else {
            int len = familyConnections.length;
            FamilyRelation[] newConnections = new FamilyRelation[len + 1];
            for (int i = 0; i < len; i++) {
                newConnections[i] = familyConnections[i];
            }
            newConnections[len] = record;
            familyConnections = newConnections;
        }
    }

    // Remove a family connection
    public void removeFamilyConnection(FamilyRelation exRelation) {
        if (familyConnections == null) return;
        int count = 0;
        for (FamilyRelation fr : familyConnections) {
            if (fr == exRelation) count++;
        }
        if (count == 0) return;
        FamilyRelation[] newConnections = new FamilyRelation[familyConnections.length - count];
        int index = 0;
        for (FamilyRelation fr : familyConnections) {
            if (fr != exRelation) {
                newConnections[index++] = fr;
            }
        }
        familyConnections = newConnections;
    }



    // Add a medical record by resizing the medicalRecords array
    public void addMedicalRecord(MedicalRecord record) {
        if (medicalRecords == null) {
            medicalRecords = new MedicalRecord[1];
            medicalRecords[0] = record;
        } else {
            int len = medicalRecords.length;
            MedicalRecord[] newRecords = new MedicalRecord[len + 1];
            for (int i = 0; i < len; i++) {
                newRecords[i] = medicalRecords[i];
            }
            newRecords[len] = record;
            medicalRecords = newRecords;
        }
    }



    ///////////////////////////////////////////////////////
    //-------------- Helper Functions ------------------//
    /////////////////////////////////////////////////////

    // Validate date format (YYYY-MM-DD)
    private boolean isValidDateFormat(String date) {
        if (date == null) return false;
        return date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }

    // Convert a date string "YYYY-MM-DD" to an integer YYYYMMDD
    private int convertDateStringToInt(String dateStr) {
        return Integer.parseInt(dateStr.replace("-", ""));
    }

    // Generate unique social ID by incrementing the counter
    private int generateSocialID() {
        counter++;
        return counter;
    }


    

}
