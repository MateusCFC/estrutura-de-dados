#include "Stack.h"

Stack::Stack()
{
    //ctor
}

void Stack::adicionarPilha(char e){
    topo++;
    pilha[topo] = e;
}

char Stack::removerPilha(){
    char aux = pilha[topo];
    topo--;
    return aux;
}

char Stack::topoPilha(){
    return pilha[topo];
}

bool Stack::estaVazia(){
    return (topo==-1);
}
