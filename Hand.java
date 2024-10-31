public class Hand {
    boolean isPocket;
    boolean isSuited;
    Card[] handArr; 

    Hand() {
        isPocket = false;
        isSuited = false;
        handArr = new Card[2];
    }
}
