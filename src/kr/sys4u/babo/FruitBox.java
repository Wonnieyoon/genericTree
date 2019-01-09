package kr.sys4u.babo;

abstract class Fruit
{
	abstract void color();
}

class Apple extends Fruit{
	@Override
	void color() {
		// TODO Auto-generated method stub
		System.out.println("빨간색");
	}	
}

class Banana extends Fruit{
	@Override
	void color() {
		// TODO Auto-generated method stub
		System.out.println("노란색");		
	}	
}


public class FruitBox {
		
	private Fruit f;
	
	FruitBox(Fruit f)	{
		this.f = f;
	}
	
	public void getFruit() {
		f.color();
	}
}
