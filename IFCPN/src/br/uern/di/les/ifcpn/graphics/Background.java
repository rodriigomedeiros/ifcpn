/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uern.di.les.ifcpn.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rodrigo
 */
public class Background extends javax.swing.JPanel{  
        BufferedImage b;  
        Rectangle2D rect;  
          
        public Background(){   
            try {  
                 //se você pegar uma imagem dentro do mesmo jar/projeto  
                b = ImageIO.read(getClass().getResourceAsStream("/br/uern/di/les/ifcpn/res/mapa.png"));
                
                //ou, se você pegar uma imagem direto do sistema, use este                 
                // b = ImageIO.read(new File("<caminho da imagem>"));  
                  
                //cria uma imagem do tamanho 130x130,   
                //que vai se repetir ao longo do fundo, o tamanho é você quem escolhe.  
                rect  = new Rectangle(0,0,768,335);                                   
                  
            } catch (IOException ex) {  
                ex.printStackTrace(System.err);  
            }  
        }  
          
        @Override   
        public void paintComponent(Graphics g){    
            /* 
             * Se você quiser que a imagem seja uma só (extendida ao tamanho da tela, não replicada 
             * tire os comentários da proxima linha 
             */  
              
          // rect = new Rectangle(0,0,this.getWidth(),this.getHeight());  
              
              
            TexturePaint p = new TexturePaint(b,rect);  
            Graphics2D g2 = (Graphics2D) g;  
            g2.setPaint(p);  
            g2.fillRect(0,0,this.getWidth(),this.getHeight());  
   
        }  
    }  