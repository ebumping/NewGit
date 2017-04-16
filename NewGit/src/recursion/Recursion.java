package recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Recursion {
	List<String> users = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
		Recursion r = new Recursion();
		r.recursiveDataProcessing("Bob Jones, Steve Mills, Beth Dill, Don Jared, Rex Ryan");
		//this is our CSV string
	}
	
	private void recursiveDataProcessing(String dataToProcess){
		//Use commas to separate user objects
		int index = dataToProcess.indexOf(",");
		if(index == -1){
			index = dataToProcess.length();
		}
		String user = dataToProcess.substring(0, index);
		//add user at index of ',' to the 'users' String array
		users.add(user);
		System.out.println(users);
		if(dataToProcess.length() > index){
			recursiveDataProcessing(dataToProcess.substring(index + 1, dataToProcess.length()));
		}
	}
	
	/*Directory recursion method only here as a reference example
	 * private void directoryRecursion(String filePath) throws IOException{
		File f = new File(filePath);
		if(f.isDirectory()){
			File[] contents = f.listFiles();
			if (contents != null){
				for(int i = 0; i < contents.length; i++){
					System.out.println(contents[i]);
					if (contents[i].isDirectory()){
						directoryRecursion(contents[i].getCanonicalPath());
					}
				}
			}
		}
	}*/
	
}
