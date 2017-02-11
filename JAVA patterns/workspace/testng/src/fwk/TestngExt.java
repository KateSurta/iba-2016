package fwk;


import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlMethodSelector;
import org.testng.xml.XmlPackage;
import org.testng.xml.XmlRun;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import test.TestExample1Test123;
import test.TestExample2;
import test.TestExample3;
/**
 * Java class for testcases running process
 * we need 
 * 1. source file to get beopt
 * 2. class files to load them in rumtime or jar file ?
 * 
 * @author Brel
 * 
 * <testng>
   <jvmarg value="-Djava.compiler=NONE" />
   <!-- ... -->
</testng>
 *
 */
public class TestngExt {

	private static final String path= "c:/17";
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
	//	Java javaTask = new Java();
		
		
		Set set = new HashSet();
		
		
		Iterator iterator = set.iterator();
		while (iterator.hasNext())
		{
			TestListenerAdapter listener = new TestListenerAdapter();
			TestNG runner = new TestNG(true);
			
			runner.addListener(listener);
			runner.addListener(listener);
			runner.setMixed(true);
			runTestcasesForGroup(runner,(String) iterator.next(),false,"tests.testng" );
		}
		//runTestcasesForGroup(runner,"",true,"com.ibm.econfig.tests.junit" );
	}

	public static void runTestcasesForGroup(TestNG runner,String group,Boolean mixedMode, String packageName) {
		
	
		
		
		
		

		

		XmlSuite suite = new XmlSuite();
		suite.setName("TmpSuite");
		
		suite.setVerbose(1);
	//	suite.setParallel(XmlSuite.DEFAULT_PRESERVE_ORDER);
		suite.setAllowReturnValues(XmlSuite.DEFAULT_ALLOW_RETURN_VALUES);

		XmlTest test = new XmlTest(suite);
		test.setName("TmpTest");
		test.setJunit(mixedMode);

		// ---------------------------------------------------------------------
		// add selector
		final XmlMethodSelector anXmlMethodSelector = new XmlMethodSelector();

		anXmlMethodSelector.setName(BeoptMethodSelector.class.getName());

		anXmlMethodSelector.setPriority(15);

		test.getMethodSelectors().add(anXmlMethodSelector);
		// ---------------------------------------------------------------------

		// groups
		XmlGroups groups = new XmlGroups();

		XmlRun run = new XmlRun();
		groups.setRun(run);

		run.onInclude(group);

		suite.setGroups(groups);
		
		suite.setJunit(mixedMode);

		// end group
		
		List<XmlClass> classes = new ArrayList<XmlClass>();

		// Add just class
		classes.add(new XmlClass(TestExample2.class.getName()));
		
		classes.add(new XmlClass(TestExample1Test123.class.getName()));
		

		// Add class and method to run
		ArrayList<XmlInclude> methodsToRun = new ArrayList<XmlInclude>();

		XmlClass testClass1 = new XmlClass(TestExample3.class.getName());
		testClass1.setName(TestExample3.class.getName());
		methodsToRun.add(new XmlInclude("test3_2"));
		testClass1.setIncludedMethods(methodsToRun);

		// add 2 classes
		 classes.add(testClass1);  
		// test.setClasses(classes);
		// add package ;
		List<XmlPackage> package1 = new ArrayList<XmlPackage>();
		package1.add(new XmlPackage(packageName));
		test.setXmlPackages(package1);

		runner.setXmlSuites(Arrays.asList(suite));
		runner.run();

	}
	
	private List<Class> loadClasseFromJar(String path) throws IOException, ClassNotFoundException
	{
		String pathToJar =null;
		
		List<Class> listClass =  new ArrayList<Class>();
		JarFile jarFile = new JarFile(path);
		Enumeration e = jarFile.entries();

		URL[] urls = { new URL("jar:file:" + pathToJar+"!/") };
		URLClassLoader cl = URLClassLoader.newInstance(urls);

		while (e.hasMoreElements()) {
		    JarEntry je = (JarEntry) e.nextElement();
		    if(je.isDirectory() || !je.getName().endsWith(".class")){
		        continue;
		    }
		// -6 because of .class
		String className = je.getName().substring(0,je.getName().length()-6);
		className = className.replace('/', '.');
		Class c = cl.loadClass(className);
		listClass.add(c);
		}
		
		return listClass;
		
	}
	
}
