package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String candidatos[] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    public static void entrandoEmContato(String candidato) {
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) tentativas++;
        } while (continuarTentando && tentativas < 3);

        if (atendeu) System.out.println("Conseguimos contato com " + candidato + " na " + tentativas + "º tentativa.");
        else System.out.println("Não conseguimos contato com " + candidato + " em 3 tentativas.");
    }

    public static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    public static void imprimirSelecionados() {
        String candidatos[] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de número " + (i+1) + " é " + candidatos[i] + ".");
        }
    }

    public static void selecaoCandidato() {
        String candidatos[] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        int candidatosSelecionados = 0;
        int canditatoAtual = 0;
        double salarioBase = 2000.00;
        while (candidatosSelecionados < 5 && canditatoAtual < candidatos.length) {
            String candidato = candidatos[canditatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou R$" + salarioPretendido + ".");
            if (salarioBase >= salarioPretendido) {
                candidatosSelecionados++;
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
            }
            canditatoAtual++;
        }
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido) System.out.println("Ligar para o candidato.");
        else if (salarioBase == salarioPretendido) System.out.println("Ligar para o candidato com contrapoposta.");
        else System.out.println("Aguardando demais candidatos.");
    }
}