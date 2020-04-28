package org.com.controller;

import java.util.List;
import org.com.model.DiagnosticCenter;
import org.com.service.DiagnosticCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DiagnosticCenter")
@CrossOrigin("http://localhost:4200")
public class DiagnostiCenterController {
	@Autowired
	DiagnosticCenterService service;

	@PostMapping("/AddDiagnosticCenter")
	public String saveDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
		service.saveDiagnosticCenter(diagnosticCenter);
		return "Diagostic Center is Added";
	}

	@GetMapping("/AllDiagnosticCenter")
	public List<DiagnosticCenter> getAllDiagnosticCenter() {
		return service.getAllDiagnosticCenter();
	}

	@DeleteMapping("/deleteDiagnosticCenter/{id}")
	public String delProduct(@PathVariable("id") int centerId) {
		service.delDiagnostic(centerId);
		return "Deleted Diagnostic Center";
		
	}

	@PutMapping("/UpdateDiagnosticCenter")
	public String updateProduct(@RequestBody DiagnosticCenter diagnosticCenter) {
		service.updateDiagnostic(diagnosticCenter);
		return "Updated Diagnostic Center";
		
	}

}
