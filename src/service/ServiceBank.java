package service;
import models.BankModel;

public class ServiceBank {
    public void depositar(BankModel conta, double valor) {
        if (valor > 0) {
            double novoSaldo = valor + conta.getSaldo();
            conta.setSaldo(novoSaldo);
            System.out.println("Depósito realizado com sucesso!");
        } else{
            System.out.println("Depósito deve ser maior que 0.");
        }
    }

    public void sacar(BankModel conta, double valor){
        if (valor > 0 && conta.getSaldo() >= valor){
            double novoSaldo = conta.getSaldo() - valor;
            conta.setSaldo(novoSaldo);
            System.out.println("Saque feito no valor de R$ "+ valor);
        } else {
            System.out.println("Saldo insuficiente para saque");
        }
    }

    public void comprarAVista(BankModel conta, double valorP) {
        if (valorP > conta.getSaldo()){
            System.out.println("Saldo vigente insuficiente");
        } else {
            double novoSaldo = conta.getSaldo() - valorP;
            conta.setSaldo(novoSaldo);
            System.out.println("Compra feita no valor de R$ " + valorP);
        }
    }

    public void comprarCredito(BankModel conta, double valorC){
        if (valorC > conta.getCredito()){
            System.out.println("Crédito vigente insuficiente");
        } else {
            double novoSaldo = conta.getCredito() - valorC;
            conta.setCredito(novoSaldo);
            System.out.println("Compra feita no valor de R$ " + valorC);
        }
    }

}
