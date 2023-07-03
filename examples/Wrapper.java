public class Wrapper {
	public static void main(String[] args) {
		Boolean boolWrap1 = Boolean.valueOf("True");
		boolean boolVal1 = boolWrap1.booleanValue();
		boolean boolVal2 = Boolean.parseBoolean("TruE");
		Boolean boolWrap2 = new Boolean("False");
		System.out.println(boolVal1);
		System.out.println(boolVal2);
		System.out.println(boolWrap2.booleanValue());

		Double apple = Double.valueOf("200.99");
  		System.out.println(apple.byteValue());
		  System.out.println(apple.shortValue());
  		System.out.println(apple.intValue());
  		System.out.println(apple.longValue());
  		System.out.println(apple.floatValue());
  		System.out.println(apple.doubleValue()); 		
	}
}
