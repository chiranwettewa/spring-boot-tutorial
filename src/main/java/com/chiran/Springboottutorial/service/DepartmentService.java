package com.chiran.Springboottutorial.service;

import com.chiran.Springboottutorial.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department getDepartment(Long id);

    public void deleteDepartmentById(Long id);

    public Department updateDepartmentById(Long departmentId,Department department);
}
