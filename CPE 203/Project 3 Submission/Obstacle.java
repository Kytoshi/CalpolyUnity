import processing.core.PImage;

import java.util.List;

public class Obstacle extends AbstractEntity {
//    private String id;
//    private Point position;
//    private List<PImage> images;
//    private int imageIndex;
//
//    public static final String OBSTACLE_KEY = "obstacle";

    public Obstacle(String id, Point position, List<PImage> images)
    {
        super(id, position, images, 0, "obstacle");
//        this.id = id;
//        this.position = position;
//        this.images = images;
//        this.imageIndex = 0;
    }
//    public PImage getCurrentImage(Entity entity)
//    {
//        return (entity).getImages().get((entity).getImageIndex());
//    }
//    public String getID() { return id; }
//    public Point getPosition() { return position; }
//    public List<PImage> getImages() { return images; }
//    public int getImageIndex() { return imageIndex; }
//    public void newPosition(Point point){
//        position = point;
//    }
//    public String getType(){
//        return OBSTACLE_KEY;
//    }
}
