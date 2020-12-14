package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Md5Util {

    private Md5Util() {
    }

    public static String encodeByMd5(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] byteArray = md5.digest(password.getBytes());
        return byteArrayToHexString(byteArray);
    }

    private static String byteArrayToHexString(byte[] byteArray) {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte b : byteArray) {
            String hex = byteToHexString(b);
            stringBuffer.append(hex);
        }

        return stringBuffer.toString();
    }

    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n/16;
        int d2 = n%16;
        return hex[d1] + hex[d2];
    }

    private static String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

}
