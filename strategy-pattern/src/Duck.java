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
    // (특정 구상 클래스 형식으로 선언하지 않는다.)
    // 각 오리 객체에서는 실행시에 이 변수에 특정 행동 형식(FlyWithWings, Squeak 등)에 대한 레퍼런스를 다형적으로 설정한다

    // 모든 Duck에는 QuackBehavior 인터페이스를 구현하는 것에 대한 레퍼런스가 있다.

    // 행동 인터페이스 형식의 레퍼런스 변수 2개를 선언한다.
    // (같은 패키지에 속하는) 모든 서브클래스에서 이 변수를 상속 받는다.

    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;
    public Duck () {

    }

    public abstract void display();

    /*    핵심은 performQuack(), performFly() 두 개의 메소드이다.
        setFlyBehavior와 setQuackBehavior의 인자인 Quackable과 Flyable는
        아규먼트 다형성 또는 프로모션이라고 불리는 다형성의 형질을 이용해 값을 넘기는 아규먼트이다.
    */
    // fly()와 quack() 대신 이 두 메소드 performQuack(), performFly()가 들어간다.
    public void performQuack() {
    // 꽥꽥거리는 행동을 직접 처리하는 대신,
    // 행동 클래스인 quackBehavior로 참조되는 객체에 그 행동을 위임한다.
        quackBehavior.quack();
    }

    public void performFly() {
        // 행동 클래스인 에 위임한다.
        flyBehavior.fly();
    }

    public void swim() {
        System.out.println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죠");
    }

//    public void setFlyBehavior (FlyBehavior flyBehavior) {
//        this.flyBehavior = flyBehavior;
//    }

//    public void setQuackBehavior (QuackBehavior quackBehavior) {
//        this.quackBehavior = quackBehavior;
//    }

}
