package org.com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String testId;
	private String testName;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centerId", referencedColumnName = "id")
	private DiagnosticCenter diagnosticCenter;
	
	public Test() {
		
	}
	
	public Test(String testName) {
		super();
		this.testName = testName;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	
	

}
