/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kc4z
 */
public class Cliente {

    private int CPF = 0;
    private String primeiroNome;
    private String segundoNome;

    public Cliente() {
    }

    public Cliente(int CPF, String primeiroNome, String segundoNome) {
        this.CPF = CPF;
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
    }

    /**
     * @return the CPF
     */
    public int getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(int CPF) {
            this.CPF = CPF;
    }

    /**
     * @return the primeiroNome
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     * @param primeiroNome the primeiroNome to set
     */
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    /**
     * @return the segundoNome
     */
    public String getSegundoNome() {
        return segundoNome;
    }

    /**
     * @param segundoNome the segundoNome to set
     */
    public void setSegundoNome(String segundoNome) {
        this.segundoNome = segundoNome;
    }
}
