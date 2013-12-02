package com.senac.jogos.labirinto;

 public class Comando {
 private static int salaDestino;

 public Comando(String direcao, Sala salaAtual) throws Exception {
    salaDestino = salaAtual.conexoes[Direcao.direcaoConverteIndex(direcao)]
                           .getSala();
    }  
 public static int returnSalaDestino() {
        return salaDestino;
    }
}
