public abstract class Organization {
    protected String name;
    protected Mediator mediator;
    protected int numberOfReq;
    Organization(String n ,Mediator med){
        name = n;
        mediator = med;
        numberOfReq = 0;
    }

    public String getName() {
        return name;
    }
    public void requestService(){
        numberOfReq++;
    }

    public abstract void provideService() ;

}
