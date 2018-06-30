package com.palmarcell.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by gemboly on 2018. 06. 30., 2018
 */

@Entity
@Data
public class PassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String siteName;

    @Column
    private String pass;

    public PassEntity() {
    }

    public PassEntity(String siteName, String pass) {
        this.siteName = siteName;
        this.pass = pass;
    }

}
