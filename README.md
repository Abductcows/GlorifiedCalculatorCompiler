# Glorified Calculator Compiler

#### just so that i can say gcc.

Optional project in my Programming Language Design course in university. It is on the larger side of solo university projects and its grade can be used to pass the course.

This compiler compiles programs written in a simple C-like language into MIPS assembly code (tested with MARS MIPS compiler).
The compiler was made using [Antlr4](https://www.antlr.org/).

Info about the language (grammar/tokens) can be found at the bottom.  
Integers are 31-bit signed.  
Floats are in the approximate range (10^-58, 10^57).  
          
[myLanguage.g4](myLanguage.g4) contains the Antlr4 definition of the language's tokens and grammar (Implementation language independent).  
[Compile](Compile.java) is the starting class that initialises the Antlr4 lexer and parser. The result tree is visited with a custom visitor to generate the MIPS assembly code.  
[MIPSCodeGeneratorVisitor](MIPSCodeGeneratorVisitor.java) is the visitor class that does all the code generation and file handling. Heaviest read in the project for sure. Might try to split a few components at some point.  
[ProgramExamples/](ProgramExamples) contains sample programs in the language that compile succesfully.  
[CompileErrorFiles/](CompileErrorFiles) contains sample programs that will not compile and throw an exception.  
[CompileErrorTest](CompileErrorTest.java) class contains a JUnit test class that runs all compile error files and prints their exceptions.  

Compiler should be packed in a .jar file with main class "[Compile](Compile.java)". Running the compiler without arguments will display a java-compile-style usage message.
Can compile directories full of source files, or 1 or more individual files with custom output path/name.  

## Example of printing the first 10 Fibonacci numbers:

```
mainclass Fibonacci {
    public static void main ( ) {
        int first, second, i, tmp;
        first = 0;
        second = 1;
        
        i = 0;
        while (i < 10) {
            tmp = first + second;
            println(tmp);
            
            first=second;
            second=tmp;
            i = i + 1;
        }
    }
}
```

## Tokens  

![image](https://drive.google.com/uc?export=view&id=1W_n2qwcYk67VIpmdRI1U8P15L6vmzft4)  
#### plus some reserved words such as "public", "main", etc. Reserved words are defined in [myLanguage.g4](myLanguage.g4)

## Grammar
![image](https://drive.google.com/uc?export=view&id=1yekZ9DyQ4Q4wsGDXaGpooPZK_-F-DATE)  
![image](https://drive.google.com/uc?export=view&id=1376G4YobUl6MSBXV-4yvMOS2UWC9qLWb)  
