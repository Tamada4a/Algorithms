# J. Formatting the document
<table>
  <tr>
      <td>Time limit</td>
      <td>2 second</td>
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

Vasya is writing a new version of his office suite "Closed Office". He recently started working on the "Dword" editor 
included in the package.  

The last problem that Vasya faced was the placement of images in the document. There is no way he can achieve a stable 
display of images in the places where he places them. Finally desperate to write the appropriate module on his own, 
Vasya decided to ask you for help. Write a program that will place the document on the page.  

A document in the "Dword" editor format is a sequence of paragraphs. Each paragraph is a sequence of elements – words and 
images. The elements of one paragraph are separated by spaces and/or line feed. Paragraphs are separated by an empty line. 
A string consisting only of spaces is considered empty.  

A word is a sequence of characters consisting of letters of the Latin alphabet, numbers, and punctuation marks: 
".", ",", ":", ";", "!", "?", "-", "'".  

The image is described as follows: "(<b>image</b> image parameters)". Each parameter of the image has the form "name=value". 
The image parameters are separated by spaces and/or line feed. Each image must have the following parameters:
<table>
  <thead>
    <tr>
      <th align= "left">Parameters</th>
      <th align= "left">Description</th>
    </tr>
  </thead>
  <tr>
      <td>width</td>
      <td>A positive integer is the width of the image in pixels</td>
  </tr>
  <tr>
      <td>height</td>
      <td>A positive integer is the height of the image in pixels</td>
  </tr>
  <tr>
      <td>layout</td>
      <td>One of the following values: embedded (in the text), surrounded (text wrapping), floating (free) – describes 
	  the location of the image relative to the text</td>
  </tr>
</table>

The document is placed on an infinite up and down page with a width of <i>w</i> pixels (splitting into finite-height pages 
is planned in the next version of the editor). One of the points on the left border of the page is conventionally considered 
a point with an ordinate equal to zero. The ordinate increases downwards.  

The document is placed as follows. Paragraphs are placed in turn. The first paragraph is placed so that its upper bound has the 
ordinate 0.  

<div align="center"><img src=".assets/width.png?raw=true" alt="Element width" height="206"/></div>

The paragraph is placed as follows. The elements are arranged in rows. Each row initially has a height of <i>h</i> pixels. 
In the process of placing images, the height of the lines may increase, and the lines may be broken into fragments by images.

<div align="center"><img src="./assets/fragments.png?raw=true" alt="An example of splitting a row into fragments" height="160"/></div>

The words are placed as follows. It is assumed that each character has a width of <i>c</i> pixels. Before each word, except for the 
first one in the fragment, a space is also placed with a width of <i>c</i> pixels. If a word is placed in the current fragment, then 
it is placed on it. If a word does not fit in the current fragment, then it is placed in the first fragment of the current line, 
located to the right of the current one in which it is placed. If there is no such fragment, then a new line begins, and the search 
for a suitable fragment continues in it. The word is always "pressed" to the upper border of the line.  

The placement of the image depends on its location relative to the text.  

If the location of the image relative to the text is set to "<i>embedded</i>", then it is positioned the same as the word, except 
that its width is equal to the width specified in the image parameters. In addition, if the height of the image is greater than 
the current line height, then it increases to the height of the image (while the upper border of the line does not move, but the 
lower border moves down). If a image of the type "<i>embedded</i>" is not the first element in the fragment, then a space <i>c</i> 
pixels wide is placed in front of it. Images of the type "<i>embedded</i>" are also pressed against the upper border of the line.  

If the location of the image relative to the text is set to "<i>surrounded</i>", then the image is placed as follows. First, 
the first fragment is similarly located, in which the image is placed in width. At the same time, a space is not placed before a 
image of this type, even if it is not the first element in the fragment.  

After that, the image is placed as follows: the upper edge of the image coincides with the upper border of the line in which the 
found fragment is located, and the image itself continues downwards. At the same time, the lines through which it passes are broken 
into fragments by it.  

If the location of the image relative to the text is set to "<i>floating</i>", then the image is placed on top of the text and 
other images and does not interact with them in any way. In this case, the image has two additional parameters: "<i>dx</i>" and 
"<i>dy</i>" — integers that specify the offset in pixels of the upper-left corner of the image to the right and down, respectively, 
relative to the position where the upper-right corner of the previous word or the image (or the leftmost upper point of the first 
line of the paragraph, if the image is the first element of the paragraph).  

If, when placing the image in this way, it goes beyond the left border of the page, then it is shifted to the right, so that its 
left edge coincides with the left border of the page. Similarly, if the image goes beyond the right border of the page, it is shifted 
to the left so that its right edge coincides with the right border of the page.  

The upper border of the next paragraph coincides with the lower point from the lower border of the last line and the lowest border of 
the "<i>surrounded</i>" images of the previous paragraph.  

Using the given <i>w</i>, <i>h</i>, <i>c</i> and the document, find the coordinates of the upper-left corners of all images in the document.

## Input format
The first line of the input file contains three integers: <i>w</i>, <i>h</i> and <i>c</i> (1 ≤ <i>w</i> ≤ 1000, 1 ≤ <i>h</i> ≤ 50, 
1 ≤ <i>c</i> ≤ <i>w</i>).

The document follows. The size of the input file does not exceed 1000 bytes. It is guaranteed that the width of any word and any image 
does not exceed <i>w</i>. The height of all images does not exceed 1000. The relative displacement of all images of the "<i>floating</i>" 
type does not exceed 1000 in absolute value.

## Output format
Print two numbers for each image to the output file — the coordinates of its upper-left corner. Print the coordinates of the images 
in the order in which they occur in the input file.

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
          120 10 8</br>
          start (image layout=embedded width=12 height=5)</br>
          (image layout=surrounded width=25 height=58)</br>
          and word is</br>
          (image layout=floating dx=18 dy=-15 width=25 height=20)</br>
          here new</br> 
          (image layout=embedded width=20 height=22)</br>
          another</br>
          (image layout=embedded width=40 height=19)</br>
          longword</br>
          </br>
          new paragraph</br>
          (image layout=surrounded width=5 height=30)</br>
          (image layout=floating width=20 height=35 dx=50 dy=-16)</br>
        </td>
        <td>
          48 0</br>
          60 0</br>
          74 -5</br>
          32 20</br>
          0 52</br>
          104 81</br>
          100 65
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
        <td>1000 2 3</td>
        <td></td>
    </tr>
  </tbody>  
</table>

## Example 3
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
          100 2 3</br>
          (image dx=10 dy=11 height=100 width=20 layout=floating)
        </td>
        <td>10 11</td>
    </tr>
  </tbody>
</table>

## Notes
Below is a picture showing the location of the images in the first example.

<div align="center"><img src="./assets/example.png?raw=true" alt="Image showing the location of the images in the first example" height="421"/></div>