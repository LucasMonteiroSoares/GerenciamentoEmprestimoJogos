package pacote;

import java.util.ArrayList;

public class Amigo {
    private String nome;
    private String nickname;

    ArrayList<Amigo> listaAmigos = new ArrayList<>();

    public Amigo(String nome, String nickname){
        this.nome = nome;
        this.nickname = nickname;
    }


}
