public abstract class PizzaDecorator implements Pizza{
    protected Pizza decoratedpizza;

    PizzaDecorator(Pizza decoratedpizza){
        this.decoratedpizza = decoratedpizza;
    }
    @Override
    public int price() {
        return decoratedpizza.price();
    }

}
