package com.example.mutants.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.mutants.Entities.DNA;

public interface StatsDao extends CrudRepository<DNA, Integer> {
 
    long countAllByIsMutant(Boolean isMutant);
}