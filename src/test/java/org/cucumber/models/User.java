package org.cucumber.models;


import io.cucumber.datatable.DataTable;

import java.util.Map;

public class User {
    private String username;
    private String password;
    private String confirmPassword;
    private String role;
    private String fname, lname;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User createUser(DataTable dataTable, User user) {
        Map<String, String> map = dataTable.asMap();

        for (Map.Entry entry : map.entrySet()) {
            switch ((String) entry.getKey()) {
                case "username":
                    user.setUsername((String) entry.getValue());
                    break;
                case "fName":
                    user.setFname((String) entry.getValue());
                    break;
                case "lName":
                    user.setLname((String) entry.getValue());
                    break;
                case "password":
                    user.setPassword((String) entry.getValue());
                    break;
                case "confirmPassword":
                    user.setConfirmPassword((String) entry.getValue());
                    break;
                case "role":
                    user.setRole((String) entry.getValue());
                    break;
            }
        }
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role='" + role + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
