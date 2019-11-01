public class NonSingletonChocolateBoilder {

    private boolean empty;
    private boolean boiled;

    private NonSingletonChocolateBoilder () {
        //이 코드는 보일러가 비어있을 때만 돌아간다.
        empty = true;
        boiled = false;
    }

    public void fill () {
        if (isEmpty()) {
            // 보일러가 비어있을 때만 재료를 집어 넣는다.
            // 원료를 가득 채우고 나면 empty와 boiled 플래그를 false로 설정한다.
            empty = false;
            boiled = false;
            // 보일러에 우유/초콜릿을 혼합한 재료를 집어넣는다.
        }
    }

    public void drain () {
        //보일러가 가득 차 있고(비어있지 않고), 다 끓여진 상태에서만
        //보일러에 들어있는 재료를 다음 단계로 넘긴다.
        //보일러를 다 비우고 나면 empty 플래그를 다시 true로 설정한다.
        if (!isEmpty() && isBoiled()) {
            // 재료를 끓임
            empty = true;
        }
    }

    public  boolean isEmpty () {
        return  empty;
    }

    public boolean isBoiled () {
        return boiled;
    }
}
