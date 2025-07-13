import processing.core.PImage;

import java.util.List;
import java.util.Random;

public class Fish extends StaticEntity{

//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
//    private int actionPeriod;

    private static final Random rand = new Random();

//    private static final String FISH_KEY = "fish";

    private static final String CRAB_KEY = "crab";
    private static final String CRAB_ID_SUFFIX = " -- crab";
    private static final int CRAB_PERIOD_SCALE = 4;
    private static final int CRAB_ANIMATION_MIN = 50;
    private static final int CRAB_ANIMATION_MAX = 150;

    public Fish(String id, Point position, List<PImage> images, int actionPeriod) {
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.imageIndex = 0;
//        this.actionPeriod = actionPeriod;
        super(id, position, images, 0, "fish", actionPeriod);
    }

        public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler){
            Point pos = this.getPosition();  // store current position before removing

            world.removeEntity(this);
            scheduler.unscheduleAllEvents(this);

            AnimatedEntity crab = (AnimatedEntity)world.createCrab(this.getID() + CRAB_ID_SUFFIX,
                    pos, this.getActionPeriod() / CRAB_PERIOD_SCALE,
                    CRAB_ANIMATION_MIN +
                            rand.nextInt(CRAB_ANIMATION_MAX - CRAB_ANIMATION_MIN),
                    imageStore.getImageList(CRAB_KEY));

            world.addEntity(crab);
            crab.scheduleActions(scheduler, world, imageStore);
        }

//        public void scheduleActions (EventScheduler scheduler,
//                WorldModel world, ImageStore imageStore)
//        {
//            scheduler.scheduleEvent(this,
//                    this.createActivityAction(world, imageStore),
//                    this.actionPeriod);
//        }
//
//        public Action createAnimationAction ( int repeatCount)
//        {
//            return new Animation(this, repeatCount);
//        }
//
//        public Action createActivityAction (WorldModel world, ImageStore imageStore)
//        {
//            return new Activity(this, world, imageStore);
//        }
//
//        public PImage getCurrentImage (Entity entity)
//        {
//            return entity.getImages().get((entity).getImageIndex());
//        }
//
//
//        public String getID(){
//            return id;
//        }
//        public Point getPosition () {
//            return position;
//        }
//        public List<PImage> getImages () {
//            return images;
//        }
//        public int getImageIndex () {
//            return imageIndex;
//        }
//        public int getActionPeriod () {
//            return actionPeriod;
//        }
//        public void newPosition (Point point){
//            position = point;
//        }
//        public String getType () {
//            return FISH_KEY;
//        }
    }
