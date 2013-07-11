package test;

class A{
	public void method1(){
		method2();
	}
	public void method2(){
		System.out.println("A");
	}
}

class B extends A{
	public void method1(int i){
		System.out.println("B");
	}
	public void method2(){
		System.out.println("CCC");
	}
}

public class PolymorphismTest {
	public static void main(String[] args) {
		A b = new B();
		b.method1();
		b.method2();
	}
}
