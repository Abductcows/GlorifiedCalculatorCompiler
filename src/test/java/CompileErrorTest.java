import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for files meant to throw compiler errors
 */
class CompileErrorTest {

    private static final String sourceDirectory = "src/test/resources/CompileErrorExamples";
    private static final List<String> filenames =
            Arrays.stream(Objects.requireNonNull(new File(sourceDirectory).list()))
                    .map(s -> sourceDirectory + "/" + s)
                    .toList();


    @AfterAll
    static void tearDown() {
        filenames.forEach(filename -> new File(filename + ".asm").delete());
    }

    void printExceptionMessage(Throwable e) {
        if (e instanceof ParseCancellationException) {
            printExceptionMessage(e.getCause());
        } else {
            e.printStackTrace();
        }
    }

    @TestFactory
    List<DynamicTest> testFactory() {

        return filenames.stream()
                .map(filename ->
                        DynamicTest.dynamicTest(
                                filename, () -> {
                                    String[] args = {filename};
                                    Throwable thrown = assertThrows(Exception.class, () -> Compile.main(args));
                                    printExceptionMessage(thrown);
                                }
                        )
                )
                .toList();
    }
}