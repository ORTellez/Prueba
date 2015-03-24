import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {

		int puerto = 5000;

		ServerSocket myServerSocket;
		try {
			myServerSocket = new ServerSocket(puerto);

			System.out.println("Escucho el puerto " + puerto);

			while (true) {

				Socket mySocket = myServerSocket.accept(); // Crea objeto
				System.out.println("Conexion! ");

				InputStream myInputStream = mySocket.getInputStream();
				DataInputStream myDataInputStream = new DataInputStream(
						myInputStream);
				String s = myDataInputStream.readUTF();
				System.out.println(s);

				mySocket.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
