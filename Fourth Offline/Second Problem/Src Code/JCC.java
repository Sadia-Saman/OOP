import java.util.*;

public class JCC implements Mediator{
    private ArrayList<Request> requests;
    private JPDC jpdc;
    private JWSA jwsa;
    private JRTA jrta;
    private JTRC jtrc;
    private String seeker;
    JCC(){
        requests = new ArrayList<>() ;
        jpdc = new JPDC(this);
        jwsa = new JWSA(this);
        jrta = new JRTA(this);
        jtrc = new JTRC(this);
        seeker ="";
    }

    public void passRequest(String service,String seeker){
        Organization org;
        if(service.equalsIgnoreCase("WATER"))  org = jwsa;
        else if(service.equalsIgnoreCase("ENERGY") || service.equalsIgnoreCase("POWER"))  org= jpdc;
        else if(service.equalsIgnoreCase("TRANSPORT"))  org= jrta;
        else if(service.equalsIgnoreCase("TELECOM"))  org= jtrc;
        else return;
        org.requestService();
        requests.add(new Request(service,seeker,org));
        System.out.println(seeker + " requests for "+service+ " service");
    }

    @Override
    public void Notify(String provider) {
        for (Request request : requests) {
            if (request.getProvider().getName().equals(provider)) {
                seeker = request.getSeeker();
                System.out.println(provider+" serves the request of "+ seeker);
                requests.remove(request);
                return;
            }
        }
        System.out.println(provider+" has no request to serve ");
    }
    public Organization getOrg(String name){
        Organization org;
        if(name.equalsIgnoreCase("JWSA"))  org = jwsa;
        else if(name.equalsIgnoreCase("JPDC"))  org= jpdc;
        else if(name.equalsIgnoreCase("JRTA"))  org= jrta;
        else if(name.equalsIgnoreCase("JTRC"))  org= jtrc;
        else return null;
        return org;
    }

}
