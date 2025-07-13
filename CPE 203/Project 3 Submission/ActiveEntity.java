import processing.core.PImage;

import java.util.List;

public abstract class ActiveEntity extends AbstractEntity implements ActivityEntity{
    private int actionPeriod;

    public ActiveEntity(String id, Point position, List<PImage> images, int imageIndex, String type, int actionPeriod){
        super(id, position, images, imageIndex, type);
        this.actionPeriod = actionPeriod;
    }

    public int getActionPeriod(){
        return actionPeriod;
    }

    public Action createActivityAction(WorldModel world, ImageStore imageStore)
    {
        return new Activity(this, world, imageStore);
    }
}
