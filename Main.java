import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        AuxiliarLocacoes auxLocacoes = new AuxiliarLocacoes();

        //usuários e locações pré-cadastrados
        Proprietario proprietario1 = new Proprietario("Lucas", "Lucassantos@gmail.com", "L1998sanTOS");
        Proprietario proprietario2 = new Proprietario("Fátima", "fatimamoreira@outlook.com", "25fm4428");
        Hospede hospede1 = new Hospede("Gustavo", "gustavosilva@gmail.com", "Xxs3GU!!");
        Hospede hospede2 = new Hospede("Leonardo", "leofernandes@gmail.com", "LF2020yxz");
        Locacao locacao1 = new Locacao("Apartamento", "São Paulo - Paulista", "Apartamento com vista para toda a Avenida Paulista, com 2 quartos, 1 banheiro e 1 cozinha.", 2, 70, proprietario1);
        Locacao locacao2 = new Locacao("Casa antiga", "São Paulo - Consolação", "Casa com arquitetura clássica no bairro da consolação, com 2 quartos, 1 suíte, 1 banheiro e cozinha.", 5, 100, proprietario1);
        Locacao locacao3 = new Locacao("Kitnet", "São Paulo - Santana", "Kitnet com varanda, 1 quarto, 1 banheiro, cozinha e academia", 1, 60, proprietario2);
        auxLocacoes.locacoesGerais.add(locacao1);
        auxLocacoes.locacoesGerais.add(locacao2);
        auxLocacoes.locacoesGerais.add(locacao3);
        Reserva reserva1 = new Reserva(hospede1, locacao3, 4, 1);
        Reserva reserva2 = new Reserva(hospede2, locacao1, 3, 2);
        Avaliacao avaliacao1 = new Avaliacao(hospede1, 5, "Muito confortável!");
        Avaliacao avaliacao2 = new Avaliacao(hospede2, 4, "Vista incrível!");

        //menu principal
        while(true){
            int opcao = 0;
            System.out.println();
            System.out.println("### MENU ###");
            System.out.println("1- Se cadastrar como proprietário");
            System.out.println("2- Se cadastrar como hóspede");
            System.out.println("3- Sair");
            System.out.print(">>> ");
            opcao = entrada.nextInt();
            if (opcao == 1){
                System.out.println();
                System.out.println("Nome:");
                System.out.print(">>> ");
                String nome = entrada.next();
                System.out.println();
                System.out.println("Endereço de e-mail:");
                System.out.print(">>> ");
                String email = entrada.next();
                System.out.println();
                System.out.println("Senha:");
                System.out.print(">>> ");
                String senha = entrada.next();
                if (senha.length() < 8){
                    while (true){
                        System.out.println();
                        System.out.println("#A SENHA DEVE TER NO MÍNIMO 8 CARACTERES#");
                        System.out.print(">>> ");
                        senha = entrada.next();
                        if (senha.length() >= 8){
                            break;
                        }
                    }
                }
                Proprietario usuarioProprietario = new Proprietario(nome,email,senha);
                menuProprietario(usuarioProprietario, entrada,auxLocacoes);
            }else if(opcao == 2){
                System.out.println();
                System.out.println("Nome:");
                System.out.print(">>> ");
                String nome = entrada.next();
                System.out.println();
                System.out.println("Endereço de e-mail:");
                System.out.print(">>> ");
                String email = entrada.next();
                System.out.println();
                System.out.println("Senha:");
                System.out.print(">>> ");
                String senha = entrada.next();
                if (senha.length() < 8){
                    while (true){
                        System.out.println();
                        System.out.println("#A SENHA DEVE TER NO MÍNIMO 8 CARACTERES#");
                        System.out.print(">>> ");
                        senha = entrada.next();
                        if (senha.length() >= 8){
                            break;
                        }
                    }
                }
                Hospede usuarioHospede = new Hospede(nome,email,senha);
                menuHospede(usuarioHospede,entrada,auxLocacoes);
            }else if(opcao == 3){
                break;
            }else{
                while (opcao < 1 || opcao > 3){
                    System.out.println();
                    System.out.println("#OPÇÃO INVÁLIDA, TENTE NOVAMENTE#");
                    System.out.print(">>> ");
                    opcao = entrada.nextInt();
                }
            }
        }
    }

    //menu usuário proprietário
    public static void menuProprietario(Proprietario usuarioProprietario,Scanner entrada,AuxiliarLocacoes auxLocacoes){
        while(true){
            int opcao = 0;
            System.out.println();
            System.out.println("#MENU#");
            System.out.println("1- Cadastrar locação");
            System.out.println("2- Minhas locações");
            System.out.println("3- Locações reservadas");
            System.out.println("4- Sair");
            System.out.print(">>> ");
            opcao = entrada.nextInt();
            if(opcao == 1){
                usuarioProprietario.cadastraLocacao(usuarioProprietario,auxLocacoes);
            }else if(opcao == 2){
                usuarioProprietario.getLocacoesProprietario();
            }else if(opcao == 3){
                usuarioProprietario.getLocacoesReservadas();
            }else if(opcao ==4){
                break;
            }
        }
    }
    
    //menu usuário hóspede
    public static void menuHospede(Hospede usuarioHospede,Scanner entrada,AuxiliarLocacoes auxLocacoes){
        while(true){
            int opcao = 0;
            System.out.println();
            System.out.println("#MENU#");
            System.out.println("1- Fazer reserva");
            System.out.println("2- Minhas reservas");
            System.out.println("3- Deixar avaliação");
            System.out.println("4- Sair");
            System.out.print(">>> ");
            opcao = entrada.nextInt();
            if(opcao == 1){
                auxLocacoes.getLocacoesGerais();
                usuarioHospede.criaReserva(usuarioHospede, auxLocacoes);
            }else if(opcao == 2){
                usuarioHospede.getReservasHospede();
            }else if(opcao == 3){
                usuarioHospede.criaAvaliacao(usuarioHospede);
            }else if(opcao == 4){
                break;
            }
        }
    }

    //limpa a tela
    public static void limpaTela(){
        String os = System.getProperty("os.name");
        os.contains("Windows");
    }
    
}
