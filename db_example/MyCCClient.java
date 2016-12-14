package db_example;
 
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class MyCCClient {
    private String address = "127.0.0.1";// 連線的ip
    private int port = 8765;// 連線的port
 
    private Socket client;
	private PrintWriter out;
	private BufferedReader in;
	private BufferedReader stdIn;
	
	public MyCCClient() {
		try {
			client = new Socket(this.address, this.port);
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void end() {
		try {
			stdIn.close();
			out.close();
			in.close();
			client.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			String userInput;
			System.out.print("input: ");
			while ((userInput = stdIn.readLine()) != null) {
				out.println(userInput);
				if(userInput.equals("QUIT.")) break;
				
				String buf = in.readLine();
				while(buf.length()!=0) {
					System.out.println("echo: " + buf);
					buf = in.readLine();
				}
				System.out.print("input: ");
			}
		} catch (Exception e) {
			e.printStackTrace();
        } 

    }
 
    public static void main(String args[]) {
        MyCCClient client = new MyCCClient();
		client.play();
		client.end();
    }
}