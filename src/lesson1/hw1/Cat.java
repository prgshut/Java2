package lesson1.hw1;

public class Cat implements Member {
    private final String name;
    private int runDistance;
    private int jumpHeight;
    private boolean isCompete = true;

    public Cat(String name, int runDistance, int jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    @Override
    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public boolean isCompete() {
        return isCompete;
    }

    @Override
    public void setCompete(boolean compete) {
        isCompete = compete;
    }

    @Override
    public int getRunDistance() {
        return runDistance;
    }

    @Override
    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void jump() {
        System.out.println("Прыгнули");
    }

    @Override
    public void run() {
        System.out.println("Побежали");
    }
}
