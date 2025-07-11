package pacote;
import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    // Atributos da classe jogo
    private String nome;
    private String descricao;
    private String genero;
    private boolean disponivel;
    private String dono;

    // Getters, setters e constructor 
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

    public static void cadastrarJogo(){ // Método que cadastra novo jogo no sistema
        if (Amigo.amigos.size() == 0){
            System.out.println("Cadastre pelo menos um amigo antes de cadastrar jogos.");
            return;
        }

        System.out.println("\nCadastrando jogo...");
        System.out.println("Informe o nome do jogo: ");
        String nomeJogo = sc.nextLine();
        System.out.println("Informe o genero do jogo: ");
        String generoJogo = sc.nextLine();
        System.out.println("Informe a descrição do jogo: ");
        String descricaoJogo = sc.nextLine();
        System.out.println("Informe se o jogo está disponível para empréstimo (s) sim ou (n) não: ");
        char disponivel = sc.next().charAt(0);
        sc.nextLine();
        Boolean disponibilidadeJogo = (disponivel == 's') ?  true : false;
        System.out.println("Informe o nome do dono do jogo: ");
        String donoJogo = sc.nextLine();
            
        for(int i = 0; i<Amigo.amigos.size(); ++i){
            Amigo dono = Amigo.amigos.get(i); 
            if(donoJogo.equals(dono.getNome())){
                jogos.add(new Jogo(nomeJogo, generoJogo, descricaoJogo, disponibilidadeJogo, donoJogo)); 
                dono.adicionarJogosPossuidos(nomeJogo); // Atribui jogo cadastrado a um amigo também cadastrado
                System.out.println("Jogo cadastrado com sucesso.");  
                return;
            } else if (i == Amigo.amigos.size() - 1 && donoJogo.equals(dono.getNome()) == false){
                System.out.println("Não foi encontrado um amigo cadastrado com o nome do dono do jogo acima.");
            }
        }
    }

    public static void removerJogo(){ // Método que remove jogos cadastrados no sistema
        if(jogos.isEmpty()) {
            System.out.println("Nenhum jogo foi cadastrado.");
            return;
        }
        
        System.out.println("Removendo jogo...");
        System.out.println("Informe o nome do jogo que deseja remover: ");
        String remover = sc.nextLine();

        for(int i = 0; i<Amigo.amigos.size(); ++i){
            Amigo amigo = Amigo.amigos.get(i);
            amigo.removerJogosPossuidos(remover); // Remove atribuição de jogo a amigo também
        }

        for(int i = 0; i<jogos.size(); ++i){
            Jogo jogo = jogos.get(i);
            if (jogo.getNome().equals(remover)){ 
                jogos.remove(i);
                System.out.println("Jogo removido com sucesso.");
                return;
            } if (i == jogos.size()-1){
                System.out.println("Não foi encontrado um jogo com esse nome.");
            }
        }
    }

    public static String saidaDisponibilidade(Jogo jogo){ // Método que escreve uma mensagem para indicar disponibilidade com base no atributo boolean
        if (jogo.getDisponibilidade() == true){
            return "Jogo disponível para troca!";
        } else {
            return "Jogo indisponível para troca.";
        }
    }
    
    public static void listarJogosDisponiveis(){ // Método que lista todos jogos cadastrados disponíveis para empréstimo
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo foi cadastrado.");
            return;
        }

        boolean listaVazia = true;
        System.out.println("Jogos disponíveis no momento:");
        for(int i = 0; i< jogos.size(); ++i){
            Jogo jogo = jogos.get(i);
            if(jogo.getDisponibilidade() == true){
            System.out.println("Nome: " + jogo.getNome() + " | Genero: " + jogo.getGenero() + " | Descrição: " + jogo.getDescricao() + " | Disponibilidade: Disponível para troca!" + " | Dono do jogo: " + jogo.getDono());
            listaVazia = false;
            } else if (i == jogos.size() -1 && jogo.getDisponibilidade() == false && listaVazia == true){
                System.out.println("Nenhum jogo disponível no momento.");
            }
        }
    }

    public static void listarJogosIndisponiveis(){ // Método que lista todos jogos cadastrados indisponíveis para empréstimo
        if(jogos.isEmpty()) {
            System.out.println("Nenhum jogo foi cadastrado.");
            return;
        }

        boolean listaVazia = true;
        System.out.println("Jogos indisponíveis no momento:");
        for(int i = 0; i< jogos.size(); ++i){
            Jogo jogo = jogos.get(i);
            if(jogo.getDisponibilidade() == false){
            System.out.println("Nome: " + jogo.getNome() + " | Genero: " + jogo.getGenero() + " | Descrição: " + jogo.getDescricao() + " | Disponibilidade: Não está disponível para troca."  + " | Dono do jogo: " + jogo.getDono());
            listaVazia = false;
            } else if (i == jogos.size() -1 && jogo.getDisponibilidade() == true && listaVazia == true){
                System.out.println("Nenhum jogo indisponível!");
            }
        }
    }

    public static void buscaJogo(){ // Método que busca jogo pelo nome e traz informações
        if(jogos.isEmpty()){
            System.out.println("Nenhum jogo foi cadastrado.");
            return;
        }
        
        System.out.println("Informe o nome do jogo que deseja buscar: ");
        String nomeJogo = sc.nextLine();
        System.out.println("\n");

        for (int i = 0; i<jogos.size(); ++i){
            Jogo jogo = jogos.get(i);
            String msgDisponibilidade = saidaDisponibilidade(jogo);
            if(nomeJogo.equals(jogo.getNome())){
                System.out.println("Nome: " + jogo.getNome() + " | Genero: " + jogo.getGenero() + " | Descrição: " + jogo.getDescricao() + " | Disponibilidade: "  + msgDisponibilidade +  " | Dono do jogo: " + jogo.getDono());
                return;
            } 
            if(i==jogos.size()-1) {
                System.out.println("Jogo não encontrado. Tente novamente ou cadastre seu jogo.");
            }
        }
    }
}