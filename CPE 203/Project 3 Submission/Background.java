import processing.core.PImage;

import java.util.List;

final class Background
{
   private String id;
   private List<PImage> images;
   private int imageIndex;

   private static final String BGND_KEY = "background";

   public Background(String id, List<PImage> images)
   {
      this.id = id;
      this.images = images;
      this.imageIndex = 0;
   }

   public PImage getCurrentImage()
   {
      return this.images.get(this.imageIndex);
   }

   public String getType(){
      return BGND_KEY;
   }
}
