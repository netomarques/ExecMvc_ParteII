/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.logica.Logica;

/**
 *
 * @author Wilson
 */

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
    
    String pacote = "mvc.logica.";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String acao = request.getParameter("logica");
        String nomeClasse = pacote + acao;
        
        System.out.println("---> " + nomeClasse);
        
        try {
            
            Class<?> classe = Class.forName(nomeClasse);
            
            Logica logica = (Logica) classe.newInstance();
            
            String pagina = logica.executa(request, response);
            
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            
            rd.forward(request, response);
            
        } catch (Exception e) {
            
            throw new ServletException("Exceção gerada pela lógica de negócios", e);
            
        }
        
    }
    
}
