import a4out.myLanguageLexer;
import a4out.myLanguageParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import utilities.ParserBetterMessageErrorStrategy;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Main class of the compiler. Initialises antlr lexer, parser and visitor from filename argument and visits the
 * parse tree for code generation
 */
public class Compile {

    /**
     * Start method of the compiler
     *
     * @param args compiler arguments
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0 || args.length == 1 && args[0].equals("help")) {
            printHelp();

        } else if (args.length == 2 && args[0].equals("-dir")) {
            compileDir(args[1]);

        } else {
            compileFilesOptionalOutput(Arrays.asList(args));
        }
    }

    /**
     * Antlr start method
     *
     * @param fileName   compile target file name
     * @param outputName output file name
     */
    private static void compile(String fileName, String outputName) throws IOException {
        myLanguageLexer lexer = new myLanguageLexer(CharStreams.fromFileName(fileName));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        myLanguageParser parser = new myLanguageParser(tokens);
        parser.setErrorHandler(new ParserBetterMessageErrorStrategy());
        ParseTree tree = parser.program(); // Start at the first rule

        MIPSCodeGeneratorVisitor visitor = new MIPSCodeGeneratorVisitor(outputName, tree); // MIPS generator visitor
        visitor.start();
    }

    /**
     * Help message for empty argument calls or help argument
     */
    private static void printHelp() {
        System.out.println(
                """
                        Usage:\s
                           \tmlc.jar -dir <directory>
                            \t\t(to compile all files within a directory)
                         or\tmlc.jar <filename1> <filename2> .. <filenameN> [options]
                            \t\t(to compile one or more files)

                         where options include:
                        \t -o <outputFile1> <outputFile2> .. <outputFileN>
                        """

        );
    }

    /**
     * Calls compile method on all the files in the directory
     *
     * @param dirName name of the directory
     */
    private static void compileDir(String dirName) throws IOException {

        List<String> filesToCompile = Arrays.stream(Objects.requireNonNull(new File(dirName).list()))
                .filter(s -> !new File(dirName + "/" + s).isDirectory()) // exclude directories
                .toList();

        // compile all
        var outputDir = dirName + "/MIPSOut_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_kk-mm-ss"));
        new File(outputDir).mkdirs();
        for (String filename : filesToCompile) {
            compile(dirName + "/" + filename, outputDir + "/" + filename);
        }
    }

    /**
     * Calls compile method an all files before the (-o) and all files if -o option is omitted. In case not enough output
     * names are provided, uses source name for output name
     *
     * @param args list of program arguments
     */
    private static void compileFilesOptionalOutput(List<String> args) throws IOException {
        int halt = args.contains("-o") ? args.indexOf("-o") : args.size();
        int left = 0, right = halt + 1;

        while (left < halt) {
            if (right < args.size()) {
                compile(args.get(left), args.get(right++));
            } else {
                compile(args.get(left), args.get(left));
            }
            ++left;
        }
    }
}
