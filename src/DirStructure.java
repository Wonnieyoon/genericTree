import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import kr.sys4u.file.FileNode;

class DataSave
{
	private Set<File> file;
	public DataSave()
	{
		
	}
	
	public String DirName;
	public ArrayList<Object> al;	
	
	public Node(String DirName)
	{
		this.DirName = DirName; 
		al = new ArrayList<Object>();
	}	
}

public class DirStructure {
		
	private String DirSplit = "└";
	private String DirPath = "";

	public ArrayList<Object> TreeData;	
	
	public DirStructure()
	{
		TreeData = new ArrayList<>();    
	}

	public String getDirPath() {
		return DirPath;
	}

	public void setDirPath(String dirPath) {
		DirPath = dirPath;
	}
	
	public String ShowDirStructure()
	{
		SaveDirStructure(DirPath,true,null);
		
		if(TreeData.size()==0)
			return "없습니다.";
		
		StringBuilder strCombine= new StringBuilder("");
		
		for(int i=0;i<TreeData.size();i++)
		{	
			StringBuilder sb = new StringBuilder("");
			FileNode temp = (FileNode)TreeData.get(i);			
			strCombine.append(DirSplit + temp.DirName+"\n");			
			MakeStringOneGroup(sb,temp,1);			
			strCombine.append(sb.toString());				
		}		
		return strCombine.toString();		
	}
	
	public void MakeStringOneGroup(StringBuilder data, FileNode node,int position)
	{
		for(int i=0;i<node.children.size();i++)
		{			
			for(int j=0;j<position;j++)
			{
				data.append("\t");
			}	
				FileNode temp = (FileNode)node.children.get(i);
				data.append(DirSplit + temp.DirName + "\n");				
				MakeStringOneGroup(data, temp, position+1);									
		}		
	}
		
	public void SaveDirStructure(String DirPath , boolean check , FileNode node) 
	{
		File dir = new File(DirPath);		
		if(dir.exists())
		{			
			File[] fileList = dir.listFiles();			
						
			
			for(File data:fileList)
			{
				//File file = fileList[i];
				File file = data;
				if(file.isDirectory())
				{
					FileNode temp = new FileNode(file.getName());					
					if(check == true)
					{							
						TreeData.add(temp);
					}else
					{
						node.children.add(temp);
					}
								
					SaveDirStructure(DirPath +"/" + file.getName() , false , temp);
				}				
			}
		}		
	}
}

