package Main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import utils.WriteReadHandler;

public class IDandPasswords {
	private HashMap<String, String> logininfo = new HashMap<String, String>();
	private HashMap<String, String> adminlogin = new HashMap<String, String>();
	private WriteReadHandler rsh = new WriteReadHandler();
	
	protected IDandPasswords() {

		logininfo.put("Jason", "pass1");
		logininfo.put("Andrea", "pass2");
		logininfo.put("Bryle", "pass3");
		logininfo.put("Sean", "pass4");
		
		adminlogin.put("admin", "frondabacalso");
	}

	protected HashMap getLoginInfo() throws FileNotFoundException, ClassNotFoundException, IOException {
		logininfo = rsh.readUsernamePass();
		return logininfo;
	}
	
	protected HashMap getAdminLoginInfo() {
		return adminlogin;
	}

}
