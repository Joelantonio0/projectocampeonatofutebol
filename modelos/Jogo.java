package projectocampeonatofutebol.modelos;

import projectocampeonatofutebol.enums.Cartoes;

import java.util.Date;
import java.util.Random;

public class Jogo {
    private Equipa mandante;
    private Equipa visitante;
    private Date dataDoJogo;
    private String estadio;
    private Integer placarMandante;
    private Integer placarVisitante;

    public Jogo() {
    }

    public Jogo(Equipa mandante, Equipa visitante, Date dataDoJogo, String estadio, Integer placarMandante, Integer placarVisitante) {
        this.mandante = mandante;
        this.visitante = visitante;
        this.dataDoJogo = dataDoJogo;
        this.estadio = estadio;
        this.placarMandante = placarMandante;
        this.placarVisitante = placarVisitante;
    }

    public Equipa getMandante() {
        return mandante;
    }

    public void setMandante(Equipa mandante) {
        this.mandante = mandante;
    }

    public Equipa getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipa visitante) {
        this.visitante = visitante;
    }

    public Date getDataDoJogo() {
        return dataDoJogo;
    }

    public void setDataDoJogo(Date dataDoJogo) {
        this.dataDoJogo = dataDoJogo;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Integer getPlacarMandante() {
        return placarMandante;
    }

    public void setPlacarMandante(Integer placarMandante) {
        this.placarMandante = placarMandante;
    }

    public Integer getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(Integer placarVisitante) {
        this.placarVisitante = placarVisitante;
    }
    public void gerarResultado() {
        Random random = new Random();

        // Somar a qualidade dos titulares de cada equipe
        double qualidadeMandante = this.mandante.getRelacionados().stream().mapToDouble(Jogador::getQualidade).sum();
        double qualidadeVisitante = this.visitante.getRelacionados().stream().mapToDouble(Jogador::getQualidade).sum();

        System.out.println("Qualidade total do mandante: " + qualidadeMandante);
        System.out.println("Qualidade total do visitante: " + qualidadeVisitante);

        // Definir probabilidades
        double probabilidadeMandante = 0.5;
        double probabilidadeVisitante = 0.3;
        double probabilidadeEmpate = 0.2;

        // Ajustar probabilidades baseado na qualidade
        if (qualidadeMandante > qualidadeVisitante) {
            probabilidadeMandante = 0.5;
            probabilidadeVisitante = 0.3;
        } else if (qualidadeMandante < qualidadeVisitante) {
            probabilidadeMandante = 0.3;
            probabilidadeVisitante = 0.5;
        }

        // Gerar resultado aleatório
        double resultado = random.nextDouble();

        if (resultado < probabilidadeMandante) {
            this.placarMandante = random.nextInt(1, 5); // Gera um placar aleatório entre 1 e 4 para o mandante
            this.placarVisitante = random.nextInt(0, 3); // Gera um placar aleatório entre 0 e 2 para o visitante
            System.out.println("Resultado: Vitória do Mandante");
        } else if (resultado < probabilidadeMandante + probabilidadeEmpate) {
            this.placarMandante = random.nextInt(0, 3); // Gera um placar aleatório entre 0 e 2 para o mandante
            this.placarVisitante = random.nextInt(0, 3); // Gera um placar aleatório entre 0 e 2 para o visitante
            System.out.println("Resultado: Empate");
        } else {
            this.placarMandante = random.nextInt(0, 3); // Gera um placar aleatório entre 0 e 2 para o mandante
            this.placarVisitante = random.nextInt(1, 5); // Gera um placar aleatório entre 1 e 4 para o visitante
            System.out.println("Resultado: Vitória do Visitante");
        }

        System.out.println("Placar final: " + this.mandante.getNome() + " " + this.placarMandante + " - " + this.placarVisitante + " " + this.visitante.getNome());
        this.permitirTreinamento();
    }

    public void gerarLesoes(){
        Random random = new Random();
        int numTimeLesao = random.nextInt(0,4);
        if(numTimeLesao==0){
            System.out.println("----------------------------------------------------------");
            System.out.println("              Não há lesões neste jogo!!!");
            System.out.println("----------------------------------------------------------");
        }else if(numTimeLesao==1){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("LESÃO NO JOGO:1");
            int numIndexJogadorLesionado = random.nextInt(0,10);
            System.out.println("Lesão na equipa:"+this.mandante.getNome());
            System.out.println( this.mandante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade antes da lesão: "+mandante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            this.mandante.getRelacionados().get(numIndexJogadorLesionado).sofrerLesao();
            System.out.println(this.mandante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade após lesão: "+mandante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            System.out.println("--------------------------------------------------------------------------------------");
        }else if(numTimeLesao==2){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("LESÃO NO JOGO:1");
            int numIndexJogadorLesionado = random.nextInt(0,10);
            System.out.println("Lesão na equipa:"+this.visitante.getNome());
            System.out.println(this.visitante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade antes da lesão: "+visitante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            this.visitante.getRelacionados().get(numIndexJogadorLesionado).sofrerLesao();
            System.out.println(this.visitante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade após lesão: "+visitante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            System.out.println("--------------------------------------------------------------------------------------");
        }else{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("LESÃO NO JOGO:2");
            int numIndexJogadorLesionado = random.nextInt(0,10);
            System.out.println("Lesão na equipa:"+this.mandante.getNome());
            System.out.println( this.mandante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade antes da lesão: "+mandante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            this.mandante.getRelacionados().get(numIndexJogadorLesionado).sofrerLesao();
            System.out.println(this.mandante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade após lesão: "+mandante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            System.out.println("--------------------------------------------------------------------------------------");
            numIndexJogadorLesionado = random.nextInt(0,10);
            System.out.println("Lesão na equipa:"+this.visitante.getNome());
            System.out.println(this.visitante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade antes da lesão: "+visitante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            this.visitante.getRelacionados().get(numIndexJogadorLesionado).sofrerLesao();
            System.out.println(this.visitante.getRelacionados().get(numIndexJogadorLesionado).getNome()+", Qualidade após lesão: "+visitante.getRelacionados().get(numIndexJogadorLesionado).getQualidade());
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }
    public void gerarCartoes(){
        Random random = new Random();
        int numeroCartoes = random.nextInt(0, 3);
        if(numeroCartoes==0){
            System.out.println("--------------------------------------------------------");
            System.out.println("                Nenhum cartão no jogo");
            System.out.println("--------------------------------------------------------");
        }else{
            int numEquipaCartao=0;
            for(int i=numeroCartoes;i>=0;i--) {
                numEquipaCartao = random.nextInt(1, 3);
                if (numEquipaCartao == 1) {
                    System.out.println("----------------------------EQUIPA:" + this.mandante.getNome() + "--------------------------");
                    int jogadorCartao = 0;
                    jogadorCartao = random.nextInt(0, 10);
                    if (!this.mandante.getRelacionados().get(jogadorCartao).verificarCondicaoJogo()) {
                        System.out.println("Ainda pode receber cartão...");
                        this.mandante.getRelacionados().get(jogadorCartao).aplicarCartao(Cartoes.values()[random.nextInt(0, 1)]);
                        System.out.println(this.mandante.getRelacionados().get(jogadorCartao).getNome()+" recebeu "+this.mandante.getRelacionados().get(jogadorCartao).getCartoes()[this.mandante.getRelacionados().get(jogadorCartao).getIndice()-1]);
                    }
                    System.out.println("---------------------------------------------------------------------------------------------");

                } else {
                    System.out.println("----------------------------EQUIPA:" + this.visitante.getNome() + "--------------------------");
                    int jogadorCartao = 0;

                    jogadorCartao = random.nextInt(0, 10);
                    if (!this.visitante.getRelacionados().get(jogadorCartao).verificarCondicaoJogo()) {
                        System.out.println("Ainda pode receber cartão...");
                        this.visitante.getRelacionados().get(jogadorCartao).aplicarCartao(Cartoes.values()[random.nextInt(0, 1)]);
                        System.out.println(this.visitante.getRelacionados().get(jogadorCartao).getNome()+" recebeu "+this.visitante.getRelacionados().get(jogadorCartao).getCartoes()[this.visitante.getRelacionados().get(jogadorCartao).getIndice()-1]);
                    }
                    System.out.println("---------------------------------------------------------------------------------------------");
                }
            }
        }
    }
    public void permitirTreinamento(){
        for (Jogador jogadoresMandante: mandante.getJogadores()){
            jogadoresMandante.setTreinamento(true);
        }
        for (Jogador jogadoresMandante: mandante.getRelacionados()){
            jogadoresMandante.setTreinamento(true);
        }
        for (Jogador jogadoresVisitantes: visitante.getJogadores()){
            jogadoresVisitantes.setTreinamento(true);
        }
        for (Jogador jogadoresVisitantes: visitante.getRelacionados()){
            jogadoresVisitantes.setTreinamento(true);
        }
    }
}
