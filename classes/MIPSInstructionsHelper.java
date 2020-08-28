package classes;

import java.util.HashMap;

/**
 * Helper class that returns Strings containing instructions. Newline is never appended
 */
public class MIPSInstructionsHelper {

  public static final HashMap<String, String> intBranches = new HashMap<>();

  static {
    intBranches.put("==", "bne");
    intBranches.put("<", "bge");
    intBranches.put("<=", "bgt");
    intBranches.put(">", "ble");
    intBranches.put(">=", "blt");
    intBranches.put("!=", "beq");
  }

  /**
   * Instruction for pushing the content from the argument register into the int stack
   * @param register  register holding the value
   * @return  String containing the instructions
   */
  public String pushIntStack(String register) {
    return String.format("sw %1$s, (%2$s)\naddi %2$s, %2$s, 4", register, MIPSStackTracker.intStackRegister);
  }

  /**
   * Instruction for pushing the content from the argument register into the float stack
   * @param register  register holding the value
   * @return  String containing the instructions
   */
  public String pushFloatStack(String register) {
    return String.format("s.d %1$s, (%2$s)\naddi %2$s, %2$s, 8", register, MIPSStackTracker.floatStackRegister);
  }

  /**
   * Instruction for pushing the content from the argument register into the bool stack
   * @param register  register holding the value
   * @return  String containing the instructions
   */
  public String pushBoolStack(String register) {
    return String.format("sw %1$s, (%2$s)\naddi %2$s, %2$s, 4", register, MIPSStackTracker.boolStackRegister);
  }

  /**
   * Instruction for popping the top of the int stack and storing its results in the argument register
   * @param register  register to store the value to
   * @return  String containing the instructions
   */
  public String getIntStackTopAndPop(String register) {
    return String.format("addi %2$s, %2$s, -4\nlw %1$s, (%2$s)", register, MIPSStackTracker.intStackRegister);
  }

  /**
   * Instruction for popping the top of the float stack and storing its results in the argument register
   * @param register  register to store the value to
   * @return  String containing the instructions
   */
  public String getFloatStackTopAndPop(String register) {
    return String.format("addi %2$s, %2$s, -8\nl.d %1$s, (%2$s)", register, MIPSStackTracker.floatStackRegister);
  }

  /**
   * Instruction for popping the top of the bool stack and storing its results in the argument register
   * @param register  register to store the value to
   * @return  String containing the instructions
   */
  public String getBoolStackTopAndPop(String register) {
    return String.format("addi %2$s, %2$s, -4\nlw %1$s, (%2$s)", register, MIPSStackTracker.boolStackRegister);
  }

  /**
   * Instruction for setting the int stack pointer to the start of the stack
   * @return  String containing the instruction
   */
  public String resetIntStack() {
    return String.format("la %s, _intStack", MIPSStackTracker.intStackRegister);
  }

  /**
   * Instruction for setting the float stack pointer to the start of the stack
   * @return  String containing the instruction
   */
  public String resetFloatStack() {
    return String.format("la %s, _floatStack", MIPSStackTracker.floatStackRegister);
  }

  /**
   * Instruction for setting the bool stack pointer to the start of the stack
   * @return  String containing the instruction
   */
  public String resetBoolStack() {
    return String.format("la %s, _boolStack", MIPSStackTracker.boolStackRegister);
  }

  /**
   * Instruction for converting the integer in cp1 register {@code fromReg} to a double and moving it to cp1 register
   * {@code toReg}
   * @param toReg  destination co-processor1 register
   * @param fromReg  source co-processor1 register
   * @return  String containing the instruction
   */
  public String intToFloat(String toReg, String fromReg) {
    return String.format("cvt.d.w %s, %s", toReg, fromReg);
  }

  /**
   * Instruction for converting the double in cp1 register {@code fromReg} to an int and moving it to cp1 register
   * {@code toReg}
   * @param toReg  destination co-processor1 register
   * @param fromReg  source co-processor1 register
   * @return  String containing the instruction
   */
  public String floatToInt(String toReg, String fromReg) {
    return String.format("cvt.w.d %s, %s", toReg, fromReg);
  }

  /**
   * Instruction for program exit
   * @return  String containing the instruction
   */
  public String getProgramExit() {
    return "li $v0, 10\n" + "syscall";
  }
}
