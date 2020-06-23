package com.xg.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_hotel")
public class Hotels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "hotelname")
    private String hotelname;

    @Column(name = "longitude")
    private String longitude ;

    @Column(name = "dimensionality")
    private String dimensionality ;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "phone")
    private String phone;
}
