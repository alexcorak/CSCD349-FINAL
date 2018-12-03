Teammembers Contribution:
Nick: Dungeon, Room, Vision potion, Flyweight/Strategy/Singleton, Factories, DungeonAdventure, Hero methods

Alex: Additional Monsters, Additional Heroes, Save/Load Memento, 
Hero toString, Hero Fields, Balancing, Flyweight, Factories, Dungeon Adventure

Vision potion reveals the rooms that you can enter from your current position. If the room appears blank,
it means it is empty.

Output:

Welcome to the Dungeon Adventure!
The Dungeon is a 25 room labyrinth filled with pitfalls, treasures, monsters, and more!
The map is revealed as you trek through its halls, with the following symbols for a legend:
@ - Your current position
# - A room you've already visited
P - A pit your hero may fall into
I - The entrance to the dungeon, and where your adventure begins
O - The exit to the dungeon, you cannot leave until you've found the pillars
M - A multiple item room; may have potions, a pit, or both!
X - An evil monster inhabits this room
R - A pillar is in this room, the goal of your quest is to gather all 4 Pillars of OO
Enter anything to continue: 

Choose a hero by number:
1. Warrior
2. Sorceress
3. Thief
4. Archer
5. Berserker

1
Enter character name: alex

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | @ | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 
1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
1
Your room contains: I
Pillars found: 0

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | @ | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

Where would you like to move?
1) Up
2) Down
3) Right
4) Left
5) Back to main menu

2
Your room contains: R
Congrats! You've found a Pillar of OO!

Pillars found: 1

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | I | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | @ | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

Where would you like to move?
1) Up
2) Down
3) Right
4) Left
5) Back to main menu

3
Your room contains: V
Congrats! You've found a vision potion!

Pillars found: 1

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | I | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | # | | @ | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

Where would you like to move?
1) Up
2) Down
3) Right
4) Left
5) Back to main menu

2
Your room contains: V
Congrats! You've found a vision potion!

Pillars found: 1

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | I | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | # | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | | @ | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

Where would you like to move?
1) Up
2) Down
3) Right
4) Left
5) Back to main menu

1
Your room contains: #
Pillars found: 1

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | I | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | # | | @ | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

Where would you like to move?
1) Up
2) Down
3) Right
4) Left
5) Back to main menu

1
Your room contains:  
Pillars found: 1

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | I | | @ | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | # | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

Where would you like to move?
1) Up
2) Down
3) Right
4) Left
5) Back to main menu

5
1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
2
Vision Potions left: 2
1) Use Vision Potion
2) Use Health Potion
3) Back to main menu
1
1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
1
Your room contains:  
* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | I | | @ | | X * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | # | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 
Pillars found: 1


Where would you like to move?
1) Up
2) Down
3) Right
4) Left
5) Back to main menu

5
1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
3
Originator: Setting state to map
Originator: Setting state to alex
Saving to Memento. 
Enter a filename: 
save2
Hero has been saved
1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
5


Enter character name: oiuqewporiuqweoiruqwepoiu

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | | @ * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 
1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
6
Enter a filename: 
save1
File Not Found. Please check the filename, and do not include the extension.
Name: oiuqewporiuqweoiruqwepoiu Current HP: 110  Pillars of OO found: 0

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | | @ * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
6
Enter a filename: 
save2
Name: alex Current HP: 135  Vision Potions left: 1 Pillars of OO found: 1

* * * * * * * * * * * * * * * 
*   | |   | |   | |   | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | I | | @ | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | | # | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | | # | |   * 
* - * * - * * - * * - * * - * 
* - * * - * * - * * - * * - * 
*   | |   | |   | |   | |   * 
* * * * * * * * * * * * * * * 

1) Move hero
2) Access Inventory
3) Save game
5) Quit
6) Load
