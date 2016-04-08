package com.xebia.jetter.dao;

import com.xebia.jetter.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Created with IntelliJ IDEA.
 * User: HJAIN
 * Date: 4/9/16
 * Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer>{


     Passenger findByUsername(String username);
}
