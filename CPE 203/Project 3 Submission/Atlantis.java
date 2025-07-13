import processing.core.PImage;

import java.util.List;

public class Atlantis extends AnimatedEntity {

//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
//    private int actionPeriod;
//    private static int animationPeriod;
//
//   private static final String ATLANTIS_KEY = "atlantis";
    public static final int ATLANTIS_ANIMATION_REPEAT_COUNT = 7;

    public Atlantis(String id, Point position, List<PImage> images, int actionPeriod, int animationPeriod)
    {
        super(id, position, images, "atlantis", actionPeriod, animationPeriod);
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.imageIndex = 0;
//        this.animationPeriod = animationPeriod;
    }

    public void executeActivity (WorldModel world,
                                         ImageStore imageStore, EventScheduler scheduler)
    {
        scheduler.unscheduleAllEvents(this);
        world.removeEntity(this);
    }

    public void scheduleActions(EventScheduler scheduler,
                                WorldModel world, ImageStore imageStore)
    {
        scheduler.scheduleEvent(this,
                createAnimationAction( ATLANTIS_ANIMATION_REPEAT_COUNT),
                getAnimationPeriod());
    }
//
//    public Action createAnimationAction(int repeatCount)
//    {
//        return new Animation(this, repeatCount);
//    }
//
//    public Action createActivityAction(WorldModel world, ImageStore imageStore) {
//        return new Activity(this, world, imageStore);
//    }
//
//    public void nextImage()
//    {
//        this.imageIndex = (this.imageIndex + 1) % this.images.size();
//    }
//
//    public PImage getCurrentImage(Entity entity)
//    {
//        return (entity).getImages().get((entity).getImageIndex());
//    }
//    public int getAnimationPeriod()
//    {
//        return animationPeriod;
//    }
//    public String getID() { return id; }
//    public Point getPosition() { return position; }
//    public List<PImage> getImages() { return images; }
//    public int getImageIndex() { return imageIndex; }
//    public int getActionPeriod() { return actionPeriod; }
//    public void newPosition(Point point){ position = point; }
//    public String getType(){ return ATLANTIS_KEY; }
}
