Due to the unexpected departure of one of our group members, we had to modify some of the requirements for this project. 
So far, we have a launch activity that lets users start a new game or continue an existing game, as well as a main activity 
that is split into 3 tabs (map, current objective, objectives list).

Map fragment - We had a lot of trouble with getting GPS to work, especially with tracking the current location of the device 
and dynamically updating the display. Currently, our map places a marker where the current objective is located, which can serve 
as a "hint" for the player, since they now have no idea where they are positioned on the map.

Current objective fragment - Shows an image of the current objective, along with a button for when the user finds the objective.

Objectives list fragment - Shows a randomized list of objectives for each game, and pressing an objective will display a new activity 
with more details.

Eventually, we would like to implement a firebase databases to store all the objectives. This would allow us to dynamically update
what objectives are found by the user when they click the found button. We would also be able to save a user's current game objectives.