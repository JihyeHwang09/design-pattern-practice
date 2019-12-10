# 이터레이터 패턴(iterator pattern)
> 컬렉션 구현 방법을 노출시키지 않으면서도 그 집합체 안에 들어있는 
> 모든 항목에 접근할 수 있는 방법을 제공


이터레이터 패턴을 사용하면 모든 항목에 일일이 접근하는 작업을 컬렉션 객체가 아닌 반복자 객체에서 맡게 된다.
 
![iterator-pattern](https://user-images.githubusercontent.com/37353837/70488790-2707d080-1b3d-11ea-9446-da4ed755f22b.png)


## 클라이언트의 기능 5가지

- `printMenu()`: 메뉴에 있는 모든 항목을 출력
- `printBreakfastMenu()`: 아침 식사 항목만 출력
- `printLunchMenu()`: 점심 식사 항목만 출력
- `printVegetarianMenu()`:  채식주의자용 메뉴 항목만 출력
- `isItemVegetarian(name)`: name 항목



### 반복을 캡슐화 하자.
반복 작업을 **캡슐화**해서 `Iterator`라는 객체를 만든다.




## Composite 패턴
### Composite 패턴의 장점
**클라이언트를 단순화**시킬 수 있다.
클라이언트에서는 복합 객체인지, 리프 객체인지 신경쓰지 않아도 된다.
(올바른 객체에 대해서 올바른 메서드를 호출하고 있는지 확인하기 위해 여기저기에 if문을 사용하지 않아도 된다는 것을 의미한다. )
            
            
### Composite 패턴의 클래스 다이어그램
![composite-pattern](https://user-images.githubusercontent.com/37353837/70488796-28d19400-1b3d-11ea-8f7d-b1be63897803.png)


### 책 예제 클래스 다이어그램
![](https://user-images.githubusercontent.com/37353837/70488799-2a9b5780-1b3d-11ea-89f7-ef52a173191c.png)
      
> `MenuComponent`가 `MenuItem`(Leaf)와 `Menu`(Composite)에서 쓰이는 **인터페이스 역할**을 한다.

```java
public abstract class MenuComponent {

//    Composite's method 
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent) {}
    public MenuComponent getChild(int i) {}
    
//  Left, Composite's method    
    public String getName() {}
    public String getDescription() {}
    public double getPrice() {}
    public boolean isVegitarian() {}
    
    public void print() {}
}
```

```java
public class Menu extends MenuComponent {
    ArrayList menuComponents = new ArrayList();
    // 생성자 코드
    // 기타 메서드
    
    public void print() {
        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
}
```
```java
public class Client {
    Menucomponent allMenus;
    
    public Client(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }
    
    public void print() {
        allMenus.print();
    }
}
```

Composite 패턴은 단일 역할 원칙을 깬다. But, 투명성을 확보하는 패턴

## Compoiste에 대한 반복자(Iterator) 구현하기
인터페이스인 `MenuComponent`에 `createIterater()`를 추가한다. 

```java
// Menu
public Iterator createIterator() {
    return new CompositeIterator(menuComponents.iterator());
}
```
MenuItem은 NullIterator 객체를 리턴한다.
NullIterator는 Iterator를 구현한 클래스이다.
```java
public Iterator createIterator() {
    return new NullIterator();
}
```

CompositeIterator 클래스를 살펴보자. 

```java
import java.util.*;

public class CompoisteIterator implements Iterator {
    Stack stack = new Stack();
    
    public CompoisteIterator(Iterator iterator) {
        stack.push(iterator);
    }
    
    public Object next() {
        if (hasNext()) {
            //  stack.peek(): 읽기. stack의 top이 가리키는 데이터를 반환
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            } 
            return component;
        } else {
            return null;
        }
    }
        
    public boolean hasNext() {
        if (!stack.empty()) {
            Iterator iterator = (Iterator) stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();            
            } else {
                return true;
            }
        }
    }
    
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
```





---
### 참고 링크
[이터레이터 패턴 (iterator pattern)- 정리정리정리]: https://jusungpark.tistory.com/25
[Head First : Design Patterns - 제9장 Iterator 와 Composite 패턴]: https://secretroute.tistory.com/entry/Head-First-Design-Patterns-%EC%A0%9C9%EC%9E%A5-Iterator-%EC%99%80-Composite-%ED%8C%A8%ED%84%B4
