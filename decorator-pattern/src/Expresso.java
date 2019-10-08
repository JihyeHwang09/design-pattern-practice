public class Expresso extends Beverage {
    public Expresso () {
        this.description = "에스프레소";
    }

    @Override
    public int cost () {
        return 3500;
    }
}
