package com.example.user.DTO;

import com.example.user.Entity.departments_Info;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class departments_InfoDto {

    private Long DID;


    private String departsName;


    private int max_Level;


    public departments_InfoDto(departments_Info entity){
        DID = entity.getDID();
        departsName = entity.getDepartsName();
        max_Level = entity.getMax_Level();

    }


}