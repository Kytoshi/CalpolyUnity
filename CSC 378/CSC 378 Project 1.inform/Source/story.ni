"CSC 378 Project 1" by Koichi 

[http://inform7.com/book/RB_6_8.html]
A thing can be examined or unexamined.
After taking something unexamined:
	say "Taken. [run paragraph on]";
	try examining the noun.
	
Carry out examining something:
	now the noun is examined.
[]

a thing can be gross.
check taking something gross:
	say "I don't think I want to pick that up..."

Outdoors is a region. The Front, LeftHouse, RightHouse, Backhouse are in Outdoors.

The Front is a room. "There is an abandoned [house] in front of you. All the windows and doors are boarded up. There seems to be no entry from this side of the house." 
The printed name of the Front is "Front Porch".

house are scenery in the Front.

The LeftHouse is a room. "You are facing the West side of the house. Windows are boarded up on this side too. Gotta be some way in." 
The printed name of the LeftHouse is "West side of the House".
West of the Front is the LeftHouse.

The RightHouse is a room. "[if RightHouse is unvisited] A couple racoons scurry away as you turn the corner. [end if] You are facing the East side of the house. There is a knocked over [trash can] that the racoons were looting."
The printed name of RightHouse is "East side of the House".
East of the Front is the RightHouse.
trash can are scenery in RightHouse. 
The knife is a thing in the trash can.
rotten food are things in the trash can.
rotten food is gross.


The BackHouse is a room. 
