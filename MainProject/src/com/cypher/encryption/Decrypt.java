//package com.cypher.encryption;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.File;
//import java.util.Base64;
//
///**
// * Created by adlerd on 3/4/17.
// */
//public class Decrypt{
//
//    private String str;
//    private String algorithm = "AES";
//    private String mode = "ECB";
//    private String padding = "PKCS5Padding";
//    private String encryptionMethod = algorithm + "/" + mode + "/" + padding;
//    private byte[] data;
//    private File fileIn;
//    private File fileOut;
//
//
//    public String getAlgorithm() {
//        return algorithm;
//    }
//
//    public void setAlgorithm(String algorithm) {
//        this.algorithm = algorithm;
//    }
//
//    public String getMode() {
//        return mode;
//    }
//
//    public void setMode(String mode) {
//        this.mode = mode;
//    }
//
//    public String getPadding() {
//        return padding;
//    }
//
//    public void setPadding(String padding) {
//        this.padding = padding;
//    }
//
//
//    /**
//     * Constructor for encrypting a String
//     *
//     * @param data
//     */
//
//    public Decrypt(final String data) {
//        this.str = data;
//    }
//
//    /**
//     * Constructor for encrypting a byte[] of data
//     *
//     * @param data
//     */
//    public Decrypt(final byte[] data) {
//        this.data = data;
//    }
//
//    /**
//     * Constructor for encrypting the contents of 'fileIn' and then outputting it to 'fileOut'
//     *
//     * @param fileIn
//     */
//    public Decrypt(File fileIn) {
//        this.fileIn = fileIn;
//    }
//
//    /**
//     * Consgtructor for encrypting the contents of 'fileIn' and then outputting it to 'fileOut'
//     *
//     * @param fileIn
//     * @param fileOut
//     */
//    public Decrypt(File fileIn, File fileOut) {
//        this.fileIn = fileIn;
//        this.fileOut = fileOut;
//    }
//
//    /**
//     *
//     * @param key The encryp tion key generated to guide the encryption
//     * @return
//     * @throws Exception For any of the many exceptions that could be thrown
//     */
//    public String decryptToString(final KeyFile key) throws Exception {
//        data = Base64.getDecoder().decode(str);
//        final Cipher cipher = Cipher.getInstance(encryptionMethod);
//        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//        return new String(cipher.doFinal(data), "UTF-8");
//    }
//
//    public byte[] decryptToBytes(final KeyFile key) throws Exception {
//        data = Base64.getDecoder().decode(str);
//        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
//        cipher.init(Cipher.DECRYPT_MODE, secretKey);
//        return cipher.doFinal(data);
//    }
//}
