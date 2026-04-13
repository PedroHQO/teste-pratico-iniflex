package br.com.pedrohqo.desafio.principal;

import br.com.pedrohqo.desafio.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = cadastroFuncionarios();
        funcionarios.removeIf(f -> f.getNome().equals("João"));
        System.out.println("_____LISTA FUNCIONÁRIOS_____");
        mostrarFuncionarios(funcionarios);
        aumentoSalario(funcionarios, new BigDecimal("1.10"));
        System.out.println("_____FUNCIONÁRIOS COM AUMENTO 10%_____");
        mostrarFuncionarios(funcionarios);
        mostrarFuncionarioAgrupadosPorFuncao(funcionarios);
        mostrarAniversariantes(funcionarios, List.of(10, 12));
        mostrarMaisVelho(funcionarios);
        imprimirOrdemAlfabetica(funcionarios);
        imprimirTotalSalarios(funcionarios);
        imprimirQtdSalariosMinimo(funcionarios, new BigDecimal("1212.00"));

    }

    private static List<Funcionario> cadastroFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18),new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12),new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2),new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14),new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5),new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19),new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31),new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8),new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24),new BigDecimal("1605.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2),new BigDecimal("2799.93"), "Gerente"));
        return funcionarios;
    }

    private static void mostrarFuncionarios(List<Funcionario> funcionarios){
        for (Funcionario funcionario : funcionarios){
            System.out.println("Nome: " + funcionario.getNome() +
                    " - Data Nascimento: " + formatadorData(funcionario.getDataNascimento()) +
                " - Salário: R$" + formatadorMoeda(funcionario.getSalario()) +
                " - Função: " + funcionario.getFuncao());
        }
    }

    private static void aumentoSalario(List<Funcionario> funcionarios, BigDecimal taxaAumento){
        for (Funcionario funcionario : funcionarios) {
            BigDecimal novoSalario = funcionario.getSalario().multiply(taxaAumento).setScale(2, RoundingMode.HALF_UP);
            funcionario.setSalario(novoSalario);
        }
    }

    public static void mostrarFuncionarioAgrupadosPorFuncao(List<Funcionario> funcionarios){
        System.out.println("\n_____FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO_____");
        Map<String, List<Funcionario>> porFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        porFuncao.forEach((funcao, listaDeFuncionarios) -> {
            System.out.println("Função: " + funcao);

            for (Funcionario f : listaDeFuncionarios) {
                System.out.println("   - " + f.getNome());
            }
        });
    }

    private static void mostrarAniversariantes(List<Funcionario> funcionarios, List<Integer> mesesAlvo){
        System.out.println("\n_____ANIVERSARIANTES MÊS 10 e 12_____");
        funcionarios.stream()
                .filter(f -> mesesAlvo.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f ->
                System.out.println(f.getNome() + " Aniversário no mês: " + f.getDataNascimento().getMonthValue())
        );
    }

    private static void mostrarMaisVelho(List<Funcionario> funcionarios){
        System.out.println("_____FUNCIONÁRIO MAIS VELHO_____");
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElseThrow(NoSuchElementException::new);

        long idade = ChronoUnit.YEARS.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now());
        System.out.println("Nome: " + funcionarioMaisVelho.getNome() + " - Idade: " + idade + " anos");

    }


    private static void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("_____LISTA ORDEM ALFABÉTICA_____");
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        for (Funcionario ordemAlfabetica : funcionarios) {
            System.out.println("Nome: " + ordemAlfabetica.getNome());
        }
    }

    private static void imprimirTotalSalarios(List<Funcionario> funcionarios){
        System.out.println("_____LISTA TOTAL DE SALÁRIOS_____");
        BigDecimal total = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Valor Total: R$ " + formatadorMoeda(total));
    }

    private static void imprimirQtdSalariosMinimo(List<Funcionario> funcionarios, BigDecimal salarioMinimo){
        System.out.println("\n_____LISTA QTD SALÁRIOS MÍNIMOS_____");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal qtdSalario = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println("Funcionário: " + funcionario.getNome() + " - Qtd Salário Min: R$" + formatadorMoeda(salarioMinimo) + " ( " + formatadorMoeda(qtdSalario) + ")");
        }
    }

    private static String formatadorData(LocalDate data){
        return
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data);
    }

    private static String formatadorMoeda(BigDecimal valor){
        NumberFormat formatadorDeMoeda = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        formatadorDeMoeda.setMinimumFractionDigits(2);
        return formatadorDeMoeda.format(valor);
    }
}

