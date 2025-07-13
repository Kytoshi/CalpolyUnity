import processing.core.PImage;

import java.util.List;
import java.util.Optional;

public class Crab extends NonStaticEntity {

    private static final String QUAKE_KEY = "quake";

    public Crab(String id, Point position, List<PImage> images, int actionPeriod, int animationPeriod){
        super(id, position, images, "crab", actionPeriod, animationPeriod );
    }

    public void executeActivity( WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> crabTarget = world.findNearest(
                this.getPosition(), "sgrass");
        long nextPeriod = this.getActionPeriod();

        if (crabTarget.isPresent()) {
            Point tgtPos = crabTarget.get().getPosition();

            if (this.moveToCrab(world, crabTarget.get(), scheduler)) {
                ActivityEntity quake = world.createQuake(tgtPos,
                        imageStore.getImageList(QUAKE_KEY));

                world.addEntity(quake);
                nextPeriod += this.getActionPeriod();
                quake.scheduleActions(scheduler, world, imageStore);
            }
        }
        scheduler.scheduleEvent(this,
                this.createActivityAction(world, imageStore),
                nextPeriod);
    }
    public boolean moveToCrab (WorldModel world,
                               Entity target, EventScheduler scheduler)
    {
        if (this.getPosition().adjacent(target.getPosition())) {
            world.removeEntity(target);
            scheduler.unscheduleAllEvents(target);
            return true;
        } else {
            Point nextPos = this.nextPositionCrab(world, target.getPosition());

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

    public Point nextPositionCrab (WorldModel world,
                                   Point destPos)
    {
        int horiz = Integer.signum(destPos.getX() - this.getPosition().getX());
        Point newPos = new Point(this.getPosition().getX() + horiz,
                this.getPosition().getY());

        Optional<Entity> occupant = world.getOccupant(newPos);

        if (horiz == 0 ||
                (occupant.isPresent() && !(occupant.get() instanceof Fish))) {
            int vert = Integer.signum(destPos.getY() - this.getPosition().getY());
            newPos = new Point(this.getPosition().getX(), this.getPosition().getY() + vert);
            occupant = world.getOccupant(newPos);

            if (vert == 0 ||
                    (occupant.isPresent() && !(occupant.get() instanceof Fish))) {
                newPos = this.getPosition();
            }
        }

        return newPos;
    }
    public void scheduleActions(EventScheduler scheduler,
                                WorldModel world, ImageStore imageStore)
    {
        scheduler.scheduleEvent(this, this.createActivityAction(world, imageStore),
                this.getActionPeriod());
        scheduler.scheduleEvent(this, this.createAnimationAction(0),
                this.getAnimationPeriod());
    }
//
//    public void nextImage()
//    {
//        this.imageIndex = (this.imageIndex + 1) % this.images.size();
//    }
//
//    public Action createAnimationAction(int repeatCount)
//    {
//        return new Animation(this, repeatCount);
//    }
//
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
//    public String getID() { return id; }
//    public Point getPosition() { return position; }
//    public List<PImage> getImages() { return images; }
//    public int getImageIndex() { return imageIndex; }
//    public int getActionPeriod() { return actionPeriod; }
//    public void newPosition(Point point){
//        position = point;
//    }
//    public String getType(){
//        return CRAB_KEY;
//    }
}
