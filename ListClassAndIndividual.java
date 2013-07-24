package webJena;

import java.util.Iterator;
import java.util.Scanner;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.ontology.impl.OntologyImpl;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ListClassAndIndividual {
	public static void main(String[] args) {
		String className;
		OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		ontModel.read("file:/home/lin/语义web/本体/university.owl");  //读取当前路径下的文件，加载模型
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要查找的概念：");
		className=scanner.nextLine();
		for(Iterator it = ontModel.listClasses();it.hasNext();){
			OntClass ontClass = (OntClass)it.next();
			if(ontClass.getLocalName() != null && ontClass.getLocalName().equals(className)){   //判断是否是同一个类
				//显示当前类的名称
				System.out.print("class: ");
				//获取累的URI并输出，在输出时对URI做了简化（将命名空间前缀省略）
	//			System.out.println(ontClass.getModel().getGraph().getPrefixMapping().shortForm(ontClass.getURI()));
				
				
				System.out.println("The super class is :");
				for(Iterator i=ontClass.listSuperClasses();i.hasNext();){
					OntClass superClass = (OntClass)i.next();
					String superClassUri = superClass.getURI();
					String superName = superClassUri.substring(superClassUri.indexOf("#")+1);
					System.out.println("  "+superName);
				}
				System.out.println("The subClass is: ");
				for(Iterator i=ontClass.listSubClasses();i.hasNext();){
					OntClass subClass = (OntClass)i.next();
					String subClassUri = subClass.getURI();
					String subName = subClassUri.substring(subClassUri.indexOf("#")+1);
					System.out.println("  "+subName);
				}
				
				System.out.println("The equivalentClass is:");
				for(Iterator i=ontClass.listEquivalentClasses();i.hasNext();){
					OntClass equilClass=(OntClass)i.next();
					String equilClassUri = equilClass.getURI();
					String equilName = equilClassUri.substring(equilClassUri.indexOf("#")+1);
					System.out.println("  "+equilName);
				}
				
				System.out.println("The individual is: ");
				for(Iterator i=ontClass.listInstances();i.hasNext();){
					Individual individual = (Individual)i.next();
					
					
					System.out.println(individual.getLocalName());
					for(Iterator ipp = ontClass.listDeclaredProperties(); ipp.hasNext();){
						OntProperty p = (OntProperty)ipp.next();
						System.out.println(individual.getPropertyValue(p));
					}
				}
				
				
				//迭代显示当前类相关的所有属性
				System.out.println("The all property is: ");
				for(Iterator ipp = ontClass.listDeclaredProperties(); ipp.hasNext();){
					OntProperty p = (OntProperty)ipp.next();
					System.out.println(p.getLocalName());
				}
			}
		}
		//迭代显示模型中的类，在迭代过程中完成各种操作
		
		
	}
}
