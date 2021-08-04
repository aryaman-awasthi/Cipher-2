import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
/*import java.io.BufferedReader;
import java.io.InputStreamReader;*/
import java.util.ArrayList;
import java.util.List;

class EncryptDecrypt {
    private static  final String UNICODE_FORMAT = "UTF-8";
    public static void main(String[] args) throws Exception
    {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        /*String data = bufferedReader.readLine();
        /*System.out.println("Original: "+data);
        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        System.out.println(encryptDecrypt.encrypt(data));*/
    }
    public List<key> encrypt(String DATA)
    {
        try
        {
            SecretKey secrKey = generateKey("AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] encryptedData = encryptString(DATA, secrKey,cipher);
            String encryptedString = new String(encryptedData);
            List<key> list = new ArrayList<key>();
            list.add(new key(encryptedString, cipher, secrKey, encryptedData));
            return list;
        }
        catch (Exception e)
        {
            List<key> list = new ArrayList<key>();
            list.add(new key(e));
            return list;
            
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

