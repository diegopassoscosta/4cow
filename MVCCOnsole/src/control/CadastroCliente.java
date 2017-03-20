/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Cliente;

/**
 *
 * @author kc4z
 */
public class CadastroCliente {
    private static String primeiroNome;
    private static String segundoNome;
    private static int cpf;

    public CadastroCliente(){
    }
    
    public static void cadastre(Cliente cliente) {
        
        ClienteRN clienteRegraDeNegocio = new ClienteRN(cliente);
        clienteRegraDeNegocio.cadastre();
        
        
    }
    
    
}
