package stack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.print("Digite a expressao: ");
        Scanner in = new Scanner(System.in);
        String entrada = in.next();
        boolean flag = false;

        for (int i=0;i<entrada.length();i++){
            char c = entrada.charAt(i);
            if (c == '(' || c == '[') {
                s.adicionarPilha(c);
            }
            else if (c == ')' || c == ']'){
                if (s.estaVazia()){
                    flag = true;
                    break;
                } else if (comparar(s.topoPilha(),c)) {
                    s.removerPilha();
                } else {
                    s.adicionarPilha(c);
                }
            }
        }

        if (flag || !s.estaVazia()) System.out.println("Expressao incorreta");
        else System.out.println("Expressao correta");
    }

    static boolean comparar(char a, char b){
        return ((a == '(' && b == ')') || (a == '[' && b == ']'));
    }
}
