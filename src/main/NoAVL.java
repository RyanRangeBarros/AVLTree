package main;

public class NoAVL<T extends Comparable<T>> {

    T valor;
    private NoAVL<T> esquerda;
    private NoAVL<T> direita;
    private int altura;

    public NoAVL(T valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 0;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoAVL<T> getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(NoAVL<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoAVL<T> getDireita() {
        return this.direita;
    }

    public void setDireita(NoAVL<T> direita) {
        this.direita = direita;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int compareTo(T elemento) {
        return this.valor.compareTo(elemento);
    }

    @Override
    public String toString() {
        return this.valor.toString() + " / Coeficiente: " + this.altura;
    }
}
