package crypto;

/**
 * Created by adlerd on 3/2/17.
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by HUE on 8/25/13.
 */
public class CryptedFile {
    private File file;
    private byte[] data;

    public CryptedFile(final File file) {
        this.file = file;
    }

    public CryptedFile(final byte[] data) {
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
        byte[] preData = null;
        if(file != null){
            preData = new byte[(int) this.file.length()];
            out.println("Pre-Data byte[]: " + Arrays.toString(preData));
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