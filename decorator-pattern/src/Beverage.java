public abstract class Beverage {
    private String description ="Empty";

    public String getDescription () {
        return this.description;
    }

    public abstract int cost();
}