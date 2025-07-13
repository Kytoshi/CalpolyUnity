import processing.core.PImage;

import java.util.List;

public class Quake extends AnimatedEntity {
//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int actionPeriod;
//    private int imageIndex;
//    private static int animationPeriod;
//
//    public static final String QUAKE_KEY = "quake";
    public static final int QUAKE_ANIMATION_REPEAT_COUNT = 10;

    public Quake(String id, Point position, List<PImage> images, int actionPeriod, int animationPeriod)
    {
        super(id, position, images, "quake",actionPeriod, animationPeriod);
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.actionPeriod = actionPeriod;
//        this.animationPeriod = animationPeriod;
//        this.imageIndex = 0;
    }
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore)
    {
        scheduler.scheduleEvent(this,
                this.createActivityAction(world, imageStore),
                this.getActionPeriod());
        scheduler.scheduleEvent(this,
                this.createAnimationAction(QUAKE_ANIMATION_REPEAT_COUNT),
                this.getAnimationPeriod());
    }
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler)
    {
        scheduler.unscheduleAllEvents(this);
        world.removeEntity(this);
    }


//    public Action createAnimationAction(int repeatCount)
//   {
//      return new Animation(this, repeatCount);
//   }
//
//   public Action createActivityAction(WorldModel world, ImageStore imageStore)
//   {
//      return new Activity(this, world, imageStore);
//   }
//
//   public PImage getCurrentImage(Entity entity)
//   {
//      return (entity).getImages().get((entity).getImageIndex());
//   }
//   public void nextImage()
//   {
//      this.imageIndex = (this.imageIndex + 1) % this.images.size();
//   }
//
//
//   public String getID() { return id; }
//   public Point getPosition() { return position; }
//   public List<PImage> getImages() { return images; }
//   public int getImageIndex() { return imageIndex; }
//   public int getActionPeriod() { return actionPeriod; }
//   public void newPosition(Point point){
//      position = point;
//   }
//   public int getAnimationPeriod()
//   {
//            return animationPeriod;
//   }
//   public String getType(){
//        return QUAKE_KEY;
//    }
}
