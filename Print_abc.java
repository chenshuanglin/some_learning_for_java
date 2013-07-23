package test_thread;

public class Print_abc implements Runnable{
	private String name;
	private Object prev;
	private Object self;
	public Print_abc(String name,Object prev,Object self){
		this.name = name;
		this.prev = prev;
		this.self =self;
	}
	public void run(){
		int count=10;
		while(count > 0){
			synchronized(prev){
				synchronized(self){
					System.out.print(name);
					count--;
					try{
						Thread.sleep(1);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					self.notify();
				}
				try{
					prev.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		Print_abc p_a = new Print_abc("A", c, a);
		Print_abc p_b = new Print_abc("B", a, b);
		Print_abc p_c = new Print_abc("C", b, c);
		
		new Thread(p_a).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(p_b).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(p_c).start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
