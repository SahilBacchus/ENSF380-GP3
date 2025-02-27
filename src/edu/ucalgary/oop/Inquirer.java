package edu.ucalgary.oop;

public class Inquirer {
    private String FIRST_NAME;
    private String LAST_NAME;
    private String SERVICES_PHONE;
    private String INFO;


    /////////////////////////////////////////////////////
    //-------------- Constructor(s) ------------------//
    ///////////////////////////////////////////////////

    public Inquirer(String firstName, String lastName, String phone, String info) {
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.SERVICES_PHONE = phone;
        this.INFO = info;
    }


    
    /////////////////////////////////////////////
    //-------------- Getters ------------------//
    ////////////////////////////////////////////
    
    public String getFirstName() {
        return FIRST_NAME;
    }
    public String getLastName() {
        return LAST_NAME;
    }
    public String getServicesPhoneNum() {
        return SERVICES_PHONE;
    }
    public String getInfo() {
        return INFO;
    }


}
