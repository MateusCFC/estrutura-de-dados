package stack;

/**
 * Created by Mateus Antonio on 06/04/2016.
 */

public class Stack {
    int topo = -1;
    static final int MAXSIZE = 50;
    char[] pilha = new char[MAXSIZE];

    public void adicionarPilha(char e) {
        topo++;
        pilha[topo] = e;
    }

    public char topoPilha(){
        return pilha[topo];
    }

    public char removerPilha() {
        char aux = pilha[topo];
        topo--;
        return aux;
    }

    public boolean estaVazia(){
        return (topo==-1);
    }
}
