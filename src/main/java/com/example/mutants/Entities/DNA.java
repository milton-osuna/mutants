package com.example.mutants.Entities;
import javax.persistence.*;

@Entity
@Table(name="humans")
public class DNA {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int Id;
	
    @Column(name="DNA",unique = true, nullable = false)
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
	public void setId(int id) {
		Id = id;
	}
	public boolean isMutant() {
		return isMutant;
	}
	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

}
