package main;

public class Main {

    static Aluno[] alunos = {
        new Aluno("Nicolas", "00000000000", 22, "000000", 600.00f, 0.00f),//0
        new Aluno("Harry", "11111111111", 23, "111111", 300.00f, 0.00f),//1
        new Aluno("Fulustreco", "22222222222", 20, "222222", 1500.00f, 10.00f),//2
        new Aluno("Copa", "33333333333", 17, "333333", 4400.00f, 30.00f),//3
    };
    static Aluno[] alunos2 = {
        new Aluno("Austin", "44444444444", 22, "444444", 3000.00f, 30.00f),//0
        new Aluno("MArcelo", "55555555555", 22, "555555", 400.00f, 0.00f),//1
        new Aluno("Tj", "66666666666", 40, "666666", 545.00f, 0.00f),//2
        new Aluno("Marcio", "77777777777", 12, "777777", 560.00f, 10.00f),//3
    };
    static Aluno[] alunos3 = {
        new Aluno("Ana", "88888888888", 20, "888888", 800.00f, 15.00f),//0
        new Aluno("Maria", "99999999999", 15, "999999", 1500.00f, 100.00f),//1
        new Aluno("Michele", "10101010101", 18, "101010", 234.00f, 102.00f),//2
        new Aluno("jessica", "121212122212", 24, "121212", 999.00f, 10.00f), //3
    };
    static Aluno[] alunos4 = {
        new Aluno("Xandão", "172535261", 20, "888888", 900.00f, 15.00f),//0
        new Aluno("PAto", "99999999999", 21, "999999", 150.00f, 10.00f),//1
        new Aluno("yoda", "90238928191", 22, "101010", 2234.00f, 12.00f),//2
        new Aluno("Alan", "121212122212", 25, "121212", 1009.00f, 100.00f), //3
    };

    public static void main(String[] args) throws InvalidaRaiz {
        AVLTree arvore = new AVLTree();  // faz o teste da  rotação RL
        AVLTree arvore2 = new AVLTree(); // faz o teste da rotação LR
        AVLTree arvore3 = new AVLTree(); // faz o teste da  rotação RR
        AVLTree arvore4 = new AVLTree(); //faz o teste da  rotação LL
       

        System.out.println("Árvore Balanceada: ");
        arvore.adicionar(alunos[0]);
        arvore.adicionar(alunos[1]);
        arvore.adicionar(alunos[2]);
        arvore.adicionar(alunos[3]);

        arvore.GetpreOrdem();
        System.out.println();

        System.out.println("Árvore2 Balanceada: ");
        arvore2.adicionar(alunos2[0]);
        arvore2.adicionar(alunos2[1]);
        arvore2.adicionar(alunos2[2]);
        arvore2.adicionar(alunos2[3]);

        arvore2.GetpreOrdem();
        System.out.println();

        System.out.println("Árvore3 Balanceada: ");
        arvore3.adicionar(alunos3[0]);
        arvore3.adicionar(alunos3[1]);
        arvore3.adicionar(alunos3[2]);
        arvore3.adicionar(alunos3[3]);

        arvore3.GetpreOrdem();
        System.out.println();

        System.out.println("Árvore4 Balanceada: ");
        arvore4.adicionar(alunos4[0]);
        arvore4.adicionar(alunos4[1]);
        arvore4.adicionar(alunos4[2]);
        arvore4.adicionar(alunos4[3]);

        arvore4.GetpreOrdem();
        System.out.println();

    }
}
