package com.example.user.DTO;

import com.example.user.Entity.humanResourceEntity;
import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class humanResourceDto {

    private Long idx;


    private String name;


    private int age;


    private String HID;


    private String PW;


    private String HIP;

    public humanResourceDto(humanResourceEntity entity){
        idx = entity.getIdx();
        name = entity.getName();
        age = entity.getAge();
        HID = entity.getHID();
        PW = entity.getPW();
        HIP = entity.getHIP();
    }


}
