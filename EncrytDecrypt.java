import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class EncryptDecrypt {
    private static  final String UNICODE_FORMAT = "UTF-8";
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String data = bufferedReader.readLine();
        System.out.println("Original: "+data);
        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        encryptDecrypt.encryptDecrypt(data);
    }
    public void encryptDecrypt(String DATA)
    {
        try
        {
            /**
             * Encryption type changed by Aryaman A.
             * AES -> DES
             * Branch: feature1
             * Master branch: No change
             */
            SecretKey key = generateKey("DES");
            Cipher cipher = Cipher.getInstance("DES");

            byte[] encryptedData = encryptString(DATA, key,cipher);
            String encryptedString = new String(encryptedData);
            System.out.println("Encrypted: "+encryptedString);
            String decryptedString = decryptString(encryptedData, key,cipher);
            System.out.println("Decrypted: "+decryptedString);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static SecretKey generateKey(String encryptionType)
    {
        try
        {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(encryptionType);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static byte[] encryptString(String dataToEncrypt, SecretKey secretKey, Cipher cipher)
    {
        try {
            byte[] bytes = dataToEncrypt.getBytes(UNICODE_FORMAT);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] textEncrypted = cipher.doFinal(bytes);
            return textEncrypted;
        }
        catch (Exception e)
        {
            return null;
        }

    }
    public static String decryptString(byte[] dataToDecrypt, SecretKey secretKey, Cipher cipher)
    {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] textDecrypted = cipher.doFinal(dataToDecrypt);
            String result = new String(textDecrypted);
            return result;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}

