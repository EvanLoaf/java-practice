package com.gmail.evanloafakahaitao.prac.class26.service;

import com.gmail.evanloafakahaitao.prac.class26.UserDTO;
import com.gmail.evanloafakahaitao.util.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDTOGeneratorService {

    public List<UserDTO> generateUsersList(int amount, int minSalary, int maxSalary, List<String> cities) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName("Name" + i);
            userDTO.setCity(cities.get(InputService.getRandomNumberInRange(0, cities.size() - 1)));
            userDTO.setSalary(InputService.getRandomNumberInRange(minSalary, maxSalary));
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
