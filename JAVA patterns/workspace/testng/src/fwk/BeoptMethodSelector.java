package fwk;


import java.lang.reflect.Method;
import java.util.List;

import org.testng.IMethodSelector;
import org.testng.IMethodSelectorContext;
import org.testng.ITestNGMethod;



public class BeoptMethodSelector implements IMethodSelector
{

	private static final long serialVersionUID = 224817457782849332L;


	public boolean includeMethod(IMethodSelectorContext context, ITestNGMethod method, boolean isTestMethod)
	{
		
		List<String> includeGroups = method.getXmlTest().getIncludedGroups();
		List<String> excludeGroups = method.getXmlTest().getExcludedGroups();
		Method testMethod = method.getConstructorOrMethod().getMethod();

		if (includeGroups == null || includeGroups.isEmpty() || !testMethod.isAnnotationPresent(Beopt.class))
		{
			return false;
		}
		else
		{
			Beopt beoptAnnotation = testMethod.getAnnotation(Beopt.class);
			
			if (includeGroups.contains(beoptAnnotation.value()) && !excludeGroups.contains(beoptAnnotation.value()))
			{
				
				return true;
			}
		}
		return false;
	}

	public void setTestMethods(List<ITestNGMethod> testMethods) {
		// TODO Auto-generated method stub
		
	}


}
