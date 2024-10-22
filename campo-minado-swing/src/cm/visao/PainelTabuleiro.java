package cm.visao;

import cm.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro){

        setLayout(new GridLayout(
                tabuleiro.getLinhas(), tabuleiro.getColunas()));
            
        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservador(e ->{

            SwingUtilities.invokeLater(() -> {
                if(e.isGanhou()){
                    JOptionPane.showMessageDialog(this, "Parabens! Voce ganhou!");
                } else {
                    JOptionPane.showMessageDialog(this, "Que pena... Voce perdeu!");
                }

                tabuleiro.reiniciar();
            });
        });
    }

}
