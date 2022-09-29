package br.estudante.iftm.elisabete.servicos;

import br.estudante.iftm.elisabete.modelos.Aluno;

public class MainServiços {

    public static void main(String[] args) {
        Aluno maria = new Aluno("Maria","026","3231","1544","maria@gmail.com","26/02/2003");
        Aluno joao = new Aluno("Joao","027","3232","1545","joao@gmail.com","18/03/2003");

        MatriculaAlunoServico matriculaAluno = new MatriculaAlunoServico();
        matriculaAluno.avisar(joao);
        matriculaAluno.avisar(maria);



    }
}
