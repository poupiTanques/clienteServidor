package com.poupitanques.Clientes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {

    public static void main(String[] args) {
        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];

        try {
            InetAddress direccionServidor = InetAddress.getByName("localhost");
            DatagramSocket socketUDP = new DatagramSocket();

            String mensaje = "¡Hola soy el cliente!";
            buffer = mensaje.getBytes();

            DatagramPacket envioAlServidor = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
            System.out.println("Envio data grama");
            socketUDP.send(envioAlServidor);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(peticion);
            System.out.println("Recibo peticion");
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            socketUDP.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}