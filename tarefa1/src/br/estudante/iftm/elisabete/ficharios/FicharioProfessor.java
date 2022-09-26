package br.estudante.iftm.elisabete.ficharios;


import br.estudante.iftm.elisabete.modelos.Professor;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioProfessor {


    private final ArrayList<Professor> professores;
    private final Scanner entrada;

    public FicharioProfessor(ArrayList<Professor> professores) {
        this.professores = professores;
        entrada = new Scanner(System.in);

    }


    public Professor buscaProfessor(String cpfAlterado) {

        for (int j = 0; j < professores.size(); j++) {

            if (professores.get(j) != null && professores.get(j).getCpf().equals(cpfAlterado)) {
                return professores.get(j);
            }
        }
        return null;
    }

    public Professor buscaProfessor(int registroAlterado) {

        Professor professor = new Professor(registroAlterado);
        int i = professores.indexOf(professor);

        if (professores.contains(professor))
            return professores.get(i);
        else
            return null;
    }

    public Professor tiposBuscaProfessores() {
        String nome, cpf;
        int registro;
        int opcoesBusca;
        Professor professor = new Professor();


        System.out.println("1- CPF");
        System.out.println("2- Registro");
        opcoesBusca = entrada.nextInt();
        entrada.skip("\n");


        switch (opcoesBusca) {

            case 1 -> {
                System.out.print("CPF ");
                cpf = entrada.nextLine();
                professor = buscaProfessor(cpf);
            }
            case 2 -> {
                System.out.print("Registro: ");
                registro = entrada.nextInt();
                entrada.skip("\n");
                professor = buscaProfessor(registro);
            }
        }
        return professor;
    }

    public Professor setarProfessor() {
        String nome, telefone, cpf, email;
        int registro;
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Registro: ");
        registro = entrada.nextInt();
        entrada.skip("\n");
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
        System.out.print("CPF: ");
        cpf = entrada.nextLine();
        System.out.print("Email: ");
        email = entrada.nextLine();

        return new Professor(nome, registro, telefone, cpf, email);

    }


    public void cadastrar() {

        System.out.println(" === Cadastrar Professor ==== ");

        Professor professor = setarProfessor();

        if (professores.contains(professor)) {
            System.out.println("Cadastro não realizado! já existe um professor com esse registro");
        } else {
            professores.add(professor);
            System.out.println("Cadastrado realizado!");
        }
    }

    public void alterar() {

        String nome, telefone, cpf, email;
        int registro;
        int alteracaoFeita;
        int retorno;


        System.out.println("===BUSCAR PROFESSOR A ALTERAR POR: ===");
        Professor professor = tiposBuscaProfessores();

        if (professor != null) {


            do {

                System.out.println("O que deseja alterar? ");
                System.out.println("1 - Nome do Professor ");
                System.out.println("2 - Registro do Professor ");
                System.out.println("3 - Telefone do Professor ");
                System.out.println("4 - CPF do Professor ");
                System.out.println("5 - Email do Professor ");
                alteracaoFeita = entrada.nextInt();
                entrada.skip("\n");

                switch (alteracaoFeita) {
                    case 1 -> {
                        System.out.print("Novo Nome: ");
                        nome = entrada.nextLine();
                        professor.setNome(nome);
                    }
                    case 2 -> {
                        System.out.print("Novo Registro: ");
                        registro = entrada.nextInt();
                        entrada.skip("\n");
                        professor.setRegistro(registro);
                    }
                    case 3 -> {
                        System.out.print("Novo Telefone: ");
                        telefone = entrada.nextLine();
                        professor.setTelefone(telefone);
                    }
                    case 4 -> {
                        System.out.print("Novo CPF ");
                        cpf = entrada.nextLine();
                        professor.setCpf(cpf);
                    }
                    case 5 -> {
                        System.out.print("Novo Email ");
                        email = entrada.nextLine();
                        professor.setEmail(email);
                    }
                    default -> System.out.println("Operação inválida!");

                }

                System.out.println("Deseja alterar mais alguma coisa?");
                System.out.println("1- Sim");
                System.out.println("2- Não");
                retorno = entrada.nextInt();
                entrada.skip("\n");
            } while (retorno == 1);
        } else
            System.out.println("Professor não encontrado!");

    }

    public void excluir() {

        System.out.println("===DESEJA INFORMAR O PROFESSOR A SER EXCLUÍDO POR:===");
        Professor professor = tiposBuscaProfessores();
        System.out.println("Confirma a exclusão?");
        System.out.println("1- Sim\n2-Não");
        int confirmacao = entrada.nextInt();
        entrada.skip("\n");
        if (confirmacao == 1) {
            professores.remove(professor);
            System.out.println("Professor excluído");
        } else System.out.println("Operação cancelada");
    }


    public void consultar() {

        System.out.println("===DESEJA INFORMAR O PROFESSOR A SER CONSULTADO POR:===");
        Professor professor = tiposBuscaProfessores();
        System.out.println(professor != null ? professor : "Cadastro nao encontrado!!");

    }

    public void relatorio() {

        System.out.println("[Relatório de PROFESSORES]");
        for (Professor professor : professores) {
            if (professor != null) {
                System.out.println(professor);
                System.out.println("---------------------");
            }

        }

    }
}
