package org.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "seq", initialValue = 1000, allocationSize = 100)
public class DiagnosticCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int centerId;
	@NotNull
	private String centerName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private List<Test> listOfTest;
	private List<Appointment> appointmentList;

	public DiagnosticCenter() {

	}

	public DiagnosticCenter(String centerName, List<Test> listOfTest) {
		super();
		this.centerName = centerName;
		this.listOfTest = listOfTest;
	}

	public int getCenterId() {
		return centerId;
	}

	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public List<Test> getListOfTest() {
		return listOfTest;
	}

	public void setListOfTest(List<Test> listOfTest) {
		this.listOfTest = listOfTest;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

}