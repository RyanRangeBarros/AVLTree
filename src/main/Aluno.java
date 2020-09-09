
package main;


public class Aluno implements Comparable<Aluno> {

    private String nome;
    private String CPF;
    private int idade;
    public String matricula;
    public float mensalidade;
    public float desconto;

    public Aluno(String nome, String CPF,
            int idade, String matricula,
            float mensalidade, float desconto) {
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.matricula = matricula;
        this.mensalidade = mensalidade;
        this.desconto = desconto;

    }

    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    public float atualizar(float percentual) {
        this.mensalidade = mensalidade + (mensalidade * percentual);
        return mensalidade;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.matricula.equals(
                ((Aluno) obj).matricula));
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        b.append("{\"nome\":\"").append(nome).append("\",")
                .append("\"CPF\":\"").append(CPF).append("\",")
                .append("\"idade\": ").append(idade).append(",")
                .append("\"matricula\":\"").append(matricula).append("\",")
                .append("\"mensalidade\": ").append(mensalidade).append(",")
                .append("\"desconto\": ").append(desconto).append(",");

        return b.toString();
    }

    @Override
    public int compareTo(Aluno aluno) {
        return this.matricula.compareTo(aluno.matricula);
    }

}
