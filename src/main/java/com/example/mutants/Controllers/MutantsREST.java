package com.example.mutants.Controllers;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import com.example.mutants.DAO.MutantsDAO;
import com.example.mutants.Entities.DNA;
import com.example.mutants.Entities.Human;
import com.example.mutants.Interfaces.IDNAAnalyzerService;
import com.example.mutants.Services.DNAAnalyzer;


@RestController
@RequestMapping("mutant")
public class MutantsREST  extends BaseController {


	@Autowired
	private IDNAAnalyzerService dnaAnalyzer;

	@PostMapping
	public ResponseEntity<String> getMutant(@RequestBody String [] dna) {		

		HttpStatus status;
		String body;
		if(dnaAnalyzer.PurifyTreatment(dna)) {
		try {
			String DNA[] =dna;
			Human human=new Human();
		
			human.isMutant = dnaAnalyzer.isMutant(DNA);
		
			
			if (human.isMutant) {
				status = HttpStatus.OK;
				body = "{\"message\": \"Welcome! Mutant Friend\"}";
			} else {
				status = HttpStatus.FORBIDDEN;
				body = "{\"message\": \"Sorry! only mutants allowed\"}";
			}
		} catch (IllegalArgumentException e) {
			status = HttpStatus.BAD_REQUEST;
			body = e.getMessage();
		}
		
	
		}
		else {
			status = HttpStatus.FORBIDDEN;
			body = "{\"message\": \"\r\n" + 
					"Error Contaminated DNA\"}";
		}
		return ResponseEntity.status(status)
				.contentType(MediaType.APPLICATION_JSON).body(body);
		
	}

}
