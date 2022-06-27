package com.techlead.user.service;

import com.techlead.user.entity.User;
import com.techlead.user.repository.UserRepository;
import com.techlead.user.valueobjects.Department;
import com.techlead.user.valueobjects.ResponseTemplateValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

       return userRepository.save(user);
    }

    public ResponseTemplateValueObject getUserWithDepartment(Long userId) {
        ResponseTemplateValueObject valueObject = new ResponseTemplateValueObject();

        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +
                user.getDepartmentId(), Department.class);

        valueObject.setUser(user);
        valueObject.setDepartment(department);

        return valueObject;

    }
}
