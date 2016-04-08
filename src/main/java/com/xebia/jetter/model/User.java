package com.xebia.jetter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by gurinder on 8/4/16.
 */

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;


}
