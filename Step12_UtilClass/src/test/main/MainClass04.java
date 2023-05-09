package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type을 저장할 수 있는 ArrayList 객체를 생성해서
		//참조값을 List 인터페이스 type 지역 변수 cars에 담아보세요.
		List<Car> cars = new ArrayList<>();
		//2. Car 객체(3개)를 생성해서 List 객체에 저장해보세요.
		cars.add(new Car("소나타"));
		cars.add(new Car("SUV"));
		cars.add(new Car("다마스"));
		
		//여기까지해서 생성되는 객체는 총 7개(Car객체 3 + ArrayList 객체 1 + String 객체 3)이다.
		//각각의 String 객체들의 Car 객체 안의 필드에 저장되어 있다.
		
		//3. 일반 for 문을 이용해서 List 객체 저장된 모든 Car 객체의 drive() 메소드를
		//순서대로 호출해보세요
		for(int i = 0; i < cars.size(); i++) {
			cars.get(i).drive();
		}
		
		System.out.println("----------");
		//4. 확장 for 문을 이용해서 List 객체에 저장된 모든 Car 객체의 drive() 메소드를
		//순서대로 호출해보세요
		for(Car tmp: cars) {
			//tmp = cars.get(i)
			tmp.drive();
		}
		System.out.println("----------");
		//5. Consumer 인터페이스를 활용해서 List 객체에 저장된 모든 car 객체의 drive() 메소드를
		//순서대로 호출해보세요.
		cars.forEach(new Consumer<Car>() {
			@Override
			// t = cars.get(i)
			public void accept(Car t) {
				t.drive();
			}
		});
		System.out.println("----------");
		cars.forEach((t)->{
			// t = cars.get(i)
			t.drive();
		});
		
	}
}
