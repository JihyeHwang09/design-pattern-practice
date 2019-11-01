// 피자 가게 운영을 위한 객체를 생성하는 클래스
public abstract class PizzaStore {
    // 추상 클래스나 인터페이스로는 직접 인스턴스를 생성 불가
    public Pizza orderPizza (String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    abstract Pizza createPizza(String type); // Pizza 인스턴스를 만드는 일은
    // 팩토리 역할을 하는 메소드에서 맡아서 처리
}
