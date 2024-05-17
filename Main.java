package projectocampeonatofutebol;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import projectocampeonatofutebol.enums.Cartoes;
import projectocampeonatofutebol.modelos.Equipa;
import projectocampeonatofutebol.modelos.FabricaEquipa;
import projectocampeonatofutebol.modelos.Jogador;

import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) {
        Equipa equipe2 = FabricaEquipa.criarEquipa2();
        System.out.println("Jogadores:");
        for (Jogador j : equipe2.getJogadores()) {
            System.out.println(j.getNome() + " " + j.getPosicao() + " " + j.getQualidade());
        }
        List<Jogador> naoRelacionados = equipe2.relacionarJogadores();
        System.out.println("---------------------------");
        System.out.println("Relacionados:");
        for (Jogador r : equipe2.getRelacionados()) {
            System.out.println(r.getNome() + " " + r.getPosicao() + " " + r.getQualidade());
        }
        System.out.println("---------------------------");
        System.out.println("Jogadores não relacionados:");
        for (Jogador j : naoRelacionados) {
            System.out.println(j.getNome() + " " + j.getPosicao() + " " + j.getQualidade());
        }

        equipe2.ImprimirEscalacoes();
    }
}
