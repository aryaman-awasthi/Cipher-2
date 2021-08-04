import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

class key{
    private String encryptString;
    private Cipher cipher;
    private SecretKey secretKey;
    byte[] encryptedData;
    private Exception e;
    public key(String encryptString, Cipher cipher, SecretKey secretKey, byte[] encryptedData)
    {
        this.encryptString = encryptString;
        this.cipher = cipher;
        this.secretKey = secretKey;
        this.encryptedData = encryptedData;
    }
    public key(Exception e)
    {
        this.e = e;
    }
    public Cipher getCipher() {
        return cipher;
    }
    public Exception getE() {
        return e;
    }
    public String getEncryptString() {
        return encryptString;
    }
    public byte[] getEncryptedData() {
        return encryptedData;
    }
    public SecretKey getSecretKey() {
        return secretKey;
    }
    
}