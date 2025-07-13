import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Octo_Full extends Octo {
//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
    private int resourceLimit;
    private int resourceCount;
//    private int actionPeriod;
//    private static int animationPeriod;

//    private static final String OCTO_KEY = "octo";


    public Octo_Full(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount,
                     int actionPeriod, int animationPeriod){
//      this.id  = id;
//      this.position = position;
//      this.images = images;
        super(id, position, images,"octo", actionPeriod, animationPeriod);
        this.resourceCount = resourceCount;
        this.resourceLimit = resourceLimit;
//        this.actionPeriod = actionPeriod;
//        this.animationPeriod = animationPeriod;
    }
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler)
    {
        Optional<Entity> fullTarget = world.findNearest(this.getPosition(), "atlantis");

        if (fullTarget.isPresent() &&
                this.moveToFull(world, fullTarget.get(), scheduler))
        {
            ((Atlantis)fullTarget.get()).scheduleActions(scheduler, world, imageStore);
            this.transformFull(world, scheduler, imageStore);

        }
        else
        {
            scheduler.scheduleEvent(this, createActivityAction(world, imageStore), this.getActionPeriod());
        }
    }
    public void transformFull(WorldModel world, EventScheduler scheduler, ImageStore imageStore)
    {
        AnimationEntity octo = world.createOctoNotFull(this.getID(), this.resourceLimit, this.getPosition(),
                this.getActionPeriod(), this.getAnimationPeriod(), this.getImages());

        world.removeEntity(this);
        scheduler.unscheduleAllEvents(this);

        world.addEntity(octo);
        octo.scheduleActions(scheduler, world, imageStore);
    }
    public boolean moveToFull(WorldModel world, Entity target, EventScheduler scheduler)
    {
        if (this.getPosition().adjacent(target.getPosition()))
        {
            return true;
        }
        else
        {
            Point nextPos = this.nextPositionOcto(world, target.getPosition());

            if (!this.getPosition().equals(nextPos))
            {
                Optional<Entity> occupant = world.getOccupant(nextPos);
                if (occupant.isPresent())
                {
                    scheduler.unscheduleAllEvents(occupant.get());
                }

                world.moveEntity(this, nextPos);
            }
            return false;
        }
    }
//    public Point nextPositionOcto(WorldModel world, Point destPos)
//    {
//        int horiz = Integer.signum(destPos.getX() - this.position.getX());
//        Point newPos = new Point(this.position.getX() + horiz,
//                this.position.getY());
//
//        if (horiz == 0 || world.isOccupied(newPos))
//        {
//            int vert = Integer.signum(destPos.getY() - this.position.getY());
//            newPos = new Point(this.position.getX(),
//                    this.position.getY() + vert);
//
//            if (vert == 0 || world.isOccupied(newPos))
//            {
//                newPos = this.position;
//            }
//        }
//
//        return newPos;
//    }

//    public void scheduleActions(EventScheduler scheduler,
//                                WorldModel world, ImageStore imageStore)
//    {
//        scheduler.scheduleEvent(this, this.createActivityAction(world, imageStore),
//                this.actionPeriod);
//        scheduler.scheduleEvent(this, this.createAnimationAction(0),
//                this.getAnimationPeriod());
//
//
//    }

//    public Action createAnimationAction(int repeatCount)
//    {
//        return new Animation(this, repeatCount);
//    }

//    public Action createActivityAction(WorldModel world, ImageStore imageStore)
//    {
//        return new Activity(this, world, imageStore);
//    }

//    public PImage getCurrentImage(Entity entity)
//    {
//        return (entity).getImages().get((entity).getImageIndex());
//    }

//    public int getAnimationPeriod()
//    {
//        return animationPeriod;
//    }
//    public void nextImage()
//    {
//        this.imageIndex = (this.imageIndex + 1) % this.images.size();
//    }

//
//    public String getID() { return id; }
//    public Point getPosition() { return position; }
//    public List<PImage> getImages() { return images; }
//    public int getImageIndex() { return imageIndex; }
//    public int getResourceLimit() { return resourceLimit; }
//    public int getResourceCount() { return resourceCount; }
//    public int getActionPeriod() { return actionPeriod; }
//    public void newPosition(Point point){
//        position = point;
//    }
//    public String getType(){
//        return OCTO_KEY;
//    }
}
