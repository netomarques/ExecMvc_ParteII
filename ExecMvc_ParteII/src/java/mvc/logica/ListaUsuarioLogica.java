/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.dao.UsuarioDAO;
import mvc.model.Usuario;

/**
 *
 * @author Wilson
 */
public class ListaUsuarioLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Connection connection  = (Connection) request.getAttribute("connection");
        
        UsuarioDAO dao =  new UsuarioDAO(connection);
        
        List<Usuario> usuarios = dao.listaUsuarios();
        
        request.setAttribute("usuarios", usuarios);
        
        return "view/listaUsuarios.jsp";
        
    }
    
}
