package projectocampeonatofutebol.modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Equipa {
    private String nome;
    private String apelido;
    private String fundacao;
    private List<Jogador> jogadores = new ArrayList<>();
    private List<Jogador> relacionados = new ArrayList<>();

    public Equipa(String nome, String apelido, String fundacao, List<Jogador> jogadores, List<Jogador> relacionados) {
        this.nome = nome;
        this.apelido = apelido;
        this.fundacao = fundacao;
        this.jogadores = jogadores;
        this.relacionados = relacionados;
    }

    public Equipa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getFundacao() {
        return fundacao;
    }

    public void setFundacao(String fundacao) {
        this.fundacao = fundacao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public List<Jogador> getRelacionados() {
        return relacionados;
    }

    public void setRelacionados(List<Jogador> relacionados) {
        this.relacionados = relacionados;
    }

    public void cadastrarJogadores(List<Jogador> jogadores) {
        if(jogadores.size()<=23)
            this.jogadores = jogadores;
        else
            System.out.println("Não foi possível cadastrar jogadores: verifique as quantidades!");
    }
    public List<Jogador> relacionarJogadores() {
        List<Jogador> naoRelacionados = new ArrayList<>();
        List<Jogador> relacionados = new ArrayList<>();

        // Criar uma cópia da lista de jogadores para iterar
        List<Jogador> copiaJogadores = new ArrayList<>(this.jogadores);

        // Iterar sobre a lista de jogadores
        for (Jogador jogador : copiaJogadores) {
            boolean adicionado = false;

            for (Jogador rel : relacionados) {
                if (jogador.getPosicao().equals(rel.getPosicao())) {
                    if (jogador.getQualidade() > rel.getQualidade()) {
                        relacionados.remove(rel);
                        relacionados.add(jogador);
                        naoRelacionados.add(rel);
                        adicionado = true;
                        break;
                    } else {
                        naoRelacionados.add(jogador);
                        adicionado = true;
                        break;
                    }
                }
            }

            if (!adicionado) {
                relacionados.add(jogador);
            }
        }

        // Selecionar os suplentes
        relacionados.sort((j1, j2) -> Double.compare(j2.getQualidade(), j1.getQualidade()));
        List<Jogador> suplentes = relacionados.subList(0, Math.min(relacionados.size(), 23));
        naoRelacionados.addAll(relacionados.subList(Math.min(relacionados.size(), 23), relacionados.size()));
        naoRelacionados.sort((j1,j2) -> Double.compare(j2.getQualidade(), j1.getQualidade()));
        int numJogadores=1;

        this.relacionados = new ArrayList<>(suplentes);
        for (int i = 0; i < naoRelacionados.size() ; i++) {
            if(numJogadores<7){
                this.relacionados.add(naoRelacionados.get(i));
                System.out.println(numJogadores+"");
                numJogadores++;
            }
        }
        //removendo os jogadores que já subiram como suplentes para relacionados
        for (int i = 0; i < 6; i++) {
            naoRelacionados.remove(naoRelacionados.removeFirst());
        }
        this.jogadores = new ArrayList<>(naoRelacionados);

        return naoRelacionados;
    }

    public void ImprimirEscalacoes(){
        List<Jogador> copiaRelacionados = this.relacionados;
        System.out.println("--------------------------------PLANTEL "+this.nome.toUpperCase()+" ---------------------------------------");
        int jogadoresEmCampo = 0;
        for (Jogador relacionados : copiaRelacionados){
            if(relacionados.getPosicao().equals("GOLEIRO"))
                System.out.print("GOLEIRO: ");
            else if(relacionados.getPosicao().equals("MEIO-ARMADOR"))
                System.out.print("MEIO-ARMADOR: ");
            else if(relacionados.getPosicao().equals("MEIO-ATACANTE"))
                System.out.print("MEIO-ATACANTE: ");
            else if(relacionados.getPosicao().equals("ZAGUEIRO-CENTRAL"))
                System.out.print("ZAGUEIRO-CENTRAL: ");
            else if(relacionados.getPosicao().equals("ALA-ESQUERDA"))
                System.out.print("ALA-ESQUERDA: ");
            else if(relacionados.getPosicao().equals("ALA-DIREITA"))
                System.out.print("ALA-DIREITA: ");
            else if(relacionados.getPosicao().equals("ZAGUEIRO"))
                System.out.print("ZAGUEIRO: ");
            else if(relacionados.getPosicao().equals("LATERAL-DIREITO"))
                System.out.print("LATERAL-DIREITO: ");
            else if(relacionados.getPosicao().equals("AVANÇADO"))
                System.out.print("AVANÇADO: ");
            else if(relacionados.getPosicao().equals("LATERAL-ESQUERDO"))
                System.out.print("LATERAL-ESQUERDO: ");
            else if(relacionados.getPosicao().equals("VOLANTE"))
                System.out.print("VOLANTE: ");
            if(jogadoresEmCampo<11) {
                System.out.println(relacionados.getId()+" "+relacionados.getNome() + " " + relacionados.getApelido() + " " +relacionados.getDataNascimento().toString() + " " + (relacionados.getSuspenso()?"SUSPENSO":"TÁ PRA JOGO"));
                jogadoresEmCampo++;
            }
        }
        System.out.println();
        System.out.println("--------------------------------------SUPLENTES------------------------------------------------------------");
        for (int i=jogadoresEmCampo;i<17;i++){
            if(copiaRelacionados.get(i).getPosicao().equals("GOLEIRO"))
                System.out.print("GOLEIRO: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("MEIO-ARMADOR"))
                System.out.print("MEIO-ARMADOR: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("MEIO-ATACANTE"))
                System.out.print("MEIO-ATACANTE: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("ZAGUEIRO-CENTRAL"))
                System.out.print("ZAGUEIRO-CENTRAL: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("ALA-ESQUERDA"))
                System.out.print("ALA-ESQUERDA: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("ALA-DIREITA"))
                System.out.print("ALA-DIREITA: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("ZAGUEIRO"))
                System.out.print("ZAGUEIRO: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("LATERAL-DIREITO"))
                System.out.print("LATERAL-DIREITO: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("AVANÇADO"))
                System.out.print("AVANÇADO: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("LATERAL-ESQUERDO"))
                System.out.print("LATERAL-ESQUERDO: ");
            else if(copiaRelacionados.get(i).getPosicao().equals("VOLANTE"))
                System.out.print("VOLANTE: ");
            System.out.println(copiaRelacionados.get(i).getId()+" "+copiaRelacionados.get(i).getNome() + " " + copiaRelacionados.get(i).getApelido() + " " +copiaRelacionados.get(i).getDataNascimento().toString() + " " + (copiaRelacionados.get(i).getSuspenso()?"SUSPENSO":"TÁ PRA JOGO"));
        }
        //System.out.println("-----------------------------------------------------------------------------------------------------------");
        //System.out.println("|                              |             "+copiaRelacionados.get(2).getNome()+"                                      |                |");
        //System.out.println("|                              |                                                          |                |");
        //System.out.println("|                              |                                                          |                |");
        //System.out.println("|                              |                                                          |                |");
        //System.out.println("|                              ------------------------------------------------------------                |");
        //System.out.println("|                                                                                                          |");
        //System.out.println("|        "+copiaRelacionados.get(10).getNome()+"                                              "+copiaRelacionados.get(4).getNome()+"                            "+copiaRelacionados.get(8).getNome()+"         |");
    }
}
