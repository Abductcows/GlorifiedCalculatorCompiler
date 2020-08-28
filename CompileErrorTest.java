import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Test class meant to check for thrown exceptions. Tests succeed by default but if an exception is thrown during a
 * test, the compilation process has been halted.
 *
 * A test is considered successful only successful if it throws an exception.
 */
class CompileErrorTest {

  private static final String directory = "CompileErrorFiles";
  private static final List<String> filenames =
      Arrays.stream(Objects.requireNonNull(new File(directory).list()))
      .filter(s -> s.contains("Test"))
      .map(s -> directory + "/" + s)
      .collect(Collectors.toList());

  private static int i = -1;

  @BeforeEach
  void setUp() throws Exception {
    String currentFile = filenames.get(++i);
    System.out.println(currentFile);
    String[] args = {currentFile};
    Compile.main(args);
  }

  @AfterEach
  void tearDown() {
    new File(filenames.get(i) + ".asm").delete();
  }

  @Test
  void testFile1() {}
  @Test
  void testFile2() {

  }
  @Test
  void testFile3() {

  }
  @Test
  void testFile4() {

  }
  @Test
  void testFile5() {

  }
  @Test
  void testFile6() {

  }
  @Test
  void testFile7() {

  }
  @Test
  void testFile8() {

  }
  @Test
  void testFile9() {

  }
  @Test
  void testFile10() {

  }
  @Test
  void testFile11() {

  }
  @Test
  void testFile12() {

  }
  @Test
  void testFile13() {

  }
  @Test
  void testFile14() {

  }
  @Test
  void testFile15() {

  }
}