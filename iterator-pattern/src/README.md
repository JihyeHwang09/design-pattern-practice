# 이터레이터 패턴(iterator pattern)
> 컬렉션 구현 방법을 노출시키지 않으면서도 그 집합체 안에 들어있는 
> 모든 항목에 접근할 수 있는 방법을 제공


이터레이터 패턴을 사용하면 모든 항목에 일일이 접근하는 작업을 컬렉션 객체가 아닌 반복자 객체에서 맡게 된다.
 
 
 - [] 클래스 다이어그램 
    - [] 그리기 -> 넣기


## 클라이언트의 기능 5가지

- `printMenu()`: 메뉴에 있는 모든 항목을 출력
- `printBreakfastMenu()`: 아침 식사 항목만 출력
- `printLunchMenu()`: 점심 식사 항목만 출력
- `printVegetarianMenu()`:  채식주의자용 메뉴 항목만 출력
- `isItemVegetarian(name)`: name 항목



### 반복을 캡슐화 하자.
반복 작업을 **캡슐화**해서 `Iterator`라는 객체를 만든다.


                         
---
### 참고 링크
- [이터레이터 패턴 (iterator pattern) [정리정리정리]]: https://jusungpark.tistory.com/25
