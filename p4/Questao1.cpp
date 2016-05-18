#include <iostream>
#include <stack>

using namespace std;

int head(stack<string> x);

int main()
{
    stack<string> p1;
    stack<string> p2;

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
	  while (!p1.empty()) {
	    p2.push(p1.top());
	    p1.pop();
	  }
	    p2.pop();
            while (!p2.empty()) {
	      p1.push(p2.top());
	      p2.pop();
	    }
            cout << endl;
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
