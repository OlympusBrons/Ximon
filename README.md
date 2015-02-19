# **Ximon**

This game is a mock-up of the classic Simon game.

I am somewhat new to programming in Java, and very new to Android and libgdx. This is my first Android game. It may take me a good while for this to be completed, but I will gladly soak up the experience. I'll also be open to any advice if possible. I will post in the issues section if I run into any serious trouble.


##--- **When finished, there will be...** ---
- A normal/classic game mode, nostaligically familiar to the original Simon game.

######( THE FOLLOWING CONCEPTS ARE MOST PROBABLY SUBJECT TO CHANGE )

- Perhaps a "X" mode that gradually increases speed of Simon, and you must keep up with his pace or else you lose.
- A "Xyncopation" mode. The idea is instead of ONLY having to copy the correct order of button pushes, you also have to keep up with his tempo (more or less)... probably using java's System.currentTimeMillis() to judge your tempo accuracy. This game mode will likely include a metrenome or some looped drum beat.
- A "Xycho" mode will be just like normal except he will begin to actually rotate slowly, picking up some speed, changing direction as he pleases. (This one is only an idea. Need feedback because I'm not sure if this will be more annoying than challenging.)

##--- **Progress Log** ---
 (2/6/15)
- I included the libgdx library.

(2/7/15)
- Nothing is functional yet, I literally just created the project and added some png files. 

(2/9/2015)
- Still not functional. I have sounds and a new way of displaying it on the screen (as a texture instead of using xml layout). 
- I'm realizing new ideas as I explore libgdx features.

(2/10/2015)
- Currently remaking the game buttons. 

(2/17/2015)
- After taking a break, I came back and made the buttons functional... as in, when I push them, they make a sound, and when I let go, it stops. 
- The size problem needs fixing, and the buttons need polishing. 

(2/18/2015)
- Fixed the position and sizing problem
- Feathered edges of buttons
- Buttons light up when you press them

##--- **Tasks** ---

- [x] Add png files
- [x] Link png to XML
- [x] Add sound effects
- [x] Make the "buttons" interactive (each one plays corresponding sound effect)
- [x] Each button lights up when pressed
- [ ] Create main menu
- [ ] Build data structure (ArrayList) for handling the turns
- [ ] Implement the turns (computer generates random color, adds to the ArrayList, and "pushes" buttons in order)
- [ ] Create GAME OVER screen with scoreboard

