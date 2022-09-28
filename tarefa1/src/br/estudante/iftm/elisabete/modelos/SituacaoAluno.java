package br.estudante.iftm.elisabete.modelos;

public enum SituacaoAluno {


    NaoEnturmado {
        public String toString() {
            return "Não Enturmado";
        }
    },

    Enturmado{
        public String toString(){
            return "Enturmado";
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
