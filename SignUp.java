import java.io.*;
import java.util.ArrayList;
import java.util.List;
class SignUp
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Email: ");
        String email = br.readLine();
        System.out.print("\nPassword: ");
        String pass = br.readLine();
        
        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        List<key> e_email = new ArrayList<key>();
        e_email = encryptDecrypt.encrypt(email);

        List<key> e_pass = new ArrayList<key>();
        e_pass = encryptDecrypt.encrypt(pass);

        key e = e_email.get(0);
        key p = e_pass.get(0);

        String encrEmail = e.getEncryptString();
        String encrPass = p.getEncryptString();
        System.out.println("\nEncrypted Email: "+encrEmail+"\nEncrypted Password: "+encrPass);
       
        String orgiEmail = encryptDecrypt.decryptString(e.getEncryptedData(), e.getSecretKey(), e.getCipher());
        String orgiPass = encryptDecrypt.decryptString(p.getEncryptedData(), p.getSecretKey(), p.getCipher());
        System.out.println("\nDecrypted Email: "+orgiEmail+"\nDecrypted Password: "+orgiPass);
       
    

    }
}