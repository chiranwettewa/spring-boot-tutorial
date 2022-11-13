package com.chiran.Springboottutorial.service;

import com.chiran.Springboottutorial.entity.Department;
import com.chiran.Springboottutorial.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department getDepartment(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartmentById(Long departmentId,Department department);

    public Department fetchDepartmentByName(String departmentName);
}
