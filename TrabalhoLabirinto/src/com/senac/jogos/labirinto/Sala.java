package com.senac.jogos.labirinto;

import java.util.ArrayList;

public class Sala {
        private int sala = 0;
        Conexao[] conexoes = new Conexao[6];

        public void setSala(int iD) {
                this.sala = iD;
        }
        public int getSala() {
                return this.sala;
        }
        
        private static int getDirecaoIndex(String direcao) throws Exception {
                Direcao dir = Direcao.converte(direcao);
                return dir.getIndex();
        }
        
        public void setArmadilha(String direcao) throws Exception {
                conexoes[getDirecaoIndex(direcao)].setArmadilha();
        }
        public void addConexao(String direcao, int sala) throws Exception {
                int ndx = getDirecaoIndex(direcao);
                if (conexoes[ndx] != null)
                        throw new Exception("Conexao já existente.");

                conexoes[ndx] = new Conexao(sala);
        }
        public Conexao getConexao(Direcao direcao) {
    		return conexoes[direcao.getIndex()];
    	}
       
        public String toString() {
                try {
                	System.out.println("______________________________________________________");
                			String res = "Movimentos possíveis nas direcoes:\n";
                        for (int i = 0; i < 6; i++)
                                if (conexoes[i] != null)
                                        res += "\t" + Direcao.converte(i) + " " + conexoes[i] + "\n";
                        res += "Sala Atual: " + sala;
                        return res;
                } catch (Exception e) {
                        return "SALA COM ESTADO INVALIDO!";
                }
               
        }
        
}
