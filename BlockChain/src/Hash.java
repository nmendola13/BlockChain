package BlockChain.src;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
  
  byte[] hash;

  public Hash (byte[] data) {

  }

  public byte[] getData() {
    return this.hash;
  }

  public boolean isValid() {
      return (this.hash)
  }

  public String toString() {
    for()
  }

  public boolean equals(Object other) {
    return hash.equals(other);
  }

  public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(msg.getBytes());
    return md.digest();
    // Remaining implementation below...
} // calculateHash(String)

}