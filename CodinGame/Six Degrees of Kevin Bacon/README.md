# Six Degrees of Kevin Bacon

## Goal
**Six Degrees of Kevin Bacon** is a pop-culture game in which an arbitrarily chosen actor is repeatedly connected to another actor via a movie 
that both actors have appeared in together, repeating this process to try to find the shortest path that ultimately leads to the prolific 
American actor **Kevin Bacon**.  

Given an `actor_name`, an integer `n` and then that many `movie_casts` determine the **Bacon number** of `actor_name`, i.e. the minimum number of 
movies needed to link `actor_name` to **Kevin Bacon**.

## Input
- **Line 1:** `actor_name`, the name of the actor whose **Bacon number** is being calculated.
- **Line 2:** an integer `n`.
- **Next `n` lines:** a string `movie_cast` in the format `Movie_name`: `Actor 1`, `Actor 2`, ...

## Output
**1 line:** an integer representing the **Bacon number** of `actor_name`: the minimum number of movies needed to connect `actor_name` to 
**Kevin Bacon**.

## Constraints
- There will always be a path to **Kevin Bacon**.
- 0 < `n` < 50.
- Movie casts will contain at most 10 actors.
- A single colon (followed by a space) is used to separate the movie title from the movie cast. A single comma (followed by a space) is used to separate the cast members.
- There will be no colons (:) in movie titles or actor names.

## Example
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
			Elvis Presley</br>
			3</br>
			Change of Habit: Elvis Presley, Mary Tyler Moore, Barbara McNair, Jane Elliot, Ed Asner</br>
			JFK: Kevin Costner, Kevin Bacon, Tommy Lee Jones, Laurie Metcalf, Gary Oldman, Ed Asner</br>
			Sleepers: Kevin Bacon, Jason Patric, Brad Pitt, Robert De Niro, Dustin Hoffman
        </td>
        <td>
			2
		</td>
    </tr>
  </tbody>
</table>

## Note
The answer is **2** because **Elvis Presley** → **Ed Asner** → **Kevin Bacon**, using **Change of Habit** to connect **Presley** and **Asner** and 
then **JFK** to connect **Asner** to **Bacon** = **2** degrees of separation.