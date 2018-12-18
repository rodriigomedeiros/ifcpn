/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uern.di.les.ifcpn.conexao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketException;

/**
 *
 * @author Rodrigo
 */
public interface JavaCPNInterface
{
    // A method to actively establish a connection to an external process
    public void connect(String hostName, int port) throws IOException;

    // A method to passively establish a connection with an external process
    public void accept(int port) throws IOException;

    // A method to send data to an external process
    public void send(ByteArrayInputStream sendBytes) throws SocketException;

    // A method to receive data from an external process
    public ByteArrayOutputStream receive() throws SocketException;

    // A method to close a connection to an external process
    public void disconnect() throws IOException;
}