package app;
import java.util.Scanner;
import java.util.Locale;
import models.BankModel;
import models.UserModel;
import controller.Validacoes;
import service.ServiceBank;



public class Main {
    public static void main(String[] args) {
        UserModel usuario = new UserModel();
        BankModel conta = new BankModel();
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
        Validacoes verificar = new Validacoes();
        ServiceBank servicos = new ServiceBank();

        // --- Usuário ---
        while (true) {
            System.out.println("-----------------------------");
            System.out.print("Informe seu nome: ");
            String nome = teclado.nextLine();
            if (verificar.validarNome(nome)) {
                usuario.nome = nome.trim();
                break;
            } else {
                System.out.println("Nome inválido. Apenas letras e maior que 4 caracteres!");
            }
        }

        while (true) {
            System.out.println("-----------------------------");
            System.out.print("Informe sua idade: ");
            if (teclado.hasNextInt()) {
                int idade = teclado.nextInt();
                teclado.nextLine();
                if (verificar.validarIdade(idade)) {
                    usuario.idade = idade;
                    break;
                } else {
                    System.out.println("Idade inválida. Deve estar entre 11 e 120 anos!");
                }
            } else {
                System.out.println("Erro: Digite apenas números para a idade!");
                teclado.next();
            }
        }

        // --- Banco ---
        usuario.contaBancaria = conta;
        while (true) {
            System.out.println("---------- DADOS BANCÁRIOS ----------");
            System.out.print("Informe seu banco: ");
            String banco = teclado.nextLine();
            if (!verificar.validarBanco(banco)) {
                System.out.println("Banco inválido! Recomeçando...");
                continue;
            }
            usuario.contaBancaria.banco = banco;

            System.out.print("Informe seu saldo inicial: ");
            if (teclado.hasNextDouble()) {
                double saldo = teclado.nextDouble();
                teclado.nextLine();
                if (verificar.validarDouble(saldo)) {
                    usuario.contaBancaria.setSaldo(saldo);
                } else {
                    System.out.println("Saldo inválido. Reiniciando...");
                    continue;
                }
            } else {
                System.out.println("Erro: Saldo deve ser número! Reiniciando...");
                teclado.next(); teclado.nextLine();
                continue;
            }

            System.out.print("Informe seu limite de crédito: ");
            if (teclado.hasNextDouble()) {
                double credito = teclado.nextDouble();
                teclado.nextLine();
                if (verificar.validarDouble(credito)) {
                    usuario.contaBancaria.setCredito(credito);
                } else {
                    System.out.println("Limite inválido. Reiniciando...");
                    continue;
                }
            } else {
                System.out.println("Erro: Crédito deve ser número! Reiniciando...");
                teclado.next(); teclado.nextLine();
                continue;
            }

            System.out.print("Crie uma senha (mínimo 8 caracteres): ");
            String senha = teclado.nextLine();
            if (verificar.validarSenha(senha)) {
                usuario.contaBancaria.setSenha(senha);
                break;
            } else {
                System.out.println("Senha inválida! Reiniciando cadastro bancário...");
            }
        }


        conta.setDono(usuario);
        System.out.println("**************************");

        // ---  MENU  ---
        while (true) {
            System.out.println("\n--- MENU BANCÁRIO ---");
            System.out.println("1 - Ver informações bancárias\n2 - Depositar\n3 - Sacar");
            System.out.println("4 - Comprar à vista\n5 - Comprar no crédito\n0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (teclado.hasNextInt()) {
                int opcao = teclado.nextInt();
                teclado.nextLine();

                switch (opcao) {
                    case 1:
                        verificar.returnUsuario(conta);
                        break;
                    case 2:
                        System.out.print("Valor para depósito: ");
                        if (teclado.hasNextDouble()) {
                            double v = teclado.nextDouble();
                            teclado.nextLine();
                            servicos.depositar(usuario.contaBancaria, v);
                        } else { teclado.next(); }
                        break;
                    case 3:
                        System.out.print("Valor para saque: ");
                        if (teclado.hasNextDouble()) {
                            double v = teclado.nextDouble();
                            teclado.nextLine();
                            servicos.sacar(usuario.contaBancaria, v);
                        } else { teclado.next(); }
                        break;
                    case 4:
                        System.out.print("Valor da compra à vista: ");
                        if (teclado.hasNextDouble()) {
                            double v = teclado.nextDouble();
                            teclado.nextLine();
                            servicos.comprarAVista(usuario.contaBancaria, v);
                        } else { teclado.next(); }
                        break;
                    case 5:
                        System.out.print("Valor da compra no crédito: ");
                        if (teclado.hasNextDouble()) {
                            double v = teclado.nextDouble();
                            teclado.nextLine();
                            servicos.comprarCredito(usuario.contaBancaria, v);
                        } else { teclado.next(); }
                        break;
                    case 0:
                        System.out.println("Saindo do sistema. Até logo!");
                        return;
                    default:
                        System.out.println("Opção inexistente!");
                }
            } else {
                System.out.println("Por favor, digite o número da opção.");
                teclado.next();
            }
        }
    }
}