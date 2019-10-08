# 데코레이터 패턴(decorator pattern)
> 객체에 추가적인 요건을 동적으로 첨가한다.
> 데코레이터는 서브클래스를 만드는 것을 통해서 기능을 유연하게 확장할 수 있는 방법을 제공한다. 

- `ConcreateComponent`에 새로운 행동을 동적으로 추가할 수 있다.
- 각 데코레이터 안에는 구성 요소(Component)에 대한 레퍼런스가 들어있는 인스턴스 변수가 있다.
- `Decorator`는 자신이 장식할 구성 요소(Component)와 같은 인터페이스 또는 추상 클래스를 구현한다.
- `ConcreteDecoratorA`, `ConcreteDecoratorB` 에는 그 객체가 장식하고 있는(데코레이터가 감싸고 있는 Component 객체)을
위한 인스턴스 변수가 있다. 
- -> 데코레이터는 Component의 상태를 확장할 수 있다.
-  `ConcreteDecoratorA`, `ConcreteDecoratorB`  데코레이터에서 새로운 메소드를 추가할 수도 있다. 
- But, 일반적으로 새로운 메소드를 추가하는 대신, 
Component에 원래 있던 메소드를 호출하기 전, 또는 후에 별도의 작업을 처리하는 방식으로 새로운 기능을 추가한다. 



```java
public class Beverage {
    // 변수 메소드

    public int cost () {
        int totCost = 0;
        if (hasMilk()) {
            totCost += milkCost;
        }
        if (hasSoy()) {
            totCost += soyCost;
        }
        if (hasMocah()) {
            totCost += mocahCost;
        }
        if (hasWhip()) {
            totCost += whipCost;
        }
        return totCost;
    }

    public class DarkRoast extends Beverage {
        @Override
        public int cost() {
            return 4500 + super.cost();
        }
    }
}
```

> 첨가물의 가격이 바뀔 때마다 기존 코드 수정이 필요하다.
첨가물의 종류가 많아지면 새로운 메소드를 추가해야 한다.
슈퍼클래스의 cost()메소드도 계속 고쳐줘야 한다.
새로운 음료가 나왔을 때, 특정 첨가물이 들어가면 안되는 경우도 있을 것이다.
But! 여전히 슈퍼클래스에서 모두 상속받는다.
ex) 더블 모카를 계산해야 할 경우
-> 당장은 해결된 것 같은데, 나중에 디자인이 어떻게 바뀌어야 할 지 생각해보면
이 접근법에도 문제가 있는 것 같다.


### 디자인 원칙
> `OCP(Open-Closed principle)`
> 클래스는 확장에 대해서는 열려 있어야 하지만, 코드 변경에 대해서는 닫혀 있어야 한다. 



### 참고 링크
-  [[정리정리정리] 디자인패턴 - 데코레이터 패턴 (decorator pattern)]: https://jusungpark.tistory.com/9?category=630296