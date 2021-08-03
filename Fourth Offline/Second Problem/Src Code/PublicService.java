import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PublicService {
    public static void main(String []args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Mediator mediator = new JCC();
        Organization org = null;

        try {
            while (true){
                System.out.print("(Enter q to quit ): ");
                String input = reader.readLine();
                String []words = input.split(" ");
                if(words.length==1){
                    if(input.equalsIgnoreCase("Init"))
                        System.out.println("All four services are initiated through mediator");
                    else if(input.equalsIgnoreCase("q")) break;
                }else {
                    if(words.length!=2) System.out.println("Enter two word command.");
                    else {
                        if (words[1].equalsIgnoreCase("SERVE")){
                            org = mediator.getOrg(words[0]);
                            if(org!=null)
                             org.provideService();
                        }else {
                            mediator.passRequest(words[1],words[0]);
                        }
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Error occurred.");
        }
    }
}
