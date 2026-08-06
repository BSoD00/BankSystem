
import java.util.Scanner;


public class Banco {
    public static void main(String[] args) {

        
        Scanner teclado = new Scanner(System.in);

        
        int opcaoMenu = 0;

        
        Conta conta1 = new Conta("Henry","Corrente",1000);
        Conta conta2 = new Conta("Ana","Corrente",1000);

        
        while(opcaoMenu != 7){
            String menu = """
                    |OPÇÕES BANCO|
                    1- MOSTRAR DADOS
                    2- CONSULTAR SALDO
                    3- REALIZAR SAQUE
                    4- REALIZAR TRANSFERÊNCIA
                    5- REALIZAR DEPÓSITO
                    6- EXTRATO
                    7- SAIR
                    """;
            System.out.println(menu);
            System.out.print("Insira sua opção: ");
                opcaoMenu = teclado.nextInt();

           
            switch(opcaoMenu){
                
                case 1:
                    conta1.dados();
                    break;

                
                case 2:
                    conta1.exibeSaldo();
                    break;

                
                case 3:
                    System.out.println("Insira o valor que deseja sacar: ");
                        double valorSaque = teclado.nextDouble();
                    if(conta1.sacar(valorSaque)){
                        System.out.println("Saque realizado com sucesso.");
                    }
                    else{
                        System.out.println("Não foi possível realizar o saque, verifique seu saldo, insira o valor correto e tente novamente.");
                    }
                    break;

                
                case 4:
                    System.out.println("Insira o valor que deseja transferir: ");
                        double valorTransferir = teclado.nextDouble();
                    if(conta1.transferir(conta2, valorTransferir)){
                        System.out.println("Transferência realizada com sucesso.");
                    }
                    else{
                        System.out.println("Não foi possível realizar a transferência, verifique seu saldo, insira o valor correto e tente novamente.");
                    }
                    break;

                
                case 5:
                    System.out.println("Insira o valor que deseja depositar: ");
                        double valorDeposito = teclado.nextDouble();
                    if(conta1.depositar(valorDeposito)){
                        System.out.println("Depósito realizado com sucesso.");
                    }
                    else{
                        System.out.println("Não foi possível realizar o depósito, verifique o valor digitado e tente novamente.");
                    }
                    break;

                
                case 6:
                    System.out.println("|EXTRATO|");
                    conta1.exibirExtrato();
                    break;

                
                case 7:
                    System.out.println("Encerrando...");
                    break;

                
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
        teclado.close();
    }
}
