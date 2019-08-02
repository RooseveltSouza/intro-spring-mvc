/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roosevelt.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Sr. Roosevelt
 */
@Controller
public class MeuController {
    
    @RequestMapping("/")
    public String PrimeiroController(){
        //return "welcome";
        return "redirect:/usuario/todos";
    }
    
}
