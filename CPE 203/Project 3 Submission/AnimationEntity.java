public interface AnimationEntity extends ActivityEntity
{
    void nextImage();
    int getAnimationPeriod();
    Action createAnimationAction(int repeatCount);
}
