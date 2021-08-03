import java.io.*;
import java.util.ArrayList;

public class StockTrader {
    static boolean change= false;
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.readStock();
        new Thread(server).start();

        BufferedReader console_in = new BufferedReader(new InputStreamReader(System.in));
        Thread write = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        synchronized (this){
                            System.out.print("==> ");
                            String s = console_in.readLine();
                            String[] str = s.split(" ");
                            if (str.length != 3) {

                            } else {
                                int idx = -1;
                                for (Stock stock : Server.Stocks) {
                                    if (stock.getName().equalsIgnoreCase(str[1])) {
                                        idx = Server.Stocks.indexOf(stock);
                                        if (str[0].equalsIgnoreCase("I")) {
                                            change = true;
                                            Server.Stocks.get(idx).setPrice(Server.Stocks.get(idx).getPrice() + Double.parseDouble(str[2]));
                                        } else if (str[0].equalsIgnoreCase("D")) {
                                            change = true;
                                            Server.Stocks.get(idx).setPrice(Server.Stocks.get(idx).getPrice() - Double.parseDouble(str[2]));
                                        } else if (str[0].equalsIgnoreCase("C")) {
                                            change = true;
                                            Server.Stocks.get(idx).setCount(Integer.parseInt(str[2]));
                                        }
                                        break;
                                    }
                                }
                                if (change) {
                                    change = false;
                                    ArrayList<String> subscribers = Server.Stocks.get(idx).getSubscribers();
                                    System.out.println(subscribers.size());
                                    for (String subs : subscribers) {
                                        for (ClientHandler client : Server.clients) {
                                            if (client.getName().equalsIgnoreCase(subs)) {
                                                client.getWriter().println("State of stock : " + str[1] + " is changed.");
                                                break;
                                            }
                                        }
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
        write.start();
    }

}