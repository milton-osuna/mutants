package com.example.mutants.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mutants.Entities.Stats;
import com.fasterxml.jackson.core.JsonProcessingException;
@Controller
@RequestMapping(path = "/stats")
public class StatsController extends BaseController {

    @GetMapping
    public ResponseEntity<String> GetStats() throws JsonProcessingException {
        Stats stats = dnaAnalyzer.getStats();
        String body = bodyObjMap.writeValueAsString(stats);
        return ResponseEntity.ok(body);
    }
}