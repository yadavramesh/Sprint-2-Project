package org.com.controller;

import java.util.List;
import java.util.Optional;
import org.com.dao.DiagnosticCenterDao;
import org.com.dao.TestDao;
import org.com.model.DiagnosticCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DiagnosticCenter")
@CrossOrigin("http://localhost:4200")
public class DiagnostiCenterController {
	@Autowired
	DiagnosticCenterDao diagnosticCenterDao;
	@Autowired
	TestDao testDao;
	
	@PostMapping("/AddDiagnosticCenter")
	public DiagnosticCenter saveDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter)
	{
		Optional<DiagnosticCenter> findById=diagnosticCenterDao.findById(diagnosticCenter.getCenterId());
		if(!findById.isPresent())
		{
			diagnosticCenterDao.save(diagnosticCenter);
			System.out.println("done added");
			return diagnosticCenter;
		
		}
		else
			return null;
	}
	@GetMapping("/AllDiagnosticCenter")
	public List<DiagnosticCenter> getAllDiagnosticCenter()
	{
		return diagnosticCenterDao.findAll();
	}

}
