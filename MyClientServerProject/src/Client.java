import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	private String host = "localhost";
	private int puerto = 5000;
	
	public Client(String host, int puerto) {
		super();
		this.host = host;
		this.puerto = puerto;
	}
	
	public void send(String s){
		try {
			//abrir socket
			Socket mySocket = new Socket(host, puerto);
			//Escribir
			OutputStream myOutputStream = mySocket.getOutputStream();
			DataOutputStream myDataOutputStream = new DataOutputStream(myOutputStream);
			myDataOutputStream.writeUTF(s);
			//cerrar socket
			mySocket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void send(Object myOutputObject){
		Object myInputObject = null;
		
		//abrir socket
		Socket mySocket = null;
		try {
			mySocket = new Socket(host, puerto);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Escribir
		try {
			OutputStream myOutputStream = mySocket.getOutputStream();
			ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myOutputStream);
			myObjectOutputStream.writeObject(myOutputObject);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Leer
		try {
			InputStream myInputStream = mySocket.getInputStream();
			ObjectInputStream myObjectInputStream = new ObjectInputStream(myInputStream);
			myInputObject = myObjectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(myInputObject);
		
		//cerrar socket
		try {
			mySocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
