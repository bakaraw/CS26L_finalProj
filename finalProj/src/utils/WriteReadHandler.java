package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class WriteReadHandler {
	
	public void writeUsernamPass(HashMap<String, String> logininfo) throws FileNotFoundException, IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("logininfo.bin"));
		objectOutputStream.writeObject(logininfo);
	}
	
	public HashMap readUsernamePass() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream objectInpuStream = new ObjectInputStream(new FileInputStream("logininfo.bin"));
		HashMap<String, String> logininfo = new HashMap();
		logininfo = (HashMap<String, String>) objectInpuStream.readObject();
		return logininfo;
	}
	
}
