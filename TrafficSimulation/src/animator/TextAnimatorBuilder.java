package animator;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import animator.AnimatorBuilder;
import model.CarAcceptor;
import model.RoadEnd;
import model.Car;
import animator.Animator;

// this class builds Animators
public class TextAnimatorBuilder implements AnimatorBuilder {
  TextAnimator animator;
  public TextAnimatorBuilder() {
    animator = new TextAnimator();
  }
  
  public Animator getAnimator() {
    if (animator == null) { throw new IllegalStateException(); }
    Animator returnValue = animator;
    animator = null;
    return returnValue;
  }
  
  public void addLight(RoadEnd a, int i, int j) {
    animator.addLight(a,i,j);
  }
  
  public void addHorizontalRoad(CarAcceptor b, int i, int j, boolean eastToWest) {
    animator.addRoad(b,i,j);
  }
  
  public void addVerticalRoad(CarAcceptor b, int i, int j, boolean southToNorth) {
    animator.addRoad(b,i,j);
  }


  // this is the class for drawing the Model
  private static class TextAnimator implements Animator {

    private static class Element<T> {
      T x;
      int i;
      int j;
      Element(T x, int i, int j) {
        this.x = x;
        this.i = i;
        this.j = j;
      }
    }
    
    private List<Element<CarAcceptor>> roadElements;
    private List<Element<RoadEnd>> lightElements;
    TextAnimator() {
      roadElements = new ArrayList<Element<CarAcceptor>>();
      lightElements = new ArrayList<Element<RoadEnd>>();
    }
    
    void addLight(RoadEnd x, int i, int j) {
      lightElements.add(new Element<RoadEnd>(x,i,j));
    }
    
    void addRoad(CarAcceptor x, int i, int j) {
      roadElements.add(new Element<CarAcceptor>(x,i,j));
    }
    
    public void dispose() { }
    
    public void update(Observable o, Object arg) {
      for (Element<RoadEnd> e : lightElements) {
        System.out.print("Light at (" + e.i + "," + e.j + "): ");
        if (e.x.getLight().getState()) {
          System.out.println("Green");
        } else {
          System.out.println("Yellow");
        }
      }
      for (Element<CarAcceptor> e : roadElements) {
        for (Car d : e.x.getCars()) {
          System.out.print("Road at (" + e.i + "," + e.j + "): ");
          System.out.println("Car at " + d.getFirstPosition());
        }
      }
    }
  }
}