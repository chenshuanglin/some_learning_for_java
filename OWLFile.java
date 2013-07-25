package webJena;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class OWLFile {
	private String owlFile;
	public OWLFile(String owlFile){
		this.owlFile = owlFile;
	}
	public void writeOWLMessageToFile(){
		OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		ontModel.read("file:"+owlFile);  //读取当前路径下的文件，加载模型
		StringBuffer buf = new StringBuffer(owlFile+" ");
		
		for(Iterator it = ontModel.listClasses();it.hasNext();){
			OntClass ontClass = (OntClass)it.next();
			buf.append(ontClass.getLocalName()+" ");
		}
		
		//把buf的内容存入文件
		File file = new File("/home/lin/语义web/OWL_ANAYLSIS_FILE.txt");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter(file,true));
			System.out.println(buf.toString());
			write.write(buf.toString());
			write.newLine();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
