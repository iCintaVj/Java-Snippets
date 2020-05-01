import java.util.*;
import java.io.*;
class Execute {
	public static void main(String[] args) {
		String compile = "javac Client.java";
		String run = "java Client";
		Process process = Runtime.getRuntime().exec(compile);
   		try {			
			Process process = Runtime.getRuntime().exec(run);
	        BufferedReader reader = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }
	        reader.close();
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
}
