public class MallardDuck extends Duck {
//    MallardDuck은 Duck 클래스에서 quackBehavior와 flyBehavior를 반드시 상속 받아야 한다!!
    public MallardDuck() {
//        MallardDuck에서는 꽥꽥거리는 소리를 처리할 때
//        Quack 클래스를 사용하기 때문에 performQuack()이 호출되면,
//        이 꽥꽥거리는 행동은 Quack 객체에게 위임된다.
        quackBehavior = new Quack();
//       flyBehavior의 형식으로는 FlyWithWings을 사용한다.
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("청둥오리 입니다.");
    }
}
/*
진행 순서
    꽥꽥 소리내는 행동
     MallardDuck의 인스턴스가 만들어질 때 생성자에서는 Duck으로부터 상속 받은
     quackBehavior 인스턴스 변수에 Quack(QuackBehavior를 구현한 구상 클래스) 형식의
     새로운 인스턴스를 대입한다.

    나는 행동
    MallardDuck 생성자에서는 flyBehavior 인스턴스 변수에
    FlyWithWings(FlyBehavior를 구현한 구상 클래스) 형식의 인스턴스를 만들어 대입한다.
 */
