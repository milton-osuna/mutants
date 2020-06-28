package com.example.mutants.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mutants.DAO.StatsDao;
import com.example.mutants.Entities.MutantPatternDNA;
import com.example.mutants.Entities.Stats;
import com.example.mutants.Interfaces.IDNAAnalyzerService;

@Service
public class DNAAnalyzer implements IDNAAnalyzerService {
	@Autowired
	protected StatsDao statsdao;
	public boolean isMutant(String[] dna) {
		boolean isMutant = false;

		isMutant = HorizontalTreatment(dna);		
		if (isMutant) {return isMutant;}   //analiza horizontal
		isMutant = VerticalTreatment(dna);
		if (isMutant) {return isMutant;} //analiza Vertical
		isMutant = ObliqueTreatment(dna);
		

		return isMutant;
	}

	private boolean HorizontalTreatment(String[] dna) {
		boolean isMutant = false;
		// TratamientoHorizontal
		for (int i = 0; i < dna.length; i++) {

			if (dna[i].contains(MutantPatternDNA.DNAType.AAAA.toString())) {
				isMutant = true;
			}
			if (dna[i].contains(MutantPatternDNA.DNAType.CCCC.toString())) {
				isMutant = true;
			}
			if (dna[i].contains(MutantPatternDNA.DNAType.TTTT.toString())) {
				isMutant = true;
			}
			if (dna[i].contains(MutantPatternDNA.DNAType.GGGG.toString())) {
				isMutant = true;
			}

		}
		return isMutant;

	}

	private boolean VerticalTreatment(String[] dna) {
		// obtener cada elemento de 1 columna y reordenarlos para tratarlos
		// horizontalmente.
		boolean isMutant = false;
		List<String> dnapurify = new ArrayList();	
		int y = 0;
		for (int i = 0; i < dna.length; i++) {
			dna[i].replace("\"", "");

			y = y + 1; // cuento cada elemento, me va a determinar cantidad de columnas
		}

		for (int i = 0; i < y; i++) {// recorro cada columna viendo el valor individual
			StringBuilder strBuilder = new StringBuilder();
			String vertical = "";
			for (int v = 0; v < dna[i].length(); v++) {

				vertical = String.valueOf((strBuilder.append(String.valueOf(dna[v].charAt(i)))));
			}
			dnapurify.add(vertical);

		}
		isMutant = HorizontalTreatment(dnapurify.toArray(new String[0]));

		return isMutant;

	}

	private boolean ObliqueTreatment(String[] dna) {
		boolean isMutant = false;
		List<String> dnapurify = new ArrayList<>();
		for (int i = 0; i < dna.length / 2; i++) {
			StringBuffer diag1 = new StringBuffer(dna.length);
			StringBuffer diag2 = new StringBuffer(dna.length);
			for (int j = 0; j < dna.length - i; j++) {
				diag1.append(dna[j].charAt(j + i));
				if (i != 0) {
					diag2.append(dna[i + j].charAt(j));
				}
			}
			if (diag1.length() > 0) {
				dnapurify.add(diag1.toString());

			}
			if (diag2.length() > 0) {
				dnapurify.add(diag2.toString());

			}
			isMutant = HorizontalTreatment(dnapurify.toArray(new String[0]));
		}
		return isMutant;
	}

	public boolean PurifyTreatment(String[] dna) {
		final String PATTERNEXCLUSIVE = "^[CGTA]+$";
		Stream<String> dnaStream = Arrays.stream(dna);
		return dnaStream.allMatch(s -> s.length() >= 4 && s.matches(PATTERNEXCLUSIVE));

	}

	public String ConvertDNAArrayToString(String[] dna) {
		StringBuilder strBuilder = new StringBuilder();
		String[] cutDNA;
		String DNASTRING;
		for (int i = 0; i < dna.length; i++) {
			 cutDNA =dna[i].split(",");  
			 for(int j=0;j<cutDNA.length;j++) {
				 strBuilder.append(cutDNA[j]+","); 
			 }
			  

		}
		DNASTRING="["+strBuilder.toString().substring(0,strBuilder.toString().length()-1)+"]";
		
		return DNASTRING;

	}
	@Override
	public Stats getStats() {
		    long countMutants = statsdao.countAllByIsMutant(true);
	        long countHuman =  statsdao.countAllByIsMutant(false);
	        Stats stats = new Stats(countMutants, countHuman);
	        return stats;
	}


}
