package BlockChain.src;

import java.io.PrintWriter;
import java.util.Scanner;

/** 
 * Program allowing the user to interact with the BlockChain. Takes
 * a single command-line argument that is the initial non-negative
 * dollar amount that Alexis starts with.
 * 
 * @author Noah Mendola and Albert-Kenneth Okine
 */
public class BlockChainDriver {

  public static void main (String[] args) {
    // Create a PrintWriter object directed towards System.out
    PrintWriter pen = new PrintWriter(System.out, true);
    // Create a new Scanner object directed towards System.in
    Scanner in = new Scanner(System.in);
    
    // Check if the user provided a valid initial dollar amount.
    if ((args.length != 1) || (Integer.parseInt(args[0]) < 0)) {
      System.exit(1);
    } // if ((user did not enter argument) or (amount is less than 0))

    // Create a new BlockChain with the initial dollar amount;
    BlockChain current = new BlockChain(Integer.valueOf(args[0]));

    String command;

    do { // Continuously ask the use for a command, then execute it.
      // Print out the contents of the blockchain.
      pen.println(current.toString());
      //
      pen.print("Command? ");
      pen.flush();
      // Read in the command from the user
      command = in.nextLine();
      // 
      executeCommand(pen, in, command, current);

    } while (!command.equals("quit")); 
  } // main(String[])

  /**
   * 
   */
  static void executeCommand(PrintWriter pen, Scanner in, String command, BlockChain current) {
    switch (command) {
      case "mine": Block newBlock = current.mine(readNumber(pen, in, "Amount tranferred?").intValue());
        pen.printf("amount = %d, nonce = %d\n\n", newBlock.getAmount(), newBlock.getNonce());
        break;
      case "append": current.append(
        new Block(current.getSize() + 1, 
          readNumber(pen, in, "Amount transferred?").intValue(),
          current.getHash(),
          (long) readNumber(pen, in, "Nonce?")));
        break;
      case "remove": current.removeLast();
        break;
      case "check": pen.println(current.isValidBlockChain() ? "chain is valid!" : "chain is invalid :(");
        break;
      case "report": current.printBalances();
        break;
      case "help": helpMenu(pen);
        break;
      case "quit": break;
      default: pen.println("|" + command + "|");
      
      pen.println();
    } // switch (command)
  } // executeCommand()

  /*
   * Print the message querying the user for an integer input. Then,
   * read in the input and return it.
   */
  private static Long readNumber(PrintWriter pen, Scanner in, String msg) {
    pen.print(msg + " ");
    pen.flush();
    long returnLong = in.nextLong();
    in.nextLine();
    return returnLong;
  } // readInt(PrintWriter, Scanner, String)

  private static void helpMenu(PrintWriter pen) {
    pen.println("""
      Valid commands:                                             
  \tmine: discovers the nonce for a given transaction         
  \tappend: appends a new block onto the end of the chain     
  \tremove: removes the last block from the end of the chain  
  \tcheck: checks that the block chain is valid               
  \treport: reports the balances of Alexis and Blake          
  \thelp: prints this list of commands                        
  \tquit: quits the program                                   
      """);
  } // helpMenu(PrintWriter)

} // class BlockChainDriver