package p5;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by mateuscfc on 20/04/16.
 */

public class ServerDatabase extends Database {
    public static final ArrayList<ArrayList<Conta>> contas;
    public static final int N = 100;
    static
    {
        contas = new ArrayList<ArrayList<Conta>>();
        for(int i=0;i<N;i++)
        {
            contas.add(new ArrayList<Conta>());
        }
    }

    public static int hashCode(String md5) {
        BigInteger bi = new BigInteger(md5, 16);
        BigInteger m = new BigInteger(Integer.toString(N), 10);
        int pos;
        pos = bi.mod(m).intValue();
        return pos;
    }

    public static void insereConta(Conta conta) {
        String md5 = conta.getMd5();
        int posicao = hashCode(md5);
        ArrayList<Conta> aux = contas.get(posicao);
        boolean flag = false;
        for (int i=0; i<aux.size();i++){
            if (md5.equals(aux.get(i).getMd5())) flag = true;
        }
        if (!flag) contas.get(posicao).add(conta);
    }

    public static Conta getConta(String md5) {
        int posicao = hashCode(md5);
        if (contas.size() < posicao) return null;
        else {
            ArrayList<Conta> aux = contas.get(posicao);
            Conta out = null;
            for (int i=0;i<aux.size();i++){
                if (md5.equals(aux.get(i).getMd5())) out = aux.get(i);
            }
            return out;
        }
    }
}