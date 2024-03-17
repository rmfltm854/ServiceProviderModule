package com.example.clientside.Entity;

import com.example.clientside.DTO.departments_InfoDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name="departmentsInfo")
public class departments_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DID;

    @Column(length = 10, nullable = false, name = "departsName")
    private String departsName;

    @Column( nullable = false, name = "max_Level")
    private int max_Level;




    @Builder
    public departments_Info(departments_InfoDto dto) {
        this.DID = dto.getDID();
        this.departsName = dto.getDepartsName();
        this.max_Level = dto.getMax_Level();
    }
}