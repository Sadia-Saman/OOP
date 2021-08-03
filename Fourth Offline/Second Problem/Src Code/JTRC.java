public class JTRC extends Organization{
    JTRC(Mediator mediator) {
        super("JTRC", mediator);
    }

    @Override
    public void provideService() {
        if(numberOfReq==0) {
            mediator.Notify(name);
            return;
        }
        numberOfReq--;
        System.out.println("TeleCommunication Supplied");
        mediator.Notify(name);
    }
}
