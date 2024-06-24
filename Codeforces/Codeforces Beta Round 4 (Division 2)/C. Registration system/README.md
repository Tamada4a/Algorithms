# C. Registration system
time limit per test: 5 seconds
memory limit per test: 64 megabytes  
input: standard input  
output: standard output

In the near future, a new "Berlandesk" postal service will open in Berland. The site administration wants to launch their project as soon as 
possible, so they asked you for help. You are invited to implement a prototype of the site registration system.

The system should work according to the following principle. Every time a new user wants to register, he sends the system a *name* request with 
his name. If this name is not contained in the system database, then it is entered there and the user receives an answer *OK* confirming 
successful registration. If a user with the name *name* is already present on the site, the system generates a new name and gives it to the 
user as a hint, *at the same time, the hint is also added to the database*. The new name is formed according to the following rule. Numbers 
are sequentially assigned to *name*, starting with one (*name1*, *name2*, ...), and among them they find such a smallest *i* that *namei* is not 
contained in the site database.

## Input
The first line of the input data contains the number *n* (1 ≤ *n* ≤ 10<sup>5</sup>). The following *n* lines contain requests to the system. 
Each query is a non-empty string of no more than 32 characters long, consisting only of lowercase letters of the Latin alphabet.

## Output
The output data should contain n lines — the system's responses to requests: *OK* in case of successful registration, or a hint with a new name 
if the requested one is already occupied.

## Examples
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
			4</br>
			abacaba</br>
			acaba</br>
			abacaba</br>
			acab
        </td>
        <td>
			OK</br>
			OK</br>
			abacaba1</br>
			OK
		</td>
    </tr>
  </tbody>
</table>

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
			6</br>
			first</br>
			first</br>
			second</br>
			second</br>
			third</br>
			third
        </td>
        <td>
			OK</br>
			first1</br>
			OK</br>
			second1</br>
			OK</br>
			third1
		</td>
    </tr>
  </tbody>
</table>
