package com.example.clientside.Entity;

import com.example.clientside.DTO.humanResourceDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="HUMANRESOURCES")
public class humanResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 10, nullable = false, name="name")
    private String name;

    @Column(nullable = false, name="age")
    private int age;

    @Column(nullable = false, name="HID",unique = true)
    private String HID;

    @Column(nullable = false, name="PW")
    private String PW;

    @Column(nullable = false, name="HIP")
    private String HIP;

    @Builder
    public humanResourceEntity(humanResourceDto dto) {
        this.idx = dto.getIdx();
        this.name = dto.getName();
        this.age = dto.getAge();
        this.HID = dto.getHID();
        this.PW = dto.getPW();
        this.HIP = dto.getHIP();
    }


}
