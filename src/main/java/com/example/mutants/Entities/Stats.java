package com.example.mutants.Entities;

public class Stats {
	private long count_mutant_dna;
	private long count_human_dna;


	public Stats(long countMutants, long countHuman) {
		this.count_mutant_dna = countMutants;
		this.count_human_dna = countHuman;
	}

	public long getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public long getCount_human_dna() {
		return count_human_dna;
	}

	public float getRatio() {
		long total = count_mutant_dna + count_human_dna;
		if (total == 0) {
			return 1f;
		} else {
			return count_mutant_dna / (float) total;
		}
	}

}
