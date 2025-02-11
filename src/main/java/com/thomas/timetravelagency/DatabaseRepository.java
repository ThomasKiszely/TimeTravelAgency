package com.thomas.timetravelagency;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxPrepare;
import javafx.scene.chart.PieChart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    public DatabaseRepository() {}

    //Create customer
    public String createCustomer(Customer customer) {
        String sql = "INSERT INTO customer (id, name, email) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getEmail());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0){
            return "Customer created successfully";
        }
        else {
            return "Customer creation failed";
            }
        }
        catch (SQLException e){
            return "Customer creation failed";
        }
    }
    //Read customer
    public List<Customer> readCustomer(){
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try(Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Customer customer = new Customer(id,name,email);
                customers.add(customer);
            }

    }catch (SQLException e){
            e.printStackTrace();
        }
        return customers;
    }

    //Update customer
    public String updateCustomer(int id,String name, String email){
        String sql = "UPDATE customer SET name = ?, email = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0){
                return "Customer updated successfully";
            }
            else {
                return "Customer update failed";
            }
        }catch (SQLException e){
            return "Customer update failed";
        }
    }
    //Delete customer
    public String deleteCustomer(int id){
        String sql = "DELETE FROM customer WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int deletedRows = preparedStatement.executeUpdate();
            if (deletedRows > 0){
                return "Customer deleted successfully";
            }
            else {
                return "Customer deletion failed";
            }
        } catch (SQLException e){
            return "Customer deletion failed";
        }
    }
    //Create TimeMachine
    public String createTimeMachine(int id, String name, String capacity, Boolean status){
        String sql = "INSERT INTO time_machine (id, name, capacity, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, capacity);
            preparedStatement.setBoolean(4, status);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                return "Time machine created successfully";
            }
            else {
                return "Time machine creation failed";
            }

        } catch (SQLException e){
            return "Time machine creation failed";
        }
    }
    //Read timemachines
    public List<TimeMachine> readTimeMachine(){
        List<TimeMachine> timeMachines = new ArrayList<>();
        String sql = "SELECT * FROM time_machine";
        try (Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String capacity = resultSet.getString("capacity");
                Boolean status = resultSet.getBoolean("status");
                TimeMachine timeMachine = new TimeMachine(id,name,capacity,status);
                timeMachines.add(timeMachine);
                System.out.println(timeMachine);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return timeMachines;
    }
    //Update Time Machine
    public String updateTimeMachine(int id, String name, String capacity, Boolean status){
        String sql = "UPDATE time_machine SET name = ?, capacity = ?, status = ? WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, capacity);
            preparedStatement.setBoolean(3, status);
            preparedStatement.setInt(4, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0){
                return "Time machine updated successfully";
            }
            else {
                return "Time machine update failed";
            }
        } catch (SQLException e){
            return "Time machine update failed";
        }
    }
    //delete time machine
    public String deleteTimeMachine(int id){
        String sql = "DELETE FROM time_machine WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int deletedRows = preparedStatement.executeUpdate();
            if (deletedRows > 0){
                return "Time machine deleted successfully";
            }
            else {
                return "Time machine delete failed";
            }
        }catch (SQLException e){
            return "Time machine delete failed";
        }
    }

    //Create timeperiod
    public String createTimePeriod(int id, String name, String description){
        String sql = "INSERT INTO time_period (id, name, description) VALUES (?, ?, ?)";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                return "Time period created successfully";
            }
            else {
                return "Time period creation failed";
            }
        }catch (SQLException e){
            return "Time period creation failed";
        }
    }
    //Read time period
    public List<TimePeriod> readTimePeriod(){
        List<TimePeriod> timePeriods = new ArrayList<>();
        String sql = "SELECT * FROM time_period";
        try(Connection conn = DatabaseConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                TimePeriod period = new TimePeriod(id, name, description);
                timePeriods.add(period);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return timePeriods;
    }
    //Update timeperiod
    public String updateTimePeriod(int id, String name, String description){
        String sql = "UPDATE time_period SET name = ?, description = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0){
                return "Time period updated successfully";
            }
            else {
                return "Time period update failed";
            }
        }catch (SQLException e){
            return "Time period update failed";
        }
    }
    //delete timeperiod
    public String deleteTimePeriod(int id){
        String sql = "DELETE FROM time_period WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0){
                return "Time period deleted successfully";
            }
            else {
                return "Time period delete failed";
            }
        }catch (SQLException e){
            return "Time period delete failed";
        }
    }
    //guides: id, name, specialty.
    //Create guide
    public String createGuide(int id, String name, String specialty){
        String sql = "INSERT INTO guide (id, name, specialty) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, specialty);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0){
                return "Guide created successfully";
            }
            else {
                return "Guide create failed";
            }
        } catch (SQLException e){
            return "Guide create failed";
        }
    }
    //Read guide
    public List<Guide> readGuide(){
        List<Guide> guideList = new ArrayList<>();
        String sql = "SELECT * FROM guide";
        try (Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                Guide guide = new Guide(id, name, specialty);
                guideList.add(guide);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return guideList;
    }
    //Update guider
    public String updateGuide(int id, String name, String specialty){
        String sql = "UPDATE guide SET name = ?, specialty = ? WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, specialty);
            preparedStatement.setInt(3, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0){
                return "Guide updated successfully";
            }
            else {
                return "Guide update failed";
            }
        }catch (SQLException e){
            return "Guide update failed";
        }
    }
    //Delete guide
    public String deleteGuide(int id){
        String sql = "DELETE FROM guide WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0){
                return "Guide deleted successfully";
            }
            else {
                return "Guide delete failed";
            }
        }catch (SQLException e){
            return "Guide delete failed";
        }
    }
    //Create booking
    public String createBooking(int customerId, int timeMachineId, int timePeriodId, int guideId) {
        String sql = "INSERT INTO booking (customer_id, time_machine_id, time_period_id, guide_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerId);
            preparedStatement.setInt(2, timeMachineId);
            preparedStatement.setInt(3, timePeriodId);
            preparedStatement.setInt(4, guideId);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                return "Booking created successfully";
            } else {
                return "Booking create failed";
            }
        } catch (SQLException e) {
            return "Booking create failed";
        }
    }
        //Read booking
        public List<Booking> readBooking() {
        List<Booking> bookingList = new ArrayList<>();
        String sql = "SELECT * FROM booking";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
             while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerId = resultSet.getInt("customer_id");
                int timeMachineId = resultSet.getInt("time_machine_id");
                int timePeriodId = resultSet.getInt("time_period_id");
                int guideId = resultSet.getInt("guide_id");
                Booking booking = new Booking(id, customerId, timeMachineId, timePeriodId, guideId);
                bookingList.add(booking);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingList;
    }
    //Update booking
    public String updateBooking(int id, int customerId, int timeMachineId, int timePeriodId, int guideId) {
        String sql = "UPDATE booking SET customer_id = ?, time_machine_id = ?, time_period_id, guide_id WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                return "Booking created successfully";
            }
            else {
                return "Booking create failed";
            }
        }catch (SQLException e){
            return "Booking create failed";
        }
    }
    //Delete booking
    public String deleteBooking(int id){
        String sql = "DELETE FROM booking WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0){
                return "Booking deleted successfully";
            }
            else {
                return "Booking delete failed";
            }
        }catch (SQLException e){
            return "Booking delete failed";
        }
    }
    public List<String> getTimeMachineName(){
        List<String> timeMachineList = new ArrayList<>();
        String sql = "SELECT name FROM time_machine";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()){
                String name = resultSet.getString("name");
                timeMachineList.add(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return timeMachineList;
    }
    public List<TimeMachine> getTimeMachineFromName(String name){
        List<TimeMachine> timeMachineList = new ArrayList<>();
        String sql = "SELECT * FROM time_machine WHERE name = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             preparedStatement.setString(1, name);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                 int id = resultSet.getInt("id");
                 String capacity = resultSet.getString("capacity");
                 Boolean status = resultSet.getBoolean("status");
                 TimeMachine timeMachine = new TimeMachine(id,name,capacity,status);
                 timeMachineList.add(timeMachine);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }return timeMachineList;
    }
    public List<TimePeriod> getTimePeriodFromName(String name){
        List<TimePeriod> timePeriodList = new ArrayList<>();
        String sql = "SELECT * FROM time_period WHERE name = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                TimePeriod timePeriod = new TimePeriod(id,name,description);
                timePeriodList.add(timePeriod);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }return timePeriodList;
    }
    public List<String> getTimePeriodNames(){
        List<String> timePeriodList = new ArrayList<>();
        String sql = "SELECT name FROM time_period";
        try(Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                String name = resultSet.getString("name");
                timePeriodList.add(name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return timePeriodList;
    }

    //id, customer_id, time_machine_id, time_period_id, guide_id.
}
