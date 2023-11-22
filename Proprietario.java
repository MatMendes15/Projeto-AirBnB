import java.util.ArrayList;
import java.util.Scanner;

public class Proprietario extends Usuario {
    private ArrayList<Locacao> locacoes;
    Scanner entrada = new Scanner(System.in);

    //construtor
    public Proprietario(String nome,String email,String senha){
        super(nome,email,senha);
        this.locacoes = new ArrayList<>();
    }

    //cria uma locação
    public void cadastraLocacao(Proprietario proprietario, AuxiliarLocacoes auxLocacoes){
        System.out.println();
        System.out.println("Título da locação:");
        System.out.print(">>> ");
        String titulo = entrada.next();
        System.out.println();
        System.out.println("Localização:");
        System.out.print(">>> ");
        String localizacao = entrada.next();
        System.out.println();
        System.out.println("Descrição da locação:");
        System.out.print(">>> ");
        String descricao = entrada.next();
        System.out.println();
        System.out.println("Capacidade da locação:");
        System.out.print(">>> ");
        int capacidade = entrada.nextInt();
        //valida se a capacidade é válida
        if (capacidade <= 0){
            while(true){
                System.out.println();
                System.out.println("#A LOCAÇÃO DEVE SUPORTAR NO MINÍMO UM HÓSPEDE, FAVOR INSERIR NOVAMENTE");
                System.out.print(">>> ");
                capacidade = entrada.nextInt();
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Preço por noite:");
        System.out.print(">>> ");
        double precoNoite = entrada.nextDouble();
        //cria a locação
        Locacao novaLocacao = new Locacao(titulo, localizacao, descricao, capacidade, precoNoite, proprietario);
        this.locacoes.add(novaLocacao);
        //adiciona a lista de locações globais
        auxLocacoes.adicionaLocacoesGerais(novaLocacao);
    }

    //exibe as locações
    public void getLocacoesProprietario(){
        //caso não exista nenhuma
        if (this.locacoes.size() <= 0){
            System.out.println();
            System.out.println("#VOCÊ NÃO CADASTROU NENHUMA LOCAÇÃO ATÉ O MOMENTO#");
            System.out.println();
        //caso exista
        }else{
            System.out.println();
            System.out.println("#LOCAÇÕES EXISTENTES#");
            for (Locacao locacao : this.locacoes){
                System.out.println();
                System.out.println("Título: "+locacao.getTituloLocacao());
                System.out.println("("+locacao.getLocalizacaoLocacao()+")");
                System.out.println(locacao.getDescricaoLocacao());
                System.out.println("Capacidade: "+locacao.getCapacidadeLocacao());
                System.out.println("Preço por noite: "+locacao.getPrecoNoiteLocacao());
            }
        }
    }

    //exibe as locações que possuem reserva
    public void getLocacoesReservadas(){
        //caso não tenha reserva
        for (Locacao locacao1 : this.locacoes){
            if (locacao1.getReservasLocacao().size() <= 0){
                System.out.println();
                System.out.println("#NÃO HÁ NENHUMA RESERVA#");
                System.out.println();
                break;
            }
        }
        //caso tenha reserva
        for (Locacao locacao2 : this.locacoes){
            if (locacao2.getReservasLocacao().size() > 0){
                if (locacao2.getStatusReservaLocacao() == true){
                    System.out.println();
                    System.out.println(locacao2.getTituloLocacao());
                    System.out.println();
                }
            }
        }
    }
}
