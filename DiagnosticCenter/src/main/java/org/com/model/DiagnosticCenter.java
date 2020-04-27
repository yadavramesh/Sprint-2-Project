package org.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DiagnosticCenter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String centerId;
	private String centerName;
	 @OneToMany(
		        mappedBy = "DiagnosticCenter",
		        cascade = CascadeType.PERSIST,
		        fetch = FetchType.LAZY
		    )
	private List<Test> listOfTest;
	private List<Appointment> appointmentList;
	
	public DiagnosticCenter()
	{
		
	}
	
	public DiagnosticCenter(String centerName) {
		super();
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
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
