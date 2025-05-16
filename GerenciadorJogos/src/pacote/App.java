package pacote;
import java.util.Scanner;

public class App {

    public static void menuAmigos(){ // Menu que aparecerá quando usuário cair no case 1 do switch (Gerenciar Amigos)
        System.out.println("\n*************************************");
        System.out.println("Menu de Amigos ");
        System.out.println("(1) Cadastrar um amigo");
        System.out.println("(2) Remover um amigo");
        System.out.println("(3) Listar todos amigos");
        System.out.println("(4) Visualizar os jogos de um amigo");
        System.out.println("(5) Voltar ao menu principal");
        System.out.println("*************************************");
    }

    public static void menuJogos(){ // Menu que aparecerá quando usuário cair no case 2 do switch (Gerenciar Jogos)
        System.out.println("\n**********************************");
        System.out.println("Menu de Jogos ");
        System.out.println("(1) Cadastrar um jogo");
        System.out.println("(2) Remover um jogo");
        System.out.println("(3) Listar jogos disponíveis");
        System.out.println("(4) Listar jogos indisponíveis");
        System.out.println("(5) Buscar um jogo");
        System.out.println("(6) Voltar ao menu principal");
        System.out.println("***********************************");
    }

    public static void main(String[] args) throws Exception {
        boolean rodando = true;
        Scanner sc = new Scanner(System.in);
        
        do{ // Estrutura que mantém programa rodando enquanto usuário não caia no case 3 do switch (fechar o programa)
            System.out.println("\n*******************");
            System.out.println("Menu principal ");
            System.out.println("(1) Amigos");
            System.out.println("(2) Jogos");
            System.out.println("(3) Fechar programa");
            System.out.println("*******************");

            System.out.println("\nEscolha uma opção: ");
            int opcaoMenu = sc.nextInt();

            switch(opcaoMenu){
                
                case 1: // Menu de amigos
                boolean rodandoMenuAmigos = true;
                while(rodandoMenuAmigos == true){
                    menuAmigos();
                    System.out.println("\nEscolha uma opção: ");
                    int opcaoAmigo = sc.nextInt();

                    if(opcaoAmigo == 1){ // Chama método que cadastra um amigo no sistema
                        Amigo.cadastrarAmigo();
                
                    }

                    else if(opcaoAmigo == 2) { // Chama método que remove um amigo no sistema
                        Amigo.removerAmigo();
                    }

                    else if(opcaoAmigo == 3){ // Chama método que lista amigos cadastrados no sistema
                        Amigo.listarAmigos();
                    }

                    else if(opcaoAmigo == 4){ // Chama método que mostra jogos cadastrados de um amigo no sistema

                    }

                    else if(opcaoAmigo == 5){ // Volta para o menu principal
                        rodandoMenuAmigos = false;
                    }

                    else{ // Tratamento de erro
                        System.out.println("Opção inválida!");
                    }
                }
                break;

                case 2:
                boolean rodandoMenuJogos = true;
                while (rodandoMenuJogos == true) {
                    menuJogos();
                    System.out.println("\nEscolha uma opção: ");
                    int opcaoJogo = sc.nextInt();

                    if (opcaoJogo == 1){ // Chama método que cadastra um jogo no sistema
                        Jogo.cadastrarJogo();
                    }

                    else if(opcaoJogo == 2){ // Chama método que remove um jogo do sistema
                        Jogo.removerJogo();
                    }

                    else if(opcaoJogo == 3){ // Chama método que lista jogos DISPONIVEIS
                        Jogo.listarJogosDisponiveis();
                    }

                    else if (opcaoJogo == 4){ // Chama método que lista jogos INDISPONIVEIS
                        Jogo.listarJogosIndisponiveis();
                    }

                    else if(opcaoJogo == 5){ // Chama método que busca um jogo específico cadastrado no sistema
                        Jogo.buscaJogo();
                    }

                    else if(opcaoJogo == 6){ // Volta para o menu principal
                        rodandoMenuJogos = false;
                    }

                    else{ // Tratamento de erro
                        System.out.println("Opção inválida!");
                    }
                }
                
                case 3:
                rodando = false;
                break;

                default:
                System.out.println("Opção inválida!");
                break;
            }
        }
        while(rodando==true);
        sc.close();
    }
}
