package info.goldbo.base.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AuthRandom {

	private String randomstr;
	private Integer length;
	private Map<String, ?> hmap;
	private List<Character> lower;
	private List<Character> upper;

	private String algorithm;
	private String provider;
	private boolean secure;
	private Random random;
	private SecureRandom secrandom;

	public AuthRandom() {
		length = new Integer(8);
		lower = null;
		upper = null;
		algorithm = null;
		provider = null;
		secure = false;
		random = null;
		secrandom = null;
		setCharset("0-9");
		setLength("4");
		try {
			generateRandomObject();
		} catch (Exception exception) {
			System.out.println((new StringBuilder()).append("Auth Random")
					.append(exception.getMessage()).toString());
		}
	}

	private float getFloat() {
		if (random == null)
			return secrandom.nextFloat();
		else
			return random.nextFloat();
	}

	public final void generateRandomObject() throws Exception {
		if (secure)
			try {
				if (provider != null)
					random = SecureRandom.getInstance(algorithm, provider);
				else
					random = SecureRandom.getInstance(algorithm);
			} catch (NoSuchAlgorithmException nosuchalgorithmexception) {
				throw new Exception(nosuchalgorithmexception.getMessage());
			} catch (NoSuchProviderException nosuchproviderexception) {
				throw new Exception(nosuchproviderexception.getMessage());
			}
		else
			random = new Random();
	}

	private void generateRandom() {
		StringBuffer random = new StringBuffer();
		if (upper.size() == 3) {
			for (int i = 0; i < length.intValue(); i++){
				if ((int) (getFloat() * 100F) % 2 == 0){
					random.append(randomChar((Character) lower.get(2),(Character) upper.get(2)));
				} else if ((int) (getFloat() * 100F) % 2 == 0){
					random.append(randomChar((Character) lower.get(1),(Character) upper.get(1)));
				} else {
					random.append(randomChar((Character) lower.get(0),(Character) upper.get(0)));
				}
			}
		} else if (upper.size() == 2) {
			for (int i = 0; i < length.intValue(); i++){
				if ((int) (getFloat() * 100F) % 2 == 0){
					random.append(randomChar((Character) lower.get(1),(Character) upper.get(1)));
				} else {
					random.append(randomChar((Character) lower.get(0),(Character) upper.get(0)));			
				}
			}
		} else {
			for (int i = 0; i < length.intValue(); i++){
				random.append(randomChar((Character) lower.get(0),(Character) upper.get(0)));
			}
		}
		randomstr = random.toString();
	}


	private Character randomChar(Character character, Character character1) {
		int j = character.charValue();
		char c = character1.charValue();
		int i = (int) ((float) j + getFloat() * (float) (c - j));
		return new Character((char) i);
	}

	public final String getRandom() {
		randomstr = new String();
		generateRandom();
		if (hmap != null) {
			for (; hmap.containsKey(randomstr); generateRandom())
				;
			hmap.put(randomstr, null);
		}
		return randomstr;
	}

	public final void setLength(String s) {
		length = new Integer(s);
	}

	public final void setAlgorithm(String s) {
		algorithm = s;
		secure = true;
	}

	public final void setProvider(String s) {
		provider = s;
	}

	public final void setCharset(String charset) {
		boolean flag = true;
		lower = new ArrayList<Character>();
		upper = new ArrayList<Character>();
		if(charset==null||charset.equals("")){
			charset = "a-zA-Z0-9";
		}
		if (charset.charAt(1) == '-' && charset.charAt(0) != '\\'){
			while (flag && charset.charAt(1) == '-' && charset.charAt(0) != '\\') {
				lower.add(new Character(charset.charAt(0)));
				upper.add(new Character(charset.charAt(2)));
				
				if (charset.length() <= 3){
					flag = false;
				} else {
					charset = charset.substring(3);
				}
			}
		}
	}
}
