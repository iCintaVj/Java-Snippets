import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import com.sun.management.OperatingSystemMXBean;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.xml.bind.DatatypeConverter;

public class Test {
	private static final ExecutorService pool = Executors.newFixedThreadPool(3);
	private static  int encryptionKeyLength;
	private static  int encryptionBits;
	private static  int messageSize;
	private static String encryptionKey = "";
	private static String plainText = "";
	private static final String characterEncoding = "UTF-8";
	private static final String cipherTransformation = "AES/CBC/PKCS5PADDING";
	private static final String aesEncryptionAlgorithem = "AES";

	public static String encrypt(String plainText) {
		String encryptedText = "";
		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
			keygenerator.init(encryptionBits, new SecureRandom(encryptionKey.getBytes()));
			SecretKey generatedKey = keygenerator.generateKey();
			Cipher cipher = Cipher.getInstance(cipherTransformation);
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
			KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
			keygenerator.init(encryptionBits, new SecureRandom(encryptionKey.getBytes()));
			SecretKey generatedKey = keygenerator.generateKey();
			Cipher cipher = Cipher.getInstance(cipherTransformation);
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

	private static void printStats(String type) {
		OperatingSystemMXBean operatingSystemMXBean = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean());

		double currentCpu = operatingSystemMXBean.getProcessCpuLoad();
		double availableProcessors = operatingSystemMXBean.getAvailableProcessors();

		System.out.println("CPU Used : " + type + (currentCpu / availableProcessors) * 100);

		double freeMemory = (double) operatingSystemMXBean.getFreePhysicalMemorySize();
		double totalMemory = (double) operatingSystemMXBean.getTotalPhysicalMemorySize();
		System.out.println("Memory Used : " + type + (double) (((totalMemory - freeMemory) / totalMemory) * 100));

		System.out.println("Heap Memory Used : " + type + ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed());
		System.out.println("Non Heap Memory Used : " + type + ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage().getUsed());

	}

	private static void test(int keyLength, String plainText) {

//		pool.submit(new Thread(new Runnable() {
//			@Override
//			public void run() {
				long startTime = System.currentTimeMillis(), endTime = 0L;
				String encyptStr = encrypt(plainText);
				endTime = System.currentTimeMillis();
				long timeTaken = (endTime - startTime);
				System.out.println("Time taken to perform encryption is :" + timeTaken);
				printStats("Encrypt : ");
//			}
//		}));

		// pool.submit(new Thread(new Runnable() {
		// @Override
		// public void run() {
		// long startTime = System.currentTimeMillis(),
		// endTime = 0L;
		// String cipherText =
		// decrypt("x/0YNcigt6KxWBy3QJeG1+qFJVZXZ/LWvGG6FD3VVaKlN3WMqqnDxgpsVAQBlNilXll1T5mEs5257XDLUXTAJTGz6pttf2xYb+A3K+U9B0ZGoRPmew0S1YjTGAMGEZvLBg27xEz7LZeK+HPiXOQnPozcCrK3BgJHvcrQoq0O/ofsTiIVVSJm2OnQ8Y7FuJlkFkaG/coowk+hOO5f05i8vV3GU5mFG1EH232rc/13YfywwTn+csCz0qQkUpC9DgwRLT2Fetx2nx1e6vhphEA6T/WNQCEd5g809QR2uUP7uKjweCa89Ky7CHVRvropE4lo4wu3Z3zxODMFkJWC9M4iE+ee31lXvQNEnvej/HWjDIs6KAfoCvz0w95GlCGJkQSnuNU5C1nEBvV0HDrjRgbpQSo93dF9wB9wmO+jXTh7Dw68Hro5Ih438dvav2vS283yRMS5sKCXAS15hLtOfSU+dNbAJAUt+g8SZskQc+y3U4yf9A7EOP46R9+yARypu/Aicg3vpMGGRAMLfCjek+JFrX/sTkLH5AtNrwTQzuG3ddcdojc7xBBX2IfvAQ8m14yREeJZv45xxphn/2t40guYtHw++THU6wm/fchbyD58AKhThtA+hPA0LYL0jGEQxKMVUa/dbclx+MGbj+u4IuFmphhNvPEln9VwkmwebsGuM2kI6aSvGI30OVwU1c+/NR/KQ9ftUQGYTCddQtVK0y4+GloBKmzUpfd3ar7Sgz8etDzyc53l4p6zSjztZ69wxrlMV/W+H7RM2X+TRQ0o5YxNIPMdulTiSKSZb1n9oHyJ2ORwXlqP61n6O838JYeBl5fXN7s/cfVTBj0uvldjEvlNFN5RHMTWwSkioxuJD8Z0vSzJ4zG9nqkhfBS96JbPADVsYAluj4Ji9q9CELoH1UFe/zyXB8RL5oQkPmSRcZrjpQpvT1zDZpbaDrckj4N28y780kICYrz11S/sLSDA2CkO0s1uUkKIY05BQw8SIfHeD8KBNxvXWEsCo4E81lUHgiXzUW/TX0d3+QRNPOEAmK3WeZhOV8ZygR70G8b8m1rKOz6YMzeiXxgrKTsqi1LWp1ibXL92VfiUIrF8YwovOhYV6HhpOiEA959i4yBwWvt9YTlquMNU9tAKShWqlDTUKX7rtadX5X9x6XItbOwlGFWdw7Lmre/xWpKeO/c6AngtllG/f/xY7jJxIBYAuXj5DiE8G16jAQRqtupVbYVBVYWkDfZjH7bInAnMs/VSgFv9eRAYpryLtz+BGnDHsOk27cX0C/MS9XyNX4Igiai0tMJShVJ6pTp1rQGO4SbNIE7OdSFXw5gHSH3BF5Nhe9PHj3jXoEGqvJ4aDrYw6jNRGHlGcGA8KK0FEgDEk0EO8qJI7lc=");
		// endTime = System.currentTimeMillis();
		// long timeTaken = (endTime - startTime);
		// System.out.println("Time taken to perform decryption is :" + timeTaken);
		// printStats("Decrypt : ");
		// }
		// }));

	}

	public static void main(String args[]) throws Exception {
		
		encryptionKeyLength = Integer.parseInt(args[0]);
		encryptionBits = Integer.parseInt(args[1]);
		messageSize = Integer.parseInt(args[2]);

		char[] chars = new char[messageSize * 1000000];
		Arrays.fill(chars, 'V');
		plainText = new String(chars);

		chars = new char[encryptionKeyLength];
		Arrays.fill(chars, '1');
		encryptionKey = new String(chars);

		test(128, plainText);
	}
}
