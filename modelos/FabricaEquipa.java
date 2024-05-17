package projectocampeonatofutebol.modelos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import projectocampeonatofutebol.enums.Cartoes;
import projectocampeonatofutebol.modelos.Equipa;
import projectocampeonatofutebol.modelos.Jogador;

import static java.time.LocalDate.*;

public class FabricaEquipa {

    public static List<Jogador> criarJogadoresEquipa1() {
        List<Jogador> jogadores = new ArrayList<>();
        Cartoes[] cartoes = new Cartoes[3];
        // Vamos criar uma data de nascimento válida
        LocalDate dataNascimento = of(1990, 1, 1);

        // Criando os jogadores com todos os parâmetros necessários
        jogadores.add(new Jogador(1, "Joel", "Lucas", Date.valueOf(dataNascimento), 11, "AVANÇADO", 82.0, cartoes, false));
        jogadores.add(new Jogador(2, "Pedro", "Miguel", Date.valueOf(dataNascimento), 10, "MEIO-ATACANTE", 70.0, cartoes, false));
        jogadores.add(new Jogador(3, "Milton", "Pedro", Date.valueOf(dataNascimento), 9, "MEIO-ARMADOR", 70.0, cartoes, false));
        jogadores.add(new Jogador(4, "Miguel", "Watch", Date.valueOf(dataNascimento), 8, "ALA-DIREITA", 68.0, cartoes, false));
        jogadores.add(new Jogador(5, "João", "António", Date.valueOf(dataNascimento), 17, "ALA-ESQUERDA", 72.0, cartoes, false));
        jogadores.add(new Jogador(6, "Kelivaldo", "Nelembe", Date.valueOf(dataNascimento), 14, "VOLANTE", 72.5, cartoes, false));
        jogadores.add(new Jogador(7, "Kenivaldo", "Nelembe", Date.valueOf(dataNascimento), 2, "ZAGUEIRO-CENTRAL", 75.0, cartoes, false));
        jogadores.add(new Jogador(8, "João", "Nelembe", Date.valueOf(dataNascimento), 6, "ZAGUEIRO", 70.0, cartoes, false));
        jogadores.add(new Jogador(9, "Adriano", "Nelembe", Date.valueOf(dataNascimento), 5, "LATERAL-ESQUERDO", 78.0, cartoes, false));
        jogadores.add(new Jogador(10, "Roberto", "Correia", Date.valueOf(dataNascimento), 4, "LATERAL-DIREITO", 78.0, cartoes, false));
        jogadores.add(new Jogador(11, "Cristiano", "Salomão", Date.valueOf(dataNascimento), 1, "GOLEIRO", 80.0, cartoes, false));
        jogadores.add(new Jogador(12, "A", "1", Date.valueOf(dataNascimento), 12, "AVANÇADO", 83.0, cartoes, false));
        jogadores.add(new Jogador(13, "B", "1", Date.valueOf(dataNascimento), 13, "MEIO-ATACANTE", 74.0, cartoes, false));
        jogadores.add(new Jogador(14, "C", "1", Date.valueOf(dataNascimento), 15, "MEIO-ARMADOR", 68.0, cartoes, false));
        jogadores.add(new Jogador(15, "D", "1", Date.valueOf(dataNascimento), 16, "ALA-DIREITA", 69.0, cartoes, false));
        jogadores.add(new Jogador(16, "E", "1", Date.valueOf(dataNascimento), 20, "ALA-ESQUERDA", 73.0, cartoes, false));
        jogadores.add(new Jogador(17, "F", "1", Date.valueOf(dataNascimento), 23, "VOLANTE", 69.5, cartoes, false));
        jogadores.add(new Jogador(18, "G", "1", Date.valueOf(dataNascimento), 70, "ZAGUEIRO-CENTRAL", 72.0, cartoes, false));
        jogadores.add(new Jogador(19, "H", "1", Date.valueOf(dataNascimento), 72, "ZAGUEIRO", 72.0, cartoes, false));
        jogadores.add(new Jogador(20, "I", "1", Date.valueOf(dataNascimento), 74, "LATERAL-ESQUERDO", 74.0, cartoes, false));
        jogadores.add(new Jogador(21, "J", "1", Date.valueOf(dataNascimento), 76, "LATERAL-DIREITO", 73.0, cartoes, false));
        jogadores.add(new Jogador(22, "K", "1", Date.valueOf(dataNascimento), 78, "GOLEIRO", 82.0, cartoes, false));
        jogadores.add(new Jogador(23, "L", "1", Date.valueOf(dataNascimento), 79, "LATERAL-DIREITO", 81.0, cartoes, false));

        return jogadores;
    }

