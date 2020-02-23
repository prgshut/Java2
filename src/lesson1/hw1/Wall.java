package lesson1.hw1;

public class Wall implements Stadium {
    @Override
    public void playground(Member member){
        if (member.isCompete()){
            if (member.getJumpHeight()>=WALL_HEIGT){
                System.out.printf("Участник %s перепрыгнул препятствие\n\r", member.getName() );
                member.setJumpHeight(member.getJumpHeight()/2);
            }else {
                System.out.printf("Участник %s не перепрыгнул препятствие и выбыл\n\r", member.getName() );
                member.setCompete(false);
            }
        }
    }
}
