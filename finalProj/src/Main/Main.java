package Main;

import java.io.IOException;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		IDandPasswords idandPasswords = new IDandPasswords();
		
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
//		idandPasswords.showLoginCred();
//		created new branch
	}

}
