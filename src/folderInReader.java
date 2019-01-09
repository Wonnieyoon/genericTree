import java.io.File;

public class folderInReader {
   	public static void main(String[] args)  {
		String path="C:/";
		File dirFile=new File(path);
		File []fileList=dirFile.listFiles();
		for(File tempFile : fileList) {
		  if(tempFile.isFile()) {
		    String tempPath=tempFile.getParent();
		    String tempFileName=tempFile.getName();
		    System.out.println("Path="+tempPath);
		    System.out.println("FileName="+tempFileName);		   
		  }
		}
	}
}

