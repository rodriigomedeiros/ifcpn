/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uern.di.les.ifcpn.conexao;

import java.io.IOException;

/**
 *
 * @author Rodrigo
 */
public class Servidor extends Thread {

        JavaCPN cpnJava, cpnJavaCampo;//= new JavaCPN();
        String deCPN;
        
        private String hostName;// = "127.0.0.1"; //150.165.61.89 IP com o qual deseja comunicar
        private int port, portRec;// = 9985; //Porta de comunicação com CPNTools
        
        public String msg;

        public Servidor(){
                cpnJava= new JavaCPN();
                cpnJavaCampo= new JavaCPN();
                hostName = "127.0.0.1"; //150.165.61.89 IP com o qual deseja comunicar
                port = 9000; //Porta de comunicação com CPNTools
                portRec = 9000;
        }
        public JavaCPN getJavaCPN(){
                return cpnJava;
        }
        
        /**
         *Abre comunicacao entre CPNTools e Xj3D de IP: hostName e porta: port
         */
        public void conectar(){
        
                try{
                        System.out.println("Abrindo comunicao Socket com IP: "+hostName+" pela porta: "+port);
                        cpnJava.connect(hostName, port);
                        
                        System.out.println("Conexao Aberta com sucesso");

                }
                catch (IOException e)
                {
                        System.err.println("Não pode fazer conexao");
                }
                try{
                        System.out.println("Server Socket com IP: Porta: "+portRec);
                        
                        cpnJavaCampo.accept(portRec);
                        System.out.println("Conexao Aberta com sucesso - Server");

                }
                catch (IOException e)
                {
                        System.err.println("Não pode fazer conexao");
                }
                
        }
        
        /**
         * Envia a mensagem de qual foi a chave acionada
         * @param chave String com o nome do painel e da chave
         */
        public void envia(String chave){
                
                System.out.println("Enviando mensagem");
                try{                                    
//                      Converte a mensagem e envia
                        cpnJava.send(EncodeDecode.encode(chave));
                        System.out.println("Mensagem enviada: "+ chave);
                }catch (IOException e) { 
                        System.out.println("Conexão interrompida...");
                }
        
        }
        /**
         * Retorna a mensagem recebi convertida em String
         * @return a String com mensagem recebida  
         */
        public String recebe(){
                try{
//                      Recebe a mensagem e converte para String
                        deCPN=EncodeDecode.decodeString(cpnJava.receive());
                        System.out.println("Mensagem recebida: "+deCPN);

                }catch (IOException e) { 

                        System.out.println("Conexão interrompida...");
                }

                System.out.println("Recebimento concluido");
                return deCPN;
        }
        public String recebeCampo(){
                try{
//                      Recebe a mensagem e converte para String
                        deCPN=EncodeDecode.decodeString(cpnJavaCampo.receive());
                        System.out.println("Mensagem recebida do Campo: "+deCPN);

                }catch (IOException e) { 

                        System.out.println("Conexão interrompida...");
                }

                System.out.println("Recebimento concluido");
                return deCPN;
        }
//      public String recebe()throws Exception {
//              Thread timeout = new Thread(new Runnable(){
//              public void run() {
//                      System.out.println("inicio da thread timeout");
//                      try {
//                              System.out.println("Recebendo:");
//                              deCPN=EncodeDecode.decodeString(cpnJava.receive());
//                              
//                      } catch (SocketException e) {
//                              // TODO Auto-generated catch block
//                              e.printStackTrace();
//                      }
//                      System.out.println("Mensagem recebida: "+deCPN);
//              }
//      });
//
//              timeout.start();
//              long endTimeMillis = System.currentTimeMillis() + 500000;
//              while (timeout.isAlive()) {
//                      if (System.currentTimeMillis() > endTimeMillis) {
//                              // set an error flag
//                              System.out.println("Estouro");
//                              
//                              throw new Exception("time out - reconfigurar sistema");
//                      }
//              } 
//
////            Recebe a mensagem de converte para String
//
//              System.out.println("Recebimento concluido");
//              return deCPN;
//      }
//      
//      public String ChecaTimeout(){
//              
//              NovaThread timeout = new NovaThread(cpnJava); 
}
