package com.cypher.encryption;

/**
 * Created by adlerd on 3/2/17.
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by HUE on 8/25/13.
 */
public class EncryptString {
    private String str;
    private byte[] data;

    public EncryptString(final String data) {
        this.str = str;
    }

    public EncryptString(final byte[] data) {
        this.data = data;
    }

    public byte[] encryptToDataAES(final KeyFile key) throws Exception {
        out.println(Arrays.toString(str.getBytes()));
        byte[] preData = str.getBytes();
        final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(preData);
    }

    public String encryptToStringAES(final KeyFile key) throws Exception {
        out.println(Arrays.toString(str.getBytes()));
        byte[] preData = str.getBytes();
        final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.toString();
    }


    public byte[] encryptToDataCustom(final KeyFile key, String cipherMethod) throws Exception {
        out.println(Arrays.toString(str.getBytes()));
        byte[] preData = str.getBytes();
        final Cipher cipher = Cipher.getInstance(cipherMethod);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(preData);
    }

    public String encryptToStringCustom(final KeyFile key, String cipherMethod) throws Exception {
        out.println(Arrays.toString(str.getBytes()));
        byte[] preData = str.getBytes();
        final Cipher cipher = Cipher.getInstance(cipherMethod);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.toString();
    }


}