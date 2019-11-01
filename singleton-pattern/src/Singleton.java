public class Singleton {
    //private으로 Sinleton 클래스의 유일한 인스턴스를 저장하기 위한 정적 변수를 선언
    private  static Singleton uniqueInstance;

    // 기타 인스턴스 변수
    //생성자를 private로 선언했기 때문에 Singleton에서만 클래스를 만들 수 있다.
    private  Singleton () {}

    //클래스의 인스턴스를 만들어서 리턴해 준다.
    //synchronized 키워드만 추가하면 두 스레드가 이 메소드를 동시에 실행시키는 일은 일어나지 않게 된다.
    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return  uniqueInstance;
    }
}
/*
 uniqueInstance에 하나밖에 없는 인스턴스가 저장,
uniqueInstance가 null이기 때문에 아직 인스턴스가 만들어지지 않았다면
-> private으로 선언된 생성자를 이용해서 Singleton 객체를 만든 후
-> uniqueInstance 변수에 객체를 대입한다.
이렇게 할 경우, 인스턴스가 필요한 상황이 닥치기 전에는 아예 인스턴스를 생성하지 않게 되고
이런 방법을 게으른 인스턴스 생성(lazy instantiation)이라고 부른다.
*/

/*
synchronized를 추가하는 것보다 더 효율적인 방법은 없을까?
1. getInstance()의 속도가 그리 중요하지 않다면 그냥 내버려 둔다.
메소드를 동기화하면 성능이 100배 정도 저하된다는 것은 기억해 두자.
만약 getInstance()가 애플리케이션에서 병목으로 작용한다면 다른 방법을 생각해봐야 한다.

2. 인스턴스를 필요할 때 생성하지 말고, 처음부터 만들어 버린다.


3. DCL(Double-Checking Locking)을 써서 getInstance()에서 동기화되는 부분을 줄인다.
 */