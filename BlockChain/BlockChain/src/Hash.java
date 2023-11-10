package BlockChain.src;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Class that provides the hash (array of bytes) for each block in the block chain
 * 
 * @author Noah Mendola and Albert-Kenneth Okine
 */
public class Hash {

  /** The byte array. */
  byte[] hash;

  /** Make a new Hash with the given byte array of data. */
  public Hash(byte[] data) {
    try {
      this.hash = calculateHash(new String(data, StandardCharsets.UTF_8));
    } catch (NoSuchAlgorithmException e) {
      System.out.print("exception \n");
    }
  } // Hash(byte[])

  /** Returns the hash contained in this object. */
  public byte[] getData() {
    return this.hash;
  } // getData

  /**
   * Returns true if the hsah meets the criteria for validity, i.e., its first three indices contain
   * zeroes.
   */
  public boolean isValid() {
    return ((0x0 == this.hash[0]) && (0x0 == this.hash[1]) && (0x0 == this.hash[2]));
  } // isValid()

  /**
   * 
   * @param hash byte of arrays
   * @return returns the string representation of the hash as a string of hexadecimal digits, 2
   *         digits per byte.
   */
  public String toString() {
    // StringBuffer hexStringBuffer = new StringBuffer();
    // for (int i = 0; i < hash.length; i++) {
    //   hexStringBuffer = hexStringBuffer.append(toStringHelper(hash[i]));
    // }
    // return hexStringBuffer.toString();
    
    String returnString = "";
    for (byte chomp : this.hash) returnString += 
      String.format("%x", (new Byte(chomp)).toUnsignedInt(chomp));
    return (returnString.equals("")) ? "null" : returnString;
  }


  /**
   * @param other object being compared to our hash
   * @return returns true if the given object is the same as our hash
   */
  public boolean equals(Object other) {
    if (other instanceof Hash) {
      Hash o = (Hash) other;
      if (Arrays.equals(o.hash, hash)) {
        return true;
      }
      return false;
    } else {
      return false;
    }
  }

  /**
   * @param msg
   * @return returns array of bytes calculated by the message digest
   * @throws NoSuchAlgorithmException
   */
  public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(msg.getBytes());
    return md.digest();
  } // calculateHash(String)

  public static void main(String[] args) {
    Hash newHash = new Hash("Hello".getBytes());
    System.out.println(newHash.toString());

    System.out.println(new Hash(null));
  } // main

} // class Hash
