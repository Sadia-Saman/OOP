import java.io.*;
import java.net.*;

public class Client   {
    public static void main(String[] args){
        try {

            Socket socket = new Socket("localhost", 5555);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer  = new PrintWriter(socket.getOutputStream(),true);
            String Name = reader.readLine();
            System.out.println(Name);
            Thread read = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (this){
                                System.out.println("server : " + reader.readLine());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread write = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (this) {
                                System.out.print("==> ");
                                String str = console.readLine();
                                writer.println(Name + " " + str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
            read.start();
            write.start();
            read.join();
            write.join();

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}