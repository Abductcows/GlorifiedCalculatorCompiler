import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Test class meant to check for thrown exceptions. Tests succeed by default but if an exception is thrown during a
 * test, the compilation process has been halted.
 *
 * A test is considered successful only successful if it throws an exception.
 */
class CompileErrorTest {

  private static int i = -1;
  private static String currentFile;
  private static final String directory = "CompileErrorFiles";

  private static final List<String> filenames =
      Arrays.stream(Objects.requireNonNull(new File(directory).list()))
      .filter(s -> !s.equals("README.txt"))
      .collect(Collectors.toList());

  @BeforeEach
  void setUp() throws Exception {
    // compile next file
    currentFile = directory + "/" + filenames.get(++i);
    System.out.println(filenames.get(i));
    String[] args = { currentFile };
    Compile.main(args);
  }

  @AfterEach
  void tearDown() {
    // delete last file
    File asmFile = new File(currentFile + ".asm");
    asmFile.delete();
  }


  @Test
  void testFile1() throws Exception {
  }
  @Test
  void testFile2() throws Exception {

  }
  @Test
  void testFile3() throws Exception {

  }
  @Test
  void testFile4() throws Exception {

  }
  @Test
  void testFile5() throws Exception {

  }
  @Test
  void testFile6() throws Exception {

  }
  @Test
  void testFile7() throws Exception {

  }
  @Test
  void testFile8() throws Exception {

  }
  @Test
  void testFile9() throws Exception {

  }
  @Test
  void testFile10() throws Exception {

  }
  @Test
  void testFile11() throws Exception {

  }
  @Test
  void testFile12() throws Exception {

  }
  @Test
  void testFile13() throws Exception {

  }
  @Test
  void testFile14() throws Exception {

  }
  @Test
  void testFile15() throws Exception {

  }
}