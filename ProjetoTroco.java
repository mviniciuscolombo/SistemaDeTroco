// Projeto de como calcular a quantidade de notas a dar de troco.
//Como dados usei um vetor com dados fixos apenas como demonstração mas a lógica é bem simples,
//Basicamente pego uma nota e diminuo do valor total até que nao de pelo menos uma divisão,então pulo pra proxima nota.

package projetotroco;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProjetoTroco {

    public static void main(String[] args) {

        ArrayList<Caixa> caixa = new ArrayList();
        DecimalFormat df = new DecimalFormat("#0.00");
        String leitura;
        BigDecimal valor;
        String saida = "";

        //Os objetos abaixo são apenas para exemplo. 
        //Em uma aplicação esses dados de caixa já virão do banco de dados.
        
        Caixa c1 = new Caixa(new BigDecimal("100.0"), 5);
        caixa.add(c1);
        Caixa c2 = new Caixa(new BigDecimal("50.0"), 5);
        caixa.add(c2);
        Caixa c3 = new Caixa(new BigDecimal("20.0"), 5);
        caixa.add(c3);
        Caixa c4 = new Caixa(new BigDecimal("10.0"), 5);
        caixa.add(c4);
        Caixa c5 = new Caixa(new BigDecimal("5.0"), 5);
        caixa.add(c5);
        Caixa c6 = new Caixa(new BigDecimal("2.0"), 5);
        caixa.add(c6);
        Caixa c7 = new Caixa(new BigDecimal("1.0"), 5);
        caixa.add(c7);
        Caixa c8 = new Caixa(new BigDecimal("0.50"), 5);
        caixa.add(c8);
        Caixa c9 = new Caixa(new BigDecimal("0.25"), 5);
        caixa.add(c9);
        Caixa c10 = new Caixa(new BigDecimal("0.10"), 5);
        caixa.add(c10);
        Caixa c11 = new Caixa(new BigDecimal("0.05"), 5);
        caixa.add(c11);
        Caixa c12 = new Caixa(new BigDecimal("0.01"), 5);
        caixa.add(c12);
       
        while (true) {
            ArrayList<Integer> qtde = new ArrayList();                          //array está aqui dentro do laço para ser zerado a cada troco.
            BigDecimal total = new BigDecimal("0.0");

            leitura = JOptionPane.showInputDialog("Informe o valor! [Exemplo 3.50]\n"
                    + "Leve em conta que inicialmente em caixa existem 5 notas/moedas de cada valor.");
            valor = new BigDecimal(leitura);

            for (Caixa tmp : caixa) {
                Integer nNotas = 0;

                while ((valor.divide(tmp.getValor()).compareTo(new BigDecimal("1.0"))) >= 0) {//verifica se a nota é maior que o valor, se for maior então é preciso uma menor.
                    if (tmp.getQtde() > 0) {                                    //verifica se no caixa possui essa nota.
                        tmp.setQtde(tmp.getQtde() - 1);                         //diminui 1 nota ou moeda do caixa.
                        valor = valor.subtract(tmp.getValor());                 //diminui do total informado o valor da nota usada.
                        nNotas++;                                               //soma 1 ao valor de notas usadas desse valorno troco.
                        total = total.add(tmp.getValor());                      //soma o valor da nota para no final comparar se o troco está correto.
                    } else {
                        break;
                    }
                }
                qtde.add(nNotas);                                               //adiciona a quantidade de notas necessárias no ArrayList.
            }

            for (int i = 0; i < qtde.size(); i++) {
                Caixa caixaTmp = caixa.get(i);                                  //instância temporária do objeto pra não precisar buscar no array toda vez.
                Integer qtdeTmp = qtde.get(i);
              
              if (qtdeTmp >= 1) {
                    saida += qtde.get(i) + "   R$ " + df.format(caixaTmp.getValor()) + "\n";
                }
            }

           
            if (saida == "" || total.compareTo(new BigDecimal(leitura)) < 0) {                   //compara se o calor em notas é o mesmo do fornecido pelo usuário
                String diferenca = df.format((new BigDecimal(leitura).subtract(total)));
                saida += "\nFaltam R$ " + diferenca + " de troco!";
            }
            JOptionPane.showMessageDialog(null, saida);
            saida = "";
        }
    }
}