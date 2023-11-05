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
    last.nextNode = new Node(newBlock, last);
    return newBlock;
  }

  public int getSize(){
    int i = 1;
    while (this.nextNode =! null) {
      this.nextNode = this;
      i++;
    }
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
