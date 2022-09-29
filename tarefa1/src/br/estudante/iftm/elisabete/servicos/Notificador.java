package br.estudante.iftm.elisabete.servicos;

import br.estudante.iftm.elisabete.modelos.Aluno;

public interface Notificador {

    void notificar (Aluno aluno, String mensagem);
}
