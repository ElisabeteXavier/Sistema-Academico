package br.estudante.iftm.elisabete.servicos;

import br.estudante.iftm.elisabete.modelos.Aluno;

public class MatriculaAlunoServico {
    public void avisar (Aluno aluno){
        NotificadorEmail notificadorEmail = new NotificadorEmail();
        notificadorEmail.notificar(aluno,"Matricula realizada!");

    }
}
