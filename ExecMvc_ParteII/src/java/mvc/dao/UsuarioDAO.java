/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mvc.model.Usuario;

/**
 *
 * @author Wilson
 */
public class UsuarioDAO {
    
    private Connection connection;

    public UsuarioDAO() {
    }

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void adicionaUsuario(Usuario usuario){
        
        PreparedStatement instrucao = null;
        String sql = "insert into usuario (usuid, usunome, usulogin, ususenha) values (?,?,?,?)";
        
        try {
            
            instrucao = connection.prepareStatement(sql);
            
            instrucao.setInt(1, 0);
            instrucao.setString(2, usuario.getNome());
            instrucao.setString(3, usuario.getLogin());
            instrucao.setString(4, usuario.getSenha());
            
            instrucao.execute();
            
        } catch (SQLException e) {
            System.out.println("EXCEÇÃO ADICIONAUSUARIO DAO " + e.getMessage());
        }
        
    }
    
    public Usuario pesquisaUsuario(int id){
        
        PreparedStatement instrucao =  null;
        ResultSet resultado = null;
        
        String sql = "select * from usuario "
                   + "where usuid = ?";
        
        try {
            instrucao =  connection.prepareStatement(sql);
            instrucao.setInt(1, id);
            resultado =  instrucao.executeQuery();
            
            Usuario usuario = null;
            if(resultado.next()){
                
                usuario =  new Usuario(resultado.getInt("usuid"),
                                                resultado.getString("usunome"),
                                                    resultado.getString("usulogin"),
                                                        resultado.getString("ususenha"));
                
            }
            
            return usuario;
            
        } catch (SQLException e) {
            
            throw new RuntimeException("EXCEÇÃO pesquisaUsuario ", e);
            
        }
    }
    
    public List<Usuario> listaUsuarios(){
        
        PreparedStatement instrucao =  null;
        ResultSet resultados = null;
        
        String sql = "select * from usuario";
        
        try {
            
            instrucao =  connection.prepareStatement(sql);
            resultados = instrucao.executeQuery();
            
            List<Usuario> usuarios = new ArrayList<>();
            Usuario usuarioSaida;
            
            while (resultados.next()) {
                usuarioSaida =  new Usuario(resultados.getInt("usuid"),
                                                resultados.getString("usunome"),
                                                    resultados.getString("usulogin"),
                                                        resultados.getString("ususenha"));
                
                usuarios.add(usuarioSaida);
            }
            
            return usuarios;
            
        } catch (SQLException e) {
            
            throw new RuntimeException("EXCEÇÃO listaUsuarios ", e);
            
        }
        
    }
    
    public void alteraUsuario(Usuario usuario){
        
        PreparedStatement instrucao = null;
        String sql = "update usuario set usunome = ?, usulogin = ?, ususenha = ? "
                   + "where usuid = ?";
        
        try {
            
            instrucao = connection.prepareStatement(sql);
            
            instrucao.setString(1, usuario.getNome());
            instrucao.setString(2, usuario.getLogin());
            instrucao.setString(3, usuario.getSenha());
            instrucao.setInt(4, usuario.getId());
            
            instrucao.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("EXCEÇÃO removeUsuario " + e.getMessage());
        }
        
    }
    
    public void removeUsuario(int id){
        
        PreparedStatement instrucao =  null;
        
        String sql = "delete from usuario "
                   + "where usuid = ?";
        
        try {
            
            instrucao = connection.prepareStatement(sql);
            
            instrucao.setInt(1, id);
            
            instrucao.execute();
            
        } catch (SQLException e) {
            
            throw new RuntimeException("EXCEÇÃO removeUsuario ", e);
            
        }
    }
    
    
    
    
}
