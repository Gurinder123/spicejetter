package com.xebia.jetter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by gurinder on 8/4/16.
 */

@Getter
@Setter
@Entity
@Table(name = "passenger")
public class Passenger implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "flight_passenger", joinColumns = @JoinColumn(name =  "passenger_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "flight_id", referencedColumnName = "id"))
    private Set<Flight> flights;

}
