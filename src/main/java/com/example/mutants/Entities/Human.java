package com.example.mutants.Entities;
import javax.persistence.*;

@Entity
@Table(name="humans")
public class Human {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long Id;
	

	@Column(name="dna", unique = true, nullable = false)
	public String MuestraDNA;
	
	@Column(name="mutant")
	public boolean isMutant;
	
	public String getMuestraDNA() {
		return MuestraDNA;
	}
	public void setMuestraDNA(String muestraDNA) {
		MuestraDNA = muestraDNA;
	}

	

	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public boolean isMutant() {
		return isMutant;
	}
	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

}
