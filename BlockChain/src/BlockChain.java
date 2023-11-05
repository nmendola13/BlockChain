package BlockChain.src;

public class BlockChain {
  Node first;
  Node last;

  public static class Node {
    Block data;
    Node nextNode;
  }

  public BlockChain (int initial){
    Block firstBlock = new Block(0, initial, getHash());
    this.first.data = firstBlock;
    this.last.data = firstBlock;
  }

  public Block mine(int amount){
    Block 
    last.nextNode = 
  }

  public int getSize(){

  }

  public void append(Block blk){

  }

  public boolean removeLast(){

  }

  public Hash getHash() {

  }

  public boolean isValidBlockChain(){

  }

  public void printBalances(){

  }

  public String toString(){

  }

}
