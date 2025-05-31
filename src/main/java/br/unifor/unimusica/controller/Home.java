package br.unifor.unimusica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public String teste() {
        return "Can you hear me, major Tom?";
    
    }}