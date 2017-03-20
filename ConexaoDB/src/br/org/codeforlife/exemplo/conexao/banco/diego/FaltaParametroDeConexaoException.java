/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.codeforlife.exemplo.conexao.banco.diego;

/**
 *
 * @author Diego Passos Costa
 */
public class FaltaParametroDeConexaoException extends Exception{
    
    
    public FaltaParametroDeConexaoException() {  
        super("Falta algum parâmetro para a conexão");  
    }
    
    public FaltaParametroDeConexaoException(String message) {  
        super(message);  
    }
}
