package projectocampeonatofutebol;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import projectocampeonatofutebol.enums.Cartoes;
import projectocampeonatofutebol.modelos.Equipa;
import projectocampeonatofutebol.modelos.Jogador;

import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) {
        List<Jogador> jogadores = new ArrayList<>();
        Cartoes[] cartoes = new Cartoes[3];
        cartoes[0] = Cartoes.AMARELO;
        cartoes[1] = Cartoes.AMARELO;
        cartoes[2] = Cartoes.AMARELO;

        // Vamos criar uma data de nascimento válida
        LocalDate dataNascimento = of(1990, 1, 1);

        // Criando um jogador com todos os parâmetros necessários
        Jogador j1 = new Jogador(1, "Joel", "Lucas", Date.valueOf(dataNascimento),11, "AVANÇADO", 82.0, cartoes, false);
        Jogador j2 = new Jogador(2, "Pedro", "Miguel", Date.valueOf(dataNascimento),10, "MEIO-ATACANTE", 70.0, cartoes, false);
        Jogador j3 = new Jogador(3, "Milton", "Pedro", Date.valueOf(dataNascimento),9, "MEIO-ARMADOR", 70.0, cartoes, false);
        Jogador j4 = new Jogador(4, "Miguel", "Watch", Date.valueOf(dataNascimento),8, "ALA-DIREITA", 68.0, cartoes, false);
        Jogador j5 = new Jogador(5, "João", "António", Date.valueOf(dataNascimento),17, "ALA-ESQUERDA", 72.0, cartoes, false);
        Jogador j6 = new Jogador(6, "Kelivaldo", "Nelembe", Date.valueOf(dataNascimento),14, "VOLANTE", 72.5, cartoes, false);
        Jogador j7 = new Jogador(7, "Kenivaldo", "Nelembe", Date.valueOf(dataNascimento),2, "ZAGUEIRO-CENTRAL", 75.0, cartoes, false);
        Jogador j8 = new Jogador(8, "João", "Nelembe", Date.valueOf(dataNascimento),6, "ZAGUEIRO", 70.0, cartoes, false);
        Jogador j9 = new Jogador(9, "Adriano", "Nelembe", Date.valueOf(dataNascimento),5, "LATERAL-ESQUERDO", 78.0, cartoes, false);
        Jogador j10 = new Jogador(10, "Roberto", "Correia", Date.valueOf(dataNascimento),4, "LATERAL-DIREITO", 78.0, cartoes, false);
        Jogador j11 = new Jogador(11, "Cristiano", "Salomão", Date.valueOf(dataNascimento),1, "GOLEIRO", 80.0, cartoes, false);
        Jogador j12 = new Jogador(12, "A", "1", Date.valueOf(dataNascimento),12, "AVANÇADO", 83.0, cartoes, false);
        Jogador j13 = new Jogador(13, "B", "1", Date.valueOf(dataNascimento),13, "MEIO-ATACANTE", 74.0, cartoes, false);
        Jogador j14 = new Jogador(14, "C", "1", Date.valueOf(dataNascimento),15, "MEIO-ARMADOR", 68.0, cartoes, false);
        Jogador j15 = new Jogador(15, "D", "1", Date.valueOf(dataNascimento),16, "ALA-DIREITA", 69.0, cartoes, false);
        Jogador j16 = new Jogador(16, "E", "1", Date.valueOf(dataNascimento),20, "ALA-ESQUERDA", 73.0, cartoes, false);
        Jogador j17 = new Jogador(17, "F", "1", Date.valueOf(dataNascimento),23, "VOLANTE", 69.5, cartoes, false);
        Jogador j18 = new Jogador(18, "G", "1", Date.valueOf(dataNascimento),70, "ZAGUEIRO-CENTRAL", 72.0, cartoes, false);
        Jogador j19 = new Jogador(19, "H", "1", Date.valueOf(dataNascimento),72, "ZAGUEIRO", 72.0, cartoes, false);
        Jogador j20 = new Jogador(20, "I", "1", Date.valueOf(dataNascimento),74, "LATERAL-ESQUERDO", 74.0, cartoes, false);
        Jogador j21 = new Jogador(21, "J", "1", Date.valueOf(dataNascimento),76, "LATERAL-DIREITO", 73.0, cartoes, false);
        Jogador j22 = new Jogador(22, "K", "1", Date.valueOf(dataNascimento),78, "GOLEIRO", 82.0, cartoes, false);
        Jogador j23 = new Jogador(23, "L", "1", Date.valueOf(dataNascimento),79, "LATERAL-DIREITO", 81.0, cartoes, false);
        jogadores.add(j1);
        jogadores.add(j2);
        jogadores.add(j3);
        jogadores.add(j4);
        jogadores.add(j5);
        jogadores.add(j6);
        jogadores.add(j7);
        jogadores.add(j8);
        jogadores.add(j9);
        jogadores.add(j10);
        jogadores.add(j11);
        jogadores.add(j12);
        jogadores.add(j13);
        jogadores.add(j14);
        jogadores.add(j15);
        jogadores.add(j16);
        jogadores.add(j17);
        jogadores.add(j18);
        jogadores.add(j19);
        jogadores.add(j20);
        jogadores.add(j21);
        jogadores.add(j22);
        jogadores.add(j23);

        // Agora que temos um jogador válido, podemos criar uma equipe com ele
        List<Jogador> relacionados = new ArrayList<>();

        Equipa equipe = new Equipa("Barcelona", "Barça", "1999", jogadores, relacionados);
        System.out.println("Jogadores:");
        for (Jogador j : equipe.getJogadores()){
            System.out.println(j.getNome()+" "+j.getPosicao()+" "+j.getQualidade());
        }
        List<Jogador> naoRelacionados = equipe.relacionarJogadores();
        System.out.println("---------------------------");
        System.out.println("Relacionados:");
        for (Jogador r : equipe.getRelacionados()){
            System.out.println(r.getNome()+" "+r.getPosicao()+" "+r.getQualidade());
        }
        System.out.println("---------------------------");
        System.out.println("Jogadores não relacionados:");
        for (Jogador j : naoRelacionados){
            System.out.println(j.getNome()+" "+j.getPosicao()+" "+j.getQualidade());
        }
    }
}
