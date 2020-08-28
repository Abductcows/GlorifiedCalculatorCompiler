package utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Symbol table class utilising a HashMap using IDs as keys
 */
public class SymbolTable {

  /**
   * Enum of types INT and FLOAT. FLOAT refers to the language's float type and not standard binary32 floating point
   * numbers
   */
  public enum Types {
    FLOAT, INT;

    private static final Types[] widerToNarrower = { FLOAT, INT };

    /**
     * Returns the wider of the two types
     * @param t1  type 1
     * @param t2  type 2
     * @return  wider of the types
     */
    public static Types getWiderType(Types t1, Types t2) {
      return Arrays.stream(widerToNarrower)
          .filter(t -> t == t1 || t == t2)
          .collect(Collectors.toList())
          .get(0);
    }
  }

  /**
   * Class storing information tied to a variable or an expression.
   */
  public static class VariableInfo {
    private final String id;
    private final Types type;
    private int intVal;
    private double floatVal;

    /**
     * Stores id and int value
     */
    public VariableInfo(String id, int intVal) {
      this.id = id;
      this.intVal = intVal;
      this.type = Types.INT;
    }

    /**
     * Stores int value
     */
    public VariableInfo(int intVal) {
      this(null, intVal);
    }

    /**
     * Stores id and float value
     */
    public VariableInfo(String id, double floatVal) {
      this.id = id;
      this.floatVal = floatVal;
      this.type = Types.FLOAT;
    }

    /**
     * Stores float value
     */
    public VariableInfo(double floatVal) {
      this(null, floatVal);
    }

    // Getters

    public String getID() { return id; }
    public Types getType() { return type; }
    public int getIntVal() { return intVal; }
    public double getFloatVal() { return floatVal; }
  }

  private final HashMap<String, VariableInfo> table = new HashMap<>();

  /**
   * Inserts an (id, info) pair in the table
   * @param id  the key
   * @param intVal  int value to create a new VariableInfo object and store as a value
   */
  public void insert(String id, int intVal) {
    table.putIfAbsent(id, new VariableInfo(id, intVal));
  }

  /**
   * Inserts an (id, info) pair in the table
   * @param id  the key
   * @param floatVal  float value to create a new VariableInfo object and store as a value
   */
  public void insert(String id, double floatVal) {
    table.putIfAbsent(id, new VariableInfo(id, floatVal));
  }

  /**
   * Fetches the value associated with the "id" key in the table
   * @param id  key used to get value from the table
   * @return  value corresponding to key or null if key is not present
   */
  public VariableInfo get(String id) {
    return table.get(id);
  }

  /**
   * Returns all the keys in the symbol table
   */
  public Set<String> getIDs() { return table.keySet(); }

}
