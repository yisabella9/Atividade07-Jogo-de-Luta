import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Lutador[] lutadores = new Lutador[2];

        System.out.println("Digite o nome do seu lutador:");
        String nomeJogador = sc.nextLine();

        System.out.println("Escolha o tipo do seu lutador! (1 - Leve | 2 - Médio | 3 - Pesado):");
        int tipo = sc.nextInt();
        sc.nextLine();

        switch (tipo) {
            case 1 -> lutadores[0] = new LutadorLeve(nomeJogador);
            case 2 -> lutadores[0] = new LutadorMedio(nomeJogador);
            case 3 -> lutadores[0] = new LutadorPesado(nomeJogador);
            default -> {
                System.out.println("Tipo inválido! Será criado em Lutador Médio.");
                lutadores[0] = new LutadorMedio(nomeJogador);
            }
        }

        int tipoOponente = random.nextInt(3) + 1;

        switch (tipoOponente) {
            case 1 -> lutadores[1] = new LutadorLeve("Oponente Leve");
            case 2 -> lutadores[1] = new LutadorMedio("Oponente Médio");
            case 3 -> lutadores[1] = new LutadorPesado("Pesado");
        }

        System.out.println("\n======== STATUS INICIAL ========");
        lutadores[0].MostrarStatus();
        lutadores[1].MostrarStatus();

        while (lutadores[0].estaVivo() && lutadores[1].estaVivo()) {

            System.out.println("\n======== SEU TURNO ========");
            System.out.println("1 - Ataque normal");
            System.out.println("2 - Ataque especial");
            System.out.println("3 - Defender");
            System.out.println("4 - Curar (recupera 15 de vida)");
            int acao = sc.nextInt();

            switch (acao) {
                case 1 -> lutadores[0].atacar(lutadores[1]);
                case 2 -> lutadores[0].especial(lutadores[1]);
                case 3 -> lutadores[0].defender();
                case 4 -> lutadores[0].curar(15);
                default -> System.out.println("Ação inválida!");
            }

            if (!lutadores[1].estaVivo()) break;

            System.out.println("\n======== TURNO DO OPONENTE ========");

            int acaoNPC = random.nextInt(3);

            switch (acaoNPC) {
                case 0 -> lutadores[1].atacar(lutadores[0]);
                case 1 -> lutadores[1].especial(lutadores[0]);
                case 2 -> lutadores[1].defender();
            }

            System.out.println("\n===== STATUS ATUAL ====");
            lutadores[0].MostrarStatus();
            lutadores[1].MostrarStatus();
        }

        System.out.println("\n==== FIM DA LUTA ====");
        if (lutadores [0].estaVivo()) {
            System.out.println("🏆 " + lutadores[0].nome + " venceu! 🏆");
        } else {
            System.out.println("💀 Você foi derrotado! 💀");
        }

        sc.close();
    }
}