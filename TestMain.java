package webJena;

import java.io.File;
import java.util.Scanner;

public class TestMain {
	private String keyWord;   //要搜索的关键字
	public TestMain(String keyWord){
		this.keyWord=keyWord;
	}
	public void searchOntology(String path){
		File file = new File(path);
		if(file.isFile()){
			String ext=path.substring(path.lastIndexOf(".")+1);   //得到当前文件的扩展名
			if(ext.equals("owl")){
				ListClassAndIndividual listClass = new ListClassAndIndividual(path, keyWord);
				listClass.listMessage();
//				OWLFile owlFile = new OWLFile(path);
//				owlFile.writeOWLMessageToFile();
			}
		}
		if(file.isDirectory()){
			for(String name:file.list()){
				String absolutePath = path+"/"+name;
				searchOntology(absolutePath);
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要查找的概念：");
		String keyWord=scanner.nextLine();
		long startTime = System.currentTimeMillis();
		TestMain test = new TestMain(keyWord);
		test.searchOntology("/home/lin/语义web/本体");
		long endTime = System.currentTimeMillis();
		System.out.println("run time:"+(endTime-startTime));
	}
}
