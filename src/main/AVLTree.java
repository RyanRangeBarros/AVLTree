package main;

import java.util.LinkedList;

public class AVLTree<T extends Comparable<T>> {

    private NoAVL<T> raiz;

    public AVLTree() {
        this.raiz = null;
    }

    public T localizar(T valor) {
        return localizarP(raiz, valor);
    }

    private NoAVL<T> RotaçaoEscolhida(NoAVL<T> raiz) throws InvalidaRaiz {
        if (raiz.getAltura() < -1) {
            if (raiz.getDireita().getAltura() < 0) {
                System.out.println("Vai fazer RR");
                raiz = rotacaoRR(raiz);
            } else {
                System.out.println("Vai fazer RL");
                raiz = rotacaoRL(raiz);
            }
        } else if (raiz.getAltura() > 1) {
            if (raiz.getEsquerda().getAltura() > 0) {
                System.out.println("VAi fazer LL");
                raiz = rotacaoLL(raiz);
            } else {
                System.out.println("Vai fazer LR");
                raiz = rotacaoLR(raiz);
            }
        }
        return raiz;
    }

    private T localizarP(NoAVL<T> raiz, T valor) {

        if (raiz == null) {
            return null;
        }

        int cmp = raiz.compareTo(valor);

        if (cmp < 0) {
            return localizarP(raiz.getEsquerda(), valor);
        } else if (cmp > 0) {
            return localizarP(raiz.getDireita(), valor);
        } else {
            return raiz.getValor();
        }

    }

    public void adicionar(T valor) throws InvalidaRaiz {
        this.raiz = adicionarP(this.raiz, valor);
    }

    public NoAVL<T> adicionarP(NoAVL<T> raiz, T valor) throws InvalidaRaiz {

        if (raiz == null) {
            return new NoAVL<T>(valor);
        }

        int cmp = raiz.compareTo(valor);

        if (cmp < 0) {
            raiz.setEsquerda(adicionarP(raiz.getEsquerda(), valor));
             raiz = RotaçaoEscolhida(raiz);
            balanceamento(raiz);
            
        } else if (cmp > 0) {
            raiz.setDireita(adicionarP(raiz.getDireita(), valor));
             raiz = RotaçaoEscolhida(raiz);
            balanceamento(raiz);
           
        } else {
            raiz.setValor(valor);
             raiz = RotaçaoEscolhida(raiz);
            balanceamento(raiz);
           
        }

        return raiz;
    }

    public NoAVL<T> ValorMaximo(NoAVL<T> raiz) {
        NoAVL<T> Pai = null;
        while (raiz.getDireita() != null) {
            Pai = raiz;
            raiz = raiz.getDireita();

        }
        return Pai;
    }

    public void AtualizaValor(NoAVL<T> NoA, NoAVL<T> NoB) {
        T temp = NoA.getValor();
        NoA.setValor(NoB.getValor());
        NoB.setValor(temp);
    }

    public void remove(T valor) throws InvalidaRaiz {

        removerRec(valor, this.raiz, null);

    }

    public void removerRec(T valor, NoAVL<T> raiz, NoAVL<T> Pai) throws InvalidaRaiz {
        if (raiz != null) {
            if (valor.compareTo(raiz.getValor()) < 0) {
                removerRec(valor, raiz.getEsquerda(), raiz);
                balanceamento(raiz);
                RotaçaoEscolhida(raiz);
            } else if (valor.compareTo(raiz.getValor()) > 0) {
                removerRec(valor, raiz.getDireita(), raiz);
                balanceamento(raiz);
                RotaçaoEscolhida(raiz);
            } else {
                if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
                    raiz = null;
                } else if (raiz.getEsquerda() == null || raiz.getDireita() == null) {
                    if (raiz.getEsquerda() == null) {
                        raiz = raiz.getDireita();
                    } else {
                        raiz = raiz.getEsquerda();
                    }
                } else {
                    NoAVL<T> NoAnterior = ValorMaximo(raiz.getEsquerda());
                    if (NoAnterior != null) {
                        NoAVL<T> NoAlvo = NoAnterior.getDireita();
                        AtualizaValor(NoAlvo, raiz);
                        NoAnterior.setDireita(NoAlvo.getEsquerda());
                    } else {
                        raiz.getEsquerda().setDireita(raiz.getDireita());
                        raiz = raiz.getEsquerda();
                    }

                }
                if (Pai == null) {
                    this.raiz = raiz;
                } else {
                    if (Pai.getEsquerda().compareTo(valor) == 0) {
                        Pai.setEsquerda(raiz);

                    } else {
                        Pai.setDireita(raiz);
                    }

                }

            }

        }
    }

    private NoAVL<T> rotacaoRR(NoAVL<T> raiz) throws InvalidaRaiz {
        NoAVL<T> auxiliar;
        if (raiz == null) {
            return null;
        }
        auxiliar = raiz.getDireita();
        raiz.setDireita(auxiliar.getEsquerda());
        auxiliar.setEsquerda(raiz);
        balanceamento(auxiliar);
        return auxiliar;
    }

    private NoAVL<T> rotacaoLL(NoAVL<T> raiz) throws InvalidaRaiz {
        NoAVL<T> auxiliar;
        if (raiz == null) {
            return null;
        }
        auxiliar = raiz.getEsquerda();
        raiz.setEsquerda(auxiliar.getDireita());
        auxiliar.setDireita(raiz);
        balanceamento(auxiliar);
        return auxiliar;
    }

    private NoAVL<T> rotacaoRL(NoAVL<T> raiz) throws InvalidaRaiz {
        if (raiz == null) {
            return null;
        }
        raiz.setDireita(rotacaoLL(raiz.getDireita()));
        return rotacaoRR(raiz);

    }

    private NoAVL<T> rotacaoLR(NoAVL<T> raiz) throws InvalidaRaiz {
        if (raiz == null) {
            return null;
        }
        raiz.setEsquerda(rotacaoRR(raiz.getEsquerda()));
        return rotacaoLL(raiz);

    }

    private void balanceamento(NoAVL raiz) throws InvalidaRaiz {
        if (raiz == null) {
            throw new InvalidaRaiz();
        }
        int auxiliar = LocalizaAltura(raiz.getDireita()) - LocalizaAltura(raiz.getEsquerda());
        raiz.setAltura(auxiliar);
    }

    private int Value(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private int LocalizaAltura(NoAVL raiz) {
        if (raiz == null) {
            return -1;
        }
        if (raiz.getEsquerda() == null) {
            return LocalizaAltura(raiz.getDireita()) - 1;
        } else if (raiz.getDireita() == null) {
            return LocalizaAltura(raiz.getEsquerda()) + 1;
        } else if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
            return 0;
        } else {
            return Value((LocalizaAltura(raiz.getDireita())), LocalizaAltura(raiz.getEsquerda())) + 1;
        }

    }

     public void GetpreOrdem(){
        GetpreOrdemX(this.raiz);
    }

    private void GetpreOrdemX(NoAVL<T> raiz){
        System.out.println(raiz);
        if (raiz.getEsquerda() != null) {
            GetpreOrdemX(raiz.getEsquerda());
        }

         if (raiz.getDireita() != null) {
            GetpreOrdemX(raiz.getDireita());
        }
    }
}
