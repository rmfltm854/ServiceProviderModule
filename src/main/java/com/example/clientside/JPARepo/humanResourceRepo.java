package com.example.clientside.JPARepo;

import com.example.clientside.Entity.humanResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface humanResourceRepo extends JpaRepository<humanResourceEntity, Long> {

    humanResourceEntity findByHID(String HID);

    List<humanResourceEntity> findAll();

}
