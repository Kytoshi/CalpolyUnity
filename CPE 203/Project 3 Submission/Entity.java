import processing.core.PImage;

import java.util.List;

interface Entity {
   String getID();
   Point getPosition();
   void newPosition(Point point);
   List<PImage> getImages();
   int getImageIndex();
   String getType();
   PImage getCurrentImage(Entity entity);
}