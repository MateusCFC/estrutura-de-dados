#include <iostream>
#include <stack>

using namespace std;

int head(stack<string> x);
stack<string>* rec(stack<string>* e);

int main()
{
    stack<string> p1;

    string ele;
    int c;

    do {
        c = head(p1);
        if (c == 1){
            cout << "Digite o elemento: ";
            cin >> ele;
            p1.push(ele);
            cout << endl;
        } else if (c == 2){
	  rec(&p1);
        }
    } while (c != 3);

    return 0;
}

int head(stack<string> x){
    int choice;
    cout << "Fila: ";
    while (!x.empty()) {
      cout << x.top() << " ";
      x.pop();
    }
    cout << "\n1 - Inserir elemento";
    cout << "\n2 - Remover elemento";
    cout << "\n3 - Sair";
    cout << "\nDigite a opcao: ";
    cin >> choice;
    return choice;
}

stack<string>* rec(stack<string>* e){
  if (e->size() == 1) {
    e->pop();
    return e;
  } else {
    stack<string>* out;
    string aux = e->top();
    e->pop();
    out = rec(e);
    out->push(aux);
    return out;
  }
}
