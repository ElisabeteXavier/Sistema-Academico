package br.estudante.iftm.elisabete.ficharios;

import br.estudante.iftm.elisabete.modelos.Turma;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioTurma implements Fichario{

    private final ArrayList<Turma> turmas;
    private final Scanner entrada;

    public FicharioTurma(ArrayList<Turma> turmas) {
        this.turmas = turmas;
        entrada = new Scanner(System.in);

    }


    private Turma buscaNome(String nome) {

        Turma turma = new Turma(nome);

        if (turmas.contains(turma)) {
            int i = turmas.indexOf(turma);

            return turmas.get(i);
        }
        return null;


    }


    private Turma buscaCodigo(int codigo) {

        for (Turma turma : turmas) {

            if (turma != null && turma.getCodigo() ==(codigo)) {
                return turma;
            }
        }
        return null;
    }

    private Turma tiposBuscaTurmas() {
        int opcoesBusca;
        String nome;
        int codigo;
        Turma retornoTurma = null;

        System.out.println("1- Nome");
        System.out.println("2- Código");
        opcoesBusca = entrada.nextInt();
        entrada.skip("\n");

        switch (opcoesBusca) {
            case 1 -> {
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                retornoTurma = buscaNome(nome);
            }
            case 2 -> {
                System.out.print("Código ");
                codigo = entrada.nextInt();
                retornoTurma = buscaCodigo(codigo);

            }
        }
        return retornoTurma;
    }


    private Turma setarTurmas() {

        String nome;
        System.out.println("===CADASTRO DA TURMA===");
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        return new Turma(nome);

    }

    public void cadastrar() {

        Turma turma =setarTurmas();

        if(turmas.contains(turma)){
            System.out.println("\nCadastro não realizado! já existe uma turma com esse nome");
        } else {
            turmas.add(turma);
            System.out.println("\nCadastrado realizado!\n");
        }
    }


    public void consultar() {

        System.out.println("===DESEJA CONSULTAR A TURMA POR:===");
         Turma turma = tiposBuscaTurmas();
        System.out.println(turma != null ? turma.consultarAlunosTurma() : "\nTurma não encontrada!");

    }

    public void alterar() {
        String nome;
        System.out.println("===BUSCAR TURMA A ALTERAR POR: ===");
        Turma turma = tiposBuscaTurmas();

        if (turma != null) {

            System.out.println("\nAlterando o Nome da turma ");

                    System.out.print(" Informe o novo Nome: ");
                    nome = entrada.nextLine();
                    turma.setNome(nome);


        } else
            System.out.println("\nTurma não encontrada!\n");
    }

    private boolean turmaVazia(Turma turma) {
        return turma.getAlunosTurmas().isEmpty();
    }

    public void excluir() {

        Turma turma = tiposBuscaTurmas();
        if (turmaVazia(turma)) {
            System.out.println("\nConfirma a exclusão?");
            System.out.println("1- Sim\n 2-Não");
            int confirmacao = entrada.nextInt();
            entrada.skip("\n");
            if (turma != null) {
                if (confirmacao == 1) {
                    turmas.remove(turma);
                    System.out.println("\nTurma excluída!");
                } else System.out.println("\nOperação cancelada, turma não excluída!");
            } else
                System.out.println("\nTurma não encontrada!");
        } else System.out.println("\nNão foi possível excluir a turma pois ela contém alunos vinculados!\n");
    }


    public void relatorio() {

        System.out.println("[Relatório de TURMAS]\n");
        System.out.println(turmas);

    }
}





