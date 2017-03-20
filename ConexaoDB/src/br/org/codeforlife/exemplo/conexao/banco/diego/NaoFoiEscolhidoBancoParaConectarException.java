/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.codeforlife.exemplo.conexao.banco.diego;

/**
 *
 * @author Diego Passos Costa
 */
public class NaoFoiEscolhidoBancoParaConectarException extends Exception{
    
    
    public NaoFoiEscolhidoBancoParaConectarException() {  
        super("Não foi escolhido nenhum banco para se conectar");  
    }
    
    public NaoFoiEscolhidoBancoParaConectarException(String message) {  
        super(message);  
    }
}
