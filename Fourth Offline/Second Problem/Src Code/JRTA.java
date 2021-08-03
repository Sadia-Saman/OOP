public class JRTA extends Organization{
    JRTA(Mediator mediator) {
        super("JTRA", mediator);
    }

    @Override
    public void provideService() {
        if(numberOfReq==0) {
            mediator.Notify(name);
            return;
        }
        numberOfReq--;
        System.out.println("Transport Supplied");
        mediator.Notify(name);
    }
}
