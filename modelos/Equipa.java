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
                        writer.write("("+jogador.getId()+","+jogador.getNome()+")");
                    }
                     writer.newLine();
                    writer.write("Relacionados:");
                    for (Jogador relacionado : this.relacionados){
                        writer.write("("+relacionado.getId()+","+relacionado.getNome()+")");
                    }
                    for (Jogador relacionado : this.relacionados){
                        writer.write("("+relacionado.getId()+","+relacionado.getNome()+")");
                    }
                    for (Jogador relacionado : this.relacionados){
                        writer.write("("+relacionado.getId()+","+relacionado.getNome()+")");
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

    public void cadastrarJogadores() {
        // Método a ser implementado
    }
}
