package com.example.mutants.Services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

import com.example.mutants.MockConstants;
import com.example.mutants.DAO.MutantsDAO;
import com.example.mutants.DAO.StatsDao;
import com.example.mutants.Interfaces.IDNAAnalyzerService;
@TestPropertySource(locations = {"classpath:application.properties"})
@ContextConfiguration
@RunWith(SpringRunner.class)
public class DNAAnalyzerTest {
	@TestConfiguration
	static class DnaAnalyzerServiceTestContextConfiguration {

		@Bean
		public IDNAAnalyzerService dnaService() {
			return new DNAAnalyzer();
		}
	}
	@Autowired
	private IDNAAnalyzerService dnaAService;
	@MockBean
	protected StatsDao statsdao;

	
	@Test
	public void isMutantDnaHorizontal() {
		assertTrue(dnaAService.isMutant(MockConstants.HORIZONTALDNA));
	}
	@Test
	public void isMutantDnaOblique() {
		assertTrue(dnaAService.isMutant(MockConstants.OBLIQUEDNA));
	}
	@Test
	public void isMutantDnaVertical() {
		assertTrue(dnaAService.isMutant(MockConstants.VERTICALDNA));
	}
	@Test
	public void isMutantDnaError() {
		assertTrue(!dnaAService.PurifyTreatment(MockConstants.ERRORDNA));
	}
}
