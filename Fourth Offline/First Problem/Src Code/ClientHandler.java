import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private String name;
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket socket;

    ClientHandler(String name,Socket csocket) throws IOException {
        this.name = name;
        socket =csocket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(),true );
        writer.println(name);
    }

    public String getName() {
        return name;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    @Override
   public void run() {
        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        synchronized (this){
                            String str = reader.readLine();
                            String[] words = str.split(" ");
                            str = str.replaceFirst(" ", " : ");
                            System.out.println(str);
                            if (words.length == 3) {
                                for (Stock stock : Server.Stocks) {
                                    if (stock.getName().equalsIgnoreCase(words[2])) {
                                        int idx = Server.Stocks.indexOf(stock);
                                        if (words[1].equalsIgnoreCase("U"))
                                            Server.Stocks.get(idx).getSubscribers().remove(words[0]);
                                        else if (words[1].equalsIgnoreCase("S"))
                                            Server.Stocks.get(idx).getSubscribers().add(words[0]);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        read.start();
    }
}
