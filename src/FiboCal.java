import java.util.Scanner;

public class FiboCal {

	public static void main(String[] args) {	
		// 1 1 2 3 5 8 13 21 34 55
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하세요: ");
		int input = sc.nextInt();
		sc.close();
		
		int Nor_result = Nor_Fibo(input);
		int Cur_result = Fibo(input,0,1);
		int NotCur_Result = NotRecur(input);
		System.out.println("재귀결과 >> "+ Nor_result);
		System.out.println("꼬리재귀결과 >> "+ Cur_result);
		System.out.println("Not재귀결과 >> "+NotCur_Result);
	}	
	
	static int Nor_Fibo(int input)
	{
		if(input==2) return 1;
		if(input==1) return 1;
		
		return Nor_Fibo(input-1)+Nor_Fibo(input-2);
	}
	
	
	static int Fibo(int input,int before,int after)
	{
		if(input==1) return after; 
		else
			return Fibo(input-1,after,before+after);		
	}
	
	static int NotRecur(int input)
	{
		int sum=0,before=0,after=1;
		
		int temp;
		for(int i=1;i<input;i++)
		{
			temp = after;
			after = after+before;
			before = temp;
		}	
		return after;
	}
}
