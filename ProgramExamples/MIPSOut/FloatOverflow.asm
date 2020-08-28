.data
_newLine: .asciiz "\n"
_divByZeroMessage: .asciiz "\nException: division by zero\nProgram will be terminated\n"
_floatOverflowMessage: .asciiz "\nException: floating point operation result too great to fit in floating point word\nProgram will be terminated\n"
_floatUnderflowMessage: .asciiz "\nException: floating point operation result too small to fit in floating point word\nPrgoram will be terminated\n"
_intStack: .align 2
.space 64
_floatStack: .align 3
.space 128
_boolStack: .align 2
.space 64
_INT_MAX: .align 2
.word 1073741823
_INT_MIN: .align 2
.word -1073741824
_FLOAT_MAX: .align 3
.double 98079714615416886934934209737619787751599303819750539264
_FLOAT_MAX_NEG: .align 3
.double -98079714615416886934934209737619787751599303819750539264
_FLOAT_MIN: .align 3
.double 1.593091911132452E-58
_FLOAT_MIN_NEG: .align 3
.double -1.593091911132452E-58
f: .align 3
.double 0.000000
.text
la $s0, _intStack
la $s2, _floatStack
la $s4, _boolStack
j main

_floatOverflow:
la $a0, _floatOverflowMessage
j _exceptionAndExit
_floatUnderflow:
la $a0, _floatUnderflowMessage
j _exceptionAndExit
_divByZero:
la $a0, _divByZeroMessage
j _exceptionAndExit
_exceptionAndExit:
li $v0, 4
syscall
li $v0, 10
syscall
_floatOverflowCheck:
mtc1.d $a0, $f4
l.d $f6, _FLOAT_MAX
c.le.d $f4, $f6
bc1f _floatOverflow
l.d $f6, _FLOAT_MAX_NEG
c.lt.d $f4, $f6
bc1t _floatOverflow
mtc1 $zero, $f6
cvt.d.w $f6, $f6
c.eq.d $f4, $f6
bc1t _floatOverflowCheck_return
c.lt.d $f4, $f6
bc1t _floatOverflowCheck_lessThanZero
l.d $f6, _FLOAT_MIN
c.lt.d $f4, $f6
bc1t _floatUnderflow
j _floatOverflowCheck_return
_floatOverflowCheck_lessThanZero:
l.d $f6, _FLOAT_MIN_NEG
c.le.d $f4, $f6
bc1f _floatUnderflow
_floatOverflowCheck_return:
jr $ra
_intOverflowCheck:
move $t0, $a0
lw $t2, _INT_MAX
lw $t3, _INT_MIN
bgt $t0, $t2, _intOverflow_max
blt $t0, $t3, _intOverflow_min
j _intOverflowCheck_return
_intOverflow_max:
sub $t0, $t0, $t2
subi $t0, $t0, 1
add $t0, $t0, $t3
j _intOverflowCheck_return
_intOverflow_min:
sub $t0, $t0, $t3
addi $t0, $t0, 1
add $t0, $t0, $t2
_intOverflowCheck_return:
move $v0, $t0
jr $ra


main:
li $t0, 5
sw $t0, ($s0)
addi $s0, $s0, 4
addi $s0, $s0, -4
lw $t0, ($s0)
mtc1.d $t0, $f4
cvt.d.w $f4, $f4
s.d $f4, f
s.d $f4, ($s2)
addi $s2, $s2, 8
la $s0, _intStack
la $s2, _floatStack
_while0: 
li $t0, 1
sw $t0, ($s4)
addi $s4, $s4, 4
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterWhile0 
l.d $f4, f
s.d $f4, ($s2)
addi $s2, $s2, 8
li $v0 3
addi $s2, $s2, -8
l.d $f12, ($s2)
syscall
li $v0, 4
la $a0, _newLine
syscall
l.d $f4, f
s.d $f4, ($s2)
addi $s2, $s2, 8
li $t0, 10
sw $t0, ($s0)
addi $s0, $s0, 4
addi $s2, $s2, -8
l.d $f4, ($s2)
addi $s0, $s0, -4
lw $t0, ($s0)
mtc1 $t0, $f6
cvt.d.w $f6, $f6
mul.d $f4, $f4, $f6
mov.d $f20, $f4
mfc1.d $a0, $f20
jal _floatOverflowCheck
s.d $f20, ($s2)
addi $s2, $s2, 8
addi $s2, $s2, -8
l.d $f4, ($s2)
s.d $f4, f
s.d $f4, ($s2)
addi $s2, $s2, 8
la $s0, _intStack
la $s2, _floatStack
j _while0 
_afterWhile0: 
li $v0, 10
syscall
