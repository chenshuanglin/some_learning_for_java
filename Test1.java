/**
 * @author chenshuanglin
 * 子类继承父类，虽然子类无法继承父类的构造函数，但子类的构造函数必须调用父类的构造函数。如果子类的
 * 构造函数中没有显式的调用父类的构造函数，则系统默认调用父类的无参构造函数；若父类自定义了非空的
 * 构造函数，系统就不再有默认的无参构造函数
 * */
package test;

class Father{
	public Father()
	{
		System.out.println("I am father!");
	}
	public Father(int age){
		System.out.println("I am "+age+" years old.");
	}
}

public class Test1 extends Father{
	public Test1(){}
	public Test1(int test_age){
		//该程序执行这个步骤的时候会自动调用父类的无参构造函数
		System.out.println("I am "+test_age+" years old");
	}
	public static void main(String[] args) {
		Test1 test1 = new Test1(21);
		//此时的此行结果是
		//I am father!
		//I am 21 years old
	}
}
