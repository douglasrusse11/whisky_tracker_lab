package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping (value = "/whiskysbyyear")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(name = "year") int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskeyByYear(year), HttpStatus.OK);
    }

    @GetMapping (value = "/whiskysbydistilleryidandage")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryIdAndAge(@RequestParam(name = "id") long id,
                                                                      @RequestParam(name= "age") int age){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryIdAndAge(id, age), HttpStatus.OK);
    }

    @GetMapping (value = "/whiskysbydistilleryregion")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryregion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
    }
}
