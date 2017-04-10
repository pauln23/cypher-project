//package com.cypher.utils;
//

//
//import java.io.File;
//import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import static java.lang.System.out;
//
//@SuppressWarnings("Duplicates")
//public class ORIGINAL_KeyFile {
//    private String rawKey;
//    private String salt = "wTmg4qj8dNszs2ji";
////    private String salt = null;
//    private int keyID;
//
//    public ORIGINAL_KeyFile(final String rawKey, final int keyID) {
//        this.rawKey = rawKey;
//        this.keyID = keyID;
//    }
//
//    public ORIGINAL_KeyFile(final String rawKey, final int keyID, final ORIGINAL_KeyFile keyFile) {
//        this.rawKey = rawKey;
//        this.keyID = keyID;
//        this.salt = keyFile.wrappedKey();
//    }
//
//    // Set custom salt
//    public void setSalt(String salt){
//        this.salt = salt;
//    }
//
//    private String getKey() throws NoSuchAlgorithmException {
//        String output;
//        final MessageDigest md = MessageDigest.getInstance("MD5");
//        final byte[] md5 = md.digest(rawKey.getBytes());
////         Turn the salt String into byte[]
//        final byte[] saltBytes = this.salt.getBytes();
//        int i = 0;
//
//        out.print("\n[DEBUG] KeyFile: ");
//        StringBuilder outputBuilder = new StringBuilder();
//        for (final byte b : md5) {
//            outputBuilder.append(Integer.toHexString(b & saltBytes[i]).substring(0, 1));
//            out.print("" + Integer.toHexString(b & saltBytes[i]).substring(0, 1));
//            if(i < (salt.length() -1)) {
//                i++;
//            }
//            else {
//                i = 0;
//            }
//        }
//        output = outputBuilder.toString();
//        out.println("\n");
//        if(output.length() > 16){
//            return output.substring(0,16).trim();
//        }
//        else {
//            return output.trim();
//        }
//    }
//
//    String wrappedKey() {
//        try {
//            return getKey();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void writeToFile(String path) throws IOException{
//        final File file = new File(path, String.format("key%s.key", this.keyID));
//        FileUtil.writeToFile(this.wrappedKey().getBytes(), file);
//    }
//}