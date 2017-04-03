package ke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 원래는 DB로부터 가져와야 하는 것
public class Classifier {

	public static String modelname = "";

	public Classifier() {
		// TODO Auto-generated constructor stub
	}

	public static void learn(String trainData, String modelName) {
		System.out.println("svm learn " + trainData + " " + "...");
		String path = "/Users/sunghee/Documents/sunghee-data/2016programs/svm_multiclass/";
		String command = path + "svm_multiclass_learn -c 5000 " + path + trainData +" " + path +"example4/model";
		executeSystemCommand(command);
	}

	public static void classify(String testData, String modelName, String pred) {
		System.out.println("svm classify " + modelName + " " + testData+"...");
		String path = "/Users/sunghee/Documents/sunghee-data/2016programs/svm_multiclass/";
		String command = path + "svm_multiclass_classify " + path + testData +" " + path + modelName + " " + path + pred ;
		System.out.println(command);
		executeSystemCommand(command);
	}
	
	public static void executeSystemCommand(String s)
	{
//		String s= null;

	    try {
	        
	    // run the Unix "ps -ef" command
	        // using the Runtime exec method:
	        Process p = Runtime.getRuntime().exec(s);
	  	//	+ "/Users/sunghee/Documents/sunghee-data/2016programs/mallet-2.0.7/bin/mallet ");
	        
	        BufferedReader stdInput = new BufferedReader(new 
	             InputStreamReader(p.getInputStream()));

	        BufferedReader stdError = new BufferedReader(new 
	             InputStreamReader(p.getErrorStream()));

	        // read the output from the command
	        System.out.println("Here is the standard output of the command:\n");
	        while ((s = stdInput.readLine()) != null) {
	            System.out.println(s);
	        }
	        
	        // read any errors from the attempted command
	        System.out.println("Here is the standard error of the command (if any):\n");
	        while ((s = stdError.readLine()) != null) {
	            System.out.println(s);
	        }
	        
//	        System.exit(0);
	    }
	    catch (IOException e) {
	        System.out.println("exception happened - here's what I know: ");
	        e.printStackTrace();
	        System.exit(-1);
	    }	
	}
	public static void main(String [] args)
	{
		Ref aRef = new Ref();
		CRFmodel aCRFmodel = new CRFmodel();
		Classifier aClassifier = new Classifier();
		String strTraining = "example4/train.dat"; // 입력자료
		String modelName = "example4/model"; // 모델명
		String testData = "example4/test.dat"; // 테스트 데이터
		String pred = "example4/predictions"; // 분류결과
		
		aClassifier.learn(strTraining, modelName);
		aClassifier.classify(testData, modelName, pred);
		
	}
}
