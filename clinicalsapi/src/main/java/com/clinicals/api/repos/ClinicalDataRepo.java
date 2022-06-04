package com.clinicals.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalDataRepo extends JpaRepository<com.clinicals.api.model.ClinicalData, Integer> {

}
