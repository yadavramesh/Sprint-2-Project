package org.com.service;

import java.util.List;
import java.util.Optional;

import org.com.dao.AppointmentDao;
import org.com.dao.DiagnosticCenterDao;
import org.com.exception.DiagnosticCenterNotAdded;
import org.com.model.Appointment;
import org.com.model.DiagnosticCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DiagnosticCenterService {
	@Autowired
	DiagnosticCenterDao diagnosticCenterDao;
	@Autowired
	AppointmentDao appointmentDao;
	public DiagnosticCenter saveDiagnosticCenter( DiagnosticCenter diagnosticCenter) {
		Optional<DiagnosticCenter> findById = diagnosticCenterDao.findById(diagnosticCenter.getCenterId());
		try {
			if (!findById.isPresent()) {
				diagnosticCenterDao.save(diagnosticCenter);
				return diagnosticCenter;

			} else
				throw new DiagnosticCenterNotAdded("Diagnostic Center Already Added");
		} catch (DiagnosticCenterNotAdded e) {
			// TODO: handle exception
			throw new DiagnosticCenterNotAdded("Diagnostic Center Already Added");
		}
	}

	public List<DiagnosticCenter> getAllDiagnosticCenter() {
		return diagnosticCenterDao.findAll();
	}

	public String delDiagnostic( int centerId) {
		Optional<DiagnosticCenter> findById = diagnosticCenterDao.findById(centerId);
		if (findById.isPresent()) {
			diagnosticCenterDao.deleteById(centerId);
			return "DiagnosticCenter  Remove";
		} else
			return "DiagnosticCenter not found";
	}

	public String updateDiagnostic( DiagnosticCenter diagnosticCenter) {
		Optional<DiagnosticCenter> findById = diagnosticCenterDao.findById(diagnosticCenter.getCenterId());
		if (findById.isPresent()) {
			diagnosticCenterDao.save(diagnosticCenter);
			return "DiagnosticCenter updated";

		} else
			return "DiagnosticCenter not found";
	}
	public Optional<DiagnosticCenter> findById(@PathVariable("id") int centerId)
	{
		Optional<DiagnosticCenter> findById=diagnosticCenterDao.findById(centerId);
		return findById;
	}

	public String deleteById(int centerId) {
		// TODO Auto-generated method stub
		Optional<DiagnosticCenter> findById=diagnosticCenterDao.findById(centerId);
		if (findById.isPresent()) {
			diagnosticCenterDao.deleteById(centerId);
			return "DiagnosticCenter  Remove";

		} else
			return "DiagnosticCenter not found";
	}
	
	public List<Appointment> appointmentList(){
		return appointmentDao.findAll();
		
	}
}