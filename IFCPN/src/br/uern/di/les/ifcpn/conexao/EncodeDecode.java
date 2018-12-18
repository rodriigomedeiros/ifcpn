/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uern.di.les.ifcpn.conexao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author Rodrigo
 */
public class EncodeDecode {
    /** Method to convert a string to a ByteArrayInputStream
 * @param toConvert The string to convert
 * @return A ByteArrayInputStream representing the string
 */
    public static ByteArrayInputStream encode(String toConvert)
    {
        return new ByteArrayInputStream(toConvert.getBytes());
    }
    
/** Method to convert a ByteArrayOutputStream to a string
 * @param toConvert A ByteArrayOutputStream to convert to string
 * @return String decoded from the ByteArrayOutputStream
 */
    public static String decodeString(ByteArrayOutputStream toConvert)
    {
        return toConvert.toString();
    }
}
