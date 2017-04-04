package com.cypher.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by nickpaul on 3/4/17.
 */



public class Decrypt {

    //variables
    private String encryptedString;
    private String decryptedString;
    private KeyFile key;
    private byte[] encryptedData;
    private String binaryString;
    private byte[] decryptedData;

    private String algorithm;
    private String mode;
    private String padding;
    private String encryptionMethod;

    //constructor to make decrypt object with parameter of String and parameter of key
    public Decrypt(final Encrypt encryptObj ,final String data, final KeyFile key){
        this.encryptedString = data;
        this.encryptedData = encryptedString.getBytes();
        this.key = key;
        padding = encryptObj.getPadding();
        algorithm = encryptObj.getAlgorithm();
        mode = encryptObj.getMode();

        encryptionMethod = algorithm + "/" + mode + "/" + padding;

        System.out.println(encryptedString);
    }


    //method to take encrypted string and decrypt
    public String decryptToByteValues() throws Exception {
        final Cipher cipher = Cipher.getInstance(encryptionMethod);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);



        decryptedString = new String(cipher.doFinal(encryptedData), "UTF-8");
        return decryptedString;
    }




}
