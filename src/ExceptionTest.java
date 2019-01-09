public class ExceptionTest {

	public static void main(String[] args) {		
		new ExceptionTest().a();		
	}	
	
	public String a() {
		return "a"+b();
	}
	
	public String b() {
		return "b"+c();
	}
	
	public String c() {
		String dResult = null;
		try {
			dResult = d();
		}catch(Exception e)
		{
			
		}
		return "c"+dResult;
	}	
	
	private String d() 
	{
		throw new IllegalArgumentException();				
	}
	
}
