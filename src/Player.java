public class Player {

    String name;

    int howManyWins;

    public Player(String name, int howManyWins) {
        this.name = name;
        this.howManyWins = howManyWins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowManyWins() {
        return howManyWins;
    }

    public void setHowManyWins(int howManyWins) {
        this.howManyWins = howManyWins;
    }
}
