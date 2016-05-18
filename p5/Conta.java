package p5;

/**
 * Created by mateuscfc on 20/04/16.
 */

public class Conta {
    private String nomeCliente, saldo, agencia, numero, senha, md5;

    Conta(String agencia, String numero, String senha) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        md5 = SecurityProvider.md5ToServer(this);
    };

    Conta(String agencia, String numero, String senha, String saldo, String nomeCliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.nomeCliente = nomeCliente;
        md5 = SecurityProvider.md5ToServer(this);
    };

    Conta(String nomeCliente, String saldo) {
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    };

    public void setNomeCliente(String n){
        nomeCliente = n;
    }

    public void setSaldo(String s){
        saldo = s;
    }

    public void setAgencia(String ag){
        agencia = ag;
    }

    public void setNumero(String num){
        numero = num;
    }

    public void setSenha(String pwd){
        senha = pwd;
    }

    public void setMd5(String md){
        md5 = md;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public String getSaldo(){
        return saldo;
    }

    public String getAgencia(){
        return agencia;
    }

    public String getNumero(){
        return numero;
    }

    public String getSenha(){
        return senha;
    }

    public String getMd5(){
        return md5;
    }

    @Override public String toString(){
        StringBuilder resultado = new StringBuilder();
        String novaLinha = System.getProperty("line.separator");
        resultado.append("AGENCIA: " + agencia);
        resultado.append(novaLinha);
        resultado.append("CONTA: " + numero);
        resultado.append(novaLinha);
        resultado.append("SENHA: " + senha);
        resultado.append(novaLinha);
        resultado.append("NOME CLIENTE: " + nomeCliente);
        resultado.append(novaLinha);
        resultado.append("SALDO: " + saldo);
        resultado.append(novaLinha);
        resultado.append("MD5: " + md5);
        resultado.append(novaLinha);
        return resultado.toString();
    }
}
