public class JPDC  extends Organization{
    JPDC(Mediator mediator) {
        super("JPDC",mediator);
    }

    @Override
    public void provideService() {
        if(numberOfReq==0) {
            mediator.Notify(name);
            return;
        }
        numberOfReq--;
        System.out.println("Energy Supplied");
        mediator.Notify(name);
    }
}
