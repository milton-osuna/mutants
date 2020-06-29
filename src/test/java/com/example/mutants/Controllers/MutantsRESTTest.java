package com.example.mutants.Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mutants.MockConstants;
import com.example.mutants.DAO.MutantsDAO;
import com.example.mutants.Interfaces.IDNAAnalyzerService;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@WebMvcTest(MutantsREST.class)
public class MutantsRESTTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private IDNAAnalyzerService dnaAnalyzer;
	@MockBean 
	private MutantsDAO mutantsDAO;
	
	@Test
	public void mutantPost() throws Exception {
		mockMvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
				.content(JsonStr(MockConstants.MUTANTDNA)));
	}
	
	
	@Test
	public void mutantPost1() throws Exception {
		mockMvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
				.content(JsonStr(MockConstants.MUTANTDNA)));
	}
	
	private static String JsonStr(final Object obj) {
		try {
			return (new ObjectMapper()).writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	

}
