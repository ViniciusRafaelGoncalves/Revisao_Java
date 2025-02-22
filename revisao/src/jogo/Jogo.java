package jogo;

public class Jogo {
    private String titulo;
    private int classificacaoEtaria;
    private double preco;

    public Jogo(String titulo, int classificacaoEtaria, double preco) {
        this.titulo = titulo;
        this.classificacaoEtaria = classificacaoEtaria;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(int classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void aplicarDesconto(double percentualDesconto) {
        preco -= preco * (percentualDesconto / 100);
    }

    public void aumentarPreco(double percentualAumento) {
        preco += preco * (percentualAumento / 100);
    }

    public void atualizarClassificacao(int novaClassificacao) {
        classificacaoEtaria = novaClassificacao;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "titulo='" + titulo + '\'' +
                ", classificacaoEtaria=" + classificacaoEtaria +
                ", preco=" + String.format("%.2f", preco) +
                '}';
    }
}