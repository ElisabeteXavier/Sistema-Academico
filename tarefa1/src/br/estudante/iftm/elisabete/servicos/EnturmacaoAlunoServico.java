package br.estudante.iftm.elisabete.servicos;

import br.estudante.iftm.elisabete.modelos.Aluno;

public class EnturmacaoAlunoServico {
    public void avisar (Aluno aluno){
        NotificadorEmail notificadorEmail = new NotificadorEmail();
        notificadorEmail.notificar(aluno,"Sua enturmação na turma foi realizada!");
    }
}
