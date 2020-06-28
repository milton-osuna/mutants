package com.example.mutants.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mutants.Interfaces.IDNAAnalyzerService;
import com.fasterxml.jackson.databind.ObjectMapper;




public class BaseController {
	    @Autowired      
	    protected IDNAAnalyzerService dnaAnalyzer;
	    @Autowired
	    protected ObjectMapper bodyObjMap;
}
