package org.com.dao;

import java.math.BigInteger;

import org.com.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDao extends JpaRepository<Appointment, BigInteger> {

}
