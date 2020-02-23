package lesson1.hw1;

public class Start {
    public static void main(String[] args) {
        Stadium[] stadium ={new Treadmill(),new Wall(),
                            new Treadmill(),new Wall()};
        Member[] member ={new Cat("Barsik", 100, 5),
                          new Human("Denis", 150, 2),
                          new Robot("Vali", 300, 10)};
        for (int i = 0; i < stadium.length; i++) {
            Stadium stadium1 = stadium[i];
            for (int j = 0; j < member.length; j++) {
                stadium1.playground(member[j]);

            }
        }

    }
}
