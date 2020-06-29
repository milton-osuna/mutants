package com.example.mutants.Controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mutants.Interfaces.IDNAAnalyzerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.mutants.Entities.Stats;




@RunWith(SpringRunner.class)
@WebMvcTest(StatsController.class)
public class StatsTest {
	@Autowired
	private MockMvc mocMVC;
	@MockBean
	private IDNAAnalyzerService dnaAnalyzer; 
	@Test
	public void getStats() throws Exception {
	           Stats stats= new Stats(0, 0);
		when(dnaAnalyzer.getStats()).thenReturn(stats);

		mocMVC.perform(get("/stats/")).andExpect(status().isOk())
				.andExpect(content().json(JsonStr(stats)));

		verify(dnaAnalyzer, times(1)).getStats();
		verifyNoMoreInteractions(dnaAnalyzer);
	}
	private static String JsonStr(final Object obj) {
		try {
			return (new ObjectMapper()).writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
