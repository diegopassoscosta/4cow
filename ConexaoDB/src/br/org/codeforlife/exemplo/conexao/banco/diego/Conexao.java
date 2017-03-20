/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.codeforlife.exemplo.conexao.banco.diego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diego Passos Costa
 */
public class Conexao {

    //Atributos de acesso ao bando de dados
    private String usuario = null;
    private String senha = null;
    //Atributos de configuração para criação do endereço
    //para acessar o host do banco de dados
    private String host = null;
    private String banco = null;
    private String instancia = null;
    private String porta = null;
    private String enderecoDeConexao = null;
    //Strings para comprar a escolha do usuário
    public static final String BANCO_DERBY = "derby";
    public static final String BANCO_MYSQL = "mysql";
    public static final String BANCO_POSTGRES = "postgres";
    public static final String BANCO_ORACLE = "oracle";
    //Strings constantes que armazenam o drive de coneção de cada banco de dados
    private static final String DRIVER_DERBY = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    private static final String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
    //Atributos resonsaveis pela conexão
    private Connection con;
    //Atributos responsaveis pela manipulação de dados resgatados pelo banco 
    private Statement stm;
    private ResultSet rs;

    /**
     * Construtor padrão inicializa parametros com null
     */
    public Conexao() {
        this.banco = null;
        this.host = null;
        this.porta = null;
        this.instancia = null;
        this.usuario = null;
        this.senha = null;
    }

    /**
     * Construtor
     *
     * @param banco
     * @param host
     * @param porta
     * @param instancia
     * @param usuario
     * @param senha
     */
    public Conexao(String banco, String host, String porta, String esquema, String usuario, String senha) throws FaltaParametroDeConexaoException {
        this.banco = banco;
        this.host = host;
        this.porta = porta;
        this.instancia = esquema;
        this.usuario = usuario;
        this.senha = senha;
        setEnderecoDeConexao(banco, host, porta, esquema, usuario, senha);
    }

    /**
     * Metodo sintetico de para se conectar ao Banco valido somente se os
     * parametros já estiverem sido ajustados pelo construtor banco host porta
     * instancia usuario senha
     * @throws ClassNotFoundException, SQLException, FaltaParametroDeConexaoException, NaoFoiEscolhidoBancoParaConectarException
     */
    public void conecteAoBanco() throws ClassNotFoundException, SQLException, FaltaParametroDeConexaoException, NaoFoiEscolhidoBancoParaConectarException {
        setEnderecoDeConexao(getBanco(), getHost(), getPorta(), getInstancia(), getUsuario(), getSenha());
        iniciarBandoDeDados(getBanco());
    }

    /**
     * Metodo sintetico de para se conectar ao Banco
     *
     * @param banco
     * @param host
     * @param porta
     * @param instancia
     * @param usuario
     * @param senha
     * @throws ClassNotFoundException, SQLException, FaltaParametroDeConexaoException, NaoFoiEscolhidoBancoParaConectarException
     */
    public boolean conecteAoBanco(String banco, String host, String porta,
            String esquema, String usuario, String senha) throws ClassNotFoundException, SQLException, FaltaParametroDeConexaoException, NaoFoiEscolhidoBancoParaConectarException {
        setBanco(banco);
        setHost(host);
        setPorta(porta);
        setInstancia(esquema);
        setUsuario(usuario);
        setSenha(senha);
        setEnderecoDeConexao(getBanco(), getHost(), getPorta(), getInstancia(), getUsuario(), getSenha());
        iniciarBandoDeDados(getBanco());

        return true;
    }

    /**
     * Retorna o usuario do usuário de acesso ao banco de dados
     *
     * @return o usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Ajusta o usuario do usuário que será usado para acessar o banco de dados
     * Ex-1: admin Ex-2: root
     *
     * @param usuario a ser ajustado
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna o usuario do usuário de acesso ao banco de dados
     *
     * @return a senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Ajusta a senha do usuário que será usada para acessar o banco de dados
     * Ex-1: 123123 Ex-2: 123456
     *
     * @param senha a ser ajustada
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna apenas o usuario do host que será usado para conectar ao banco de
     * dados
     *
     * @return o host
     */
    public String getHost() {
        return host;
    }

