public class BetMore{

    Shuffle s;

    public BetMore(Shuffle s){
        this.s = s;
    }

    public int pickCard(){
        return s.getNumber();
    }
}
