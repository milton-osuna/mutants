package com.example.mutants.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mutants.Entities.DNA;

public interface MutantsDAO extends JpaRepository <DNA,String> {

}
