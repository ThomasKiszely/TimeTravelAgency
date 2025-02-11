package com.thomas.timetravelagency;

public class Guide {
    //guides: id, name, specialty.
    private int id;
    private String name;
    private String specialty;

    public Guide(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSpecialty() {
        return specialty;
    }
    @Override
    public String toString() {
        return "Guide " + id + ", name: " + name + ", specialty: " + specialty;
    }

}
