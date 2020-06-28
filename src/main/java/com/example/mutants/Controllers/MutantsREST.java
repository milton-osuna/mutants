package com.example.mutants.Controllers;

import java.util.List;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mutants.DAO.MutantsDAO;
import com.example.mutants.Entities.MutantPatternDNA;
import com.example.mutants.Entities.DNA;
import com.example.mutants.Interfaces.IDNAAnalyzerService;
import com.example.mutants.Services.DNAAnalyzer;

@RestController
@RequestMapping(path = "/mutant")
public class MutantsREST extends BaseController {

	@Autowired
	private IDNAAnalyzerService dnaAnalyzer;

	@Autowired
	private MutantsDAO mutantsdao;

	@PostMapping
	public ResponseEntity<String> getMutant(@RequestBody String[] dna) {
		HttpStatus status;
		String body;

		if (dnaAnalyzer.PurifyTreatment(dna)) {
			try {

				DNA dnaType = new DNA();
				dnaType.MuestraDNA = dnaAnalyzer.ConvertDNAArrayToString(dna);
				dnaType.isMutant = dnaAnalyzer.isMutant(dna);

				if (dnaType.isMutant) {
					status = HttpStatus.OK;
					body = "{\"message\": \"Mutant DNA detected! Access Granted\"}";
				} else {
					status = HttpStatus.FORBIDDEN;
					body = "{\"message\": \"Not Mutant DNA detected, access Denied!\"}";
				}
				mutantsdao.save(dnaType);
			} catch (IllegalArgumentException e) {
				status = HttpStatus.BAD_REQUEST;
				body = e.getMessage();
			}

		} else {
			status = HttpStatus.FORBIDDEN;
			body = "{\"message\": \"\r\n" + "Error! Contaminated DNA, test again.\"}";
		}
		return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(body);
	}

}
