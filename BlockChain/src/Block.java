package BlockChain.src;

public class Block {
  
  int num;
  int amount;
  Hash prevHash;
  long nonce;
  Hash hash;

  public Block (int num, int amount, Hash prevHash) {

  }

  public Block (int num, int amount, Hash prevHash, long nonce) {
    
  }

  public int getNum() {
    return this.num;
  }

  public int getAmount() {
    return this.amount;
  }

  public long getNonce() {
    return this.nonce;
  }

  public Hash getPrevHash() {
    return this.prevHash;
  }

  public Hash getHash() {
    return this.hash;
  }

  public String toString() {
    return "";
  }


}
