package classes;

import java.util.Stack;

/**
 * Unique label generator for if/while statements and float literal declarations. Uses stacks to handle nested if/while
 * Labels look like _afterIfX: or _whileX: where X is their ordinal number of generation
 */
public class MIPSLabelTracker {

  Stack<Integer> ifStack = new Stack<>(), whileStack = new Stack<>();
  private int afterIfCount = -1, whileCount = -1, floatLiteralCount = -1; // values are incremented before use

  /**
   * Called when entering a new if/if-else statement. New value is pushed to the stack and is ready to use
   */
  public void pushNextAfterIf() {
    ifStack.push(++afterIfCount);
  }

  /**
   * Called when exiting an if/if-else statement
   */
  public void popAfterIf() {
    ifStack.pop();
  }

  /**
   * Called when entering a new while/for statement. New value is pushed to the stack and is ready to use
   */
  public void pushNextWhile() {
    whileStack.push(++whileCount);
  }

  /**
   * Called when exiting a while/for statement
   */
  public void popWhile() {
    whileStack.pop();
  }

  /**
   * Name of the current after if label (without the colon)
   * @return  String containing the name
   */
  public String getAfterIf() {
    return String.format("_afterIf%s ", ifStack.peek());
  }

  /**
   * Current after if label
   * @return  String containing the label
   */
  public String getAfterIfLabel() {
    return String.format("_afterIf%s: ", ifStack.peek());
  }

  /**
   * Name of the current else label (without the colon)
   * @return  String containing the name
   */
  public String getElse() { return String.format("_else%s ", ifStack.peek()); }

  /**
   * Current else label
   * @return  String containing the label
   */
  public String getElseLabel() {
    return String.format("_else%s: ", ifStack.peek());
  }

  /**
   * Name of the current while label (no colon)
   * @return  String containing the name
   */
  public String getWhile() { return String.format("_while%s ", whileStack.peek()); }

  /**
   * Current while label
   * @return  String containing the label
   */
  public String getWhileLabel() {
    return String.format("_while%s: ", whileStack.peek());
  }

  /**
   * Name of the current after while label (no colon)
   * @return  String containing the name
   */
  public String getAfterWhile() {
    return String.format("_afterWhile%s ", whileStack.peek());
  }

  /**
   * Current after while label
   * @return  String containing the label
   */
  public String getAfterWhileLabel() {
    return String.format("_afterWhile%s: ", whileStack.peek());
  }

  /**
   * Declaration of the next float literal
   * @param value  String containing the float literal
   * @return  String containing the entire instruction
   */
  public String getNextFloatLiteralDeclaration(String value) {
    return String.format("_float%s: .align 3\n.double %s", ++floatLiteralCount, value);
  }

  /**
   * Name of the last _float.. label used (no colon)
   * @return  String containing the name
   */
  public String getCurrentFloatLiteral() {
    return String.format("_float%s", floatLiteralCount);
  }
}


