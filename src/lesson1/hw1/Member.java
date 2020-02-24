package lesson1.hw1;

public interface Member {
    void jump();

    void run();

    int getRunDistance();

    void setRunDistance( int runDistance);

    int getJumpHeight();

    void setJumpHeight(int jumpHeight);

    void setCompete(boolean compete);

    boolean isCompete();

    String getName();
}
