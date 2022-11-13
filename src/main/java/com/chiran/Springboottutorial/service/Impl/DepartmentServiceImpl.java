package com.chiran.Springboottutorial.service.Impl;

import com.chiran.Springboottutorial.entity.Department;
import com.chiran.Springboottutorial.error.DepartmentNotFoundException;
import com.chiran.Springboottutorial.repository.DepartmentRepository;
import com.chiran.Springboottutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }
    @Override
    public Department getDepartment(Long id) throws DepartmentNotFoundException {

        Optional<Department> department =  departmentRepository.findById(id);
        if(!department.isPresent()){
           throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department departmentDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
