package com.poupitanques.Servidores;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {

    public static void main(String[] args) {
        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];

        try {
            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
            System.out.println("Inicio del servidor");

            while (true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticion);
                System.out.println("Recibo la informacion del cliente");

                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);

                int puertoClinte = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "¡Hola soy el servidor!";
                buffer = mensaje.getBytes();

                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoClinte);

                System.out.println("Envio informacion al cliente");
                socketUDP.send(respuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}