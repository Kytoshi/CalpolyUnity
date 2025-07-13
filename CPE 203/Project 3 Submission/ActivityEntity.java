interface ActivityEntity extends Entity{
    void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore);
    int getActionPeriod();
    void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler);
//    Action createActivityAction(WorldModel world, ImageStore imageStore);
}
