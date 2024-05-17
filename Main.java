package projectocampeonatofutebol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import projectocampeonatofutebol.enums.Cartoes;
import projectocampeonatofutebol.modelos.Equipa;
import projectocampeonatofutebol.modelos.FabricaEquipa;
import projectocampeonatofutebol.modelos.Jogador;
import projectocampeonatofutebol.modelos.Jogo;

import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) {
        Equipa equipeMandante = FabricaEquipa.criarEquipa1();
        Equipa equipeVisitante = FabricaEquipa.criarEquipa2();
        equipeMandante.relacionarJogadores();
        equipeMandante.ImprimirEscalacoes();
        equipeVisitante.relacionarJogadores();
        equipeVisitante.ImprimirEscalacoes();

        Jogo jogo = new Jogo(equipeMandante, equipeVisitante, new Date(), "Estádio X", 0, 0);
        jogo.gerarCartoes();
        jogo.gerarLesoes();
        jogo.gerarResultado();

    }
}
