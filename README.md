# Glorified Calculator Compiler

#### just so that i can say gcc.

Made this for a uni project. Lot of fun and I keep coming back to find new improvements in design/readability/portability.
The compiler was made using [Antlr4](https://www.antlr.org/).

Info about the language (grammar/tokens) can be found at the bottom. I will not "improve" the actual spec to stay true
to the requirements.
 

The project is completely packaged and easily run using `Maven`. Even includes the Mars MIPS emulator, [Mars4_5.jar](Mars4_5.jar)
to run the compiled programs. See below
# Building and running the compiler

You need `Maven` and a `JDK` (JDK 14+ should work but prefer 17+). If you use `Intellij IDEA`, you have both already. However
Maven might not be in your `PATH`, so you will only be able to run Maven commands from your IDE.

### To build from terminal, run the following with your directory set to the project's root
```Maven
mvn clean package
```
This will `download dependencies`, generate the parser from [myLanguage.g4](src/main/antlr4/myLanguage.g4), 
and finally generate the `mlc.jar` compiler executable for this language.

### You can then run the compiler with
```cmd
java -jar .\target\mlc.jar
```

Without arguments, a usage message will be displayed. You can then add file arguments to compile as you wish. 

### Terminal Use example (current `dir` is project root)
```powershell
> mvn clean package
> dir .\target\

Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
d-----         24/6/2024  12:27 πμ                archive-tmp
d-----         24/6/2024  12:27 πμ                classes
d-----         24/6/2024  12:27 πμ                generated-sources
d-----         24/6/2024  12:27 πμ                generated-test-sources
d-----         24/6/2024  12:27 πμ                maven-status
d-----         24/6/2024  12:27 πμ                test-classes
-a----         24/6/2024  12:27 πμ       16901728 mlc.jar


> java -jar .\target\mlc.jar  .\res\ProgramExamples\FibonacciExample


# This will generate the FibonacciExample.asm MIPS Assembly file 
# You can then run it with

> java -jar .\Mars4_5.jar .\res\ProgramExamples\FibonacciExample.asm

# Output:

MARS 4.5  Copyright 2003-2014 Pete Sanderson and Kenneth Vollmar

1
2
3
5
8
13
21
34
55
89


```

# Sample Program & More Specs




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

Integers are 31-bit signed.  
Floats are in the approximate range (10^-58, 10^57).

[myLanguage.g4](src/main/antlr4/myLanguage.g4) contains the Antlr4 definition of the language's tokens and grammar 
(compiler implementation language independent).  
[Compile](src/main/java/Compile.java) is the starting class that initialises the Antlr4 lexer and parser. The result tree is visited with a 
custom visitor to generate the MIPS assembly code.  
[MIPSCodeGeneratorVisitor](src/main/java/MIPSCodeGeneratorVisitor.java) is the visitor class that does all the code generation and file handling. Heaviest read 
in the project for sure. Might try to split a few components at some point.  
[ProgramExamples/](res/ProgramExamples) contains sample programs in the language that compile succesfully.  
[CompileErrorFiles/](src/test/resources/CompileErrorExamples) contains sample programs that will not compile and throw an exception. Used for tests.

## Tokens  

![image](https://drive.google.com/uc?export=view&id=1W_n2qwcYk67VIpmdRI1U8P15L6vmzft4)  
#### plus some reserved words such as "public", "main", etc. Reserved words are defined in [myLanguage.g4](src/main/antlr4/myLanguage.g4)

## Grammar
![image](https://drive.google.com/uc?export=view&id=1yekZ9DyQ4Q4wsGDXaGpooPZK_-F-DATE)  
![image](https://drive.google.com/uc?export=view&id=1376G4YobUl6MSBXV-4yvMOS2UWC9qLWb)  
