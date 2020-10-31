package aboutstring;

public class StringConstructorDemo {
	public static void StringConstructorDemo() {
		String s = new String();
		byte[] arr = { 97, 66, 67, 68 };
		String s1 = new String(arr);
		System.out.println("s1=" + s1);
	}

	public static void main(String[] args) {
		StringConstructorDemo();
	}
}
//*????String????????byte????????????UNICODE??????????
