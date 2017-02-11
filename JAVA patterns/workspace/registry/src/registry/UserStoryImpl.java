package registry;

import java.util.HashSet;
import java.util.Set;

public class UserStoryImpl extends PlanningObjectImpl implements UserStory,PlanningObject
 {
	 private final Set dependsOn = new HashSet();

	  public UserStoryImpl(final String name) {
	    super(name);
	  }

	  public void addDependsOn(final String userStoryName) {
	    dependsOn.add(Registry.getInstance().getReference(
	        userStoryName));
	  }

	  public Set getDependsOn() {
	    final Set result = new HashSet();
	    for (Object reference : dependsOn) {
	     //TODO handle it 
	    }
	    return result;
	  }
}
