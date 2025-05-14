package pacote;
import java.util.Scanner;

public class App {

    public static void menuAmigos(){ // Menu que aparecerá quando usuário cair no case 1 do switch (Gerenciar Amigos)
        System.out.println("\n*************************************");
        System.out.println("Menu de Amigos ");
        System.out.println("(1) Cadastrar um amigo");
        System.out.println("(2) Remover um amigo");
        System.out.println("(3) Listar todos amigos");
        System.out.println("(4) Visualizar um perfil de amigo");
        System.out.println("(5) Voltar ao menu principal");
        System.out.println("*************************************");
    }

    public static void menuJogos(){ // Menu que aparecerá quando usuário cair no case 2 do switch (Gerenciar Jogos)
        System.out.println("\n***********************************");
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
            int opcao = sc.nextInt();

            switch(opcao){
                
                
                case 3:
                rodando = false;
                break;
            }
        }
        while(rodando==true);
        sc.close();
    }
}
