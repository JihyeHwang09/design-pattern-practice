public class PizzaTestDrive {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza nyStypePizza = nyStore.orderPizza("cheese");
        System.out.println(nyStypePizza.getName());
        System.out.println();

        Pizza chicagoStypePizza = chicagoStore.orderPizza("cheese");
        System.out.println(chicagoStypePizza.getName());
    }
}
