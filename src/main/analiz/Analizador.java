package analiz;


import java.util.ArrayList;

public class Analizador {

    public int[] acha_sequencia(double[] probs, int[] valores) {
        int tamanho = valores.length;

        ArrayList<Integer> ordem = new ArrayList<>();
        ArrayList<Integer> usados = new ArrayList<>();

        while (ordem.size() < tamanho) {
            int indiceSelecionado = seleciona(probs, valores, usados);
            ordem.add(indiceSelecionado);
            usados.add(indiceSelecionado);
        }

        return ordem.stream().mapToInt(Integer::intValue).toArray();
    }

    public int seleciona(double[] probs, int[] valores, ArrayList<Integer> usados) {
        int melhorResult = -1;
        double melhorValor = 0.0;

        for (int i = 0; i < probs.length; i++) {
            if (!usados.contains(i)) {
                double valor = valores[i] * probs[i] * probs[i];
                if (valor > melhorValor) {
                    melhorResult = i;
                    melhorValor = valor;
                }
            }
        }

        return melhorResult;
    }
}