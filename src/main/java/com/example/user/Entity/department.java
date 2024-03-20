package com.example.user.Entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="department")
public class department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name="HID",referencedColumnName = "HID",unique = true)
    private humanResourceEntity HID;

    @ManyToOne
    @JoinColumn(name="DID",referencedColumnName = "DID")
    private departments_Info DID;

    @Column( nullable = false, name = "Level")
    private int Level;

    @Builder
    public department(int Level,humanResourceEntity entity,departments_Info dInfo) {
        this.HID = entity;
        this.Level = Level;
        this.DID = dInfo;
    }
}
