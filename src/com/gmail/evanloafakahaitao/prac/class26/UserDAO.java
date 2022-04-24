package com.gmail.evanloafakahaitao.prac.class26;

import java.util.List;

public interface UserDAO {

    int addUsers(final List<UserDTO> userDTOList);

    List<UserDTO> getUsers();

    void createTable();

    void deleteTable();

    int updateCityInSalaryRange(String city, int minSalaryRange, int maxSalaryRange);

    int updateCityAboveSalary(String city, int salary);

    int deleteUsersBelowSalary(int salary);
}
