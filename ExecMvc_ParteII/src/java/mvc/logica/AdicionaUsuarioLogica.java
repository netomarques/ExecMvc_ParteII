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
public class AdicionaUsuarioLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Usuario usuario =  new Usuario(0,
                                        request.getParameter("nome"),
                                            request.getParameter("login"),
                                                request.getParameter("senha"));
        
        Connection connection = (Connection) request.getAttribute("connection");
                
        UsuarioDAO dao = new UsuarioDAO(connection);
        dao.adicionaUsuario(usuario);
        
        request.setAttribute("nome", request.getParameter("nome"));
        request.setAttribute("mensagem", "adicionado com sucesso");
        
        return "view/usuario-mensagem.jsp";
        
    }
    
}
