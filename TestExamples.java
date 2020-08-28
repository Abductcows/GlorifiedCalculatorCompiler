import java.util.Arrays;
import java.util.stream.Collectors;

public class TestExamples {

  private enum TestTypes {
    T1, T2, T3, T4;

    private static final TestTypes[] widerToNarrower = { T4, T2, T3, T1 };

    public static TestTypes widerOf(TestTypes t1, TestTypes t2) {
      return Arrays.stream(widerToNarrower)
          .filter(t -> t == t1 || t == t2)
          .collect(Collectors.toList())
          .get(0);
    }
  }

  public static void main(String[] args) {

    for (int j=1; j<10; j++) {
      int i = Integer.MIN_VALUE - j;

      if (i == Integer.MAX_VALUE + -j + 1) {
        System.out.println("YES");
      }
    }
  }
}
