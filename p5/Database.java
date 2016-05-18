package p5;

import java.util.ArrayList;

/**
 * Created by mateuscfc on 20/04/16.
 */

public class Database
{
    public static final ArrayList<Letra> caracteres;
    static
    {
        caracteres = new ArrayList<Letra>();
        String alfaNumericos = "abcdefghijklmnopqrstuvwxyz0123456789 ";
        for (int i=0;i<alfaNumericos.length();i++) caracteres.add(new Letra("" + alfaNumericos.charAt(i)));
    }

    public static Letra getLetra(String md5){
        Letra out = new Letra(null);
        for (int i=0;i<caracteres.size();i++){
            if (md5.equals(caracteres.get(i).getMd5Code())) {
                out.setCaractere(caracteres.get(i).getCaractere());
            }
        }
        return out;
    }

    public static Conta getConta(String[] md5){
        //String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
        Letra espaco = new Letra(" ");
        String md5Espaco = espaco.getMd5Code();
        int i=md5.length-1;
        while (!md5[i].equals(md5Espaco)) i--;
        StringBuilder aux = new StringBuilder();
        StringBuilder aux2 = new StringBuilder();
        for (int j=i+1;j<md5.length;j++) {
            String md5Atual = md5[j];
            Letra actual = getLetra(md5Atual);
            aux.append(actual.getCaractere());
        }
        for (int j=0;j<i;j++) {
            String md5Atual = md5[j];
            Letra actual = getLetra(md5Atual);
            aux2.append(actual.getCaractere());
        }
        String nomeCliente = aux2.toString();
        String saldo = aux.toString();
        Conta out = new Conta(nomeCliente,saldo);
        return out;
    }
}