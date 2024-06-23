import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class CompileSuccessTest {

    private static final String directory = "src/test/resources/ProgramExamples";
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
                                    assertDoesNotThrow(() -> Compile.main(args));

                                    ProcessBuilder builder = new ProcessBuilder();
                                    builder.command("java", "-jar", ".\\Mars4_5.jar", "nc", filename + ".asm");
                                    builder.redirectErrorStream(true);

                                    try {
                                        Process mars = builder.start();
                                        BufferedReader reader = new BufferedReader(new InputStreamReader(mars.getInputStream()));
                                        String marsOutput;
                                        while ((marsOutput = reader.readLine()) != null) {
                                            System.out.println(marsOutput);
                                        }
                                        int exitCode = mars.waitFor();
                                        assertEquals(0, exitCode);
                                    } catch (IOException | InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                        )
                )
                .toList();
    }
}