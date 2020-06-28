package com.example.mutants.Interfaces;


import com.example.mutants.Entities.Stats;



public interface IDNAAnalyzerService  {
	
	  boolean isMutant(String[] dna);
	  boolean PurifyTreatment(String[] dna);
	  String ConvertDNAArrayToString(String[] dna);
	  Stats getStats();
}
