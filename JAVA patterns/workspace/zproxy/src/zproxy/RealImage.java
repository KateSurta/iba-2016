package zproxy;

public class RealImage implements Image {
	private String fileName;

	   public RealImage(String fileName){
	      this.fileName = fileName;
	      loadFromDisk(fileName);
	   }

	   public void display(Image ri) {
	      System.out.println("Displaying  " +""+ fileName +" refer " +ri);
	   }

	   private void loadFromDisk(String fileName){
	      System.out.println("Loading " + fileName);
	   }
}
