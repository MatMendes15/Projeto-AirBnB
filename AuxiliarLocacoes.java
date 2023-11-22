import java.util.ArrayList;

public class AuxiliarLocacoes {
    public ArrayList<Locacao> locacoesGerais;
    
    //construtor
    public AuxiliarLocacoes(){
        this.locacoesGerais = new ArrayList<>();
    }

    //adiciona a lista de locações globais
    public void adicionaLocacoesGerais(Locacao locacao){
        this.locacoesGerais.add(locacao);
    }

    //exibe as locações cadastradas no sistema
    public void getLocacoesGerais(){
        System.out.println();
        System.out.println("#LOCAÇÕES DISPONÍVEIS#");
        System.out.println();
        int i = 1;
        for(Locacao locacao : this.locacoesGerais){
            System.out.println(i+"- "+locacao.getTituloLocacao());
            System.out.println("Capacidade: "+locacao.getCapacidadeLocacao());
            System.out.println("Preço por noite: "+locacao.getPrecoNoiteLocacao());
            System.out.println(locacao.getDescricaoLocacao());
            System.out.println();
            i++;
        }
    }
}