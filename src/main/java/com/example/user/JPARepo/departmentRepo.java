package com.example.user.JPARepo;

import com.example.user.Entity.department;
import com.example.user.Entity.humanResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface departmentRepo extends JpaRepository<department,Long> {

    Optional<department> findDepartmentByHID(humanResourceEntity entity);

}
