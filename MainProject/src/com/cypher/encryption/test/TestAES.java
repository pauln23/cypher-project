package com.cypher.encryption.test;

/**
 * Created by adlerd on 4/9/17.
 */
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class StrongAES
{
    public void run()
    {
        try
        {
            String text = "Hello World";
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.err.println(Base64.getEncoder().encodeToString(encrypted));
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
            System.err.println(decrypted);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        StrongAES app = new StrongAES();
        app.run();
    }
}
