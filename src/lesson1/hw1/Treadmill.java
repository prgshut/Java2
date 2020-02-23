package lesson1.hw1;

public class Treadmill implements Stadium {
    @Override
    public void playground(Member member){
        if (member.isCompete()){
            if(member.getRunDistance()>=TREADMILL_DISTANCE){
                System.out.println("Участник "+member.getName()+" успешно преодолел забег");
                member.setRunDistance(member.getRunDistance()/2);
            }else {
                System.out.println("Участник "+member.getName()+" не преодолел забег и выбыл");
                member.setCompete(false);
            }
        }
    }



}
