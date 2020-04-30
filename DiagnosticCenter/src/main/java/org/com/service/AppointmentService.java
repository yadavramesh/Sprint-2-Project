package org.com.service;

import java.util.Optional;

import org.com.dao.AppointmentDao;
import org.com.exception.AppointmentNotFoundException;
import org.com.exception.NullDateException;
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
		try {
			if (appointment.getDatetime().equals(null))
				throw new NullDateException("Date cannot be null");
			else
				appointmentDao.save(appointment);
			return "Appointment saved";
		} catch (NullDateException ex) {
			System.out.println(ex);
		}
		return null;
	}

	public String removeAppointment(Appointment appointment) {
		appointmentDao.delete(appointment);
		return "Appointment deleted";
	}

	public Optional<Appointment> findById(String id) {
		Optional<Appointment> appointment = appointmentDao.findById(id);
		try {
			if (appointment != null)
				return appointment;
			else
				throw new AppointmentNotFoundException("Oops!! Appointment not found!");
		} catch (AppointmentNotFoundException ex) {
			System.out.println(ex);
		}
		return null;
	}
}
