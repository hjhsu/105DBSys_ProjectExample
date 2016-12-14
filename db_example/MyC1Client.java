package db_example;
 
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class MyC1Client {
    private String address = "127.0.0.1";// 連線的ip
    private int port = 8765;// 連線的port
 
	private Socket client;
	private PrintWriter out;
	private BufferedReader in;
	private BufferedReader stdIn;
	
    public MyC1Client() {
        client = null;
		out = null;
        in = null;
		stdIn = null;
	}
	
	public void play() {
		try {
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			String userInput;
			System.out.print("input: ");
			while ((userInput = stdIn.readLine()) != null) {
				// 每次 Input 時建立連線
				client = new Socket(this.address, this.port);
				out = new PrintWriter(client.getOutputStream(), true);
				out.println(userInput);
				if(userInput.equals("QUIT.")) break;
				
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
				String buf = in.readLine();
				while(buf.length()!=0) {
					System.out.println("echo: " + buf);
					buf = in.readLine();
				}
				out.close();
				in.close();
				
				// 獲得結果後斷線
				client.close();
				System.out.print("input: ");
			}

			stdIn.close();
		} catch (Exception e) {
			e.printStackTrace();
        } 

    }
 
    public static void main(String args[]) {
        MyC1Client client = new MyC1Client();
		client.play();
	}
}