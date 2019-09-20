public class BMWFactory implements CarFactory {

    public Car makeCar() throws Exception {
        return new Car("BMW", "50000원");
    }
}
