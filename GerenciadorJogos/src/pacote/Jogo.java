package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private String nome;
    private String descricao;
    private String genero;
    private boolean disponivel;
    private String dono;

    public Jogo(String nome, String genero, String descricao, boolean disponivel, String dono){
        this.nome=nome;
        this.genero=genero;
        this.descricao=descricao;
        this.disponivel=disponivel;
        this.dono=dono;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getDisponibilidade(){
        return disponivel;
    }

    public String getDono() {
        return dono;
    }

    public static ArrayList <Jogo> jogos = new ArrayList<>(); // ArrayList responsável por armazenar os objetos da classe Jogo
    static Scanner sc = new Scanner(System.in);

    public static void cadastrarJogo(){
        System.out.println("\n Cadastrando jogo...");
        System.out.println("Informe o nome do jogo: ");
        String nomeJogo = sc.nextLine();
        System.out.println("Informe o genero do jogo: ");
        String generoJogo = sc.nextLine();
        System.out.println("Informe a descrição do jogo: ");
        String descricaoJogo = sc.nextLine();
        System.out.println("Informe se o jogo está disponível para empréstimo (s) sim ou (n) não: ");
        char disponivel = sc.next().charAt(0);
        Boolean disponibilidadeJogo = (disponivel == 's') ?  true : false;
        // ACABAR METODO
    }
}
