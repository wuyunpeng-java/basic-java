package 包装类;

import org.junit.Test;

public class WrapperTest {
	@Test
	public void test1() {
		int num1 =25;
		Integer in1 = new Integer(num1);
		System.out.println(in1.toString());
		Integer in2 = new Integer("123");
		System.out.println(in2.toString());
		
	}

	@Test
	public void test2() {
		
//		Integer in1 = new Integer(68);
//		int i1 = in1.intValue();
		System.out.println("hello world");
	}

	@Test
	public void test3() {
		int num1 = 22;
	
		String str = num1 + "";
	
		float f1 =12.3f;
		str =String.valueOf(f1);
		Double d1 = 25.78;
		String str1 =String.valueOf(d1);
		System.out.println(str1+""+str);
		
	}
	
	
}
