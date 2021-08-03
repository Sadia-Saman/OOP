public class Coke extends PizzaDecorator{
    Coke(Pizza decoratedpizza) {
        super(decoratedpizza);
    }

    public int price(){
        return super.price()+ 150;
    }
}
