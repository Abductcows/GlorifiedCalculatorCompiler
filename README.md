# GlorifiedCalculatorCompiler

just so i can say gcc.

Optional project in my Programming Language Design course in university. It is on the larger side of solo university projects and its grade can be used to pass the course.

This compiler compiles programs written in a custom language given below into MIPS assembly code (tested with MARS MIPS compiler).
The compiler was made using Antlr4 (https://www.antlr.org/).

info on the language (grammar/tokens) can be found here: https://drive.google.com/drive/folders/1Me94kffKNvwIGz8twnEv8zM8hIowlLBu?usp=sharing.
Integers are 31-bit signed.
Floats are in the approximate range (10^-58, 10^57).

/ProgramExamples/ contains sample programs in the language that compile succesfully.
/CompileErrorFiles/ contains sample programs that will not compile and throw an exception.
/CompileErrorTest class contains a junit test class that runs all compile error files and prints their exceptions.
/MIPSCodeGeneratorVisitor is the visitor class that does all the code generation and file handling. Heaviest read in the project for sure. Might try to split a few components
  at some point.

Compiler should be packed in a .jar file with main class "Compile". Running the compiler without arguments will display a java-compile-style usage message.
Can compile directories full of source files or 1 or more individual files with custom output path/name.