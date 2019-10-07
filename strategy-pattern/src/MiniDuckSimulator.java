// 테스트 클래스
public class MiniDuckSimulator {
    public static void main (String[] args) {
        Duck mallard = new MallardDuck();

//      위임할 객체를 선택하는 setter
//        -> 실행 시점에 행동에 대한 제어가 쉬워진다.

        mallard.performQuack(); // 꽥꽥
        // 이렇게 하면, MallardDuck에서 상속받은 performQuack()메소드가 호출된다.
        // 이 메소드에서는 객체의 QuackBehavior에게 할 일을 위임한다.
        // QuackBehavior 레퍼런스의 quack() 메소드가 호출된다.

        // performFly() 메소드도 위의 performQuack() 메소드처럼 호출된다.
        mallard.performFly(); // 날고 있어요!!



        Duck model = new ModelDuck();
        // performFly를 처음 호출하면, ModelDuck 생성자에서 설정되었던 flyBehavior,
        // 즉 FlyNoWay 인스턴스의 fly() 메소드가 호출된다.
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered()); // 이렇게 하면 행동 세터 메서드가 호출된다.
        // 이제 모형 오리에 로켓의 추진력으로 날 수 잇는 능력이 생겼다.
        // 제대로 돌아간다면 모형 오리는 동적으로 나는 행동을 바꿀 수 있다.
        // 구현 코드가 Duck 클래스 안에 들어잇었다면, 그렇게 할 수 없다.
        model.performFly();

    }
}


/*
문제점
1. 서브 클래스에 코드가 중복된다.
2. 모든 오리의 행동을 알기 힘들다.(앞으로 어떤 오리가 추가될지 알 수 없다.)
3. 코드를 변경했을 때(또는 새로운 행동을 추가했을 때) 다른 오리들에게 원치 않는 영향을 끼칠 수 있다.
4. 실행시점(오리를 만들어내는 시점)에 특징을 바꾸기 힘들다.
 */


/*
솔루션1. Flayble 과 Quackable 인터페이스를 만들고 모든 오리는 이걸 구현하게 한다.
문제점
:울지 못하고 날지 못하는 1개의 오리 때문에 나머지 오리들이 전부 2개의 인터페이스를 가져다가 구현한다.


솔루션2.
이렇게 만들면 부모의 메소드로 자식의 메소드를 호출하는 메서드 다형성이 발생되는 형태가 된다.
위임할 객체를 선택하는 setter를 만들어두면, 실행 시점에 행동에 대한 제어가 쉬워진다.
Duck 클래스를 손대지 않고 단순히 performQuack과 performQuack 메소드를 호출하는 것만으로
행동되어야 할 객체를 선택할 수 있게 된다.

 */

/*
A는 B이다보다는 'A에는 B가 있다.'가 나을 수 있다.
각각의 오리들에게는 FlyBehavior와 QuackBehavior가 있으며, 각각 행동과 호리를 위임 받는다.

이런식으로 두 클래스를 합치는 것을 구성(composition)을 이용하는 것이라고 한다.
여기의 오리 클래스는 행동을 상속받는 대신, 올바른 행동 객체로 구성됨으로써 행동을 부여받게 된다.
 */