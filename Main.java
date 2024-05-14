package projectocampeonatofutebol;

import projectocampeonatofutebol.enums.Cartoes;
import projectocampeonatofutebol.modelos.Jogador;

public class Main {
    public static void main(String[] args) {
        Jogador jogador = new Jogador();

        jogador.aplicarCartao(0, Cartoes.AMARELO);
        jogador.aplicarCartao(1, Cartoes.AMARELO);
        jogador.aplicarCartao(2, Cartoes.AMARELO);
        // Verificando a condição do jogo
        boolean suspenso = jogador.verificarCondicaoJogo();
        System.out.println("Jogador suspenso: " + jogador.getSuspenso());
        jogador.cumprirSuspensao();
        jogador.setQualidade(70.0);
        jogador.sofrerLesao();
        jogador.setQualidade(98.0);
        System.out.println(jogador.getQualidade());
        jogador.executarTreinamento();
    }
}
