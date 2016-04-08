package com.xebia.jetter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


/**
 * Created by gurinder on 8/4/16.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String flightName;

    @Column
    private boolean flyingStatus;

    @Column
    private String source;

    @Column String destination;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "flight_passenger", joinColumns = @JoinColumn(name =  "passenger_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id", referencedColumnName = "id"))
    private Set<Passenger> passengers;

}
