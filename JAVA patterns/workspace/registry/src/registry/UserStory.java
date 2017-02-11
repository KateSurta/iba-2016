package registry;

import java.util.Set;

public interface UserStory {

	 public void addDependsOn(final String userStoryName) ;
	 
	 public Set getDependsOn();
}
