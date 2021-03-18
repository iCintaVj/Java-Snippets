
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.xml.bind.DatatypeConverter;

public class Test {

	private static final int encryptionKeyLength = 100;
	private static String encryptionKey = "";
	private static final String characterEncoding = "UTF-8";
	private static final String cipherTransformation = "AES/CBC/PKCS5PADDING";
	private static final String aesEncryptionAlgorithem = "AES";

	static{
		for (int i=0; i < encryptionKeyLength; i++) {
			encryptionKey += "1";
		}
	}

	public static String encrypt(String plainText) {
		String encryptedText = "";
		try {
			
			KeyGenerator keygenerator 
            = KeyGenerator.getInstance("AES"); 
        keygenerator.init(256, new SecureRandom(encryptionKey.getBytes())); 
        SecretKey generatedKey =keygenerator.generateKey(); 
			
			Cipher cipher = Cipher.getInstance(cipherTransformation);
			byte[] key = encryptionKey.getBytes(characterEncoding);
			SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
			IvParameterSpec ivparameterspec = new IvParameterSpec(new byte[16]);
			cipher.init(Cipher.ENCRYPT_MODE, generatedKey, ivparameterspec);
			byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
			Base64.Encoder encoder = Base64.getEncoder();
			encryptedText = encoder.encodeToString(cipherText);

		} catch (Exception E) {
			System.err.println("Encrypt Exception : " + E.getMessage());
		}
		return encryptedText;
	}

	public static String decrypt(String encryptedText) {
		String decryptedText = "";
		try {
			
			KeyGenerator keygenerator 
            = KeyGenerator.getInstance("AES"); 
  
        keygenerator.init(256, new SecureRandom(encryptionKey.getBytes())); 
        SecretKey generatedKey =keygenerator.generateKey(); 
			
			Cipher cipher = Cipher.getInstance(cipherTransformation);
			byte[] key = encryptionKey.getBytes(characterEncoding);
			SecretKeySpec secretKey = new SecretKeySpec(key, aesEncryptionAlgorithem);
			IvParameterSpec ivparameterspec = new IvParameterSpec(new byte[16]);
			cipher.init(Cipher.DECRYPT_MODE, generatedKey, ivparameterspec);
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] cipherText = decoder.decode(encryptedText.getBytes("UTF8"));
			decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");

		} catch (Exception E) {
			System.err.println("decrypt Exception : " + E.getMessage());
		}
		return decryptedText;
	}

	public static void test(int keyLength) throws Exception {
		String plainText = "The quick brown fox jumps over the lazy dog.";
		long startTime = System.currentTimeMillis(), endTime = 0L;
		String encyptStr = encrypt(plainText);
		endTime = System.currentTimeMillis();

		System.out.println("Time taken to perform encryption is :" + (endTime - startTime));

		startTime = System.currentTimeMillis();
		String cipherText = decrypt(encyptStr);
		endTime = System.currentTimeMillis();

		System.out.println("Time taken to perform decryption is :" + (endTime - startTime));
	}

	public static void main(String args[]) throws Exception {
		test(128);
//		 test(192);
//		 test(256);

		OperatingSystemMXBean operatingSystemMXBean = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean());

		double currentCpu = operatingSystemMXBean.getSystemLoadAverage();
		int availableProcessors = operatingSystemMXBean.getAvailableProcessors();

		long freeMemory = operatingSystemMXBean.getFreePhysicalMemorySize();
		long totalMemory = operatingSystemMXBean.getTotalPhysicalMemorySize();

		System.out.println(freeMemory);
		System.out.println(totalMemory);
		System.out.println(totalMemory - freeMemory);

		System.out.println(currentCpu);
		System.out.println(availableProcessors);
		System.out.println(currentCpu / availableProcessors);

	}
}
