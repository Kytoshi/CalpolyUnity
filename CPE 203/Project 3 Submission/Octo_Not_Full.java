import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Octo_Not_Full extends Octo {
    //    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
    private int resourceLimit;
    private int resourceCount;
//    private int actionPeriod;
//    private static int animationPeriod;

//    private static final String OCTO_KEY = "octo";
//    private static final int OCTO_NUM_PROPERTIES = 7;
//    private static final int OCTO_ID = 1;
//    private static final int OCTO_COL = 2;
//    private static final int OCTO_ROW = 3;
//    private static final int OCTO_LIMIT = 4;
//    private static final int OCTO_ACTION_PERIOD = 5;
//    private static final int OCTO_ANIMATION_PERIOD = 6;

    public Octo_Not_Full(String id, Point position, List<PImage> images, String type, int resourceLimit, int resourceCount,
                         int actionPeriod, int animationPeriod) {
//        this.id  = id;
//        this.position = position;
//        this.images = images;
        super(id, position, images, "octo", actionPeriod, animationPeriod);
        this.resourceCount = resourceCount;
        this.resourceLimit = resourceLimit;
//        this.actionPeriod = actionPeriod;
//        this.animationPeriod = animationPeriod;
    }

    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> notFullTarget = world.findNearest(this.getPosition(),
                "fish");

        if (!notFullTarget.isPresent() ||
                !this.moveToNotFull(world, notFullTarget.get(), scheduler) ||
                !this.transformNotFull(world, scheduler, imageStore))
        {
            scheduler.scheduleEvent(this,
                    this.createActivityAction(world, imageStore),
                    this.getActionPeriod());
        }
    }

    public boolean transformNotFull(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.resourceCount > this.resourceLimit) {
            AnimationEntity octo = world.createOctoFull(this.getID(), this.resourceLimit, this.getPosition(),
                    this.getActionPeriod(), this.getAnimationPeriod(),
                    this.getImages());

            world.removeEntity(this);
            scheduler.unscheduleAllEvents(this);

            world.addEntity(octo);
            octo.scheduleActions(scheduler, world, imageStore);

            return true;
        }

        return false;
    }

    public boolean moveToNotFull(WorldModel world, Entity target, EventScheduler scheduler) {
        if (this.getPosition().adjacent(target.getPosition())) {
            this.resourceCount += 1;
            world.removeEntity(target);
            scheduler.unscheduleAllEvents(target);

            return true;
        }
        else {
            Point nextPos = this.nextPositionOcto(world, target.getPosition());

            if (!this.getPosition().equals(nextPos)) {
                Optional<Entity> occupant = world.getOccupant(nextPos);
                if (occupant.isPresent()) {
                    scheduler.unscheduleAllEvents(occupant.get());
                }

                world.moveEntity(this, nextPos);
            }
            return false;
        }
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
//
//        scheduler.scheduleEvent(this, this.createActivityAction(world, imageStore),
//                        this.actionPeriod);
//        scheduler.scheduleEvent(this, this.createAnimationAction(0),
//                this.getAnimationPeriod());
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
//
//    public PImage getCurrentImage(Entity entity)
//    {
//        return entity.getImages().get(entity.getImageIndex());
//    }
//
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
//}

