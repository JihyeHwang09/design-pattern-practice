public class CarMarket {
    // 리팩토링 하기 전 코드
//    public Car carDisplay (String carName) throws Exception {
//        CarFactory factory = null;
//        if("tico".equals(carName)) {
//            factory = new TicoFactory();
//        } else {
//            factory = new BMWFactory();
//        }
//        return factory.makeCar();
//    }
/*
    위와 같이 구현할 경우 문제점
    : 롤스로이스(Roli) 하고 바이마흐(Baema)는 타야 겠다 한다고 해보자.
    -> 일단 자동차 Factory를 2개 생성하고 CarMarket의 소스도 수정해야 한다.
    현재 상태에서는 자동차 가게가 각 구현 공장들과 depencency가 걸려 있다.
    -> 따라서, 무언가가 추가되면 반드시 수정이 이루어져야 한다.
 */
    public Car carDisplay (CarFactory factory) throws Exception {
       Car madeCar = factory.makeCar();
        return madeCar;
    }
}
