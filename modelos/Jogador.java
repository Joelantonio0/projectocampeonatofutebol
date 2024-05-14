package projectocampeonatofutebol.modelos;

import java.util.Date;
import java.util.Random;

import projectocampeonatofutebol.enums.Cartoes;

public class Jogador {
    private Integer id;
    private String nome;
    private String apelido;
    private Date dataNascimento;
    private Integer numero;
    private String posicao;
    private Double qualidade;
    private Cartoes[] cartoes = new Cartoes[3];
    private Boolean suspenso;

    private Boolean treinamento = false;

    public Jogador() {
        for (int i = 0; i < cartoes.length; i++) {
            cartoes[i] = null;
        }
    }

    public Jogador(Integer id, String nome, String apelido, Date dataNascimento, Integer numero, String posicao,
                   Double qualidade, Cartoes[] cartoes, Boolean suspenso) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartoes = cartoes;
        this.suspenso = suspenso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Double getQualidade() {
        return qualidade;
    }

    public void setQualidade(Double qualidade) {
        this.qualidade = qualidade;
    }

    public Cartoes[] getCartoes() {
        return cartoes;
    }

    public void setCartoes(Cartoes[] cartoes) {
        this.cartoes = cartoes;
    }

    public Boolean getSuspenso() {
        return suspenso;
    }

    public void setSuspenso(Boolean suspenso) {
        this.suspenso = suspenso;
    }

    public boolean verificarCondicaoJogo() {
        int contadorAmarelo = 0;
        int contadorVermelho = 0;

        for (int i = 0; i < this.cartoes.length; i++) {
            if (this.cartoes[i] != null) {
                if (this.cartoes[i].equals(Cartoes.AMARELO)) {
                    contadorAmarelo++;
                } else if (this.cartoes[i].equals(Cartoes.VERMELHO)) {
                    contadorVermelho++;
                }
            }
        }
        boolean condicao = (contadorAmarelo >= 3 || contadorVermelho == 1);
        this.setSuspenso(condicao);
        return condicao;
    }

    public void aplicarCartao(int indice, Cartoes cartao) {
        if (indice >= 0 && indice < cartoes.length) {
            cartoes[indice] = cartao;
        }
        verificarCondicaoJogo();
    }

    public void cumprirSuspensao() {
        if (this.suspenso) {
            this.cartoes = new Cartoes[3];
            System.out.println("Suspensão cumprida!!!");
            this.suspenso = false;
        }
    }
    public void sofrerLesao(){
        Random random = new Random();
        int[] valoresPossiveis = {5,10,15,30,40};
        int escalaReducao = valoresPossiveis[random.nextInt(valoresPossiveis.length)];
        System.out.println("Redução de escala devido à lesão: " + escalaReducao);
        if(escalaReducao==5)
            this.qualidade -= this.qualidade*0.05;
        else if(escalaReducao==10)
            this.qualidade -= this.qualidade*0.10;
        else if(escalaReducao==15)
            this.qualidade -= this.qualidade*0.15;
        else if(escalaReducao==30)
            this.qualidade -= 2;
        else this.qualidade -= 1;
        System.out.println(this.qualidade);
    }
    public void executarTreinamento(){
        Random random = new Random();
        int[] valoresPossiveis = {5,10,15,30,40};
        int escalaAumento = valoresPossiveis[random.nextInt(valoresPossiveis.length)];
        System.out.println("Escala de aumento:"+escalaAumento);
        if(!treinamento){
            if(escalaAumento==5) {
                if(this.qualidade<96)
                    this.qualidade += 5.0;
            }
            else if(escalaAumento==10) {
                if(this.qualidade<97)
                    this.qualidade += 4.0;
            }
            else if(escalaAumento==15) {
                if(this.qualidade<98)
                    this.qualidade += 3.0;
            }
            else if(escalaAumento==30) {
                if(this.qualidade<99)
                    this.qualidade += 2.0;
            }
            else {
                if(this.qualidade!=100)
                    this.qualidade += 1.0;
            }
        }
        System.out.println("Qualidade aumentada:"+this.qualidade);
    }
}
        
        