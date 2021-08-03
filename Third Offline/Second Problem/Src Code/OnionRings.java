public class OnionRings extends PizzaDecorator{
    OnionRings(Pizza decoratedpizza) {
        super(decoratedpizza);
    }

    public int price(){
        return super.price()+ 100;
    }
}
