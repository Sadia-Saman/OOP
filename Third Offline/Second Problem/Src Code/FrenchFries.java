public class FrenchFries extends PizzaDecorator{
    FrenchFries(Pizza decoratedpizza) {
        super(decoratedpizza);
    }

    public int price(){
        return super.price()+ 100;
    }
}
