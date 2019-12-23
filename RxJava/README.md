# Reactive
## Reactive Streams
- 리액티브 프로그래밍을 위해서 정의한 스펙(Spec)이다. 
실제로 리액티브 프로그래밍을 위해서는 구현체를 만들어야 한다. 

- `Processor`
- `Publisher`
- `Subcriber`
    - Observer 역할
- `Subscrition`
    - 중간 가교 역할을 하는 클래스
    
### Observable의 행동
- `onSubscrible`
- `onNext`
- `onError | onCompleted`

### 참고 링크
- [Reactive Streams](https://www.reactive-streams.org/)
- [RxJava란?- 기본구조](https://juyoung-1008.tistory.com/38)
- [Project Reactor3. 리액티브 스트림](https://brunch.co.kr/@springboot/153) 