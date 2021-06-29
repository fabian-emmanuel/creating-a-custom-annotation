import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String passwordToHash = "myPassword";
        byte[] salt = createSalt();
        String securePassword = get_SecurePassword(passwordToHash, salt);
        System.out.println("Salted Hash Password : " + securePassword);


        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String mySecurePassword = bcrypt.encode("MySaltedPassword");

    }

    // To encode a given rawPassword

    private static String get_SecurePassword(String passwordToHash, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            System.out.println("Bytes : " + Arrays.toString(bytes));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;

    }

    private static byte[] createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}
