/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.filter;

import connection.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Wilson
 */
@WebFilter("/*")
public class ConexaoFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Connection connection = ConnectionFactory.getConnection();
            
            request.setAttribute("connection", connection);
            
            chain.doFilter(request, response);
            
            connection.close();
        } catch (IOException | SQLException | ServletException e) {
            System.out.println("EXCEÇÃO FILTER " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
