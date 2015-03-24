import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;


public class SimpleClient {

	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 5000;
		
		try {
			Socket mySocket = new Socket(host, puerto);
			//Escribir
			OutputStream myOutputStream = mySocket.getOutputStream();
			DataOutputStream myDataOutputStream = new DataOutputStream(myOutputStream);
			myDataOutputStream.writeUTF("Hola mundo");

			mySocket.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


	}

}
