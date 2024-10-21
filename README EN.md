<H1>WELCOME TO SHAMBALA</H1>

The Shambala Project is a project to create and digitize a tabletop role-playing game of the same name, which I am the author of.
The goal is twofold: to improve my technical skills and to code an application for my players that will initially provide them with a digital character sheet.
Yes, I know, purists prefer pencil and paper... and so do I :)
But it is also a technical and practical challenge for my job as a JAVA developer, combining business with pleasure.

Here are the objectives I aim to achieve in this project (version 1.0):

<br> 
<br> 
<h2>----------------------- PART 1: Character Sheet Elements ----------------------- </h2> 
<br>

Creation of the different parts of the character sheet:
<p>-> User information: name, first name, email, username, password, list of characters.</p> 
<p>-> Civil information of the character: portrait, name, first name, age, ethnicity, class, level, overall experience, class experience, and background. Linked to personal characteristics and equipment.</p> 
<p>-> Initial characteristics: hit points / max hit points, EN* points / max EN points, luck points, protection.</p> 
<p>-> Main characteristics: physical, dexterity, psychic, willpower, and combat.</p> 
<p>-> Sub-characteristics: a list of different abilities linked to a main characteristic.</p> 
<p>-> Equipment: helmet, bracers, cuirass, greaves, boots, left hand, and right hand.</p> 
<p>-> Skills: players can choose 3 from a list.</p> <p>-> Inventory: a list of various items that the player owns.</p> 
<p>-> Dice roll: type of die (D20, D100, D6...) and its rolled value.</p> 
<br> 
<br> 
*EN = Ethernano, comparable to magic points in my universe. 
<h2>----------------------- PART 2: The Logic ----------------------- </h2>
<br>

Creating a character requires following certain rules inherent to the game itself and the application:

User:
<li>Each field must be filled out.</li> 
<li>The email address must be valid.</li> 
<li>The username must not already be in use.</li>
<li>Password must be at least 8 characters long, special characters accepted.</li> 
<li>Character retrieval.</li> 
<br>

Character information:
<br>
<li>The character must have a name, written with alphabetic characters.</li>
<li>The character must have a global level and a class level of at least 0, with no defined maximum.</li> 
<li>The character must have global experience and class experience of at least 0, with no defined maximum.</li> 
<br>

Character's main and sub-characteristics:
<li>Main characteristics (physical, dexterity, psychic, willpower, and combat) have values ranging from 10 to 50, divisible by 5 (15, 20, 25...).</li> 
<li>There are 150 points to distribute among the 5 main characteristics.</li> 
<li>Each main characteristic has 4 sub-characteristics chosen from a list.</li> 
<li>Sub-characteristics have values ranging from 5 to 30, divisible by 5 (15, 20, 25...).</li> 
<li>There are 300 points to distribute among the 20 main sub-characteristics.</li> 
<li>Sub-characteristics have a type that links them to a specific main characteristic (e.g., endurance = physical, erudition = psychic).</li> 
<br>

Equipment:
<li>The character has modifiable equipment.</li>
<li>When a two-handed weapon is equipped, no other weapons can be equipped.</li>
<li>Only one piece of equipment per slot.</li> 
<br>

Skills:
<li>3 skills can be chosen from a list.</li> 
<li>No duplicate skills.</li> 
<br>

Inventory:
<li>Access to the list of items in the bag.</li>
<br>

Dice roll:
<li>The dice roll is an event with a random result depending on the die (e.g., 1D100 = number between 1 and 100).</li> 
<li>Successful dice roll: die value is lower than main characteristic + sub-characteristic.</li> 
<li>Successful dice roll with bonus: die value is lower than main characteristic + sub-characteristic, and the value is 5 or less.</li> 
<li>Failed dice roll: die value is higher than main characteristic + sub-characteristic.</li> 
<li>Failed dice roll with penalty: die value is higher than main characteristic + sub-characteristic, and the value is 96 or less.</li> 
<br>
<br>

<h2>----------------------- PART 3: Database Integration ----------------------- </h2> 
<br>
