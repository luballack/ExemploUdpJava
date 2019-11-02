package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;

public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            
            String msg = "Olá!!!";
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 20000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack1 = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack1);
            System.out.println("[OK] ]");
            
            
            
            byte[] buf = new byte[20];
            DatagramPacket pack2 = new DatagramPacket(buf, buf.length);
            socket.receive(pack2);
            byte[] received_data = pack2.getData();
            String received_msg = new String(received_data); 
            
            System.out.println("  Mensagem:             "+received_msg);
            
            
            

        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}