    /**
     * Ajusta o usuario do host que será usado para conectar ao banco de dados
     * Ex-1: 192.168.10.1 Ex-2: localhost
     *
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Retorna o banco de dados escolhido para a conexão
     *
     * @return o banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Ajusta o banco de dados escolhido EX-1: mysql EX-2: postgres
     *
     * @param banco a ser ajustado
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * Retorna o usuario do schema do banco de dados
     *
     * @return o instancia
     */
    public String getInstancia() {
        return instancia;
    }

    /**
     * Informa o usuario do schema a ser utilizado pelo banco de dados Ex-1:
     * BD_ZOOLOGICO Ex-2: MINHAEMPRESA
     *
     * @param instancia o instancia a ser ajustado
     */
    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    /**
     * Retorna a porta de conexão que será utilizada para se conetar ao banco de
     * dados
     *
     * @return a porta
     */
    public String getPorta() {
        return porta;
    }

    /**
     * Ajusta a porta a ser utilizada para efetuara a conexão com o banco de
     * dados verifique qual porta de conexão seu banco usa Ex-1: 3306 Ex-2: 1527
     *
     * @param porta a porta a ser ajustada
     */
    public void setPorta(String porta) {
        this.porta = porta;
    }

    /**
     * Ajusta o endereço de conexão
     *
     * @param enderecoDeConexao  enderecoDeConexao a ser ajustado set
     * @throws FaltaParametroDeConexaoException
     */
    private void setEnderecoDeConexao(String banco, String host, String porta,
            String esquema, String usuario, String senha) throws FaltaParametroDeConexaoException {
        setBanco(banco);
        setHost(host);
        setPorta(porta);
        setInstancia(esquema);
        setUsuario(usuario);
        setSenha(senha);
        if (this.banco == null || this.host == null || this.porta == null
                || this.instancia == null || this.usuario == null || this.senha == null) {

            throw new FaltaParametroDeConexaoException();

        }
        this.enderecoDeConexao = "jdbc:" + getBanco() + "://" + getHost() + ":" + getPorta() + "/" + getInstancia();
    }

    /**
     * Retorna o enderço configurado do banco de dados Ex-1:
     * jdbc:derby://localhost:1527/FINANCEIRO Ex-2:
     * jdbc:derby://localhost:1527/ZOOLOGICO
     *
     * @return o endereco de conexão
     */
    public String getEnderecoDeConexao() {
        return enderecoDeConexao;
    }

    /**
     * Escolha o banco de dados a ser usado na aplicação EX:
     *
     * @param banco
     * @throws throws ClassNotFoundException, SQLException, NaoFoiEscolhidoBancoParaConectarException
     */
    private void iniciarBandoDeDados(String bancoEscolhido) throws ClassNotFoundException, SQLException, NaoFoiEscolhidoBancoParaConectarException {

        if (bancoEscolhido == null) {
            throw new NaoFoiEscolhidoBancoParaConectarException();
        }

        if (bancoEscolhido.equalsIgnoreCase(Conexao.BANCO_DERBY)) {
            carregaDriver(Conexao.DRIVER_DERBY);
        } else if (banco.equalsIgnoreCase(Conexao.BANCO_MYSQL)) {
            carregaDriver(Conexao.DRIVER_MYSQL);
        } else if (banco.equalsIgnoreCase(Conexao.BANCO_ORACLE)) {
            carregaDriver(Conexao.DRIVER_ORACLE);
        } else if (banco.equalsIgnoreCase(Conexao.BANCO_POSTGRES)) {
            carregaDriver(Conexao.DRIVER_POSTGRES);
        }
        criaConexaoComBanco();
    }

    /**
     * carrega o drive do banco de dados
     *
     * @param driverDoBanco
     * @throws ClassNotFoundException
     */
    private void carregaDriver(String driverDoBanco) throws ClassNotFoundException {
        Class.forName(driverDoBanco);
    }

    /**
     * cria a conexão com o banco de dados
     *
     * @throws SQLException
     */
    private void criaConexaoComBanco() throws SQLException {
        con = DriverManager.getConnection(getEnderecoDeConexao(), getUsuario(), getSenha());
        stm = con.createStatement();
    }

    public int grava(String comando) throws SQLException {
        return stm.executeUpdate(comando);
    }

    public ResultSet consulta(String comando) throws SQLException {
        return stm.executeQuery(comando);
    }
    
    public int remove(String comando) throws SQLException {
        return stm.executeUpdate(comando);
    }

    public int atualiza(String comando) throws SQLException {
        return stm.executeUpdate(comando);
    }
}