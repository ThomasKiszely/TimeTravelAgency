package com.thomas.timetravelagency;

import java.util.ArrayList;
import java.util.List;

public class UseCase {
    DatabaseRepository databaseRepository = new DatabaseRepository();

    public String addCustomer(int id, String name, String email){
        Customer customer = new Customer(id, name, email);
        String createCustomer = databaseRepository.createCustomer(customer);
        return createCustomer;
    }

    public List<Customer> getCustomers(){
        List<Customer> customers = databaseRepository.readCustomer();
        return customers;
    }
    public String removeCustomer(Customer customer){
        int id = customer.getId();
        String removed = databaseRepository.deleteCustomer(id);
        return removed;
    }
    public String updateCustomer(Customer customer){
        int id = customer.getId();
        String name = customer.getName();
        String email = customer.getEmail();
        String updated = databaseRepository.updateCustomer(id, name, email);
        return updated;
    }
    public List<TimeMachine> getTimeMachines(){
        List<TimeMachine> timeMachines = databaseRepository.readTimeMachine();
        return timeMachines;
    }
    public List<TimePeriod> getTimePeriods(){
        List<TimePeriod> timePeriods = databaseRepository.readTimePeriod();
        return timePeriods;
    }
    public List<Guide> getGuides(){
        List<Guide> guides = databaseRepository.readGuide();
        return guides;
    }
    public String book(Customer customer, TimeMachine timeMachine, TimePeriod timePeriod, Guide guide){
        int customerId = customer.getId();
        int timeMachineId = timeMachine.getId();
        int timePeriodId = timePeriod.getId();
        int guideId = guide.getId();
        String booked = databaseRepository.createBooking(customerId, timeMachineId, timePeriodId, guideId);
        return booked;
    }
    public List<String> getTimeMachineNames(){
        List<String> timeMachineNames = databaseRepository.getTimeMachineName();
        return timeMachineNames;
    }
    public List<TimeMachine> getTimeMachineFromName(String timeMachineName){
        List<TimeMachine> timeMachineList = databaseRepository.getTimeMachineFromName(timeMachineName);
        return timeMachineList;
    }
    public List<TimePeriod> getTimePeriodFromName(String timePeriodName){
        List<TimePeriod> timePeriodList = databaseRepository.getTimePeriodFromName(timePeriodName);
        return timePeriodList;
    }
    public List<String> getTimePeriodNames(){
        List<String> timePeriodList = databaseRepository.getTimePeriodNames();
        return timePeriodList;
    }
}
