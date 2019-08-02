/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.roosevelt.curso.dao;

import br.com.roosevelt.curso.model.Usuario;
import java.util.List;

/**
 *
 * @author Sr. Roosevelt
 */
public interface UsuarioDao {
    
    void salvar(Usuario usuario);
    void editar(Usuario usuario);
    void excluir(Long id);
    
    Usuario getId(Long id);
    
    List<Usuario> getTodos();
    
}
