import java.util.Scanner;
import java.util.ArrayList;




class Poker {

    static ArrayList<Card> deck = new ArrayList<>();
    static Hand userHand = new Hand();
    static Board theBoard = new Board();
    static int numDealt;
    static int numInHand;

    public static void populateDeck(){
        for (int i = 0; i < 14; i++){
            Card hCard = new Card('h', i);
            deck.add(hCard);
            Card dCard = new Card('d', i);
            deck.add(dCard);
            Card sCard = new Card('s', i);
            deck.add(sCard);
            Card cCard = new Card('c', i);
            deck.add(cCard);
        }
    }
    

    //public static double Probability(String madeHand){
        //if (madeHand == "null") {
            
        //}
        //return percentAsDouble;
    //}


    //prints greeting, gets input from user and calls parseInfo to populate objects
    public static void getInput(){
        // Game State here
        Scanner userIn = new Scanner(System.in);
        System.out.println("Please enter your hand, use lowercase first letter for the suit," 
        +"and numbers for face cards, seperate cards with commas");
        String inputHand = userIn.nextLine();
        System.out.println("Please enter the board, or 'pf' if N/A");
        String inputBoard = userIn.nextLine();
        System.out.println("Please enter number of players dealt, (seperate by comma) number of players in hand");
        String inputPlayerNums = userIn.nextLine();

        

        parseHandInfo(inputHand);
        parseBoardInfo(inputBoard);
        parseOppInfo(inputPlayerNums);

        userIn.close();
    }

    //called by getInput, parses input and populates objects with all known info
    public static void parseHandInfo(String inputHand){
        String[] cardsToParse = inputHand.split(", ");
            
        // Extract the letter and number parts using regular expressions
        char suitPartOne = cardsToParse[0].replaceAll("[^a-zA-Z]", "").charAt(0);
        int numberPartOne = Integer.parseInt(cardsToParse[0].replaceAll("[^0-9]", ""));

        char suitPartTwo = cardsToParse[0].replaceAll("[^a-zA-Z]", "").charAt(0);
        int numberPartTwo = Integer.parseInt(cardsToParse[0].replaceAll("[^0-9]", ""));


        //loop through deck finding each card and adding it to hand array
        for (Card card : deck) {
            if (card.getSuit() == suitPartOne && card.getNum() == numberPartOne) {
                userHand.handArr[0] = card;
            }
            if (card.getSuit() == suitPartTwo && card.getNum() == numberPartTwo) {
                userHand.handArr[1] = card;
            }
        }
    }

    //called by getInput, parses input and populates objects with all known info
    public static void parseBoardInfo(String inputBoard){
        String[] cardsToParseBoard = inputBoard.split(", ");

        theBoard.numCards = cardsToParseBoard.length;
    }

    //called by getInput, parses input and populates objects with all known info
    public static void parseOppInfo(String inputPlayerNums){
        String[] relaventNums = inputPlayerNums.split(",");
                
        String first = relaventNums[0].trim();
        String second = relaventNums[1].trim();

        numDealt = Integer.parseInt(first);
        numInHand = Integer.parseInt(second);
    }

    public static void checkSuited(){
        if (userHand.handArr[0].cardNum == (userHand.handArr[1].cardNum)){
            userHand.isPocket = true;
        }
    }

    public static void checkPocket(){
        if (userHand.handArr[0].cardNum == (userHand.handArr[1].cardNum)){
            userHand.isPocket = true;
        }
    }
    public static void main(String[] args) {
        populateDeck();
        getInput();
        checkSuited();
        checkPocket();
    }
}


