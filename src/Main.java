import kr.sys4u.file.FileDir;

public class Main {
   public static void main(String[] args) {     	   
	   FileDir file = new FileDir("C:\\Intel");
	   System.out.println(file.ShowDirStructure()); 	   
   } 
}