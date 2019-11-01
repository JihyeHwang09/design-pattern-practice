# 싱글턴 패턴 (factory pattern)
## 싱글턴 패턴 (factory pattern)
> 해당 클래스의 인스턴스가 하나만 만들어지고, 어디서든지 접근할 수 있도록 하기 위한 패턴
> 클래스에서 자신의 **단 하나뿐인 인스턴스**를 관리하도록 만든다.
> **다른 어떤 클래스에서도 자신의 인스턴스를 추가로 만들지 못하도록 해야한다.**

### 고전적인 싱글턴 패턴 구현법
> 어떤 문제가 있는가?
```java
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance() { 
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
```
uniqueInstance에 하나밖에 없는 인스턴스가 저장,
uniqueInstance가 null이기 때문에 아직 인스턴스가 만들어지지 않았다면
-> private으로 선언된 생성자를 이용해서 Singleton 객체를 만든 후
-> uniqueInstance 변수에 객체를 대입한다.
이렇게 할 경우, 인스턴스가 필요한 상황이 닥치기 전에는 아예 인스턴스를 생성하지 않게 되고
이런 방법을 `게으른 인스턴스 생성(lazy instantiation)`이라고 부른다. 



그냥 보기에는 문제가 없어 보이는데, **멀티스레드 상황에서 JVM**이 되어보자.
두 개의 스레드에서 위의 `Singleton.getInstance()` 메소드를 실행시킨다고 가정해보자.

TODO: 더 추가해야 함

---
싱글턴 패턴의 정의
- 싱글턴 패턴은 해당 클래스의 인스턴스가 하나만 만들어진다.
- 어디서든지 그 인스턴스에 접근할 수 있도록 한다.
- 클래스에서 자신의 단 하나뿐인 인스턴스를 관리하도록 만들면 된다.


### synchronized를 추가하는 것보다 더 효율적인 방법은 없을까?

1. getInstance()의 속도가 그리 중요하지 않다면 그냥 내버려 둔다.
메소드를 동기화하면 성능이 100배 정도 저하된다는 것은 기억해 두자.
만약 getInstance()가 애플리케이션에서 병목으로 작용한다면 다른 방법을 생각해봐야 한다.

2. 인스턴스를 필요할 때 생성하지 말고, 처음부터 만들어 버린다.
```java
public class Singleton {
  private static Singleton uniqueInstance = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return uniqueInstance;
  }
}
```

3. DCL(Double-Checking Locking)을 써서 getInstance()에서 동기화되는 부분을 줄인다.
```java
public class Singleton {
  private volatile static Singleton uniqueInstance;

  private Singleton() {}

  public static Singleton getInstance() {
    if (uniqueInstance == null) {
      //이렇게 하면 처음에만 동기화 된다
      synchronized (Singleton.class) {
        if (uniqueInstance == null) {
          uniqueInstance = new Singleton();
        }
      }
    }
    return uniqueInstance;
  }
}
```

### 정리
- 떤 클래스에 싱글턴 패턴을 적용하면 애플리케이션에 그 클래스의 인스턴스가 최대 한 개 까지만 있도록 할 수 있다.
= 싱글턴 패턴을 이용하면 유일한 인스턴스를 어디서든지 접근할 수 있도록 할 수 있다.
- 자바에서 싱글턴 패턴을 구현 할 때는 private 생성자와 정적 메소드, 정적 변수를 사용 한다.
- 다중 스레드를 사용하는 애플리케이션에서는 속도와 자원 문제를 파악해보고 적절한 구현법을 사용해야 한다.
- DCL을 사용하는 방법은 자바2 버전 5(자바 1.5)보다 전에 나온 버전에서는 쓸 수 없다는 점에 주의.
- 클래스 로더가 여러 개 있으면 싱글턴이 제대로 작동하지 않고, 여러 개의 인스턴스가 생길 수 있다.
---

#### 출처
- [ [정리정리정리]](https://jusungpark.tistory.com/16?category=630296)
- [구루비 스터디](http://wiki.gurubee.net/pages/viewpage.action?pageId=1507403#5.%EC%8B%B1%EA%B8%80%ED%84%B4%ED%8C%A8%ED%84%B4-%EA%B3%A0%EC%A0%84%EC%A0%81%EC%9D%B8%EC%8B%B1%EA%B8%80%ED%84%B4%ED%8C%A8%ED%84%B4%EA%B5%AC%ED%98%84%EB%B2%95)