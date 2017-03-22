package com.cypher.encryption;

/**
 * Created by Zachery Shelton on 8/25/13.
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

public class ORIGINAL_EncryptFile {
    private File file;
    private byte[] data;

    public ORIGINAL_EncryptFile(final File file) {
        this.file = file;
    }

    public ORIGINAL_EncryptFile(final byte[] data) {
        this.data = data;
    }

    public byte[] decryptToData(final KeyFile key) throws Exception {
        byte[] preData = null;
        if(file != null){
            preData = new byte[(int) this.file.length()];
            final FileInputStream inputStream = new FileInputStream(this.file);
            inputStream.read(preData);
        } else {
            preData = data;
        }
        final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),"AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(preData);
    }

    public File decryptToFile(final KeyFile key, final File file) throws Exception {
        final FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(decryptToData(key));
        return file.getAbsoluteFile();
    }

    public byte[] encryptToData(final KeyFile key) throws Exception {
        // Initialize byte[] as null
        byte[] preData = null;
        // If the file is a real thing
        if(file != null){
            // Set the amount of 0s in 'preData' to the length of the text in the file
            preData = new byte[(int) this.file.length()];
            //
            final FileInputStream inputStream = new FileInputStream(this.file);
            inputStream.read(preData);
        } else {
            preData = data;
        }
        final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        final SecretKeySpec secretKey = new SecretKeySpec(key.wrappedKey().getBytes(),"AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(preData);
    }

    public File encryptToFile(final KeyFile key, final File file) throws Exception {
        final FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(encryptToData(key));
        return file.getAbsoluteFile();
    }
}