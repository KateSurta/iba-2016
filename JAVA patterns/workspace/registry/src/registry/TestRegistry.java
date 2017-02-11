package registry;

public class TestRegistry {

	public static void main(String[] args) {
		PlanningObject story = new UserStoryImpl("test1");
		System.out.println("before 1" + story);
		Registry.getInstance().register(story);
		story = new UserStoryImpl("test2");
		System.out.println("before 2" + story);
		Registry.getInstance().register(story);
		story = new UserStoryImpl("test3");
		System.out.println("before 3" + story);
		Registry.getInstance().register(story);
		
		
		System.out.println("after 1"+Registry.getInstance().getReference("test1"));
		System.out.println("test1 name check:"+Registry.getInstance().getReference("test1").getName());
		
		System.out.println("after 2"+Registry.getInstance().getReference("test2"));
		System.out.println("test2 name check:"+Registry.getInstance().getReference("test2").getName());
		
		
		
		System.out.println("after 3"+Registry.getInstance().getReference("test3"));
		System.out.println("test3 name check:"+Registry.getInstance().getReference("test3").getName());

		
	

	}

}
