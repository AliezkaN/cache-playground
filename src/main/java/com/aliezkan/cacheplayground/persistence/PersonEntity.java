package com.aliezkan.cacheplayground.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "person_info")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "social_security_number")
    private String socialSecurityNumber;
    @Column(name = "favorite_color")
    private String favoriteColor;
    @Column(name = "blood_type")
    private String bloodType;
    @Column(name = "favorite_book")
    private String favoriteBook;
    @Column(name = "favorite_movie")
    private String favoriteMovie;
    @Column(name = "zodiac_sign")
    private String zodiacSign;
}
