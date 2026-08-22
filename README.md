## Chat Cliente-Servidor TCP (Java)

Aplicación de chat en tiempo real desarrollada en Java con **Sockets TCP**, **Threads** y **Java Swing (JFrame)**. Permite que un servidor central atienda a N cantidad de clientes simultaneamente, cada uno en su propia computadora, y que todos puedan chatear entre sí en tiempo real.

## Tecnologías usadas

- Java (NetBeans / Swing GUI Builder)
- `java.net.Socket` / `ServerSocket` para la comunicación TCP
- `Thread` para manejar múltiples clientes en paralelo
- [Tailscale](https://tailscale.com/) para conectar clientes desde distintas redes

## Estructura del proyecto

| Clase | Responsabilidad |
|---|---|
| `ServidorJFrame` | Ventana del servidor. Acepta conexiones entrantes, muestra clientes conectados y el log de mensajes. |
| `ManejoHilosClientes` | Un hilo por cada cliente conectado. Lee sus mensajes y los reenvía a todos los demás. |
| `ClienteJFrame` | Ventana del cliente. Pide el nombre del usuario, muestra el chat y permite enviar mensajes. |

## Cómo ejecutar

### 1. Servidor
Una sola persona del equipo ejecuta `ServidorJFrame`. Este queda escuchando en el puerto `5000`.

### 2. Clientes
Cada compañero ejecuta `ClienteJFrame` en su propia computadora. Al iniciar, se les pedirá:
1. Ingresar su nombre.
2. El programa se conectará automáticamente a la IP configurada en la constante `HOST`.

> **Nota:** para conectar clientes desde redes distintas (no el mismo Wi-Fi), el equipo usó [Tailscale](https://tailscale.com/) para crear una red virtual privada entre todas las computadoras. La IP en `HOST` corresponde a la IP de Tailscale de la PC que corre el servidor.

## Requisitos cumplidos

- [x] Vista de Cliente (nombre, chat, envío de mensajes)
- [x] Vista de Servidor (clientes conectados, log de mensajes)
- [x] Soporte para N cantidad de clientes simultáneos
- [x] Todos los clientes ven los mensajes de todos en tiempo real

## 👥 Autores

- Chris (chrissoto03)
- Kendall (kenmendoza2712-ops)
-Maricruz
