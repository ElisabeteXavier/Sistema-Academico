package br.estudante.iftm.elisabete.modelos;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno extends Pessoa{
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public Aluno(){

    }

    public Aluno(String nome, String matricula, String telefone, String cpf, String email){
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
    }

    public Aluno(String nome, String matricula, String telefone, String cpf, String email,String dataNascimento) throws DateTimeException{

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoFormatada = LocalDate.parse(dataNascimento,formatador);

        if (dataNascimentoFormatada.getYear() > LocalDate.now().getYear()) {
            throw new DateTimeException("Ano maior que ano atual");
        }

        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimentoFormatada;
    }

    public String toString(){

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Aluno{" +
                "\nmatricula= " + matricula +
                "\n nome= " + nome +
                "\n cpf= " + cpf +
                "\n telefone= " + telefone +
                "\n email= " + email +
              "\n Data de Nascimento= " + dataNascimento.format(formatador) +
               "}";
    }

}
