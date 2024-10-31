public class Card {
    char suit;
    int cardNum; //1 = ace, 11 = jack, etc.
    boolean isKnown;
    boolean inHand;
    boolean onBoard;


    Card(char suit, int cardNum){
        this.suit = suit;
        this.cardNum = cardNum;
        isKnown = false;
        inHand = false;
        onBoard = false;
    }

    public char getSuit() {
        return suit;
    }

    public int getNum() {
        return cardNum;
    }
}
