package BlockChain.src;

import java.nio.ByteBuffer;

/** 
 * The data contained in each node of the blockchain. Note that the
 * block itself does not contain links to other blocks in the chain;
 * instead, the block will be wrapped in a Node class with the links.
 * 
 * @author Noah Mendola and Albert-Kenneth Okine
 */
public class Block {
  
  /** The number of the block in the blockchain. */
  int num;
  /** The data, i.e., the amount transferred between the two parties. */
  int amount;
  /** The hash of the previous block in the chain. */
  Hash prevHash;
  /** The nonce. */
  long nonce;
  /** The hash of this block. */
  Hash hash;

  /** 
   * Creates a new block from the specified parameters, performing the
   * mining operation to discover the nonce and hash for this block given
   * these parameters.
   */
  public Block (int num, int amount, Hash prevHash) {
    // Use the paramters to initialize each field of this block.
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    // Based on the parameters, determine the hash of the block and set it.
    this.hash = new Hash(ByteBuffer.allocate(4)
                                   .putInt(this.amount)
                                   .array());
  } // Block(int, int, Hash)

  /** 
   * Creates a new block from the specified parameters, using the provided
   * nonce and additional parameters to generate the hash for the block.
   * Because the nonce is provided, this constructor does not need to
   * perform the mining operation; it can compute the hash directly.
   */
  public Block (int num, int amount, Hash prevHash, long nonce) {
    // Use the paramters to initialize each field of this block.
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;
    // Based on the parameters, determine the hash of the block and set it.
    this.hash = new Hash(ByteBuffer.allocate(4)
                                   .putInt(this.amount)
                                   .array());
  } // Block(int, int, Hash, long)

  /** 
   * Returns the number of this block.
   */
  public int getNum() {
    return this.num;
  } // getNum()

  /** 
   * Returns the amoutn transferred that is recorded in this block.
   */
  public int getAmount() {
    return this.amount;
  } // getAmount()

  /** 
   * Returns the nonce of this block.
   */
  public long getNonce() {
    return this.nonce;
  } // getNonce()

  /** 
   * Returns the hash of the previous block in the blockchain. 
   */
  public Hash getPrevHash() {
    return this.prevHash;
  } // getPrevHash()
  
  /** 
   * Returns the hash of this block. 
   */
  public Hash getHash() {
    return this.hash;
  } // getHash

  /** 
   * Returns a string representation of the block.
   * 
   * <pre>
   * Block <num> (Amount: AMT, Nonce: NONCE, prevHash: PREV, hash: HASH)
   * </pre>
   */
  public String toString() {
    return String.format(
      "Block %d (Amount: %d, Nonce: %d, prevHash: %s, hash: %s)",
      this.num, this.amount, this.prevHash, this.hash);
  } // toString()

} // class Block
