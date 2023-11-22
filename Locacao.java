import java.util.ArrayList;

public class Locacao {
    private Proprietario proprietario;
    private String titulo;
    private String localizacao;
    private String descricao;
    private int capacidade;
    private double precoNoite;
    private ArrayList<Reserva> reservasLocacao;
    private boolean reservada;

    
    //construtor
    public Locacao(String titulo, String localizacao, String descricao, int capacidade, double precoNoite, Proprietario proprietario){
        this.titulo = titulo;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.precoNoite = precoNoite;
        this.proprietario = proprietario;
        this.reservasLocacao = new ArrayList<>();
        this.reservada = false;
    }

    //adiciona reserva a lista de reservas da locação
    public void recebeReserva(Reserva reserva){
        this.reservasLocacao.add(reserva);
        this.reservada = true;
    }

    //getters
    public String getTituloLocacao(){
        return this.titulo;
    }

    public String getLocalizacaoLocacao(){
        return this.localizacao;
    }

    public String getDescricaoLocacao(){
        return this.descricao;
    }

    public int getCapacidadeLocacao(){
        return this.capacidade;
    }

    public double getPrecoNoiteLocacao(){
        return this.precoNoite;
    }

    public ArrayList<Reserva> getReservasLocacao(){
        return this.reservasLocacao;
    }

    public boolean getStatusReservaLocacao(){
        return this.reservada;
    }
}
