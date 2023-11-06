package BlockChain.src;

import java.io.PrintWriter;

/**
 * A singly-linked structure with a first and last pointer (much like a
 * queue). Contains a nested Node static class in the standard style of
 * linked structure implementation.
 * 
 * @author Noah Mendola and Albert-Kenneth Okine
 */
public class BlockChain {
  
  /** Pointer to the first node in the linked list. */
  Node first;
  /** Pointer to the last node in the linked list. */
  Node last;

  /** 
   * 
   */
  public static class Node {
    /** The data contained in this node. */
    Block data;
    /** Pointer to the next node in the linked list. */
    Node nextNode;

    /**
     * Construct a new node from the given block of data.
     */
    public Node(Block data) {
      this.data = data;     // Set the data in the node.
      this.nextNode = null; // Initilize the next node to null
    } // Node(Block)
  } // class Node

  /** 
   * Creates a BlockChain the possess a single block, starting with the
   * given initial amount. Note that to create this block, the prevHash
   * field should be ignored when calculating the block's own nonce and
   * hash.
   */
  public BlockChain(int initial){
    // Make the initial blcok with the initial amount.
    Block firstBlock = new Block(0, initial, this.getHash());
    // Initialize the first and last pointers to the initial block.
    this.first.data = this.last.data = firstBlock;
  } // BlockChain(int)

  /** 
   * Mines a new candidate block to be added to the end of the chain.
   * The returned Block should be valid to add onto this chain.
   */
  public Block mine(int amount){
    Block 
    last.nextNode = 
  } // mine(int)

  /** 
   * Returns the size of blockchain. Note that the number of the blocks
   * provides a convenient method for quickly determining the size of
   * the chain
   */
  public int getSize(){
    return this.last.data.getNum();
  } // getSize()

  /** 
   * Adds this block to the list, throwing an IllegalArgumentException
   * if this block cannot be added to the chain.
   */
  public void append(Block blk) throws IllegalArgumentException {
    // Append the new block to the end of this blockchain.
    this.last.nextNode = new Node(blk);

    // Check if the new blockchain is valid.
    if (!isValidBlockChain()) {
      // Revert the blockchain back to what it was.
      this.last.nextNode = null;
      // Throw an exception noting that the blockchain is no longer valid.
      throw new IllegalArgumentException("Invalid with the other blocks");
    } else { 
      this.last = this.last.nextNode; // Update the last node in the list.
    } // if (invalid blockChain)...else
  } // append(Block)

  /** 
   * Removes the last block from the chain, returning true. If the
   * chain only contains a single block, then removeLast does nothing
   * and returns false.
   */
  public boolean removeLast() {
    // Check if there is more than the initial node in the BlockChain.
    if (this.first != this.last) {
      for (Node curr = this.first; curr != null; curr = curr.nextNode) {
        // Check if we have reached the last - 1 node
        if (curr.nextNode == this.last) {
          curr.nextNode = null;  // Remove the last node.
          this.last = curr;      // Update the last node.
          return true;
        } // if (reached second to last block)
      } // for (all Nodes in this BlockChain)
    } // if (the first and the last block are the same)
    
    return false; // Otherwise, there is only the initial block.
  } // removeLast()

  /** 
   * Returns the hash of the last block in the chain. 
   */
  public Hash getHash() {
    return this.last.data.getHash();
  } // getHash()
  
  /**
   * Walks the blackchain and ensures that its blocks are consistent
   * and valid.
   */
  public boolean isValidBlockChain() {
    // Determine the final balances of both Alexis and Blake.
    int[] balances = this.balances();
    // Check if they are both valid dollar amounts;
    return (balances[0] >= 0) && (balances[1] >= 0);
  } // isValidBlockChain()

  /** 
   * Print Alexis' and Blake's respective balances.
   * 
   * <pre>
   * Alexis: AMT, Blake: AMT
   * </pre>
   */
  public void printBalances(){
    // Determine the final balances of Alexis and Blake.
    int[] balances = this.balances();
    
    // Print out their balances.
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.printf("Alexis: %d, Blake: %d\n", balances[0], balances[1]);
  } // printBalances()

  /**
   * Returns a string representation of the BlockChain which is simply
   * the string representation of each of its blocks, earliest to latest,
   * one per line.
   */
  public String toString(){
    String str = ""; // Intialize the return string
    
    // Iterate through all nodes in the linked structure.
    for (Node curr = this.first; curr != null;
      curr = curr.nextNode)
    { 
      // Add the string representation of the current node's data.
      str += curr.data.toString() + "\n";
    } // for (all nodes in this BlockChain)

    return str; // return the contents of this blockchain
  } // toString()

  
  /**
   * Calculate the balances for Alexis and Blake, then return them as
   * an integer array. Note, [0] = Alexis' balance, [1] = Blake's
   * balance.
   */
  private int[] balances() {
    int total = 0;
    
    // Iterate through the BlockChain, updating the total amount left.
    for (Node curr = this.first.nextNode; curr != null; curr = curr.nextNode) {
      total += (curr.data.getAmount());
    } // for (all nodes in this BlockChain)

    return new int[] {this.first.data.getAmount() - total,  // Alexis' balance
                      this.first.data.getAmount() + total}; // Blake's balance
  } // balances()

} // class BlockChain
