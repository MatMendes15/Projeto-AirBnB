import java.util.ArrayList;
import java.util.Scanner;

public class Hospede extends Usuario {
    private ArrayList<Reserva> reservasHospede;
    Scanner entrada = new Scanner(System.in);

    //construtor
    public Hospede(String nome,String email,String senha){
        super(nome,email,senha);
        this.reservasHospede = new ArrayList<>();
    }

    //cria reserva
    public void criaReserva(Hospede usuarioHospede, AuxiliarLocacoes auxLocacoes){
        int escolha = 0;
        System.out.println();
        System.out.println("Digite o número da locação desejada, ou digite 0 para cancelar.");
        System.out.print(">>> ");
        escolha = entrada.nextInt();
        //caso o número escolhido não represente nenhuma locação
        if(escolha < 0 || escolha > auxLocacoes.locacoesGerais.size()){
            System.out.println();
            System.out.println("#NENHUMA LOCAÇÃO ENCONTRADA, FAVOR TENTAR NOVAMENTE#");
            usuarioHospede.criaReserva(usuarioHospede, auxLocacoes);
        //caso represente
        }else if(escolha != 0){
            //casting
            Object auxEscolha = auxLocacoes.locacoesGerais.get(escolha - 1);
            Locacao locacaoEscolhida = (Locacao) auxEscolha;
            //
            System.out.println();
            System.out.println("Deseja fazer a reserva para quantas pessoas?");
            System.out.print(">>> ");
            int qtdHospedes = entrada.nextInt();
            //valida se a quantidade de pessoas é suportada pela locação
            if (qtdHospedes > locacaoEscolhida.getCapacidadeLocacao() || qtdHospedes <= 0){
                while(true){
                    System.out.println();
                    System.out.println("#HÁ UM ERRO NA QUANTIDADE INFORMADA, FAVOR INSERIR NOVAMENTE#");
                    System.out.print(">>> ");
                    qtdHospedes = entrada.nextInt();
                    if (qtdHospedes > 0 && qtdHospedes <= locacaoEscolhida.getCapacidadeLocacao()){
                        break;
                    }
                }
            }
            System.out.println();
            System.out.println("Por quantos dias deseja fazer a reserva?");
            System.out.print(">>> ");
            int duracao = entrada.nextInt();
            //valida se a duração é válida
            while(duracao <= 0){
                System.out.println();
                System.out.println("#A RESERVA DEVE TER NO MINÍMO UM DIA DE DURAÇÃO, FAVOR INSERIR NOVAMENTE#");
                System.out.print(">>> ");
                duracao = entrada.nextInt();
                if(duracao > 0){
                    break;
                }
            }
            //cria a reserva
            Reserva novaReserva = new Reserva(usuarioHospede, locacaoEscolhida,duracao,qtdHospedes);
            //adiciona a reserva a lista de reservas dos hóspede
            this.reservasHospede.add(novaReserva);
            //adiciona a reserva a lista de reservas da locação
            locacaoEscolhida.recebeReserva(novaReserva);
        }
    }


    //cria avaliação
    public void criaAvaliacao(Hospede hospede){
        if (this.validaReservaHospede() == false){
            System.out.println();
            System.out.println("#É PRECISO FAZER UMA RESERVA PARA DEIXAR UMA AVALIAÇÃO#");
            System.out.println();
        }else{
            hospede.getReservasHospede();
            System.out.println();
            System.out.println("Selecione uma reserva para deixar a avaliação.");
            System.out.print(">>> ");
            int reserva = entrada.nextInt();
            if (reserva <= 0 || reserva > hospede.reservasHospede.size()){
                while(true){
                    System.out.println();
                    System.out.println("#NÃO FOI POSSÍVEL ENCONTRAR UMA RESERVA, TENTE NOVAMENTE#");
                    System.out.print(">>> ");
                    reserva = entrada.nextInt();
                    if(reserva > 0 && reserva <= hospede.reservasHospede.size()){
                        break;
                    }
                }
            }  
            //casting
            Object auxReserva = this.reservasHospede.get(reserva - 1);
            Reserva reservaEscolhida = (Reserva) auxReserva;
            //
            System.out.println();
            System.out.println("De 0 a 5, qual nota você daria para a sua experiência durante a reserva?");
            System.out.print(">>> ");
            int nota = entrada.nextInt();
            //valida a entrada
            while (nota < 0 || nota > 5){
                System.out.println();
                System.out.println("#O VALOR DEVE ESTAR ENTRE 0 E 5, TENTE NOVAMENTE#");
                System.out.print(">>> ");
                nota = entrada.nextInt();
            }
            System.out.println();
            System.out.println("Deixe um comentário:");
            System.out.print(">>> ");
            String comentario = entrada.next();
            //cria a reserva
            Avaliacao novaAvaliacao = new Avaliacao(hospede, nota, comentario);
            reservaEscolhida.setAvaliacao(novaAvaliacao);
        }
    }
        
    


    //valida se foram feitas reservas
    public boolean validaReservaHospede(){
        if(this.reservasHospede.size() <= 0){
            return false;
        }else{
            return true;
        }
    }


    //get
    public void getReservasHospede(){
        if (this.validaReservaHospede() == false){
            System.out.println();
            System.out.println("#VOCÊ NÃO POSSUI NENHUMA RESERVA ATÉ O MOMENTO#");
            System.out.println();
        }else{
            System.out.println();
            System.out.println("#RESERVAS FEITAS#");
            int i = 1;
            for (Reserva reserva : this.reservasHospede){
                System.out.println();
                System.out.println(i+"- "+reserva.getLocacaoReserva().getTituloLocacao());
                System.out.println("Pessoa(s): "+reserva.getQuantidadeHospedesReservas());
                System.out.println("Duração: "+reserva.getDuracaoReserva()+" dia(s).");
            }
        }   
    }
}
