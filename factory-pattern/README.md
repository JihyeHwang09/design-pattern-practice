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


















