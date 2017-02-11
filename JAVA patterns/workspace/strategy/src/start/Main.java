package start;

import auth.UserChecker;
import java.io.File;
import strategy.DBAuth;
import strategy.FileAuth;


public class Main {

    public static void main(String[] args) {
        UserChecker userChecker = new UserChecker();
        
        userChecker.check(new DBAuth("jdbc://etc"));
        
        userChecker.check(new FileAuth(new File("c:\\file.txt")));
        
    }
}
