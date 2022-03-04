package org.cucumber.models;

public class UserBuilder {

    public static User admin() {
        User user = new User("admin", "admin");
        user.setFname("Ivan");
        user.setLname("Petrov");
        user.setRole("DEVELOPER");
        return user;
    }

    public static User newUser() {
        User user = new User("lukeS", "newHope");
        user.setFname("Luke");
        user.setLname("Skywalker");
        user.setRole("USER");
        return user;
    }

    public static User createUser(String name, String fName, String lName, String password, String confirmPassword, String role) {
        User user = new User();
        user.setUsername(name);
        user.setFname(fName);
        user.setLname(lName);
        user.setPassword(password);
        user.setConfirmPassword(confirmPassword);
        user.setRole(role);
        return user;
    }
}
