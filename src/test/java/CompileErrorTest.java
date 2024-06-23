import org.junit.jupiter.api.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class meant to check for thrown exceptions. Tests succeed by default but if an exception is thrown during a
 * test, the compilation process has been halted.
 * <p>
 * A test is considered successful only successful if it throws an exception.
 * </p>
 */
class CompileErrorTest {

    private static final String directory = "src/test/resources/CompileErrorExamples";
    private static final List<String> filenames =
            Arrays.stream(Objects.requireNonNull(new File(directory).list()))
                    .map(s -> directory + "/" + s)
                    .toList();


    @AfterAll
    static void tearDown() {
        filenames.forEach(filename -> new File(filename + ".asm").delete());
    }


    @TestFactory
    List<DynamicTest> testFactory() {

        return filenames.stream()
                .map(filename ->
                        DynamicTest.dynamicTest(
                                filename, () -> {
                                    String[] args = {filename};
                                    assertThrows(Exception.class, () -> Compile.main(args)).printStackTrace();
                                }
                        )
                )
                .toList();
    }
}