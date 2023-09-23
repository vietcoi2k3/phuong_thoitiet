package com.example.weatheradvice.controller;

import com.example.weatheradvice.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviceController {

    @Autowired
    private AdviceRepository adviceRepository;

    @RequestMapping(value = "get-all-advice",method = RequestMethod.GET)
    public ResponseEntity getAllAdvice(){
        return ResponseEntity.ok(adviceRepository.findAll());
    }
}
