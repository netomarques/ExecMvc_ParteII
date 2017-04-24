/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.dao.UsuarioDAO;
import mvc.model.Usuario;

/**
 *
 * @author Wilson
 */
public class PesquisaUsuarioLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));
        
        Connection connection = (Connection) request.getAttribute("connection");
        
        UsuarioDAO dao = new UsuarioDAO(connection);
        
        Usuario usuario =  dao.pesquisaUsuario(id);
        
        request.setAttribute("usuario", usuario);
        
        return "view/formAlteraUsuario.jsp";
    }
    
}
