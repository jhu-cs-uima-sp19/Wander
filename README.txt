Our app is a GPS based scavenger hunt game called Wander. The games contains three main screens that can be navigated to by the
bottom menu of tabs. 

Map fragment - This screen displays a map of the user's current location using the Google Maps API. The user is displayed as the
typical blue dot on the map and the objectives that the user successfully finds get marked by a pin.

Current objective fragment - Shows an image of the current objective, along with a button for when the user finds the objective. When
the user is close enough to the objective and they hit the button a pin is dropped on the map and the location is marked as found. The
current objective can be set in the objective details in the objective list fragment.

Objectives list fragment - Shows a randomized list of objectives for each game, and pressing an objective will display a new activity 
with more details. Hitting the set current button in the objective details upadates the current objective in the current objective fragment.

Extra notes- The current radius is set at 20000 feet for finding a location for purposes of testing. This radius can be changed by editing 
the rad parameter of the verify distance method on line 65 of the CurrentObjectiveActivity java file. In the android device settings permission
needs to be given to our app to access the current location.The current GPS location of the virtual android devices is typically set to the Googleplex in California. 
This location can be edited in the extended controls of the virtual device. 
