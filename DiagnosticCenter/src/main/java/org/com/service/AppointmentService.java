package org.com.service;

import java.util.Optional;

import org.com.dao.AppointmentDao;
import org.com.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
@Autowired
AppointmentDao appointmentDao;
@Autowired
DiagnosticCenterService diagnosticCenterService;

public String saveAppointment(Appointment appointment) {
	appointmentDao.save(appointment);
	return "Appointment saved";
}
public String removeAppointment(Appointment appointment) {
	appointmentDao.delete(appointment);
	return"Appointment deleted";
}
public Optional<Appointment> findById(String id) {
	Optional<Appointment> appointment= appointmentDao.findById(id);
	return appointment;
}
}
