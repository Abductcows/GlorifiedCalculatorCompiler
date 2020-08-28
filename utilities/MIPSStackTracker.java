package utilities;

/**
 * Compile time int/float/bool stack overflow checker. Also returns instructions for the stack declaration and
 * initialisation
 */
public class MIPSStackTracker {

  private static class MIPSStackOverflow extends RuntimeException {
    public MIPSStackOverflow(String stack) {
      super(stack + " stack overflow detected");
    }
  }

  public static final String
      intStackRegister = "$s0",
      floatStackRegister = "$s2",
      boolStackRegister = "$s4";

  private int intStackByte = 0;
  private int floatStackByte = 0;
  private int boolStackByte = 0;

  private final int stackSizeBytes = 64;

  /**
   * Registers an int stack push. Throws exception if stack full
   */
  public void registerIntStackPush() {
    if (intStackByte >= stackSizeBytes) {
      throw new MIPSStackOverflow("Int");
    }
    intStackByte += 4;
  }

  /**
   * Registers a float stack push. Throws exception if stack full
   */
  public void registerFloatStackPush() {
    if (floatStackByte >= stackSizeBytes) {
      throw new MIPSStackOverflow("Float");
    }
    floatStackByte += 4;
  }

  /**
   * Registers a bool stack push. Throws exception if stack full
   */
  public void registerBoolStackPush() {
    if (boolStackByte >= stackSizeBytes) {
      throw new MIPSStackOverflow("Boolean");
    }
    boolStackByte += 4;
  }

  /**
   * Registers an int stack pop. Throws exception if stack empty
   */
  public void registerIntStackPop() {
    if (intStackByte <= 0) {
      throw new RuntimeException("Int stack empty and pop requested");
    }
    intStackByte -= 4;
  }

  /**
   * Registers an int stack pop. Throws exception if stack empty
   */
  public void registerFloatStackPop() {
    if (floatStackByte <= 0) {
      throw new RuntimeException("Float stack empty and pop requested");
    }
    floatStackByte -= 4;
  }

  /**
   * Registers an int stack pop. Throws exception if stack empty
   */
  public void registerBoolStackPop() {
    if (boolStackByte <= 0) {
      throw new RuntimeException("Bool stack empty and pop requested");
    }
    boolStackByte -= 4;
  }

  /**
   * Instruction for memory allocation for every stack in the .data part
   * @return  String containing the instruction
   */
  public String getStackDeclarations() {
    return String.format("_intStack: .align 2\n.space %1$s\n_floatStack: .align 3\n.space %2$s\n_boolStack: .align 2\n.space %1$s"
        ,stackSizeBytes, 2 * stackSizeBytes);
  }

  /**
   * Instruction that moves the stacks' addresses to their predefined registers
   * @return  String containing the instructions
   */
  public String getStackInit() {
    return
        String.format("la %s, _intStack\nla %s, _floatStack\nla %s, _boolStack",
            intStackRegister,
            floatStackRegister,
            boolStackRegister);
  }

}
