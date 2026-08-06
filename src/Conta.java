
import java.util.ArrayList;


public class Conta {
    private String titular;
    private String tipo;
    private double saldo;
    private ArrayList <String> extrato = new ArrayList<>();

    
    public Conta(String titular, String tipo, double saldo){
        this.titular = titular;
        this.tipo = tipo;
        this.saldo = saldo;
        this.extrato = new ArrayList<>();
    }

    
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
    
    public void exibeSaldo(){
        System.out.println("\nSeu saldo atual é: R$"+saldo+"\n");
    }

    
    public boolean sacar(double valorSaque){
        if(valorSaque <= 0 || valorSaque > saldo){
            return false;
        }
        saldo -= valorSaque;
        extrato.add("Saque realizado: R$"+valorSaque);
        return true;
    }

    
    public boolean transferir(Conta destino, double valorTransferir){
        if(valorTransferir <= 0 || valorTransferir > saldo){
            return false;
        }
        saldo -= valorTransferir;
        destino.saldo += valorTransferir;
        extrato.add("Valor transferido: R$"+valorTransferir+" , para: "+destino.titular);
        return true;
    }

    
    public boolean depositar(double valorDeposito){
        if(valorDeposito<=0){
            return false;
        }
        saldo += valorDeposito;
        extrato.add("Deposito realizado: R$"+valorDeposito);
        return true;
    }

    
    public void exibirExtrato(){
        for(int i =0; i<extrato.toArray().length; i++){
            System.out.println(extrato.get(i));
        }
    }
}
