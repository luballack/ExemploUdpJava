package br.ufs.dcomp.ExemploUdpJava; 
import java.util.Scanner;

import java.net.*;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");

            byte[] buf = new byte[20];
            DatagramPacket pack3 = new DatagramPacket(buf, buf.length);

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(pack3);
            System.out.println("[OK] ]");
            
            
            byte[] received_data = pack3.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = pack3.getAddress();
            int origin_port = pack3.getPort();
            
            
                    
            //resposta a ser impressa
            String msg = "Tudo bem!!!";
            //Scanner sc = new Scanner(System.in);
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            DatagramPacket pack4 = new DatagramPacket(msg_buf, msg_size, origin_address, origin_port);
            socket.send(pack4);
            

            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
            
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}