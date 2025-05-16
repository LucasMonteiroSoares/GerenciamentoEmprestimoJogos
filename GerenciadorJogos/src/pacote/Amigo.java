package pacote;
import java.util.Scanner;
import java.util.ArrayList;

public class Amigo {
    // Atributos da classe amigo
    private String nome;
    private String nickname;

    // Getters, setters e constructor
    public String getNome() {
        return nome;
    }

    public String getNickname() {
        return nickname;
    }

    public Amigo(String nome, String nickname){
        this.nome = nome;
        this.nickname = nickname;
    }

    public static ArrayList <Amigo> amigos = new ArrayList<>(); // ArrayList responsável por armazenar os objetos da classe Amigo
    static Scanner sc = new Scanner(System.in);

    public static void cadastrarAmigo(){ // Método que cadastra novos amigos
        System.out.println("\n Cadastrando amigo...");
        System.out.println("Informe o nome do amigo: ");
        String nomeAmigo = sc.nextLine();
        System.out.println("Informe o nickname do amigo: ");
        String nicknameAmigo = sc.nextLine();
        amigos.add(new Amigo(nomeAmigo, nicknameAmigo));
        System.out.println("Amigo cadastrado com sucesso.");
    }

    public static void removerAmigo(){ // Método que remove amigos
        System.out.println("Removendo amigo...");
        System.out.println("Informe o nome do amigo que deseja remover: ");
        String remover = sc.nextLine();
        for(int i = 0; i< amigos.size(); ++i){
            Amigo amigo = amigos.get(i);
            if (amigo.getNome().equals(remover)){ // Utilizei EQUALS por conta de ser comparação de strings
                amigos.remove(i);
                System.out.println("Amigo removido com sucesso.");
            }
        }
    }
    
    public static void listarAmigos(){ // Método que lista todos amigos cadastrado
        for(int i = 0; i< amigos.size(); ++i){
            Amigo amigo = amigos.get(i);
            System.out.println("Nome: " + amigo.getNome() + " | Nickname: " + amigo.getNickname());
        }
    }

    public static void jogosPossuidos(){ // Método que mostra os jogos de um amigo específico

    }
}
