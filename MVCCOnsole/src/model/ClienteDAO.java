/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.org.codeforlife.exemplo.conexao.banco.diego.Conexao;
import br.org.codeforlife.exemplo.conexao.banco.diego.FaltaParametroDeConexaoException;
import br.org.codeforlife.exemplo.conexao.banco.diego.NaoFoiEscolhidoBancoParaConectarException;
import java.sql.SQLException;


/**
 *
 * @author kc4z
 */
public class ClienteDAO {
    /**
     * @param c
     * @return
     * @throws ClassNotFoundException
     * @throws FaltaParametroDeConexaoException
     * @throws NaoFoiEscolhidoBancoParaConectarException
     * @throws SQLException
     */
    public static int insereCliente(Cliente c) throws ClassNotFoundException, FaltaParametroDeConexaoException, NaoFoiEscolhidoBancoParaConectarException, SQLException {
        Conexao conn = new Conexao();
        conn.conecteAoBanco("mysql", "localhost", "3306", "exemplo_mvc_simples", "root", "123123");
        String comando = "INSERT INTO `exemplo_mvc_simples`.`cliente` (`cpf`, `primeiroNome`, `segundoNome`) VALUES (" + c.getCPF() + ", '" + c.getPrimeiroNome()+ "', '"+ c.getSegundoNome()+"')";
        return conn.grava(comando);
    }
    
    
}