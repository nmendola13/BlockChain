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

    while (true) {
      // Print out the contents of the blockchain.
      pen.println(current.toString());
      //
      pen.print("\nCommand? ");
      // Read in the command from the user
      String command = in.nextLine();

      // 
      switch (command) {
        case "mine": current.mine((int) readNumber(pen, in, "Amount tranferred?"));
          break;
        case "append": current.append(
          new Block(current.getSize() + 1, 
            (int) readNumber(pen, in, "Amount transferred?"),
            current.getHash(),
            (long) readNumber(pen, in, "Nonce?")));
          break;
        case "remove": current.removeLast();
          break;
        case "check": current.isValidBlockChain();
          break;
        case "report": current.printBalances();
          break;
        case "help": helpMenu(pen);
          break;
        case "quit": System.exit(0);
          break;
        default: pen.println("Invalid command.");
        
        pen.println();
      } // switch (command)
    } // while ()
  } // main(String[])

  /*
   * Print the message querying the user for an integer input. Then,
   * read in the input and return it.
   */
  private static Number readNumber(PrintWriter pen, Scanner in, String msg) {
    pen.println(msg);
    return in.nextInt();
  } // readInt(PrintWriter, Scanner, String)

  private static void helpMenu(PrintWriter pen) {
    pen.println("""
      Valid commands:                                             \n
      \tmine: discovers the nonce for a given transaction         \n
      \tappend: appends a new block onto the end of the chain     \n
      \tremove: removes the last block from the end of the chain  \n
      \tcheck: checks that the block chain is valid               \n
      \treport: reports the balances of Alexis and Blake          \n
      \thelp: prints this list of commands                        \n
      \tquit: quits the program                                   \n
      """);
  } // helpMenu(PrintWriter)

} // class BlockChainDriver