package com.techlead.department.service;


import com.techlead.department.entity.Department;
import com.techlead.department.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {


    private final DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {

        return departmentRepository.findByDepartmentId(departmentId);
    }
}
