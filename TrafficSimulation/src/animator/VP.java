package animator;

import model.MP;

//  Static class for view parameters.
class VP {
  private VP() {}  								
  static double elementWidth = MP.carLength;	// the width of model elements (in meters)  
  static double gap = 1;						// the gap between model elements (in meters) 
  static int displayWidth = 1000;				// the width of displayed graphics window (in pixels)
  static int displayHeight = 1000;				// the height of displayed graphics window (in pixels)
  static int displayDelay = 50;					// the delay into each graphics update (in milliseconds)  
  static double scaleFactor = 1;				// the scaleFactor relating model space to pixels (in pixels/meter) 
}