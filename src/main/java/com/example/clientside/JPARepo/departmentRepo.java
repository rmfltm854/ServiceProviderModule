package com.example.clientside.JPARepo;

import com.example.clientside.Entity.department;
import com.example.clientside.Entity.humanResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface departmentRepo extends JpaRepository<department,Long> {

    List<department> findDepartmentByHID(humanResourceEntity entity);

}
