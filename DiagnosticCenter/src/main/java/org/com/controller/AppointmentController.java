package org.com.controller;



import java.util.List;
import java.util.Optional;

import org.com.dao.AppointmentDao;
import org.com.dao.DiagnosticCenterDao;
import org.com.dao.TestDao;
import org.com.model.Appointment;
import org.com.model.DiagnosticCenter;
import org.com.service.AppointmentService;
import org.com.service.DiagnosticCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Appointment")
@CrossOrigin("http://localhost:4200")
public class AppointmentController {
	@Autowired
	TestDao testDao;
	@Autowired
	DiagnosticCenterDao diagnosticCenterDao;
	@Autowired
	DiagnosticCenterService diagnosticCenterService;
	@Autowired
	AppointmentDao appointmentDao;
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/MakeAppointment")
	public void makeAppointment(@RequestBody Appointment appointment)
	{   
		diagnosticCenterService.appointmentList().add(appointment);
		System.out.println("Your appointment confirmation is pending!!");
		
	}
	
	@GetMapping("/ApproveAppointment/{id}")
	public List<Appointment> approveAppointment(@PathVariable("id") int centerId) 
	{
		Optional<DiagnosticCenter> ds= diagnosticCenterService.findById(centerId);
		if(ds.isPresent())
		return diagnosticCenterService.appointmentList();
		else
			return null;
	}
	
	@PostMapping("/Approved")
	public void approved(@RequestBody Appointment appointment) {
		appointment.setApproved(true);
		appointmentService.saveAppointment(appointment);
	}

	@PostMapping("NotApproved")
	public void notApproved(@RequestBody Appointment appointment) {
		appointment.setApproved(false);
		appointmentService.removeAppointment(appointment);
	}
	
	@GetMapping("/AppointmentStatus/{id}")
	public String appointmentStatus(@PathVariable("id") String appointmentId)
	{
		if((appointmentService.findById(appointmentId)).isPresent())
			return "Your appointment is confirmed!!";
		else
			return "Sorry! No appointment available for selected slot";
		
		}
		
	}
	
