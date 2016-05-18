package p5;

/**
 * Created by mateuscfc on 20/04/16.
 */

public class Letra {
    private String caractere, md5Code;

    Letra(String caractere){
        this.caractere = caractere;
        md5Code = SecurityProvider.md5(caractere);
    };

    public void setCaractere(String c){
        caractere = c;
    }

    public void setMd5Code(String m){
        md5Code = m;
    }

    public String getCaractere(){
        return caractere;
    }

    public String getMd5Code(){
        return md5Code;
    }
}
