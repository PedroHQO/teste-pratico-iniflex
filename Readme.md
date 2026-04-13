# TESTE PRÁTICO INIFLEX

Este repositório contém a solução do teste prático para a vaga de Desenvolvedor de Software Júnior (Iniflex). O projeto consiste em uma aplicação backend em Java puro (Core) para gerenciamento e manipulação de uma lista de funcionários, aplicando regras de negócio matemáticas e de formatação.

## 🚀 Tecnologias e Conceitos Aplicados

Para demonstrar domínio das boas práticas da linguagem e clean code, o projeto foi construído utilizando:

* **Java 8+:** Uso massivo da API de **Streams** e **Expressões Lambda** para filtragem, agrupamento e cálculos de forma declarativa.
* **BigDecimal:** Manipulação precisa de valores monetários e cálculos de porcentagem (salários e aumentos), evitando as falhas de arredondamento do tipo `double`.
* **java.time (LocalDate):** Gerenciamento moderno de datas e cálculo preciso de idades usando `ChronoUnit`.
* **Collections Framework:** Uso avançado de listas e mapas (`Map<K,V>`) para estruturação dos dados na memória.
* **Orientação a Objetos:** Aplicação de herança (`Funcionario extends Pessoa`), encapsulamento e o princípio de Responsabilidade Única (SRP) separando os modelos da lógica de formatação/apresentação.

## 📋 Requisitos Atendidos

O sistema executa sequencialmente as seguintes ações no console:

- [x] Inserção da carga inicial de funcionários.
- [x] Remoção de funcionário específico (João).
- [x] Impressão da lista com datas formatadas (`dd/MM/yyyy`) e moeda no padrão brasileiro (`R$ X.XXX,XX`).
- [x] Aplicação de 10% de aumento salarial geral e atualização da lista.
- [x] Agrupamento dos funcionários por **Função** utilizando estrutura `Map` e impressão.
- [x] Filtro e impressão de funcionários que fazem aniversário nos meses 10 e 12.
- [x] Busca e impressão do funcionário de maior idade.
- [x] Ordenação e impressão da lista de funcionários em ordem alfabética.
- [x] Cálculo e impressão do valor total da folha de pagamento.
- [x] Cálculo de quantos salários mínimos (base R$ 1212,00) cada funcionário recebe.

## 📁 Estrutura do Projeto

O projeto foi organizado em pacotes para separar as responsabilidades:

```text
src/
└── br/com/pedrohqo/desafio/
    ├── modelo/
    │   ├── Pessoa.java
    │   └── Funcionario.java
    └── principal/
        └── Principal.java

## ⚙️ Como Executar
Por ser uma aplicação baseada em Java Core, não há necessidade de gerenciadores de dependência (como Maven ou Gradle) ou servidores de aplicação.

    1. Clone este repositório:

```
    git clone [https://github.com/SEU-USUARIO/teste-pratico-iniflex.git](https://github.com/SEU-USUARIO/teste-pratico-iniflex.git)
```

    2. Abra o projeto em sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code, etc.).

    3. Navegue até o pacote br.com.pedrohqo.desafio.principal.

    4. Execute o método main da classe Principal.java.

    5. Todo o fluxo de dados e respostas dos requisitos será impresso sequencialmente no terminal/console da IDE.

### Desenvolvido com dedicação por Pedro Henrique Querino Oliveira 💻

[LinkedIn](https://www.linkedin.com/in/pedro-henriqueqo) | [Meu Portfólio](https://portfolio-pedrohqo.vercel.app/)
