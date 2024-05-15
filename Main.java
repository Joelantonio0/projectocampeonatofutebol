package projectocampeonatofutebol;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import projectocampeonatofutebol.enums.Cartoes;
import projectocampeonatofutebol.modelos.Equipa;
import projectocampeonatofutebol.modelos.Jogador;

public class Main {
    public static void main(String[] args) {
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador(1, "Joel"));
        jogadores.add(new Jogador(2, "Lucas"));
        jogadores.add(new Jogador(3, "Correia"));
        jogadores.add(new Jogador(4, "António"));
        jogadores.add(new Jogador(5, "Pedro"));
        jogadores.add(new Jogador(6, "João"));

        Cartoes[] cartoes = new Cartoes[3];
        cartoes[0] = Cartoes.AMARELO;
        cartoes[1] = Cartoes.AMARELO;
        cartoes[2] = Cartoes.AMARELO;

        // Vamos criar uma data de nascimento válida
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);

        // Criando um jogador com todos os parâmetros necessários
        Jogador jogador = new Jogador(1, "Joel", "Lucas", Date.valueOf(dataNascimento),
                5, "AVANÇADO", 56.0, cartoes, false);

        // Agora que temos um jogador válido, podemos criar uma equipe com ele
        List<Jogador> relacionados = new ArrayList<>();
        relacionados.add(new Jogador(1, "Pirão"));
        relacionados.add(new Jogador(2, "Zé"));
        relacionados.add(new Jogador(3, "Correia"));
        relacionados.add(new Jogador(4, "Da Rosa"));
        relacionados.add(new Jogador(5, "Pedrinha"));
        relacionados.add(new Jogador(6, "Machado"));

        Equipa equipe = new Equipa("Barcelona", "Barça", "FUND", jogadores, relacionados);
    }
}
