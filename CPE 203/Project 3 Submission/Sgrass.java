import processing.core.PImage;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Sgrass extends StaticEntity {
//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
//
//    private int actionPeriod;

//    private static final String SGRASS_KEY = "sgrass";

    private static final String FISH_ID_PREFIX = "fish -- ";
    private static final int FISH_CORRUPT_MIN = 20000;
    private static final int FISH_CORRUPT_MAX = 30000;

   private static final String FISH_KEY = "fish";


    private static final Random rand = new Random();

    public Sgrass(String id, Point position, List<PImage> images, int actionPeriod)
    {
        super(id, position, images, 0, "sgrass", actionPeriod);
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.imageIndex = 0;
//        this.actionPeriod = actionPeriod;
    }
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler)
   {
      Optional<Point> openPt = world.findOpenAround(this.getPosition());

      if (openPt.isPresent())
      {
         ActivityEntity fish = world.createFish(FISH_ID_PREFIX + this.getID(), openPt.get(),
                 FISH_CORRUPT_MIN +
                         rand.nextInt(FISH_CORRUPT_MAX - FISH_CORRUPT_MIN),
                 imageStore.getImageList(FISH_KEY));
         world.addEntity(fish);
         fish.scheduleActions(scheduler, world, imageStore);
      }

      scheduler.scheduleEvent(this,
              this.createActivityAction(world, imageStore),
              this.getActionPeriod());
   }
//    public void scheduleActions(EventScheduler scheduler,
//                                WorldModel world, ImageStore imageStore)
//   {
//       scheduler.scheduleEvent(this, this.createActivityAction(world, imageStore),
//               this.actionPeriod);
//   }
//
//   public Action createActivityAction(WorldModel world, ImageStore imageStore)
//   {
//      return new Activity(this, world, imageStore);
//   }
//
//   public PImage getCurrentImage(Entity entity)
//   {
//      return entity.getImages().get((entity).getImageIndex());
//   }
//
//   public String getID() { return id; }
//   public Point getPosition() { return position; }
//   public List<PImage> getImages() { return images; }
//   public int getImageIndex() { return imageIndex; }
//   public int getActionPeriod() { return actionPeriod; }
//   public void newPosition(Point point){
//      position = point;
//   }
//    public String getType(){
//        return SGRASS_KEY;
//    }
//
}
