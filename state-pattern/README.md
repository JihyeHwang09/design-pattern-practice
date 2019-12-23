# 스테이트 패턴(State pattern) 
---
title: 스테이트 패턴(State pattern)
date: 2019-12-22 20:46:58
categories:
  - Back-end
  - Design-pattern
tags:
  - design pattern
  - state pattern
---

> **Head First - Design Patterns**
> (에릭 프리먼, 엘리자베스 프리먼, 케이시 시에라, 버트 베이츠 저 | 서환수 역)
> 을 읽고 정리한 내용입니다.

---

- `스테이트 패턴`은 **스프링 AOP 구현**할 때 이용된 디자인 패턴이다.

## 스테이트 패턴의 정의

1. **객체의 내부 상태가 바뀜**에 따라서 객체의 행동을 바꿀 수 있다.

   - 상태를 별도의 클래스로 캡슐화한 다음,
     현재 상태를 나타내는 객체에게 행동을 위임하기 때문이다.
     <br>

2. **객체의 클래스가 바뀌는 것과 같은 결과**를 얻을 수 있다.
   - 클라이언트에서 사용하는 객체의 행동이 완전히 달라질 수 있기 때문이다.

---

### 스테이트 패턴의 클래스 다이어그램

![스테이트 패턴- 클래스 다이어그램](https://user-images.githubusercontent.com/37353837/71346547-7ae9cf00-25ab-11ea-95dc-5a43067667e0.png)

- `Context` 클래스: 여러 가지 내부 상태가 들어있을 수 있다.
  - ex) 책 예시에서의 BumballMachine이 Context에 해당된다.
    <br>
- `state.handle`: `Context`의 request() 메서드가 호출되면,
  그 작업이 **상태 객체**에게 맡겨진다.
  <br>
- `State` 인터페이스: 모든 구상 상태 클래스에 대한 **공통 인터페이스**를 정의
  <br>
- `ConcreateStateA`, `ConcreateStateB`
  - `Context`로부터 전달된 요청을 처리한다.
  - 요청을 처리하는 방법을 나름의 방식으로 구현한다.
  - `Context`에서 상태를 바꾸기만 하면, 행동도 바뀌게 된다.
  - 구상 상태 클래스는 얼마든지 많이 만들 수 있다.

---

### Kotlin sealed class

- `스테이트 패턴(State pattern)`과 비슷
- 추상 클래스를 다 구현할 수 있는게 아니라, 정해진 구현체만 구현 가능하다.
- 다른 패키지에서는 구현할 수 없다.

---

### JDBC 트랜잭션(Transaction)

`setAutoCommit(boolean autoCommit)`

- 대표적으로 스테이트 패턴 적용된 예시
- setAutoCommit(**true || false**)에 따라서 JDBC의 상태가 바뀐다.

---

## 스테이트 VS 스트래티지 VS 템플릿 메서드

- `스테이트 패턴(State Pattern)`
- **내부**에 의존 관계를 들고 있는 거라서 요즘은 잘 쓰이지 않는다.
- 내부에서 의존성을 주입하기 때문에 **추가 확장성이 없다.**
- **상태를 기반**으로 하는 행동을 캡슐화하고, 행동을 **현재 상태에게 위임**한다.
  <br>
- `스트래티지 패턴(Stategy Pattern)`
- **외부**에서 의존성을 주입한다.
- **구성**을 통해 행동을 정의하는 객체의 **유연성을 극대화**한다.
- **객체 지향의 꽃**이라고 불리며 스테이트 패턴에 비해 실무에서 훨씬 많이 쓰인다.
- 알고리즘의 각 단계를 구분하는 방법을 **서브클래스**에서 구현한다.
  <br>
- `템플릿 메서드 패턴(Templete Method Pattern)`
  - 바꿔 쓸 수 있는 행동을 캡슐화 한 다음, 실제 행동은 **다른 객체에 위임**한다.

---

### To Study More

- [ ] Kotlin sealed class
- [ ] 의존성 주입(Dependency Injection)
- [ ] JDBC 트랜잭션

### To do

- [ ] Java Servlet에 직접 간단한 게시판 만들어서 구현해보기
      (이 과정을 통해 Spring을 왜 사용하는지 편리함을 느끼고 이해할 수 있게 될 것이다.)

---

### 참고 링크

- [[JSP] JDBC 에서의 트랜잭션 처리 [개발이 하고 싶어요]](https://hyeonstorage.tistory.com/113)
