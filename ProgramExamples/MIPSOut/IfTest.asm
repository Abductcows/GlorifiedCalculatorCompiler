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
_float0: .align 3
.double 1.0
_float1: .align 3
.double 1.0
_float2: .align 3
.double 1.0
_float3: .align 3
.double 1.0
_float4: .align 3
.double 3.2
_float5: .align 3
.double 3.0
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
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
addi $s0, $s0, -4
lw $t1, ($s0)
addi $s0, $s0, -4
lw $t0, ($s0)
beq $t0, $t1, _else0 
li $t3, 1
sw $t3, ($s4)
addi $s4, $s4, 4
j _afterIf0 
_else0: 
sw $zero, ($s4)
addi $s4, $s4, 4
_afterIf0: 
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterIf1 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $v0 1
addi $s0, $s0, -4
lw $a0, ($s0)
syscall
li $v0, 4
la $a0, _newLine
syscall
_afterIf1: 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
l.d $f4, _float0
s.d $f4, ($s2)
addi $s2, $s2, 8
addi $s0, $s0, -4
lw $t0, ($s0)
mtc1 $t0, $f4
cvt.d.w $f4, $f4
addi $s2, $s2, -8
l.d $f6, ($s2)
c.eq.d $f4, $f6
bc1t _else2 
li $t3, 1
sw $t3, ($s4)
addi $s4, $s4, 4
j _afterIf2 
_else2: 
sw $zero, ($s4)
addi $s4, $s4, 4
_afterIf2: 
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterIf3 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $v0 1
addi $s0, $s0, -4
lw $a0, ($s0)
syscall
li $v0, 4
la $a0, _newLine
syscall
_afterIf3: 
l.d $f4, _float1
s.d $f4, ($s2)
addi $s2, $s2, 8
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
addi $s2, $s2, -8
l.d $f4, ($s2)
addi $s0, $s0, -4
lw $t0, ($s0)
mtc1 $t0, $f6
cvt.d.w $f6, $f6
c.eq.d $f4, $f6
bc1t _else4 
li $t3, 1
sw $t3, ($s4)
addi $s4, $s4, 4
j _afterIf4 
_else4: 
sw $zero, ($s4)
addi $s4, $s4, 4
_afterIf4: 
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterIf5 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $v0 1
addi $s0, $s0, -4
lw $a0, ($s0)
syscall
li $v0, 4
la $a0, _newLine
syscall
_afterIf5: 
l.d $f4, _float2
s.d $f4, ($s2)
addi $s2, $s2, 8
l.d $f4, _float3
s.d $f4, ($s2)
addi $s2, $s2, 8
addi $s2, $s2, -8
l.d $f6, ($s2)
addi $s2, $s2, -8
l.d $f4, ($s2)
c.eq.d $f4, $f6
bc1t _else6 
li $t3, 1
sw $t3, ($s4)
addi $s4, $s4, 4
j _afterIf6 
_else6: 
sw $zero, ($s4)
addi $s4, $s4, 4
_afterIf6: 
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterIf7 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $v0 1
addi $s0, $s0, -4
lw $a0, ($s0)
syscall
li $v0, 4
la $a0, _newLine
syscall
_afterIf7: 
l.d $f4, _float4
s.d $f4, ($s2)
addi $s2, $s2, 8
li $t0, 0
sw $t0, ($s0)
addi $s0, $s0, 4
addi $s2, $s2, -8
l.d $f4, ($s2)
addi $s0, $s0, -4
lw $t0, ($s0)
mtc1 $t0, $f6
cvt.d.w $f6, $f6
c.le.d $f4, $f6
bc1f _else8 
li $t3, 1
sw $t3, ($s4)
addi $s4, $s4, 4
j _afterIf8 
_else8: 
sw $zero, ($s4)
addi $s4, $s4, 4
_afterIf8: 
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterIf9 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $v0 1
addi $s0, $s0, -4
lw $a0, ($s0)
syscall
li $v0, 4
la $a0, _newLine
syscall
_afterIf9: 
li $t0, 9
sw $t0, ($s0)
addi $s0, $s0, 4
li $t0, 10
sw $t0, ($s0)
addi $s0, $s0, 4
addi $s0, $s0, -4
lw $t1, ($s0)
addi $s0, $s0, -4
lw $t0, ($s0)
ble $t0, $t1, _else10 
li $t3, 1
sw $t3, ($s4)
addi $s4, $s4, 4
j _afterIf10 
_else10: 
sw $zero, ($s4)
addi $s4, $s4, 4
_afterIf10: 
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterIf11 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $v0 1
addi $s0, $s0, -4
lw $a0, ($s0)
syscall
li $v0, 4
la $a0, _newLine
syscall
_afterIf11: 
li $t0, 10
sw $t0, ($s0)
addi $s0, $s0, 4
l.d $f4, _float5
s.d $f4, ($s2)
addi $s2, $s2, 8
addi $s0, $s0, -4
lw $t0, ($s0)
mtc1 $t0, $f4
cvt.d.w $f4, $f4
addi $s2, $s2, -8
l.d $f6, ($s2)
mtc1 $zero, $f8
cvt.d.w $f8, $f8
c.eq.d $f6, $f8
bc1t _divByZero
div.d $f4, $f4, $f6
mov.d $f20, $f4
mfc1.d $a0, $f20
jal _floatOverflowCheck
s.d $f20, ($s2)
addi $s2, $s2, 8
li $t0, 4
sw $t0, ($s0)
addi $s0, $s0, 4
addi $s2, $s2, -8
l.d $f4, ($s2)
addi $s0, $s0, -4
lw $t0, ($s0)
mtc1 $t0, $f6
cvt.d.w $f6, $f6
c.lt.d $f4, $f6
bc1t _else12 
li $t3, 1
sw $t3, ($s4)
addi $s4, $s4, 4
j _afterIf12 
_else12: 
sw $zero, ($s4)
addi $s4, $s4, 4
_afterIf12: 
addi $s4, $s4, -4
lw $t0, ($s4)
beq $t0, 0, _afterIf13 
li $t0, 1
sw $t0, ($s0)
addi $s0, $s0, 4
li $v0 1
addi $s0, $s0, -4
lw $a0, ($s0)
syscall
li $v0, 4
la $a0, _newLine
syscall
_afterIf13: 
li $v0, 10
syscall
