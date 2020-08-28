import a4out.myLanguageLexer;
import a4out.myLanguageParser;
import utilities.SymbolTable;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Main class of the compiler. Initialises antlr lexer, parser and visitor from filename argument and visits the
 * parse tree for code generation
 */
public class Compile {

  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      throw new RuntimeException("No source code files provided");
    } else if (args.length == 2 && args[0].equals("-dir")) {
      // compile every file in directory x to x/MIPSOut
      String directory = args[1];
      // create directory
      try {
        Files.createDirectory(Paths.get(directory + "/MIPSOut"));
      } catch (Exception ignored) {}
      // get list of all files
      List<String> filenames = Arrays.stream(Objects.requireNonNull(new File(directory).list()))
          .filter(s -> !new File(directory + "/" + s).isDirectory())
          .collect(Collectors.toList());

      // compile all
      for (String filename : filenames) {
        compile(directory + "/" + filename, directory + "/MIPSOut/" + filename);
      }
    } else if (args.length == 3 && args[1].equals("-o")) {
      // compile with custom output file name
      compile(args[0], args[2]);
    } else {
      // compile all files
      for (String filename : args) {
        compile(filename, filename);
      }
    }
  }

  /**
   * Antlr start method
   * @param filename  compile target file name
   * @param outputName  output file name
   */
  private static void compile(String filename, String outputName) throws IOException {
    myLanguageLexer lexer = new myLanguageLexer(CharStreams.fromFileName(filename));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    myLanguageParser parser = new myLanguageParser(tokens);
    ParseTree tree = parser.program(); // Start at the first rule

    ParseTreeVisitor<SymbolTable.VariableInfo> visitor = new MIPSCodeGeneratorVisitor(outputName);
    visitor.visit(tree);
  }

}
