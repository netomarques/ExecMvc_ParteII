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
public class AlteraUsuarioLogica implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Usuario usuario =  new Usuario(Integer.parseInt(request.getParameter("id")),
                                            request.getParameter("nome"),
                                                request.getParameter("login"),
                                                    request.getParameter("senha"));
        
        Connection connection = (Connection) request.getAttribute("connection");
        
        UsuarioDAO dao = new UsuarioDAO(connection);
        dao.alteraUsuario(usuario);
        
        request.setAttribute("nome", usuario.getNome());
        request.setAttribute("mensagem", "alterado com sucesso");
        
        return "view/usuario-mensagem.jsp";
    }
    
}
