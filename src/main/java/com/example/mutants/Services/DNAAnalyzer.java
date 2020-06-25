package com.example.mutants.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.example.mutants.Entities.DNA;
import com.example.mutants.Interfaces.IDNAAnalyzerService;

@Service
public class DNAAnalyzer implements IDNAAnalyzerService {

	public boolean isMutant(String[] dna) {
		boolean isMutant = false;

		isMutant = HorizontalTreatment(dna);
		isMutant = VerticalTreatment(dna);
		isMutant = ObliqueTreatment(dna);

		return isMutant;
	}

	private boolean HorizontalTreatment(String[] dna) {
		boolean isMutant = false;
		// TratamientoHorizontal
		for (int i = 0; i < dna.length; i++) {

			if (dna[i].contains(DNA.DNAType.AAAA.toString())) {
				isMutant = true;
			}
			if (dna[i].contains(DNA.DNAType.CCCC.toString())) {
				isMutant = true;
			}
			if (dna[i].contains(DNA.DNAType.TTTT.toString())) {
				isMutant = true;
			}
			if (dna[i].contains(DNA.DNAType.GGGG.toString())) {
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
		int x = dna.length;
		int y = 0;
		for (int i = 0; i < dna.length; i++) {
			dna[i].replace("\"", "");

			y = y + 1; // cuento cada elemento, me va a determinar las columnas
		}

		for (int i = 0; i < y; i++) {// recorro cada columna
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
		final String PATTERNEXCLUSIVE = "^[AGTC]+$";
		Stream<String> dnaStream = Arrays.stream(dna);
		return dnaStream.allMatch(s -> s.length() >= 4 && s.matches(PATTERNEXCLUSIVE));

	}
}
