#include <iostream>
#include <Stack.h>

using namespace std;

bool comparar(char a, char b);

int main()
{
    string entrada;
    Stack s;
    bool flag = false;

    cout << "Digite a expressao: ";
    cin >> entrada;

    int t = entrada.length();

    for (int i=0;i<t;i++){
        char c = entrada[i];
        if (c == '(' || c == '[') s.adicionarPilha(c);
        else if (c == ')' || c == ']'){
            if (s.estaVazia()){
                flag = true;
                break;
            } else if (comparar(s.topoPilha(),c)){
                s.removerPilha();
            } else {
                s.adicionarPilha(c);
            }
        }
    }

    if (flag || !s.estaVazia()) cout << "Expressao incorreta";
    else cout << "Expressao correta";

    return 0;
}

bool comparar(char a, char b){
    return ((a == '(' && b == ')') || (a == '[' && b == ']'));
}
