package com.clinicals.api.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="clinicaldata")
@JsonIgnoreProperties({"patient"})	// tells jackson to ignore the pulling of patient data which if pulled would again pull ClinicalData causing a continuous loop 
public class ClinicalData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String componentName;
	private String componentValue;
	
	@CreationTimestamp
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, updatable = false)
	private Timestamp measuredDateTime;
	
	@ManyToOne(fetch=FetchType.LAZY)	// many clinical data to one patient
	@JoinColumn(name="patient_id", nullable = false) // CONSTRAINT fk_patient FOREIGN KEY (patient_id)	
	private Patient patient;	// ClinicalData is owned by a patient
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentValue() {
		return componentValue;
	}
	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
	public Timestamp getMeasuredDateTime() {
		return measuredDateTime;
	}
	public void setMeasuredDateTime(Timestamp measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