    public static List<Jogador> criarJogadoresEquipa2() {
        List<Jogador> jogadores = new ArrayList<>();
        Cartoes[] cartoes = new Cartoes[3];

        // Vamos criar uma data de nascimento válida
        LocalDate dataNascimento = of(1990, 1, 1);

        // Criando os jogadores com todos os parâmetros necessários
        jogadores.add(new Jogador(24, "Ronaldo", "Silva", Date.valueOf(dataNascimento), 11, "AVANÇADO", 85.0, cartoes, false));
        jogadores.add(new Jogador(25, "Neymar", "Santos", Date.valueOf(dataNascimento), 10, "MEIO-ATACANTE", 88.0, cartoes, false));
        jogadores.add(new Jogador(26, "Lionel", "Messi", Date.valueOf(dataNascimento), 9, "MEIO-ARMADOR", 90.0, cartoes, false));
        jogadores.add(new Jogador(27, "Kylian", "Mbappé", Date.valueOf(dataNascimento), 8, "ALA-DIREITA", 87.0, cartoes, false));
        jogadores.add(new Jogador(28, "Robert", "Lewandowski", Date.valueOf(dataNascimento), 7, "ALA-ESQUERDA", 86.0, cartoes, false));
        jogadores.add(new Jogador(29, "Kevin", "De Bruyne", Date.valueOf(dataNascimento), 6, "VOLANTE", 89.0, cartoes, false));
        jogadores.add(new Jogador(30, "Sergio", "Ramos", Date.valueOf(dataNascimento), 5, "ZAGUEIRO-CENTRAL", 88.0, cartoes, false));
        jogadores.add(new Jogador(31, "Virgil", "van Dijk", Date.valueOf(dataNascimento), 4, "ZAGUEIRO", 87.0, cartoes, false));
        jogadores.add(new Jogador(32, "Andrew", "Robertson", Date.valueOf(dataNascimento), 3, "LATERAL-ESQUERDO", 85.0, cartoes, false));
        jogadores.add(new Jogador(33, "Trent", "Alexander-Arnold", Date.valueOf(dataNascimento), 2, "LATERAL-DIREITO", 86.0, cartoes, false));
        jogadores.add(new Jogador(34, "Alisson", "Becker", Date.valueOf(dataNascimento), 1, "GOLEIRO", 89.0, cartoes, false));
        jogadores.add(new Jogador(35, "Antoine", "Griezmann", Date.valueOf(dataNascimento), 11, "AVANÇADO", 86.0, cartoes, false));
        jogadores.add(new Jogador(36, "Mohamed", "Salah", Date.valueOf(dataNascimento), 10, "MEIO-ATACANTE", 87.0, cartoes, false));
        jogadores.add(new Jogador(37, "Paul", "Pogba", Date.valueOf(dataNascimento), 9, "MEIO-ARMADOR", 88.0, cartoes, false));
        jogadores.add(new Jogador(38, "Gareth", "Bale", Date.valueOf(dataNascimento), 8, "ALA-DIREITA", 85.0, cartoes, false));
        jogadores.add(new Jogador(39, "Eden", "Hazard", Date.valueOf(dataNascimento), 7, "ALA-ESQUERDA", 88.0, cartoes, false));
        jogadores.add(new Jogador(40, "N'Golo", "Kanté", Date.valueOf(dataNascimento), 6, "VOLANTE", 89.0, cartoes, false));
        jogadores.add(new Jogador(41, "Gerard", "Piqué", Date.valueOf(dataNascimento), 5, "ZAGUEIRO-CENTRAL", 88.0, cartoes, false));
        jogadores.add(new Jogador(42, "Aymeric", "Laporte", Date.valueOf(dataNascimento), 4, "ZAGUEIRO", 87.0, cartoes, false));
        jogadores.add(new Jogador(43, "Jordi", "Alba", Date.valueOf(dataNascimento), 3, "LATERAL-ESQUERDO", 86.0, cartoes, false));
        jogadores.add(new Jogador(44, "Kyle", "Walker", Date.valueOf(dataNascimento), 2, "LATERAL-DIREITO", 87.0, cartoes, false));
        jogadores.add(new Jogador(45, "Thibaut", "Courtois", Date.valueOf(dataNascimento), 1, "GOLEIRO", 89.0, cartoes, false));

        return jogadores;
    }
    public static Equipa criarEquipa1() {
        List<Jogador> jogadores = criarJogadoresEquipa1();
        List<Jogador> relacionados = new ArrayList<>();
        return new Equipa("Barcelona", "Barça", "1999", jogadores, relacionados);
    }
    public static Equipa criarEquipa2() {
        List<Jogador> jogadores = criarJogadoresEquipa2();
        List<Jogador> relacionados = new ArrayList<>();
        return new Equipa("Real Madrid", "Madrid", "1989", jogadores, relacionados);
    }
}
