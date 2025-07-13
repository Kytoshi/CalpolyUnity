import processing.core.PImage;

import java.util.List;

public abstract class Octo extends NonStaticEntity {

    public Octo(String id, Point position, List<PImage> images, String type, int actionPeriod, int animationPeriod) {
        super(id, position, images, type, actionPeriod, animationPeriod);
    }
    public Point nextPositionOcto(WorldModel world, Point destPos) {
        int horiz = Integer.signum(destPos.getX() - this.getPosition().getX());
        Point newPos = new Point(this.getPosition().getX() + horiz,
                this.getPosition().getY());

        if (horiz == 0 || world.isOccupied(newPos)) {
            int vert = Integer.signum(destPos.getY() - this.getPosition().getY());
            newPos = new Point(this.getPosition().getX(),
                    this.getPosition().getY() + vert);

            if (vert == 0 || world.isOccupied(newPos)) {
                newPos = this.getPosition();
            }
        }

        return newPos;
    }
}