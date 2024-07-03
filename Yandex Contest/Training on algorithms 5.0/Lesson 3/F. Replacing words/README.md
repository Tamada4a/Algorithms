# F. Replacing words

<table>
  <tr>
      <td>Time limit</td>
      <td>1 second</td>
  </tr>
  <tr>
      <td>Memory limit</td>
      <td>64Mb</td>
  </tr>
  <tr>
      <td>Input</td>
      <td>standart input or input.txt</td>
  </tr>
  <tr>
      <td>Output</td>
      <td>standart output or output.txt</td>
  </tr>
</table>

In order to save ink in the printer cartridge, it was decided to shorten some words in the text. To do this, a dictionary of words has been 
compiled to which longer words can be shortened. A word from the text can be shortened if there is a word in the dictionary that is the beginning 
of a word from the text. For example, if the word "may" is in the list, then the words from the text "maypole", "Maya" and other words 
starting with "may" can be shortened to "may".  

If a word from the text can be shortened to several words from the dictionary, then it should be shortened to the shortest word.

## Input format
In the first line, words from the dictionary are entered separated by a space, the words consist of small Latin letters. It is guaranteed that the 
dictionary is not empty and the number of words in the dictionary does not exceed 1000, and the length of words is 100 characters.  

In the second line, the words of the text are entered through a space (they also consist only of small Latin letters). The number of words in the 
text does not exceed 10<sup>5</sup>, and the total number of letters in them is 10<sup>6</sup>.

## Output format
Print the text in which the substitutions are made.

## Example 1
<table>
  <thead>
    <tr>
      <th align= "left">Input</th>
      <th align= "left">Output</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        a b</br>
        abdafb basrt casds dsasa a
      </td>
      <td>
        a b casds dsasa a
      </td>
    </tr>
  </tbody>
</table>

## Example 2
<table>
  <thead>
    <tr>
      <th align= "left">Input</th>
      <th align= "left">Output</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        aa bc aaa</br>
        a aa aaa bcd abcd
      </td>
      <td>
        a aa aa bc abcd
      </td>
    </tr>
  </tbody>
</table>
