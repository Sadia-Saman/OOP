public class Coffee extends PizzaDecorator{
    Coffee(Pizza decoratedpizza) {
        super(decoratedpizza);
    }

    public int price(){
        return super.price()+ 120;
    }
}
