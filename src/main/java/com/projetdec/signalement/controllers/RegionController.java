package com.projetdec.signalement.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import com.projetdec.signalement.repository.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import com.projetdec.signalement.entite.*;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import java.net.URI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class RegionController{
    private final RegionRepository repository;

    RegionController(RegionRepository repository){
        this.repository = repository;
    }

    @GetMapping("/regions")
    public String getRegion() throws Exception {
        List<Region> val = repository.findAll();
        Gson gson = new Gson();
        String rep = gson.toJson(val);
        return rep;
    }

    @GetMapping("/")
    public String helloworld() throws Exception {
        return "BISOUS BE FA METY";
    }
    

}