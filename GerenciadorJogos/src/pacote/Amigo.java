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

    public static void removerAmigo(){ // Método que remove um amigo cadastrado
        if(amigos.size() == 0){
            System.out.println("Ainda não há amigos cadastrados."); 
            return;
        } 
        
        System.out.println("\nRemovendo amigo...");
        System.out.println("Informe o nome do amigo que deseja remover: ");
        String remover = sc.nextLine();

        for(int i = 0; i< amigos.size(); ++i){
            Amigo amigo = amigos.get(i);
            if (amigo.getNome().equals(remover)){ 
                for (int j = Jogo.jogos.size() -1 ; j>= 0; --j){ // Iterando de trás para frente já que é uma lista dinâmica e muda size e index constantemente
                    Jogo jogo = Jogo.jogos.get(j);
                    if(amigo.getNome().equals(jogo.getDono())){
                        Jogo.jogos.remove(jogo); // Remove jogos desse amigo do sistema
                    }
                }
                amigos.remove(i);
                System.out.println("Amigo removido com sucesso. Seus jogos cadastrados também foram removidos.");
                return;
            } else if (i == amigos.size() - 1 && amigo.getNome().equals(remover) == false) {
                System.out.println("O nome informado não corresponde a um amigo cadastrado.");
            }
        }
    }
    
    public static void listarAmigos(){ // Método que lista todos amigos cadastrado
        if(amigos.size() == 0){
            System.out.println("\nAinda não há amigos cadastrados.");
            return;
        } 

        System.out.println("\nLista de amigos:");
        for(int i = 0; i< amigos.size(); ++i){
            Amigo amigo = amigos.get(i);
            System.out.println("Nome: " + amigo.getNome());
        }
    }


    public void adicionarJogosPossuidos(String jogo){ // Atribui jogos cadastrados a um amigo
        String[] novoArray = new String[jogosPossuidos.length + 1];

        for (int i = 0; i < jogosPossuidos.length; i++) {
            novoArray[i] = jogosPossuidos[i];
        }

        novoArray[jogosPossuidos.length] = jogo;
        jogosPossuidos = novoArray;
    }

    public void removerJogosPossuidos(String jogo){ // Remove jogos atribuitos a um amigo
        for (int i = 0; i < jogosPossuidos.length; i++) {
            if (jogosPossuidos[i] != null && jogosPossuidos[i].equals(jogo)){
                jogosPossuidos[i] = null;
            }
        }
    }

    public void printJogosPossuidos() { // Método que printa jogos possuídos por um amigo
        boolean todosNull = true;
        for(int i = 0; i<jogosPossuidos.length; ++i){
            if(jogosPossuidos[i] != null){
                for(int j = 0; j<Jogo.jogos.size(); ++j){
                    Jogo jogo = Jogo.jogos.get(j);
                    if(jogosPossuidos[i].equals(jogo.getNome())){
                        System.out.println(jogosPossuidos[i] + " - " + Jogo.saidaDisponibilidade(jogo)); // Printa nome e disponibilidade do jogo
                    }
                }
                todosNull = false;
            } else if (i == jogosPossuidos.length - 1 && todosNull == true){
                System.out.println("Não possui jogos cadastrados em seu nome.");
            }
        }
    }

    public static void listarJogosPossuidos(){ // Método que mostra os jogos de um amigo específico
        if (amigos.isEmpty()){
            System.out.println("Ainda não há amigos cadastrados.");
            return;
        }

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
