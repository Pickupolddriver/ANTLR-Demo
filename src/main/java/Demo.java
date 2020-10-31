
import Exprgen.ExprLexer;
import Exprgen.ExprParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(">");
            String command = scan.nextLine() + "\n";
            try {
                if (command.length() == 0) {
                    System.out.println("Please enter correct expression");
                    continue;
                }
                ExprLexer lexer = new ExprLexer(CharStreams.fromString(command));
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                ExprParser parser = new ExprParser(tokens);
                ExprParser.ProgContext tree = parser.prog();
                EvalVisitor eval = new EvalVisitor();
                eval.visit(tree);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

}
