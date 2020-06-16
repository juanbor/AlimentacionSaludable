package dominio;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class ContraseniaUtils {
  private static final int ITERATIONS = 65536;
  private static final int KEY_LENGTH = 512;
  private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
  
  private ContraseniaUtils(){
      throw new IllegalStateException("Utility Class");
  }

  public static Optional<String> generateSalt (final int length) {

    if (length < 1) {
      Logger.getGlobal().log(Level.SEVERE, "Error generating salt");
      return Optional.empty();
    }

    byte[] salt = new byte[length];

    return Optional.of(Base64.getEncoder().encodeToString(salt));
  }

  

  public static Optional<String> hashPassword (String password, String salt) {

    char[] chars = password.toCharArray();
    byte[] bytes = salt.getBytes();

    PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);

    Arrays.fill(chars, Character.MIN_VALUE);

    try {
      SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
      byte[] securePassword = fac.generateSecret(spec).getEncoded();
      return Optional.of(Base64.getEncoder().encodeToString(securePassword));

    } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
      Logger.getGlobal().log(Level.SEVERE, "Error hashing password "+ ex.toString());
      return Optional.empty();

    } finally {
      spec.clearPassword();
    }
  }
  
  public static boolean verifyPassword (String password, String key, String salt) {
    Optional<String> optEncrypted = hashPassword(password, salt);
    if (!optEncrypted.isPresent()) return false;
    return optEncrypted.get().equals(key);
  }
  
}