import java.io.File;

public class Master {
	
	private static final String CRNL="\r\n";
	private static final String SPACE="\t";
	private static final String CHILD_SYMBOL="└";
	
	
	private final File rootDirectory;
	private final StringBuilder resultStringBuilder = new StringBuilder();
	
	public Master(String rootDirectory) {
		
		if(rootDirectory==null) {
			throw new IllegalArgumentException("root directory is null");
		}
		
		this.rootDirectory = new File(rootDirectory);
		validate();
		
	}
	public final void validate() {
		if(!this.rootDirectory.exists()) {
			throw new IllegalArgumentException("rootDirectory["+this.rootDirectory.getAbsolutePath()+"] does not exist.");
		}
	}
	public String getDirectoryStructureString() {
		traverseDirectory(rootDirectory, 0);
		return resultStringBuilder.toString();
	}
	private void traverseDirectory(File parentDirectory, int depth) {
		File[] children = parentDirectory.listFiles();
		depth++;
		for(File child : children) {
			if(child.isFile()) {
				continue;
			}
			resultStringBuilder.append(getDepthSpace(depth)).append(child.getName()).append(CRNL);
			traverseDirectory(child,depth);
		}
	}
	private String getDepthSpace(int depth) {
		StringBuilder spaceBuilder = new StringBuilder();
		for(int i=0; i<depth; i++) {
			spaceBuilder.append(SPACE);
		}
		return spaceBuilder.append(CHILD_SYMBOL).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Master("C:\\Program Files\\Bandizip").getDirectoryStructureString());
	}

}
