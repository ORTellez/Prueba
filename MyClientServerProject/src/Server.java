import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private int puerto = 5000;
	private ServerSocket myServerSocket;
	
	public Server(int puerto) {
		super();
		this.puerto = puerto;
	}
	
	public void start() {
		try {
			myServerSocket = new ServerSocket(puerto);

			System.out.println("Escucho el puerto " + puerto);

			while (true) {

				Socket mySocket = myServerSocket.accept(); // Crea objeto
				System.out.println("Conexion! ");

				InputStream myInputStream = mySocket.getInputStream();
				//DataInputStream myDataInputStream = new DataInputStream(myInputStream);
				//String s = myDataInputStream.readUTF();
				ObjectInputStream myObjectInputStream = null;
				Object myInputObject = null;
				Object myOutputObject = null;
				
				//Leer
				try {
					myObjectInputStream = new ObjectInputStream(myInputStream);
					myInputObject = myObjectInputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(myInputObject);
				
				//Escribir
				try {
					myOutputObject = new MyTest("El mundo apesta!");
					OutputStream myOutputStream = mySocket.getOutputStream();
					ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myOutputStream);
					myObjectOutputStream.writeObject(myOutputObject);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				mySocket.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
