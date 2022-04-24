package com.gmail.evanloafakahaitao.prac.class26;

import com.gmail.evanloafakahaitao.prac.class26.impl.UserDAOimpl;
import com.gmail.evanloafakahaitao.prac.class26.service.UserDTOGeneratorService;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        listDrivers();
        UserDAO userDAO = new UserDAOimpl();
        UserDTOGeneratorService userService = new UserDTOGeneratorService();
        List<String> cities = Arrays.asList("Minsk", "Grodno", "Gomel");
        List<UserDTO> userDTOList = userService.generateUsersList(20, 500, 3000, cities);
        userDAO.createTable();
        System.out.printf("Table prob created or exists%n");
        int addedUsers = userDAO.addUsers(userDTOList);
        System.out.printf("Added users = %d%n", addedUsers);

        printUsers(userDAO.getUsers());

        int updatedUsersInRange = userDAO.updateCityInSalaryRange("Warsaw", 1500, 3000);
        System.out.printf("Updates users in range = %d%n", updatedUsersInRange);

        printUsers(userDAO.getUsers());

        int updatedUsersAbove = userDAO.updateCityAboveSalary("Berlin", 2500);
        System.out.printf("Updated users above = %d%n", updatedUsersAbove);

        printUsers(userDAO.getUsers());

        int deletedUsers = userDAO.deleteUsersBelowSalary(1000);
        System.out.printf("Deleted users = %d%n", deletedUsers);


        printUsers(userDAO.getUsers());

        /*userDAO.deleteTable();
        System.out.printf("Table prob deleted%n");*/

    }

    public static void printUsers(List<UserDTO> userDTOList) {
        for (UserDTO userDTO : userDTOList) {
            System.out.println(userDTO);
        }
    }

    private static void listDrivers() {
        Enumeration driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("   "+driverClass.getClass().getName());
        }
    }
}
