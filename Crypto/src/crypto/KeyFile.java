package crypto;

/**
 * Created by adlerd on 3/2/17.
 */

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyFile {
    private String rawKey;
    private String salt = "wTmg4qj8dNszs2ji";
    private int keyID;

    public KeyFile(final String rawKey, final int keyID) {
        this.rawKey = rawKey;
        this.keyID = keyID;
    }

    public KeyFile(final String rawKey, final int keyID, final KeyFile keyFile) {
        this.rawKey = rawKey;
        this.keyID = keyID;
        this.salt = keyFile.wrappedKey();
    }

    public String getKey() throws NoSuchAlgorithmException {
        String output = "";
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] md5 = md.digest(rawKey.getBytes());
        final byte[] saltBytes = this.salt.getBytes();
        int i = 0;
        for (final byte b : md5) {
//            output += StringUtil.reverseString(Integer.toHexString(b & saltBytes[i]).substring(0, 1));
            if(i < (salt.length() -1)) {
                i++;
            }
            else {
                i = 0;
            }
        }
        if(output.length() > 16){
            return output.substring(0,16).trim();
        }
        else {
            return output.trim();
        }
    }

    public String wrappedKey(){
        try {
            return getKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public void writeToFile() {
//        final File file = new File(FileUtil.getLacedDir(), String.format("key%s.key", this.keyID));
//        FileUtil.writeToFile(this.wrappedKey().getBytes(), file);
//    }
}