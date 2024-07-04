# Биномиальное разложение

## Описание:
Цель этого ката - написать программу, которая может выполнять некоторые алгебраические операции.  

Напишите функцию `expand`, которая принимает выражение с одной-единственной символьной переменной и раскладывает его. Выражение имеет вид 
`(ax+b)^n`, где `a` и `b` - целые числа, которые могут быть положительными или отрицательными, `x` - любая односимвольная переменная, а `n` - 
натуральное число. Если a = 1, то перед переменной не будет поставлен коэффициент. Если a = -1, то перед переменной будет поставлен знак "-".  

Развернутая форма должна быть возвращена в виде строки в виде `ax^b+cx^d+ex^f...`, где `a`, `c` и `e` являются коэффициентами соответствующих 
членов выражения, `x` - исходная односимвольная переменная, которая была передана в исходное выражение, `b`, `d` и `f` - это степени, в которые 
`x` возводится в каждом члене, и они расположены в порядке убывания.  

Если коэффициент члена равен нулю, то этот член не следует включать в итоговое выражения. Если коэффициент члена равен единице, то этот 
коэффициент включать не следует. Если коэффициент члена равен -1, то следует включать только "-". Если степень члена равна 0, то должен быть 
включен только коэффициент. Если степень члена равна 1, то циркумфлекс (^) и степень должны быть исключены.

## Примеры:
```java
KataSolution.expand("(x+1)^2");      // возвращает "x^2+2x+1"
KataSolution.expand("(p-1)^3");      // возвращает "p^3-3p^2+3p-1"
KataSolution.expand("(2f+4)^6");     // возвращает "64f^6+768f^5+3840f^4+10240f^3+15360f^2+12288f+4096"
KataSolution.expand("(-2a-4)^0");    // возвращает "1"
KataSolution.expand("(-12t+43)^2");  // возвращает "144t^2-1032t+1849"
KataSolution.expand("(r+0)^203");    // возвращает "r^203"
KataSolution.expand("(-x-1)^2");     // возвращает "x^2+2x+1"
```