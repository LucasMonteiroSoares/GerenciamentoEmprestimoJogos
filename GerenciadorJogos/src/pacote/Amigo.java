package pacote;
import java.util.Scanner;
import java.util.ArrayList;

public class Amigo {
    // Atributos da classe amigo
    private String nome;
    private String [] jogosPossuidos  = new String [10]; 

    // Getters, setters e constructor
    public String getNome() {
        return nome;
    }

    public void adicionarJogosPossuidos(String jogo){
        String[] novoArray = new String[jogosPossuidos.length + 1];

        for (int i = 0; i < jogosPossuidos.length; i++) {
            novoArray[i] = jogosPossuidos[i];
        }

        novoArray[jogosPossuidos.length] = jogo;
        jogosPossuidos = novoArray;
    }

    public Amigo(String nome){
        this.nome = nome;
    }

    public static ArrayList <Amigo> amigos = new ArrayList<>(); // ArrayList responsável por armazenar os objetos da classe Amigo
    static Scanner sc = new Scanner(System.in);

    public static void cadastrarAmigo(){ // Método que cadastra novos amigos
        System.out.println("\nCadastrando amigo...");
        System.out.println("Informe o nome do amigo: ");
        String nomeAmigo = sc.nextLine();
        amigos.add(new Amigo(nomeAmigo));
        System.out.println("Amigo cadastrado com sucesso!");
    }

    public static void removerAmigo(){ // Método que remove amigos
        if(amigos.size() == 0){
            System.out.println("Ainda não há amigos cadastrados.");
        } else {
            System.out.println("\nRemovendo amigo...");
            System.out.println("Informe o nome do amigo que deseja remover: ");
            String remover = sc.nextLine();
            for(int i = 0; i< amigos.size(); ++i){
                Amigo amigo = amigos.get(i);
                if (amigo.getNome().equals(remover)){ // Utilizei EQUALS por conta de ser comparação de strings
                    amigos.remove(i);
                    System.out.println("Amigo removido com sucesso.");
                    return;
                } else if (i == amigos.size() - 1 && amigo.getNome().equals(remover) == false) {
                    System.out.println("O nome informado não corresponde a um amigo cadastrado.");
                }
            }
        }
    }
    
    public static void listarAmigos(){ // Método que lista todos amigos cadastrado
        if(amigos.size() == 0){
            System.out.println("\nAinda não há amigos cadastrados.");
        } else {
            System.out.println("\nLista de amigos:");
            for(int i = 0; i< amigos.size(); ++i){
                Amigo amigo = amigos.get(i);
                System.out.println("Nome: " + amigo.getNome());
            }
        }
    }

    public void printJogosPossuidos() { // Método que printa jogos possuidos de um amigo
        boolean todosNull = true;
        for(int i = 0; i<jogosPossuidos.length; ++i){
            if(jogosPossuidos[i] != null){
                System.out.println(jogosPossuidos[i]);
                todosNull = false;
            } else if (i == jogosPossuidos.length - 1 && todosNull == true){
                System.out.println("Não possui jogos cadastrados em seu nome.");
            }
        }
    }

    public static void listarJogosPossuidos(){ // Método que mostra os jogos de um amigo específico
        System.out.println("\nInforme o nome do amigo que deseja listar os jogos: ");
        String nomeAmigo = sc.nextLine();
        for(int i = 0; i<amigos.size(); ++i){
            Amigo amigo = amigos.get(i);
            if(nomeAmigo.equals(amigo.getNome())){
                System.out.println("\nJogos do " + amigo.getNome() + ":");
                amigo.printJogosPossuidos();
                return;
            } else if (i == amigos.size() - 1 && nomeAmigo.equals(amigo.getNome()) == false){
                System.out.println("O nome informado não corresponde a um amigo cadastrado.");
            }
        }
    }
}
