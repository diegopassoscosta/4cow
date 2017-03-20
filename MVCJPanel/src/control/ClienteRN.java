/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import br.org.codeforlife.exemplo.conexao.banco.diego.FaltaParametroDeConexaoException;
import br.org.codeforlife.exemplo.conexao.banco.diego.NaoFoiEscolhidoBancoParaConectarException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author kc4z
 */
public class ClienteRN {
    private Cliente cliente = null;


    public ClienteRN(){
    }
    
    public ClienteRN(Cliente cliente) {
        this.cliente = cliente;
    }

    public void cadastre() {
        if (cliente.getCPF() > 0){
            try {
                ClienteDAO.insereCliente(cliente);
            } catch ( ClassNotFoundException | FaltaParametroDeConexaoException | NaoFoiEscolhidoBancoParaConectarException | SQLException ex) {
                Logger.getLogger(ClienteRN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}