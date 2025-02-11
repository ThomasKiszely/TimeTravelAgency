package com.thomas.timetravelagency;

public class TimeMachine {
    private int id;
    private String name;
    private String capacity;
    private Boolean status;

    public TimeMachine(int id, String name, String capacity, Boolean status) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCapacity() {
        return capacity;
    }
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return (name + "\t" + capacity + "\t" + status);
    }
}
