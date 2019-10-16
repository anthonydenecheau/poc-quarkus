package com.scc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Dog extends PanacheEntity {
	
    @NotBlank @Column
    public String name;

    @Column(unique = true)
    public String chip;

    @Column(unique = true)
    public String tattoo;

    @Column
    public String dateOfBirth;

    @Column
    public int numCase;

    @NotBlank @Column
    public String gender;

}
