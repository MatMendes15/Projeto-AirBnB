public class Reserva {
    private Hospede hospede;
    private Locacao locacao;
    private Avaliacao avaliacao;
    private int duracao;
    private int qtdHospedes;
    private boolean avaliada;

    //construtor
    public Reserva(Hospede hospede,Locacao locacao,int duracao, int qtdHospedes){
        this.hospede = hospede;
        this.locacao = locacao;
        this.duracao = duracao;
        this.qtdHospedes = qtdHospedes;
        this.avaliada = false;
    }

    //getters
    public Locacao getLocacaoReserva(){
        return this.locacao;
    }

    public int getDuracaoReserva(){
        return this.duracao;
    }

    public int getQuantidadeHospedesReservas(){
        return this.qtdHospedes;
    }

    public boolean getStatusAvaliacao(){
        return this.avaliada;
    }


    //setters
    public void setAvaliacao(Avaliacao avaliacao){
        this.avaliacao = avaliacao;
        this.avaliada = true;
    }

}


