package br.estudante.iftm.elisabete.modelos;

import java.util.ArrayList;
import java.util.Objects;

public class Turma {
    private int  codigo;
    private String nome;

    private static int geradorCodigo;

    private ArrayList<Aluno> alunosTurmas;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aluno> getAlunosTurmas() {
        return alunosTurmas;
    }

    public Turma(){};

    public Turma(String nome){
        this.nome = nome;
        this.codigo = ++geradorCodigo;
        this.alunosTurmas = new ArrayList<>();
    }
    public String toString(){
        return "TURMA" +
                "\n nome= " + nome +
                "\n código= " + codigo +
                "";
    }

    public String consultarAlunosTurma(){
        return "TURMA: " + nome + " Código:" + codigo +
                "\n Alunos\n " + alunosTurmas +
                "";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(nome.toLowerCase(), turma.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
