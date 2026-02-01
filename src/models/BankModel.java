package models;

public class BankModel {
    public String banco;
    private double saldo;
    private double credito;
    private String senha;
    private UserModel dono;


    // Getter para ler o saldo
    public double getSaldo() {
        return saldo;
    }

    // Setter para alterar o saldo (com validação!)
    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    // Getter e Setter para Senha
    public String getSenha(String senha) {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha != null && senha.trim().length() >= 8) {
            this.senha = senha;
        }

    }

    public void setCredito(double credito) {
        if (credito >= 0) {
            this.credito = credito;
        }
    }

    public double getCredito(){
        return credito;
    }

    public UserModel getDono() {
        return dono;
    }

    public void setDono(UserModel dono) {
        this.dono = dono;
    }
}
