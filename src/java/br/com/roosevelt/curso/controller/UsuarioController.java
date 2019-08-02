/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roosevelt.curso.controller;

import br.com.roosevelt.curso.dao.UsuarioDao;
import br.com.roosevelt.curso.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Sr. Roosevelt
 */
@Controller
@RequestMapping("usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioDao dao;
    
    @RequestMapping(value = "/todos")
    public ModelAndView listaTodos(ModelMap model){
        model.addAttribute("usuario", dao.getTodos());
        
        return new ModelAndView("/user/list", model);
    }
    
    @RequestMapping(value = "/cadastro")
    public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model){
        return "/user/add";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr){
        dao.salvar(usuario);
        attr.addFlashAttribute("message", "Usuário salvo com sucesso.");
        return "redirect:/usuario/todos";
    }
    
    @RequestMapping(value = "/update/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model){
        Usuario usuario = dao.getId(id);
       model.addAttribute("usuario", usuario);
       return new ModelAndView("/user/add", model);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView Update(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr){
       dao.editar(usuario);
       attr.addFlashAttribute("message", "Usuário alterado com sucesso.");
       return new ModelAndView("redirect:/usuario/todos");
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attr){
        dao.excluir(id);
        attr.addFlashAttribute("message", "Usuário excluido com sucesso.");
        return "redirect:/usuario/todos";
    }
}
