public class Example {
	
	public static void main(String[] args) {
	
		int a=5,b=3;
		swap(5,3);
		System.out.println("a의 값은:"+a+", b의 값은:"+b);		
		
	}
	
	static void swap(int a,int b)
	{
		int temp = a;
		a = b;
		b = temp;		
	}
	
	
}
