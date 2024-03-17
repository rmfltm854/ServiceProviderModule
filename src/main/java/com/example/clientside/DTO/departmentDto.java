package com.example.clientside.DTO;

import com.example.clientside.Entity.department;
import com.example.clientside.Entity.departments_Info;
import com.example.clientside.Entity.humanResourceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class departmentDto {

    private Long idx;

    private String HID;

    private Long DID;

    private int Level;



}
