/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import control.CadastroCliente;
import java.util.Scanner;
import model.Cliente;

/**
 *
 * @author kc4z
 */
public class MVCCOnsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        System.out.println("Informe os dados para gravar no banco");
        
        System.out.println("Informe o Primeiro Nome: ");
        String primeiroNome = leia.nextLine();
        
        System.out.println("Informe o Segundo Nome: ");
        String segundoNome = leia.nextLine();
        
        System.out.println("Informe o CPF: ");
        int cpf = leia.nextInt();
        
        Cliente cliente = new Cliente();
        cliente.setPrimeiroNome(primeiroNome);
        cliente.setSegundoNome(segundoNome);
        cliente.setCPF(cpf);
        
        CadastroCliente.cadastre(cliente);
        
    }
}
