package com.cypher.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.util.Base64;

import static java.lang.System.out;

/**
 * Created by adlerd on 4/4/17.
 */

@SuppressWarnings("Duplicates")
public class Crypto {

    private String str;
    private String algorithm = "AES";
    private String mode = "CBC";
    private String padding = "PKCS5Padding";
    private String encryptionMethod = algorithm + "/" + mode + "/" + padding;
    private byte[] data;



    /**
     * Constructor for encrypting a String
     *
     * @param data
     */
    public Crypto(final String data) {
        this.str = data;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getPadding() {
        return padding;
    }

    public void setPadding(String padding) {
        this.padding = padding;
    }

    /**
     * Method to encrypt input into a string
     *
     * @param key The encryption key generated to guide the encryption
     * @return
     * @throws Exception For any of the many exceptions that could be thrown
     */
    public String encryptToByteValues(final KeyFile key) throws Exception {
        data = str.getBytes();
        Cipher cipher = Cipher.getInstance(encryptionMethod);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return new String(cipher.doFinal(data));
    }

    /**
     * Method to decrypt input into a String
     *
     * @param key The encryption key generated to guide the encryption
     * @return
     * @throws Exception For any of the many exceptions that could be thrown
     */
    public String decryptToString(final KeyFile key) throws Exception {
//        data = Base64.getDecoder().decode(str);
        data = str.getBytes();
        Cipher cipher = Cipher.getInstance(encryptionMethod);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(data));
    }
}
