package br.estudante.iftm.elisabete.ficharios;

import br.estudante.iftm.elisabete.modelos.Aluno;


import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Scanner;

// adicionar os metodos alterar, excluir e consultar
// não permitir exclusão de alunos vinculados a turmas
public class FicharioAluno {
    private final ArrayList<Aluno> alunos;

    private FicharioEnturmacao ficharioEnturmacao;
    private final Scanner entrada;


    public FicharioAluno(ArrayList<Aluno> alunos, FicharioEnturmacao ficharioEnturmacao) {
        this.alunos = alunos;
        this.ficharioEnturmacao = ficharioEnturmacao;

        entrada = new Scanner(System.in);

    }


    private Aluno buscaNome(String nomeAlterado) {

        for (int j = 0; j < alunos.size(); j++) {

            if (alunos.get(j) != null && alunos.get(j).getNome().equals(nomeAlterado)) {
                return alunos.get(j);
            }
        }
        return null;
    }

    private Aluno buscacpf(String cpfAlterado) {

        for (int j = 0; j < alunos.size(); j++) {

            if (alunos.get(j) != null && alunos.get(j).getCpf().equals(cpfAlterado)) {
                return alunos.get(j);
            }
        }
        return null;
    }

    private Aluno buscaMatricula(String matriculaAlterada) {


        Aluno aluno = new Aluno(matriculaAlterada);

        if(alunos.contains(aluno)){
            int i = alunos.indexOf(aluno);
            return alunos.get(i);
        }
        else
            return null;
    }

    private Aluno tiposBuscaAlunos() {
        int opcoesBusca;
        String nome, cpf, matricula;
        Aluno aluno = new Aluno();

        System.out.println("1- Nome");
        System.out.println("2- CPF");
        System.out.println("3- Matrícula");
        opcoesBusca = entrada.nextInt();
        entrada.skip("\n");

        switch (opcoesBusca) {
            case 1 -> {
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                aluno = buscaNome(nome);
            }
            case 2 -> {
                System.out.print("CPF ");
                cpf = entrada.nextLine();
                aluno = buscacpf(cpf);
            }
            case 3 -> {
                System.out.print("Matricula: ");
                matricula = entrada.nextLine();
                aluno = buscaMatricula(matricula);
            }
        }
        return aluno;
    }

    private Aluno setarAluno(){
        String nome, matricula, telefone, cpf, email, dataNascimento;
        System.out.println(" === Cadastrar ALUNO ==== ");
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Matricula: ");
        matricula = entrada.nextLine();
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
        System.out.print("CPF: ");
        cpf = entrada.nextLine();
        System.out.print("Email: ");
        email = entrada.nextLine();
        System.out.print("Data de nascimento dd/mm/yyyy: ");
        dataNascimento = entrada.nextLine();

        return new Aluno(nome, matricula, telefone, cpf, email,dataNascimento);
    }


    public void cadastrar() {


        Aluno aluno = setarAluno();

        if (alunos.contains(aluno)) {
            System.out.println("\nCadastro não realizado! já existe um aluno com essa matricula\n");
        } else {
            alunos.add(aluno);
            System.out.println("\nCadastrado realizado!\n");
        }

    }


    public void alterar() {
        String nome, matricula, telefone, cpf, email;
        int alteracaoFeita;
        int retorno;


        System.out.println("===BUSCAR ALUNO A ALTERAR POR: ===");
        Aluno aluno = tiposBuscaAlunos();

        if (aluno != null) {


            do {

                System.out.println("O que deseja alterar? ");
                System.out.println("1 - Nome do Aluno ");
                System.out.println("2 - Matricula do Aluno ");
                System.out.println("3 - Telefone do Aluno ");
                System.out.println("4 - CPF do Aluno ");
                System.out.println("5 - Email do Aluno ");
                alteracaoFeita = entrada.nextInt();
                entrada.skip("\n");

                switch (alteracaoFeita) {
                    case 1 -> {
                        System.out.print("Novo Nome: ");
                        nome = entrada.nextLine();
                        aluno.setNome(nome);
                    }
                    case 2 -> {
                        System.out.print("Nova Matricula: ");
                        matricula = entrada.nextLine();
                        aluno.setMatricula(matricula);
                    }
                    case 3 -> {
                        System.out.print("Novo Telefone: ");
                        telefone = entrada.nextLine();
                        aluno.setTelefone(telefone);
                    }
                    case 4 -> {
                        System.out.print("Novo CPF ");
                        cpf = entrada.nextLine();
                        aluno.setCpf(cpf);
                    }
                    case 5 -> {
                        System.out.print("Novo Email ");
                        email = entrada.nextLine();
                        aluno.setEmail(email);
                    }

                }

                System.out.println("Deseja alterar mais alguma coisa?");
                System.out.println("1- Sim");
                System.out.println("2- Não");
                retorno = entrada.nextInt();
                entrada.skip("\n");
            } while (retorno == 1);
        } else
            System.out.println("Aluno não encontrado!");

    }

    public void excluir() {

        System.out.println("===DESEJA INFORMAR O ALUNO A SER EXCLUÍDO POR:===");
        Aluno aluno = tiposBuscaAlunos();
        if (!ficharioEnturmacao.alunoVinculadoTurma(aluno)) {
            System.out.println("Confirma a exclusão?");
            System.out.println("1- Sim\n 2-Não");
            int confirmacao = entrada.nextInt();
            entrada.skip("\n");
            if (confirmacao == 1) {
                alunos.remove(aluno);
                System.out.println("Aluno excluído");
            } else System.out.println("Operação cancelada");
        } else System.out.println("Não foi possível excluir o aluno, pois ele está vinculado a uma turma");

    }

    public void consultar() {

        System.out.println("===DESEJA INFORMAR O ALUNO A SER CONSULTADO POR:===");
        Aluno aluno = tiposBuscaAlunos();
        System.out.println(aluno != null ? aluno : "Aluno não encontrado!!");

    }


    public void relatorio() {

        System.out.println("[Relatório de ALUNOS]");
        for (Aluno aluno : alunos) {
            if (aluno != null) {
                System.out.println(aluno);
                System.out.println("---------------------");
            }

        }

    }

}
