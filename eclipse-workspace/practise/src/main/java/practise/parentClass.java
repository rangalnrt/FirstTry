package practise;

public class  parentClass {
	public static int a;

	public static void m1() {
		
	}
	
	public static Object m2() {
		return m2();
	}
	public static void m3() {
		System.out.println("Parent m3");
	}
}
