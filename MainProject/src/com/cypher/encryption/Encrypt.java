package com.cypher.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;


/**
 * Created on 3/4/17.
 *
 *  Class to encrypt a string or file contents using one of the encryption methods below.
 *
 *
 *
 * Every implementation of the Java platform is required to support the following
 * standard Cipher transformations with the keysizes in parentheses:
 *
 *      NOTE: As of 3/19/2017 I am pretty sure only the 128 bit keysizes work right now...
 *      TODO: Figure out if DES or AES can successfully encrypt and decrypt a test string.
 *
 *      ** Format **
 *      'Algorithm'/'Mode'/'Padding'
 *
 *      ** These work **
 *      AES/CBC/NoPadding (128)
 *      AES/CBC/PKCS5Padding (128)
 *      AES/ECB/NoPadding (128)
 *      AES/ECB/PKCS5Padding (128)
 *
 *      ** Pretty sure these need this class (or KeyFile.java) to be tweaked to work **
 *      DES/CBC/NoPadding (56)
 *      DES/CBC/PKCS5Padding (56)
 *      DES/ECB/NoPadding (56)
 *      DES/ECB/PKCS5Padding (56)
 *      DESede/CBC/NoPadding (168)
 *      DESede/CBC/PKCS5Padding (168)
 *      DESede/ECB/NoPadding (168)
 *      DESede/ECB/PKCS5Padding (168)
 *      RSA/ECB/PKCS1Padding (1024, 2048)
 *      RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
 *      RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
 *
 *
 *      NOTE: Possible to do...
 *      TODO: Split into two classes 'EncryptString.java' and 'ORIGINAL_EncryptFile.java'
 *
 *
 */


@SuppressWarnings("Duplicates")
public class Encrypt {

    private String str;
    private String algorithm = "AES";
    private String mode = "ECB";
    private String padding = "PKCS5Padding";
    private String encryptionMethod = algorithm + "/" + mode + "/" + padding;
//    private String pathIn;
//    private String pathOut;
    private byte[] data;
    private File fileIn;
    private File fileOut;

    /**
     * Constructor for
     *
     * @param data
     */
    public Encrypt(final String data) {
        this.str = data;
    }

    /**
     *
     * @param data
     */
    public Encrypt(final byte[] data) {
        this.data = data;
    }

    /**
     * Coctructor for encrypting the contents of 'fileIn' and then outputting it to 'fileOut'
     *
     * @param fileIn
     */
    public Encrypt(File fileIn) {
        this.fileIn = fileIn;
    }

    /**
     * Coctructor for encrypting the contents of 'fileIn' and then outputting it to 'fileOut'
     *
     * @param fileIn
     * @param fileOut
     */
    public Encrypt(File fileIn, File fileOut) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    /**
     * Get the algorithm used
     *
     * @return the algorithm used as a String
     */
    public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Get the mode used
     *
     * @return mode used as a String
     */
    public final String getMode() {
        return mode;
    }

    /**
     * get the padding used
     *
     * @return the padding used as a String
     */
    public final String getPadding() {
        return padding;
    }

    /**
     *
     *
     * @return
     */
    public String getEncryptionMethod() {
        return encryptionMethod;
    }

    /**
     *
     * @return
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     *
     * @return
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     *
     * @return
     */
    public void setPadding(String padding) {
        this.padding = padding;
    }

    /**
     *
     * @return
     */
    public void setEncryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    /**
     * Method to encrypt the input into
     *
     * @param key The encryption key generated to guide the encryption
     * @return
     * @throws Exception For any of the many exceptions that could be thrown
     */
    public String encryptToByteValues(final KeyFile key) throws Exception {
        data = str.getBytes();
        final Cipher cipher = Cipher.getInstance(encryptionMethod);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Arrays.toString(cipher.doFinal(data));
    }

    /**
     *
     * @param key The encryption key generated to guide the encryption
     * @return
     * @throws Exception For any of the many exceptions that could be thrown
     */
    public byte[] encryptToByteArr(final KeyFile key) throws Exception {
        data = str.getBytes();
        final Cipher cipher = Cipher.getInstance(encryptionMethod);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    /**
     * Encrypt a file and then
     *
     * @param key The encryption key generated to guide the encryption
     * @return A file that contains the encrypted output of whatever was inputted
     * @throws Exception For any of the many exceptions that could be thrown
     */
    public File encryptToFile(final KeyFile key) throws Exception {
        byte[] preData;
        // Check if the file is not null
        if (fileIn != null) {
            // create tem array with the length of the input in 0s
            preData = new byte[(int) this.fileIn.length()];
            final FileInputStream inputStream = new FileInputStream(this.fileIn);
            // Read
            inputStream.read(preData);
        }
        else
            preData = data;

        final Cipher cipher = Cipher.getInstance(algorithm + "/" + mode + "/" + padding);
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        final FileOutputStream outputStream = new FileOutputStream(fileOut);
        outputStream.write(cipher.doFinal(data));
        return fileOut.getAbsoluteFile();
    }

}
