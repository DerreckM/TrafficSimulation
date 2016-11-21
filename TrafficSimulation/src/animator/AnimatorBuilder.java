package animator;

import model.CarAcceptor;
import model.LightObject;
import model.RoadEnd;
import animator.Animator;

public interface AnimatorBuilder {

  public Animator getAnimator();
  public void addLight(RoadEnd intersections, int i, int j);
  public void addHorizontalRoad(CarAcceptor l, int i, int j, boolean eastToWest);
  public void addVerticalRoad(CarAcceptor l, int i, int j, boolean southToNorth);
}

class NullAnimatorBuilder implements AnimatorBuilder {
  public Animator getAnimator() { return new NullAnimator(); }
  public void addLight(RoadEnd d, int i, int j) { }
  public void addHorizontalRoad(CarAcceptor l, int i, int j, boolean eastToWest) { }
  public void addVerticalRoad(CarAcceptor l, int i, int j, boolean southToNorth) { }
}

class NullAnimator implements Animator {
  public void update(java.util.Observable o, Object arg) { }
  public void dispose() { }
}