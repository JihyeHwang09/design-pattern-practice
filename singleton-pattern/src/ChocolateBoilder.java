public class ChocolateBoilder {
    public static ChocolateBoilerSingleton cb;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilder () {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerSingleton getInstance () {
        if (cb == null)
            cb = new ChocolateBoilerSingleton();
        return cb;
    }

    public void fill () {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain () {
        if (!isEmpty() && isBoiled) {
            empty = true;
        }
    }

    public void boil () {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty () {
        return empty;
    }

    public boolean isBoiled () {
        return boiled;
    }

}
