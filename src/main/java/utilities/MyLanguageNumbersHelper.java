package utilities;

@SuppressWarnings("SpellCheckingInspection")
public class MyLanguageNumbersHelper {
  public static final String INT_MAX = "1073741823";
  public static final String INT_MIN = "-1073741824";
  public static final String FLOAT_MAX = "98079714615416886934934209737619787751599303819750539264";
  public static final String FLOAT_MIN = "1.593091911132452E-58";

  /**
   * Max and min values for ints and floats. Float min and max refer to its absolute value
   * @return  String containing the .data declarations
   */
  public static String getPrimitiveConstraintDeclarations() {
    return
        "_INT_MAX: .align 2\n.word " + INT_MAX +
        "\n_INT_MIN: .align 2\n.word " + INT_MIN +
        "\n_FLOAT_MAX: .align 3\n.double " + FLOAT_MAX +
        "\n_FLOAT_MAX_NEG: .align 3\n.double " + "-" + FLOAT_MAX +
        "\n_FLOAT_MIN: .align 3\n.double " + FLOAT_MIN +
        "\n_FLOAT_MIN_NEG: .align 3\n.double " + "-" + FLOAT_MIN;
  }

  /**
   * Messages for exceptions
   */
  @SuppressWarnings("SpellCheckingInspection")
  public static String getArithmeticErrorMessageDeclarations() {
    return
        "_divByZeroMessage: .asciiz \"\\nException: division by zero\\nProgram will be terminated\\n\"\n" +
        "_floatOverflowMessage: .asciiz \"\\nException: floating point operation result too great to fit in floating point word\\nProgram will be terminated\\n\"\n" +
        "_floatUnderflowMessage: .asciiz \"\\nException: floating point operation result too small to fit in floating point word\\nPrgoram will be terminated\\n\"";
  }

  /**
   * Labels and instructions to be called when an numeric exception is called. Instructions currently terminate the
   * program with a message
   */
  public static String getNumericExceptionInstructions() {
    return
        "_floatOverflow:\n" +
        "la $a0, _floatOverflowMessage\n" +
        "j _exceptionAndExit\n" +

        "_floatUnderflow:\n" +
        "la $a0, _floatUnderflowMessage\n" +
        "j _exceptionAndExit\n" +

        "_divByZero:\n" +
        "la $a0, _divByZeroMessage\n" +
        "j _exceptionAndExit\n" +

        "_exceptionAndExit:\n" +
        "li $v0, 4\n" +
        "syscall\n" +
        "li $v0, 10\n" +
        "syscall";
  }

  /**
   * Argument double value to check is in $a0
   * @return  multiline String containing the entire subprogram
   */
  public static String getFloatExceptionCheckSubprogram() {

    return
        "_floatOverflowCheck:\n" +
        // move argument to temp register
        "mtc1.d $a0, $f4\n" +
        // check if value > max
        "l.d $f6, _FLOAT_MAX\n" +
        "c.le.d $f4, $f6\n" +
        "bc1f _floatOverflow\n" +
        // chcek if value < -max
        "l.d $f6, _FLOAT_MAX_NEG\n" +
        "c.lt.d $f4, $f6\n" +
        "bc1t _floatOverflow\n" +

        // exit if value == 0
        "mtc1 $zero, $f6\n" +
        "cvt.d.w $f6, $f6\n" +
        "c.eq.d $f4, $f6\n" +
        "bc1t _floatOverflowCheck_return\n" +
        // check 0 < value < min and -min < value < 0

        // (If) compare to zero
        "c.lt.d $f4, $f6\n" +
        "bc1t _floatOverflowCheck_lessThanZero\n" +
        // check 0 < value < min
        "l.d $f6, _FLOAT_MIN\n" +
        "c.lt.d $f4, $f6\n" +
        "bc1t _floatUnderflow\n" +
        // no more checks left, return
        "j _floatOverflowCheck_return\n" +
        // (else)
        "_floatOverflowCheck_lessThanZero:\n" +
        // check -min < value < 0
        "l.d $f6, _FLOAT_MIN_NEG\n" +
        "c.le.d $f4, $f6\n" +
        "bc1f _floatUnderflow\n" +
        // return
        "_floatOverflowCheck_return:\n" +
        "jr $ra";
  }

  /**
   * Argument int value to correct is in $a0, value is returned in $v0
   * For j > 0:
   * i = INT_MAX + j is mapped to INT_MIN - 1 + j and
   * i = INT_MIN - j is mapped to INT_MAX + 1 - j
   * @return  multiline String containing the entire subprogram
   */
  public static String getIntOverflowCorrectionSubprogram() {
    return
        "_intOverflowCheck:\n" +
        "move $t0, $a0\n" +
        "lw $t2, _INT_MAX\n" +
        "lw $t3, _INT_MIN\n" +
        // check > max
        "bgt $t0, $t2, _intOverflow_max\n" +
        // check < min
        "blt $t0, $t3, _intOverflow_min\n" +
        // return if neither
        "j _intOverflowCheck_return\n" +

        "_intOverflow_max:\n" +
        // subtract int max
        "sub $t0, $t0, $t2\n" +
        // subtract 1
        "subi $t0, $t0, 1\n" +
        // add int min
        "add $t0, $t0, $t3\n" +
        "j _intOverflowCheck_return\n" +

        "_intOverflow_min:\n" +
        // subtract int min
        "sub $t0, $t0, $t3\n" +
        // add 1
        "addi $t0, $t0, 1\n" +
        // add int max
        "add $t0, $t0, $t2\n" +

        "_intOverflowCheck_return:\n" +
        "move $v0, $t0\n" +
        "jr $ra";
  }
}
