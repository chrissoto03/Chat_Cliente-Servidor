/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.net.*;
import java.io.*;

/**
 *
 * @author chris
 */
public class ManejoHilosClientes extends Thread{
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private String nombre;
    private ServidorJFrame servidor;

    public ManejoHilosClientes(Socket socket, ServidorJFrame servidor) {
        this.socket = socket;
        this.servidor = servidor;
    }
    
    
    public void enviarMensaje(String mensaje){
        salida.println(mensaje);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getIp() {
        return socket.getInetAddress().getHostAddress();
    }
    
    @Override
    public void run(){
        try {
            entrada = new  BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
            
            nombre = entrada.readLine();
            servidor.actualizarClientes();
            servidor.mostrarMensajes(nombre + " se ha conectado.");
            servidor.enviarListaUsuarios();
            
            String mensaje;
            while ((mensaje = entrada.readLine())!=null) {  
                servidor.mostrarMensajes(nombre+": "+ mensaje);
                servidor.enviarMenATodos(nombre+ ": "+mensaje);
            }
        } catch (Exception e) {
        }
        finally{
            servidor.eliminarCliente(this);
            servidor.actualizarClientes();
            if (nombre != null) {
                servidor.mostrarMensajes(nombre+" se a desconectado.");
                servidor.enviarMenATodos(nombre+ " se a desconectado");
                servidor.enviarListaUsuarios();
            }
        }try {
            socket.close();
        } catch (Exception e) {
        }
    }
    
    

}
