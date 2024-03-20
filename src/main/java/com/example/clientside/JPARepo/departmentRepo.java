package com.example.clientside.JPARepo;

import com.example.clientside.Entity.department;
import com.example.clientside.Entity.humanResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface departmentRepo extends JpaRepository<department,Long> {

    Optional<department> findDepartmentByHID(humanResourceEntity entity);

}
