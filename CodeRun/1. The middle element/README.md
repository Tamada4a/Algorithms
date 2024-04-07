# 1. The middle element
Consider three numbers <i>a</i>, <i>b</i> and <i>c</i>. Let's arrange them in ascending order.  

What number will stand between the other two?  

The solution to this problem in C++ could look like this:
```c++
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int a[3];
    for (int i = 0; i < 3; ++i) cin >> a[i];
    sort(a, a + 3);
    cout << a[1] << endl;
    return 0;
}
```

## Input format
Three integers are written in a single line <i>a</i>, <i>b</i>, <i>c</i> (-1000 ≤ <i>a</i>, <i>b</i>, <i>c</i> ≤ 1000), 
the numbers are separated by single spaces.

## Output format
Print the number that will stand between the other two after ordering.

## Example 1
| Input | Output |
|:------|:-------|
| 1 2 3 | 2      |

## Example 2
| Input        | Output |
|:-------------|:-------|
| 1000 -1000 0 | 0      |

## Example 3
| Input | Output |
|:------|:-------|
| 3 1 3 | 3      |