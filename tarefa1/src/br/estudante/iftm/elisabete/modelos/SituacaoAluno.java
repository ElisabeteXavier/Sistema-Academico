package br.estudante.iftm.elisabete.modelos;

public enum SituacaoAluno {


    NaoEnturmado {
        public String toString() {
            return "Não Matriculado";
        }
    },

    Enturmado{
        public String toString(){
            return "Matriculado";
        }
    },

    Formado{
        public String toString(){
            return "Formado";
        }
    },

    Cancelado{
        public String toString(){
            return "Cancelado";
        }
    },

    Desistente{
        public String toString(){
            return "Desistente";
        }
    }

}
