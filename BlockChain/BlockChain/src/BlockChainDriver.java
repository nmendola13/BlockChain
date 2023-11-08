package BlockChain.src;

import java.io.PrintWriter;
import java.util.Scanner;

public class BlockChainDriver {
  public static void main (String[] args) {
    if (args.length != 1) {
      System.exit(1);
    }

    BlockChain current = new BlockChain(Integer.valueOf(args[0]));

    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner input = new Scanner(System.in);

    while (true) {  
      
      pen.print("Command? ");
      String command = input.nextLine();

      switch (command) {
        case "mine": current.mine();
        case "append": current.append(null);
        case "remove": current.removeLast();
        case "check": current.isValidBlockChain();
        case "report": current.printBalances();
        case "help": pen.println("""
          Valid commands:
          \tmine: discovers the nonce for a given transaction
          \tappend: appends a new block onto the end of the chain
          \tremove: removes the last block from the end of the chain
          \tcheck: checks that the block chain is valid
          \treport: reports the balances of Alexis and Blake
          \thelp: prints this list of commands
          \tquit: quits the program""");
        case "quit": System.exit(0);

        default: pen.println("Error");
      }
    }
  }
}
