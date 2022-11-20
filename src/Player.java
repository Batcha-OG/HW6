public class Player {

    private int card;
    BetMore bet;

    public Player(BetMore bet){
        this.bet = bet;
    }

    public void play(){
        card = bet.pickCard();
    }

    public int getCard(){
        return card;
    }
}
