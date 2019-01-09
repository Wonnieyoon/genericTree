import java.io.File;

public class Structure2 {
	
	private final File rootDrirectory;
	private static final String CRNL = "\r\n";
	private final StringBuilder resultStringBuilder= new StringBuilder();
	private static final String SPACE =" ";

	public Structure2()
	{
		this("C:/");
	}
	
	public Structure2(String rootDrirectory)
	{
		super();
		
		//rootDir은 매우 중요하기때문에 입력값이 null 이면 안된다.
		//입력값은 검증되어야한다.
		if(rootDrirectory == null)
		{
			//==> 비즈니스 선택의 문제
			
			//--> null로 들어오는 것은 정상흐름이 아니기 때문에 예외처리하는것이다. 
			//throw new IllegalArgumentException("rootDirectory is null");
			
			//-> null이면 정상흐름으로 처리하고 c:/ 로 디폴트로 두겠다.
			this.rootDrirectory = "C:/"; 
		}
		this.rootDrirectory = new File(rootDrirectory);	
		if(!this.rootDrirectory.exists())
		{
			throw new IllegalArgumentException("rootDirectory["+rootDrirectory+"] does not exist");
		}
		
		//java.io.File / java.nio.Path			
	}
	
	public Structure2(File rootDirectroy)
	{
		if(rootDirectroy == null)
		{
			this.rootDrirectory = new File("C:/"); 
		}else
		{
			this.rootDrirectory = rootDirectroy;
		}
			
		if(!this.rootDrirectory.exists())
		{
			throw new IllegalArgumentException("rootDirectory["+rootDrirectory.getAbsolutePath()+"] does not exist");
		}
	}
	
	
	private void traverseDirectory(File parentDirectory,int depth)
	{
		File[] children = parentDirectory.listFiles();
		for(File child : children)
		{
			if(child.isFile())
			{
				continue;
			}
			
			resultStringBuilder.append(child.getName()).append(CRNL);
			traverseDirectory(child,++depth);			
		}
		
	}
	
	private String getDepthSpace(int depth )
	{
		StringBuilder spaceb = new StringBuilder();
		for(int i=0;i<depth;i++)
		{
			spaceb.append(SPACE);
		}
		return spaceb.toString();
	}
	

	public String getDirectoryStructure()
	{
		System.out.println(rootDrirectory.length());
		traverseDirectory(rootDrirectory,0);
		return resultStringBuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Structure2("c:/temp").getDirectoryStructure());
	}
	
	
}
