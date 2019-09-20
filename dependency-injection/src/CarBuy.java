public class CarBuy {
    public static void main(String[] args) throws Exception{
        CarMarket market = new CarMarket();
        // 리팩토링 하기 전 코드
//       Car ticoCar = market.carDisplay("tico");
//        System.out.println(ticoCar.getName() + " : " + ticoCar.getPrice());

        // 리팩토링 후 코드
        Car roliCar = market.carDisplay(new RoliFactory());
        System.out.println(roliCar.getName() + " : " + roliCar.getPrice());
    }
}
/*
CarBuy와 CarMarket 리팩토링 후,
자동차 구입에서 자동차가게에 파라미터로 각 구현 공장들(depencency)를 넣어주고,
자동차 가게에서 전달 받은 인
 */