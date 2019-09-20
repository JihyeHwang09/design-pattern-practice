public class TicoFactory implements CarFactory {

    public Car makeCar () throws Exception {
        return new Car("tico", "1000원");
    }
}
