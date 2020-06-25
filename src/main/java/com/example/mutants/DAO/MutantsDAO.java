package com.example.mutants.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mutants.Entities.Human;

public interface MutantsDAO extends JpaRepository <Human,Long> {

}
