public class Polymorphism {
    public static void main(String[] args) {
        SuperClass sup = new SubClass(); // Promotion: 자동 타입변환, pholymorphism
        // 동적 바인딩
        sup.methodA(); // Runtime시에 결정된다. subClass의 메소드 호출
        // 정적 바인딩
        sup.staticMethodA(); //
    }
}

class SuperClass {
    void methodA() {
        System.out.println("SuperClass");
    }
    void staticMethodA() {
        System.out.println("SuperClass");
    }
}

class SubClass extends SuperClass {
    void methodA() {
        System.out.println("SubClass");
    }
    void  staticMethodA() {
        System.out.println("SubClass");
    }
}