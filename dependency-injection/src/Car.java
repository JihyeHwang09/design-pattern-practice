public class Car {
    private String name;
    private String price;

    public Car (String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice (String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String toString() {
        final String TAB = "    ";

        String retValue = "";

        retValue = "Car ("
                + super.toString() + TAB
                + "name = " + this.name  + TAB
                + "price = " + this.price + TAB
                + " ) ";
        return retValue;
    }

}
