"Project 1" by Koichi 

[ Things left to do:
	- Include the health system (I made a super lazy start of it)
	- Add enemy attack (event that kills the player)
]

Use American dialect, brief room descriptions, and the serial comma.
The display banner rule is not listed in the startup rulebook.

[ Directions ] 
[When play begins, say "Directions: To play this game, go north, south, east, or west. You may look at certain things, but they do not aid you in progressing through the story."]

[ Definitions ] 
A thing can be distant or near. A thing is usually near. 
Direction-looking is an action applying to one visible thing and requiring light. Understand "look [direction]" or "look at [direction]" as direction-looking.
A person has a number called maximum health. A person has a number called current health. 
The maximum health of the player is 5. The current health of the player is 5. 


[ Actions ]
Instead of doing anything other than examining to a distant thing:
	say "[The noun] [are] too far away."
Carry out direction-looking:
	say "You see nothing unusual in that direction."
	
[ -- RULES -- ]

[ BACKPACK ]
Instead of inserting something into the backpack:
	if the backpack is not open:
		say "You can't put anything into the backpack until you open it.";
	otherwise:
		continue the action.
		
[ HEALTH ]
Every turn:
	now the right hand status line is "You: [current health of player] hp"; 
	if a random chance of 1 in 5 succeeds:
		say "[one of]Ouch! You tripped on a rock.[or]You were attacked by a boar![or]You are startled by a bird and run into a tree.[at random]";
		if current health of the player is 3:
			now current health of the player is 0;
		if current health of the player is 5:
			now current health of the player is 3;
		
		
[Winning Condition]
Every turn:
	If the player is in Lynesera:
		end the story saying "You met your Grandmother."	
		
[Losing Condition]
Every turn:
	If the current health of the player is 0:
		end the story saying "You have sustained too many injuries. You have died.";
	If the player is in The Thieves-den:
		end the story saying "The Theif has stopped you. You suddenly feel light headed... The Theif has stabbed you! He steals all your stuff as you begin to bleed out into white...";	
		
[ Terminology ] 
Magic is a thing. The description is "Magic is a force of nature and a part of the world."

[ -- WORLD BUILDING -- ]

[ Region ]
Eran is a region. Gaea's Cradle, Allune, Shrine, Thieves-den, and Lynesera are in Eran.

[ Backdrop ]
The sky is a backdrop. The description is "A clear and cloudless blue." The sky is in Eran.
The ground is a backdrop. The description is "Lots of dirt floating around." The ground is in Eran.

[ Starting Health ]
When play begins:
	now the right hand status line is "You: [current health of player] hp"; 
	
[ -- ITEMS -- ]

[ Defining Fruit ]
A fruit is a kind of thing. The raspberry is a fruit. The blackberry is a fruit. The blueberries is a fruit. The apple is a fruit. Fruit is edible.
Check the player eating the fruit: 
	now the current health of the player is 5.

[ Defines a way of carrying items ]
The player carries a backpack. The backpack is a lockable container. The backpack is a player's holdall. It is not fixed in place. 

[ -- STARTING ITEMS -- ] 
The player carries a silver key. The silver key unlocks the backpack. [just allows player to lock and unlock backpack]
The apple is in the backpack. [item to start with]
The letter is in the backpack. The description is "Your grandmother who lives in Lynesera. She wrote to you to come and visit because she misses you dearly.".


[ -- PLAYER STATS -- ]
The carrying capacity of the player is 50. 

[ -- ROOMS -- ]

[ Starting Area: Gaea's Cradle ]
Gaea's Cradle is a room. The printed name of Gaea's Cradle is "Gaea's Cradle". The description is "Tall old trees surround you, towering over the sky, watching over the bending path. The bending path continues north for miles ahead. To the west, among the path, you see an old shrine. Behind you is your hometown, Allune. To your right in the East, you see a long beaten trail that goes deep into the woods. You packed all you needed for your journey in your backpack."
	
	[ Description ]
	Some tall old trees are scenery in Gaea's Cradle. The description is "Magic oak trees covering your view of the sky with old, grown branches."  Understand "oak","tree","old","grown", and "branches" as the tall old trees. 
	
	[ Preventative Actions in Gaea's Cradle ]
	Instead of climbing the tall old trees:
		say "The forest grows ominous. You begin to hear the ground rumbling in the distance. You begin to panic."
	Instead of going south from Gaea's Cradle:
		say "You take a few steps towards your hometown, but remembering that you have to see Grandmother, you return to the path."
	[Instead of going west from Gaea's Cradle:
		say "You cannot go there. But you can admire the shrine."]
		
[ South Path: Allune ]
	Allune is south of Gaea's Cradle. The description is "A town where you currently live. Populated by peasants, there is not much infrastructure aside from the postal office."

[ West Path: Shrine ]
	The Shrine is west of Gaea's Cradle. The description is "The broken shrine appears to be old and covered in moss." Understand "broken", "shrine", "old", and "moss" as shrine.

[ East Path: The Beaten Path ]
	The Beaten Path is a room. The printed name is "The Beaten Path". The beaten path is east of Gaea's Cradle and west of Thieves-den. The description is "It's a dirty, beaten path that looks like it leads somewhere."

[ East End: Thieve's Den ]
	The Thieves-den is east of the beaten path. The printed name is "The Thieve's Den". "A dilapidated building in the middle of the forest." Understand "dilapidated" and "building" as Thieves-den.

[ Gaea's End ]
	Gaea's End is north of Gaea's Cradle. "The end of the forest that leads a lavish city."

[ Lynesera ]
	Lynesera is north of Gaea's End.  The description is "The path from the south ends at the silver gates, leading to a path into a city built into the base of a large Deku tree."

[ People ] 
Grandmother is a person in Lynesera. The description is "Your grandmother who lives in Lynesera. She wrote to you to come and visit because she misses you dearly."
The Thief is in the Thieves-den. The description is "Someone who wants to rob you!"
The description of the player is "There is no mirror, so you're not sure what you look like."