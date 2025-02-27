package edu.ucalgary.oop;

public class Location {
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    
    /////////////////////////////////////////////////////
    //-------------- Constructor(s) ------------------//
    ///////////////////////////////////////////////////

    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new DisasterVictim[0];
        this.supplies = new Supply[0];
    }


    /////////////////////////////////////////////
    //-------------- Getters ------------------//
    ////////////////////////////////////////////
    
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public DisasterVictim[] getOccupants() {
        return occupants;
    }
    public Supply[] getSupplies() {
        return supplies;
    }


    //////////////////////////////////////////////
    //-------------- Setters ------------------//
    ////////////////////////////////////////////


    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setOccupants(DisasterVictim[] occupants) {
        this.occupants = occupants;
    }
    public void setSupplies(Supply[] supplies) {
        this.supplies = supplies;
    }


    /////////////////////////////////////////////////////////
    //-------------- Add/Remove Methods ------------------//
    ///////////////////////////////////////////////////////
    
    
    // Add an occupant by creating a new array with an extra slot
    public void addOccupant(DisasterVictim occupant) {
        if (occupants == null) {
            occupants = new DisasterVictim[1];
            occupants[0] = occupant;
        } else {
            int len = occupants.length;
            DisasterVictim[] newOccupants = new DisasterVictim[len + 1];
            for (int i = 0; i < len; i++) {
                newOccupants[i] = occupants[i];
            }
            newOccupants[len] = occupant;
            occupants = newOccupants;
        }
    }
    // Remove an occupant from the array
    public void removeOccupant(DisasterVictim occupant) {
        if (occupants == null || occupants.length == 0) return;
        int count = 0;
        for (DisasterVictim d : occupants) {
            if (d == occupant) count++;
        }
        if (count == 0) return;
        DisasterVictim[] newOccupants = new DisasterVictim[occupants.length - count];
        int index = 0;
        for (DisasterVictim d : occupants) {
            if (d != occupant) {
                newOccupants[index++] = d;
            }
        }
        occupants = newOccupants;
    }


    // Add a supply by resizing the supplies array
    public void addSupply(Supply supply) {
        if (supplies == null) {
            supplies = new Supply[1];
            supplies[0] = supply;
        } else {
            int len = supplies.length;
            Supply[] newSupplies = new Supply[len + 1];
            for (int i = 0; i < len; i++) {
                newSupplies[i] = supplies[i];
            }
            newSupplies[len] = supply;
            supplies = newSupplies;
        }
    }
    // Remove a supply from the array
    public void removeSupply(Supply supply) {
        if (supplies == null || supplies.length == 0) return;
        int count = 0;
        for (Supply s : supplies) {
            if (s == supply) count++;
        }
        if (count == 0) return;
        Supply[] newSupplies = new Supply[supplies.length - count];
        int index = 0;
        for (Supply s : supplies) {
            if (s != supply) {
                newSupplies[index++] = s;
            }
        }
        supplies = newSupplies;
    }




}
