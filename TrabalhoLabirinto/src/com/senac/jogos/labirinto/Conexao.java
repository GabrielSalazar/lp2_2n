package com.senac.jogos.labirinto;

public class Conexao {
        private int sala;
        private Inimigo inimigo;
        private Cor cor;

    public Conexao(int sala) {
        this.sala = sala;
        //Cria as cores de portas aleatoriamente.
        if (Range.getPercentual() > 40) {
                this.cor = Cor.MARROM;
        } else if (Range.getPercentual() < 10) {
                Range corSala = new Range(0, 3);
                int idCor = corSala.getRandom();
                switch (idCor) {
                case 0:
                        setCor(Cor.VERMELHO);
                        break;
                case 1:
                        setCor(Cor.AZUL);
                        break;
                case 2:
                        setCor(Cor.VERDE);
                        break;
                case 3:
                        setCor(Cor.AMARELO);
                        break;
                default:
                        System.out.println("Cor inválida");
                        break;
                }
        } else {
                setCor(Cor.MARROM); //Se 10% das vezes tem que ser de cor aleatoria, e 60% tem que ser marrom, aqui ficam os 30% que falta.
        }
    }

    public int getSala() {
            return sala;
    }

    public void setSala(int sala) {
            this.sala = sala;
    }

    public Inimigo getInimigo() {
            return inimigo;
    }

    public void setInimigo(Inimigo inimigo) {
            this.inimigo = inimigo;
    }

    public void setArmadilha() {
            this.inimigo = new Armadilha();
    }

    public void setCor(Cor cor) {
            if (cor != null)
                    this.cor = cor;
    }
    
    public Cor getCor(){
		return cor;
	}

    public boolean canAtravessar(Jogador jogador) {
        if (cor != Cor.MARROM) {
                Chave c = jogador.getChave();
                if (c != null)
                        return c.getCor() == cor;
                else
                        return false;
        }

        if (inimigo != null) {
                if (!(inimigo instanceof Armadilha))
                        return !inimigo.isAlive();
        }

        return true;
    }

    public String toString() {
            String res = "Porta " + cor;
            if (inimigo != null && !(inimigo instanceof Armadilha))
                    res += " guardada por um " + inimigo; // possivel bug
            return res;
    }
}

