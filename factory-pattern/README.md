# 팩토리 패턴 (factory pattern)
## 팩토리 패턴 (factory pattern)
> 객체를 생성하기 위한 인터페이스를 정의하는데,
> 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만든다.
> -> 팩토리 메서드 패턴을 이용하면,
> 클래스의 인스턴스를 만드는 일을 서브클래스에게 맡기는 것이다.


## 추상 팩토리 패턴
> 인터페이스를 이용하여 서로 연관된,
> 또는 의존하는 객체를 구상 클래스를 지정하지 않고도 생성한다.
> `new`를 사용하는 것은 구상 클래스의 인스턴스를 만드는 것이다.
> 당연하게 인터페이스가 아닌 특정 구현을 사용하게 되어버리는 것이다.
> 일련의 구상 클래스들이 있을 때는 어쩔 수 없이 다음과 같은 코드를 만들어야 하는 경우가 있다.

```java
Duck duck;
if (type == picnic) duck = new MallardDuck();
else if (type == hunting) duck = new DecoyDuck();
else if (type == inBathTub) duck = new RubberDUck(); 
```
이런 코드가 있다는 것은 뭔가 변경하거나 확장해야 할 대,
코드를 다시 확인하고 추가 또는 제거해야 한다는 것을 의미한다. 

인터페이스에 맞춰서 코딩을 하면, 시스템에서 일어날 수 있는 여러 변화를 이겨낼 수 있다.
(이유: 다형성 덕분에 어떤 클래스든 특정 인터페이스만 구현하면 사용할 수 있기 때문이다.)
반대로, 구상 클래스를 많이 사용하면 새로운 구상 클래스가 추가될 때마다 코드를 고쳐야 하기 때문에 
많은 문제가 생길 수 있다. 
-> 즉, 변화에 대해 닫혀 있는 코드가 되어 버린다. 

디자인 원칙으로 봤을 때, 구상 클래스를 바탕으로 코딩을 하면
나중에 코드를 수정해야 할 가능성이 높아지고,
유연성이 떨어진다는 걸 다시 한 번 확인했는데, 그렇다면 회피할 수 있는 방법이 있는가?
`바뀔 수 있는 부분을 찾아내서 바뀌지 않는 부분과 분리시켜야 한다`는 원칙


```java
Pizza orderPizza(String type) {
    Pizza pizza;
    
    if (type.equals("cheese")) pizza = new CheesePizza();
    else if (type.equals("greek")) pizza = new GreekPizza();
    else if (type.equals ("pepperoni")) pizza = new PepperoniPizza();
    
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
}
```
---
모든 팩토리 패턴에서는 **객체 생성을 캡슐화** 한다.
팩토리 메소드 패턴에서는 서브 클래스에서 어떤 클래스를 만들지를 결정하게 함으로써 객체 생성을 캡슐화 한다.

생산을 담당하는 `PizzaStore` 추상 클래스에서 객체를 만들기 위한 메소드
-> 즉, 팩토리 메소드를 위한 인터페이스를 제공한다는 것을 알 수 있다. 
`PizzaStore`에 구현되어 있는 다른 메소드 `orderPizza`에서는 팩토리 메소드에 의해 생산된 제품을 가지고
필요한 작업을 처리한다.
But, 실제 팩토리 메소드를 구현하고 제품(객체 인스턴스)을 만들어 내는 일은 서브 클래스에서만 할 수 있다. 

이로써, 구상 클래스에 대한 의존성을 줄이는 것이 좋다는 것은 확실해졌다.
이런 내용을 정리해 놓은 객체지향 디자인 원칙이 바로 의존성 뒤집기 원칙(Dependency Inversion Principle)
이다. 


### 디자인 원칙
> 추상화된 것에 의존하도록 만들어라.
> 구상 클래스에 의존하지 않도록 만든다. 


#### 왜 의존성 뒤집이 원칙이라고 하는가?
```
PizzaStore -> NYStyleCheesePizza
PizzaStore -> NYStyleVeggiePizza
PizzaStore -> ChicagoStypeCheesePizza
```

이런 식으로 의존이 되던 좋지않은 디자인이
```
PizzaStore -> Pizza
Pizza <- NYStyleCheesePizza
Pizza <- ChicagoStyleCheesePizza
Pizza <- NYStyleVeggiePizza
```
이런 식으로 의존 관계가 뒤집어지는 형상이다. 

팩토리 메소드 패턴을 적용하고 나면, 
고수준 구성요소(PizzaStore)와 저수준 구성요소(NYStyleCheesePizza, ChicagoStylePizza, ..) 들이 
모두 추상 클래스인 Pizza에 의존하게 된다. 
(고수준 모듈과 저수준 모듈이 둘다 하나의 추상 클래스에 의존)
팩토리 메소드 패턴이 의존성 뒤집기 원칙을 준수하기 위해 쓸 수 있는 유일한 기법은 아니지만,
가장 적합한 방법 가운데 하나이다.  


### 의존성 뒤집기 원칙에 위배되는 객체지향 디자인을 피하는데 도움이 되는 가이드
> 1. 어떤 변수에도 구상 클래스에 대한 레퍼런스를 지정하지 않는다.
>   - new 연산자를 사용하면, 레퍼런스를 사용하게 되는 것이다.
> 2. 구상 클래스에서 유도된 클래스를 만들지 않는다. 
>   - 구상 클래스에서 유도된 클래스를 만들면, 특정 구상 클래스에 의존하게 된다.
> 3. 베이스 클래스에 이미 구현되어 있던 메소드를 오버라이즈하지 않는다.       
>   - 이미 구현되어 있는 메소드를 오버라이드 한다는 것은 
>     애초부터 베이스클래스가 제대로 추상화된 것이 아니었다고 볼 수 있다. 
>     베이스 클래스에서 메소드를 정의할 때는 모든 서브 클래스에서 공유할 수 있는 것만 정의해야 한다. 
>
    
    
---
# 팩토리 패턴 (factory pattern)
- `new`를 사용하면 구상 클래스의 인스턴스를 만드는 것
### 팩토리 패턴 UML
- ![](https://user-images.githubusercontent.com/37353837/67833485-21739f80-fb28-11e9-9f20-91b007dc14bb.png)
- ![](https://user-images.githubusercontent.com/37353837/67833527-3f410480-fb28-11e9-93ad-9a05495d111f.png)

### 참고 사이트
- [디자인패턴 - 팩토리 패턴 (factory pattern)]: https://jusungpark.tistory.com/14?category=630296
- [4. 팩토리 패턴]: http://wiki.gurubee.net/pages/viewpage.action?pageId=1507401  











