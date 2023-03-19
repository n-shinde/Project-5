import processing.core.PImage;

import java.util.List;

public abstract class AnimatedEntity extends Entity {

    private int animationPeriod;

    public AnimatedEntity(String id, Point position, int animationPeriod, List<PImage> images) {
        super(id, position, images);
        this.animationPeriod = animationPeriod;
    }

    public void scheduleActions(
            EventScheduler scheduler,
            WorldModel world,
            ImageStore imageStore)
    {
        scheduler.scheduleEvent(this,
                new AnimationAction(this, 0),
                this.getAnimationPeriod());
    }

    public int getAnimationPeriod() {
        return this.animationPeriod;
    }
    public void nextImage() {
        this.setImageIndex((this.getImageIndex() + 1) % this.getImages().size());
    }

}
