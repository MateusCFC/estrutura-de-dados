#ifndef STACK_H
#define STACK_H

#define MAXSIZE = 50;

class Stack
{
    private:
        int topo = -1;
        char pilha[5];
    public:
        Stack();
        void adicionarPilha(char e);
        char removerPilha();
        char topoPilha();
        bool estaVazia();
};

#endif // STACK_H
