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
        try {
            // Obtém o diretório atual do projeto
            String diretorioProjeto = System.getProperty("user.dir");
            System.out.println("Diretório do projeto: " + diretorioProjeto);

            // Define o caminho relativo para o diretório 'ficheiros' na raiz do projeto
            Path caminhoRelativo = Paths.get(diretorioProjeto, "ficheiros");

            try {
                // Cria o diretório se não existir
                if (Files.notExists(caminhoRelativo)) {
                    Files.createDirectories(caminhoRelativo);
                    System.out.println("Diretório criado com sucesso: " + caminhoRelativo.toString());
                } else {
                    System.out.println("Diretório já existe: " + caminhoRelativo.toString());
                }
                // Define o caminho para o novo ficheiro na pasta 'ficheiros'
                Path caminhoFicheiro = Paths.get(caminhoRelativo.toString(), "Equipas.txt");
                // Cria o ficheiro se não existir
                if (Files.notExists(caminhoFicheiro)) {
                    Files.createFile(caminhoFicheiro);
                    System.out.println("Ficheiro criado com sucesso: " + caminhoFicheiro.toString());
                } else {
                    System.out.println("Ficheiro já existe: " + caminhoFicheiro.toString());
                }
                // Escreve conteúdo no ficheiro
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoFicheiro.toFile(),true))) {
                    writer.write("INICIO");
                    writer.newLine();
                    writer.write(this.nome+ " "+this.apelido+" "+this.fundacao+" ");
                    writer.newLine();
                    writer.write("Jogadores:");
                    for (Jogador jogador: this.jogadores){
                        writer.write("("+jogador.getId()+" "+jogador.getNome()+ " "+jogador.getApelido()+" "+jogador.getDataNascimento().toString()+" "+jogador.getNumero()+" "+jogador.getPosicao()+" "+jogador.getQualidade()+" ("+jogador.getCartoes()[0]+","+jogador.getCartoes()[1]+","+jogador.getCartoes()[2]+") "+jogador.getSuspenso()+" "+jogador.getTreinamento()+")");
                    }
                    writer.newLine();
                    writer.write("Relacionados:");
                    for (Jogador jogador : this.relacionados){
                        writer.write("("+jogador.getId()+" "+jogador.getNome()+ " "+jogador.getApelido()+" "+jogador.getDataNascimento().toString()+" "+jogador.getNumero()+" "+jogador.getPosicao()+" "+jogador.getQualidade()+" ("+jogador.getCartoes()[0]+","+jogador.getCartoes()[1]+","+jogador.getCartoes()[2]+") "+jogador.getSuspenso()+" "+jogador.getTreinamento()+")");
                    }
                    writer.newLine();
                    writer.write("FIM");
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
