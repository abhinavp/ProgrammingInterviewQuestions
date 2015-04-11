

public  class TestAbstract {

	private String string = "";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestAbstract testSubClass1 = new TestAbstract();
		testSubClass1.string = "String1";
		TestAbstract testSubClass2= new TestAbstract();
		testSubClass2.string = "String2";
		testSubClass1.testMethod();
		testSubClass2.testMethod();
	}
	
	//public abstract void testAbstractMethod();
	public  void testMethod(){
		System.out.println("inside test Method, String value: ");
	}

}
