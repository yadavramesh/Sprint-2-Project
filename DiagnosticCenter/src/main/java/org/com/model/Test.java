package org.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Test {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int testId;
	@NotNull
	private String testName;
	public Test() {
		
	}
	
	public Test(String testName) {
		super();
		this.testName = testName;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	
	

}
