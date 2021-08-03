import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{
    static ArrayList<ClientHandler> clients = new ArrayList<>();
    static ArrayList<Stock> Stocks = new ArrayList<>();
    static int i=1;
    ServerSocket listener ;
    Server() throws IOException {
        listener = new ServerSocket(5555);
    }

    public void readStock() throws IOException {
        File file = new File("/home/sadia/Desktop/CSE308/Fourth/First/Stock_Trader/src/input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line!=null){ //stores the stocks reading from a file
            String []words = line.split(" ");
            line = reader.readLine();
            if(words.length!=3) continue;
            Stocks.add(new Stock(words[0],Integer.parseInt(words[1]),Double.parseDouble(words[2]))) ;
        }
        reader.close();
    }

    @Override
    public void run() {
        try {
            if(Stocks.size()==0){
                System.out.println("NO stock Available . ");
                return;
            }else if(listener==null){
                System.out.println("Server not available.");
                return;
            }

            System.out.println("Server is Available.");
            while (true){
                Socket socket = listener.accept();
                System.out.println("New Client joined.");
                ClientHandler client = new ClientHandler("user"+i,socket);
                clients.add(client);
                new Thread(client).start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert listener != null;
                listener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
