import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

public class Encription {
	
	private static final byte[] key = "MyDifficult_pass".getBytes();
	private static final String transformation = "AES";
	
	public static void encrypt(Serializable obj, OutputStream os) {
		System.out.println("sdf");
		SecretKeySpec sks = new SecretKeySpec(key, transformation);
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, sks);
			
			SealedObject so = new SealedObject(obj, cipher);
			ObjectOutputStream oos = new ObjectOutputStream(new CipherOutputStream(os, cipher));
			oos.writeObject(so);
			System.out.println("end");
			oos.close();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object decrypt (InputStream iS) throws IOException {
		ObjectInputStream ois = null;
		try {
			SecretKeySpec sks = new SecretKeySpec(key, transformation);
			Cipher cipher;
			cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.DECRYPT_MODE, sks);
			CipherInputStream cin = new CipherInputStream(iS, cipher);
			ois = new ObjectInputStream(cin);
			SealedObject so = (SealedObject) ois.readObject();
			System.out.println("finish decrypt server");
			return so.getObject(cipher);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ois.close();
		}
		return null;
	}
}
