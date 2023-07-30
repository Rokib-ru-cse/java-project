package com.bitspondon.rokibspringboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "FIRST_NAME")
    @NotNull
    private String firstName;

    @Column(name = "LAST_NAME")
    @Min(value = 3, message = "last name must be at least 3 character")
    @NotEmpty
    private String lastName;

    @Column(name = "EMAIL")
    @Email
    private String email;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "CONTACT")
    @Size(min = 4, message = "size must be greater than 4 character")
    private String contactNo;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "DOB")
    private String dob;


}

