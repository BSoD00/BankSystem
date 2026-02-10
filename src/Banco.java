//Importação do Scanner para a entrada de dados.
import java.util.Scanner;

/*
Criando a classe Banco, que vai ser a Main.
 */
public class Banco {
    public static void main(String[] args) {

        /*
        Criando Scanner com o nome "teclado".
         */
        Scanner teclado = new Scanner(System.in);

        /*
        Criando variável "opcaoMenu" com o valor zero,
        para ser utilizada no while do menu.
         */
        int opcaoMenu = 0;

        /*
        Criando dois objetos da classe Conta, conta1 e conta2,
        com os atributos titular, tipo e saldo.
         */
        Conta conta1 = new Conta("Henry","Corrente",1000);
        Conta conta2 = new Conta("Ana","Corrente",1000);

        /*
        Menu dentro de um while, que irá rodar enquanto
        a variável "opcaoMenu" for diferente de 7.
         */
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

            /*
            Switch (opcaoMenu) para realizar as ações
            com base na opção que o usuário escolheu.
             */
            switch(opcaoMenu){
                /*
                Caso o usuário digite 1, o metodo dados da classe Conta
                será executado.
                 */
                case 1:
                    conta1.dados();
                    break;

                /*
                Caso o usuário digite 2, o metodo exibeSaldo da classe
                Conta será executado.
                 */
                case 2:
                    conta1.exibeSaldo();
                    break;

                /*
                Caso o usuário digite 3, o usuário irá inserir
                o valor que deseja sacar, o IF vai validar se
                o valor inserido atende as condições do metodo,
                se sim, uma mensagem de sucesso vai aparecer,
                senão,uma mensagem de erro vai aparecer.
                 */
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

                /*
                Caso o usuário digite 4, ele vai inserir o valor
                que deseja transferir, o IF vai validar se o valor
                inserido atende as condições do metodo,
                se sim, uma mensagem de sucesso vai aparecer,
                senão, uma mensagem de erro vai aparecer.
                 */
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

                /*
                Caso o usuário digite 5, ele vai inserir o valor
                que deseja depositar, o IF vai validar se o valor
                inserido atende as condições do metodo, se sim,
                uma mensagem de sucesso vai aparecer, senão, uma
                mensagem de erro vai aparecer.
                 */
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

                /*
                Caso o usuário digite 6, o metodo
                exibirExtrato será executado.
                 */
                case 6:
                    System.out.println("|EXTRATO|");
                    conta1.exibirExtrato();
                    break;

                /*
                Caso o usuário digite 7, o sistema será encerrado.
                 */
                case 7:
                    System.out.println("Encerrando...");
                    break;

                /*
                Caso o usuário digite alguma opção
                que não esteja no menu, será exibida
                uma mensagem de erro.
                 */
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
        teclado.close();
    }
}