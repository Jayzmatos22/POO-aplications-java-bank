package controller;

import models.UserModel;
import models.BankModel;

public class Validacoes {
    public static boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;
        if (nome.length() < 5 || nome.length() > 100) return false;
        return nome.matches("^[a-zA-Z\\sçÇáéíóúÁÉÍÓÚâêîôûÂÊÎÔÛãõÃÕ]+$");
    }

    public static boolean validarDouble(double valor) {
        return valor>= 0;
    }

    public static boolean validarIdade(int idade) {
        return idade >= 10 && idade <= 120;
    }

    public static boolean validarBanco(String banco) {
        if (banco.length() < 3 || banco.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean validarSenha(String senha){
        if (senha.length() < 8 || senha.trim().isEmpty()) {
            return false;
        }
        return true;
    }



    public void returnUsuario(BankModel conta){
        System.out.println("\n");
        System.out.println("- SEUS DADOS BANCÁRIOS -");
        System.out.println("Banco: " + conta.banco);
        System.out.printf("Saldo vigente R$: %.2f\n", conta.getSaldo());
        System.out.printf("Crédito R$: %.2f\n", conta.getCredito());
    }
}
