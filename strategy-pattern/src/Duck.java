/*
디자인 원칙

- 애플리케이션에서 달라지는 부분을 찾아내고, 달라지지 않는 부분으로부터 분리시킨다.
    -> 달라지는 부분을 찾아서 나머지 코드에 영향을 주지 않도록 "캡슐화"를 시켜준다.
- 상속보다는 구성을 활용한다.
- 구현이 아닌 인터페이스에 맞춰서 프로그래밍 한다.

 */
/* Duck 클래스에서는 행동을 직접 처리하는 대신,
새로 만든 performQuack(), performFly() 메소드에서
각각 FlyBehavior, QuackBehavior로 참조되는 객체에 그 행동을 위임해 줄 것이다.
*/
public abstract class Duck {

    // 2개의 인터페이스 형식의 인스턴스 변수 flyBehavior, quackBehavior를 추가한다.
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void swim() {
        System.out.println("물에 떠있습니다.");
    }
    public abstract void display();

    /*    핵심은 performQuack(), performFly() 두 개의 메소드이다.
        setFlyBehavior와 setQuackBehavior의 인자인 Quackable과 Flyable는
        아규먼트 다형성 또는 프로모션이라고 불리는 다형성의 형질을 이용해 값을 넘기는 아규먼트이다.
    */
    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setFlyBehavior (FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior (QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

}
