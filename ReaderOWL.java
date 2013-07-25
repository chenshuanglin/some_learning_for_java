package OWLTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReaderOWL {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入关键字：");
		String keyWord = scanner.nextLine();
		long startTime = System.currentTimeMillis();
		File file = new File("/home/lin/语义web/OWL_ANAYLSIS_FILE.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String text = null;
			while((text = reader.readLine())!=null)
			{
				String[] argu = text.split(" ");
				for(int i = 1 ; i < argu.length;i++){
					if(argu[i].equals(keyWord)){
						ListClassAndIndividual listClass = new ListClassAndIndividual(argu[0], keyWord);
						listClass.listMessage();
					}
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("run time:"+(endTime-startTime));
	}
}
