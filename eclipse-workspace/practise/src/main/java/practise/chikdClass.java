package practise;

public class chikdClass extends parentClass{

	
	public static void m3() {
		m1();
		System.out.println("this is a variable"+a);
		
	}
	
	public static void main(String args[]) {
		parentClass p = new parentClass();
		p.m3();
		m3();
		System.out.println("super variable "+a);
	}
}
