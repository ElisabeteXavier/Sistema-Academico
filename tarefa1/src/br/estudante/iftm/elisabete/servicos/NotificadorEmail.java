package br.estudante.iftm.elisabete.servicos;

import br.estudante.iftm.elisabete.modelos.Aluno;

public class NotificadorEmail {
        public void notificar (Aluno aluno, String mensagem){
            System.out.printf("Notificando %s através do e-mail %s: %s\n", aluno.getNome(), aluno.getEmail(), mensagem);
        }
    }

