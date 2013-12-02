package com.senac.jogos.labirinto;

import static java.lang.System.*;

import java.io.FileInputStream;
import java.util.Scanner;

public class Labirinto {

  private static final Scanner teclado = new Scanner(System.in);

        private Sala[] salas;
        private int salaAtual;

        private void run() throws Exception {
                inicializaLabirinto();
                while (!isGameOver()){
                        exibeStatus();
                        executaComando(teclado.nextLine()); 
                }
        }

  private void inicializaLabirinto() {
        salas = new Sala[50];
        salas[0] = new Sala();
        salaAtual = 1; 
        try {
                leLabirinto(new Scanner(new FileInputStream("labirinto.txt")));
        } catch (Exception e) {
                err.println(e.getMessage());
                exit(1);
        }
    }
     
   private void leLabirinto(Scanner arquivo) throws Exception {
        String cmd = arquivo.next().toLowerCase();
        while (cmd.equals("room")) {
                int idSala = arquivo.nextInt();
                salas[idSala] = new Sala();
                Sala sala = salas[idSala];
                sala.setSala(idSala);
                String direcao = arquivo.next();

                do {
                        if (arquivo.hasNextInt()) {
                                idSala = arquivo.nextInt();
                        } else if (arquivo.next().equalsIgnoreCase("EXIT")) {
                                idSala = 0;
                        } else
                                break;

                        sala.addConexao(direcao, idSala);

                        if (!arquivo.hasNext())
                                return;
                        cmd = arquivo.next().toLowerCase();
                        if (cmd.equals("trap")) {
                                sala.setArmadilha(direcao);
                                if (!arquivo.hasNext())
                                        return;
                                cmd = arquivo.next();
                        }
                        direcao = cmd;
                } while (!cmd.equals("room"));
        }
            throw new Exception("Arquivo de descricao do labirinto invalido.");
    }
/*
 (Split)
 Passa para ele um texto e um separador, 
 e ele retorna  um array, com o texto desse separador dividido em cada posição.   
 */
   
    public void executaComando(String comando) throws Exception {
        comando = comando.toLowerCase();
        comando.trim();
        String[] quebra = comando.split("\\s+");
        if ((quebra[0].equals("mover"))) {
            new Comando(quebra[1], getSalaAtual());
            salaAtual = Comando.returnSalaDestino();

            } else {
                    System.out.println("Comando inválido");
            }
        }
  
    public boolean isGameOver() {
        if (salaAtual == 0) {
                System.out.println("\n Parabéns! Você saiu do labirinto!");
                return true;
        }
        return false;
    }
        
    private void exibeStatus() {
    	System.out.println(salas[salaAtual]);
    }

    public Sala getSalaAtual() {
            return salas[salaAtual];
    }

    public static void main(String[] args) throws Exception {
    	(new Labirinto()).run();
        }
}
