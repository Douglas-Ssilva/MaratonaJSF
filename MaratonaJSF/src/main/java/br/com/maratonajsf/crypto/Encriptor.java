package br.com.maratonajsf.crypto;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;

public class Encriptor {
	public static void main(String[] args) {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("AES");
			generator.init(256);	//key de 32bits
			String key = Base64.getEncoder().encodeToString(generator.generateKey().getEncoded());
			System.out.println(key);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
