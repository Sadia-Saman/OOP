public class JWSA extends Organization{
    JWSA(Mediator mediator) {
        super("JWSA", mediator);
    }

    @Override
    public void provideService() {
        if(numberOfReq==0) {
            mediator.Notify(name);
            return;
        }
        numberOfReq--;
        System.out.println("Water Supplied");
        mediator.Notify(name);
    }
}
