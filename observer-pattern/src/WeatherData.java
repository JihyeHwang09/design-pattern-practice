import java.util.ArrayList;
import java.util.List;

/*
날씨 데이터를 가지고 있는 회사와 데이터를 연동하여 여러 종류의 각각의 디스플레이에
날씨데이터를 출력해줘야 하는 업무가 생겼다고 가정했을때.
제공 받은 객체와 각 메소드의 역할
getTemperature(): 온도
getHumidity(): 습도
getPressure(): 기압

measurementsChanged(): 새로운 기상 측정 데이터가 나올 때마다 자동으로 호출되는 부분
 */
/*
measurementsChanged 메소드 안 Display update 메소드들이 구체적인 구현에 맞춰서 코딩이 되었기 때문에
프로그램을 고치지 않고는 다른 디스플레이 항목을 추가할 수 X
-> 대처법: 향후에 바뀔 수 있는 부분은 캡슐화하여 분리해야 한다.
 */

public class WeatherData implements Subject {
//
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    {
        this.observers = new ArrayList<>();
    }

    public void measurementsChanged() {
        this.notifyObservers();
    }

    public void setMeaurementsChanged(float t, float h, float p) { // 값이 세팅된다고 가정
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        this.measurementsChanged(g);
    }
    {

    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }

    @Override
    public void registerObserver(Observer observer){
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

}
