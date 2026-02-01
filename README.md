<div align="center">
  <img src="https://img.icons8.com/fluency/96/bank-building.png" alt="Bank Icon" />
  <h1>🏦 Basic Bank Java</h1>
  <p><i>Um sistema bancário robusto desenvolvido com foco em Encapsulamento, Validações e Organização em Camadas.</i></p>
</div>

<hr>

## 📌 Sobre o Projeto
Este projeto simula as operações essenciais de uma instituição bancária via console. Ele foi construído utilizando a arquitetura de separação de responsabilidades (Models, Controllers e Services), garantindo que a lógica de negócio esteja isolada da interface do usuário.

## 🚀 Funcionalidades
- [x] **Cadastro de Usuário:** Validação de nome, idade e senha (mínimo 8 caracteres).
- [x] **Configuração Bancária:** Definição de banco, saldo inicial e limite de crédito.
- [x] **Operações Financeiras:** Depósito, Saque, Compra à Vista e Compra no Crédito.
- [x] **Blindagem de Entrada:** Proteção contra entradas inválidas (letras em campos de números) e limpeza de buffer do Scanner.

## 🛠️ Tecnologias e Conceitos Aplicados
<div style="display: inline-block;">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white" />
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" />
</div>

- **Encapsulamento:** Uso de modificadores `private` e métodos `Getters/Setters`.
- **Arquitetura em Camadas:**
    - `models`: Entidades de dados.
    - `service`: Regras de negócio e operações.
    - `controller`: Validações de entrada.
    - `app`: Classe principal (Main).

## 📂 Estrutura de Pastas
```bash
banking/
├── src/
│   ├── app/
│   │   └── Main.java            # Loop principal e interface
│   ├── controller/
│   │   └── Validacoes.java      # Lógica de Regex e hasNext
│   ├── models/
│   │   ├── BankModel.java       # Entidade da Conta
│   │   └── UserModel.java       # Entidade do Usuário
│   ├── service/
│   │   └── ServiceBank.java     # Regras (Saque, Depósito)
│   └── .gitignore               # Configurações do Git
└── banking.iml                  # Arquivo do projeto IntelliJ
```

## 💻 COMO RODAR

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Jayzmatos22/Poo-Java-aplications-bank