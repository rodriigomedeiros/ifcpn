/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uern.di.les.ifcpn;

import br.uern.di.les.ifcpn.conexao.EncodeDecode;
import br.uern.di.les.ifcpn.conexao.JavaCPN;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Rodrigo
 */
public class Servidor extends Thread{

    ImageIcon estacaoLivre = new ImageIcon(getClass().getResource("/br/uern/di/les/ifcpn/res/estacaoLivre.png"));
    ImageIcon estacaoBloqueada = new ImageIcon(getClass().getResource("/br/uern/di/les/ifcpn/res/estacaoBloqueada.png"));
    ImageIcon estacaoOcupada = new ImageIcon(getClass().getResource("/br/uern/di/les/ifcpn/res/estacaoOcupada.png"));
    
    int lastTrain = 0;
    
    @Override
    public void run() {
      
        int port = 9000;
	JavaCPN conn = new JavaCPN();
	String train = "", track = "", block = "";
        try {
            conn.accept(port);
            //conn.connect("127.0.0.1", port);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
	while (true) {
            try {
                train = EncodeDecode.decodeString(conn.receive());
                track = EncodeDecode.decodeString(conn.receive());
                block = EncodeDecode.decodeString(conn.receive());
                System.out.println("TREM: "+ train + ", ESTACAO: " + track + ", BLOQUEADA " + block);
                repaintScenario(track, block);
                conn.send(EncodeDecode.encode(track));
            } catch (SocketException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
    }
    
    private void repaintScenario(String track, String block){

            if(Integer.parseInt(block)-1 == 0){
                MainIFCPN.estacoes[6].setIcon(estacaoLivre);
            }else{
                MainIFCPN.estacoes[Integer.parseInt(block)-2].setIcon(estacaoLivre);

            }
            MainIFCPN.estacoes[Integer.parseInt(block)-1].setIcon(estacaoBloqueada);
            MainIFCPN.estacoes[Integer.parseInt(track)-1].setIcon(estacaoOcupada);
    }

}
