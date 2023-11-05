package BlockChain.src;

public class BlockChain {
  Node first;
  Node last;

  public static class Node {
    Block data;
    Node nextNode;

    public Node(Block data, Node prevNode) {
      Block newData;
      prevNode.nextNode = this;
    }
    
  }

  public BlockChain (int initial){
    Block firstBlock = new Block(0, initial, getHash());
    this.first.data = firstBlock;
    this.last.data = firstBlock;
  }

  public Block mine(int amount){
    Block newBlock = new Block(amount, amount, getHash(), amount);
    Node newNode = new Node(newBlock, last);
    return newBlock;
  }

  public int getSize(){
    int i = 1;
    while (this.nextNode =! null) {
      this.nextNode = this;
      i++;
    }
    return i;
  }

  public void append(Block blk){
    Node newNode = new Node(blk, last);
  }

  public boolean removeLast(){
    if (first.equals(last)) {
      return false;
    }
    else {
      //implement remove last
      return true;
    }
  }

  public Hash getHash() {
    return last.data.getHash();
  }

  public boolean isValidBlockChain(){
    while (this.next =! null) {
      
    }
  }

  public void printBalances(){

  }

  public String toString(){

  }

}
