// Importação do ArrayList para criar uma lista para o extrato.
import java.util.ArrayList;

/*
Criando a classe Conta com os atributos titular, tipo, saldo e extrato, todos privados.
 */
public class Conta {
    private String titular;
    private String tipo;
    private double saldo;
    private ArrayList <String> extrato = new ArrayList<>();

    /*
    Construtor da classe Conta, responsável por
    criar um objeto já inicializando os atributos citados anteriormente.
    */
    public Conta(String titular, String tipo, double saldo){
        this.titular = titular;
        this.tipo = tipo;
        this.saldo = saldo;
        this.extrato = new ArrayList<>();
    }

    /*
    Metodo dados, exibe o nome e o tipo de conta do titular.
    */
    public void dados(){
        String dadosUser = """
                ===============
                |DADOS TITULAR|
                Nome: %s
                Tipo de conta: %s
                ===============
                """.formatted(titular, tipo);
        System.out.print(dadosUser);
    }
    /*
    Metodo exibeSaldo, mostra o saldo atual do usuário.
    */
    public void exibeSaldo(){
        System.out.println("\nSeu saldo atual é: R$"+saldo+"\n");
    }

    /*
    Metodo sacar, utiliza IF para verificar se o valor inserido
    pelo usuário é menor ou igual a zero ou maior que o saldo
    em conta, se sim, retorna falso, senão, subtrai do saldo
    o valor sacado e adiciona ao extrato uma mensagem.
    */
    public boolean sacar(double valorSaque){
        if(valorSaque <= 0 || valorSaque > saldo){
            return false;
        }
        saldo -= valorSaque;
        extrato.add("Saque realizado: R$"+valorSaque);
        return true;
    }

    /*
    Metodo transferir, utiliza IF para verificar se o valor
    inserido pelo usuário é menor ou igual a zero ou maior
    que o saldo em conta, se sim, retorna falso, senão,
    subtrai do saldo o valor da transferência, soma no
    saldo da conta de destino o valor da transferência, e
    adiciona ao extrato uma mensagem.
    */
    public boolean transferir(Conta destino, double valorTransferir){
        if(valorTransferir <= 0 || valorTransferir > saldo){
            return false;
        }
        saldo -= valorTransferir;
        destino.saldo += valorTransferir;
        extrato.add("Valor transferido: R$"+valorTransferir+" , para: "+destino.titular);
        return true;
    }

    /*
    Metodo depositar, utiliza IF para verificar se o valor
    inserido pelo usuário é menor ou igual a zero, se sim,
    retorna falso, senão, soma ao saldo o valor depositado
    e adiciona ao extrato uma mensagem.
     */
    public boolean depositar(double valorDeposito){
        if(valorDeposito<=0){
            return false;
        }
        saldo += valorDeposito;
        extrato.add("Deposito realizado: R$"+valorDeposito);
        return true;
    }

    /*
    Metodo exibirExtrato, utiliza um for para percorrer
    todas as mensagens dentro da lista e exibi-lás.
     */
    public void exibirExtrato(){
        for(int i =0; i<extrato.toArray().length; i++){
            System.out.println(extrato.get(i));
        }
    }
}
