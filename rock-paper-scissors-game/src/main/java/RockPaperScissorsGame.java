import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    // Private variables to track Total Games, Wins, Draws, Win/Draw Rates
    private int totalGames;
    private int player1Wins; // Your wins
    private int totalDraws; // Your draws
    private int opponentWins; // Opponent's wins
    private double winRate;
    private double drawRate;

    //Array List to hold each/all game result
    private ArrayList<String> gameResults;

    //Variables to Track Player's choice count
    private int rockCount;
    private int paperCount;
    private int scissorsCount;

    //Variables to Track Player's Choice Wins
    private int rockWins;
    private int paperWins;
    private int scissorsWins;

    // Constructor to initialize instance variables
    public RockPaperScissorsGame() {
        this.totalGames = 0;          // Initialize total games to 0
        this.player1Wins = 0;         // Initialize player 1 wins to 0
        this.totalDraws = 0;          // Initialize total draws to 0
        this.opponentWins = 0;        // Initialize opponent wins to 0
        this.winRate = 0.0;           // Initialize win rate to 0.0
        this.drawRate = 0.0;          // Initialize draw rate to 0.0
        this.gameResults = new ArrayList<>(); // Initialize game results list
        this.rockCount = 0;            // Initialize rock selections to 0
        this.paperCount = 0;           // Initialize paper selections to 0
        this.scissorsCount = 0;        // Initialize scissors selections to 0
        this.rockWins = 0;             // Initialize rock wins to 0
        this.paperWins = 0;            // Initialize paper wins to 0
        this.scissorsWins = 0;         // Initialize scissors wins to 0
    }

    //Method to get Total Games
    public int getTotalGames() {
        return totalGames;
    }

    //Method to set Total Games
    private void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    //Method to get Total Wins
    public int getPlayer1Wins() {
        return player1Wins;
    }

    //Method to set Total Wins
    private void setPlayer1Wins(int player1Wins) {
        this.player1Wins = player1Wins;
    }

    //Method to get Total Draws
    public int getTotalDraws() {
        return totalDraws;
    }

    //Method to set Total Draws
    private void setTotalDraws(int newDraw) {
        this.totalDraws = newDraw;
    }

    //Method to get Opponent Wins
    public int getOpponentWins() {
        return opponentWins;
    }

    //Method to set Opponent Wins
    private void setOpponentWins(int opponentWins) {
        this.opponentWins = opponentWins;
    }

    //Method to get Win Rate
    public double getWinRate() {
        return winRate;
    }

    //Method to set Win Rate
    private void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    //Method to get Draw Rate
    public double getDrawRate() {
        return drawRate;
    }

    //Method to set Draw Rate
    private void setDrawRate(double drawRate) {
        this.drawRate = drawRate;
    }

    //Method to get Game Results
    public ArrayList<String> getGameResults() {
        return gameResults;
    }

    //Method to set Game Results
    private void setGameResults(String gameResults) {
        this.gameResults.add(gameResults);
    }

    //Getter and Setter methods for Player choices
    //Method to get # of Rock Selections
    public int getRockCount() {
        return rockCount;
    }

    //Method to set # of Rock Selections
    private void setRockCount(int rockCount) {
        this.rockCount = rockCount;
    }

    //Method to get # of Paper Selections
    public int getPaperCount() {
        return paperCount;
    }

    //Method to set # of Paper Selections
    private void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    //Method to get # of Scissor Selections
    public int getScissorsCount() {
        return scissorsCount;
    }

    //Method to set # of Scissor Selections
    private void setScissorsCount(int scissorsCount) {
        this.scissorsCount = scissorsCount;
    }

    //Method to get Rock Wins
    public int getRockWins() {
        return rockWins;
    }

    //Method to set Rock Wins
    private void setRockWins(int rockWins) {
        this.rockWins = rockWins;
    }

    //Method to get Scissor Wins
    public int getScissorsWins() {
        return scissorsWins;
    }

    //Method to set Scissor Wins
    private void setScissorsWins(int scissorsWins) {
        this.scissorsWins = scissorsWins;
    }

    //Method to get Paper Wins
    public int getPaperWins() {
        return paperWins;
    }

    //Method to set Paper Wins
    private void setPaperWins(int paperWins) {
        this.paperWins = paperWins;
    }

    // Play Rock, Paper, Scissors, Method to play full game, call for each game
    void playGame(int userChoice) {
        Random rand = new Random();
        // Each time method runs, Increment the total games played
        setTotalGames(getTotalGames() + 1);

        // Opponent's random choice: 1 = Rock, 2 = Paper, 3 = Scissors
        // Opponent does not have to choose
        // Future versions could convert this to a 2 player game
        int opponentChoice = rand.nextInt(3);
        String userMove = moveToString(userChoice);
        String opponentMove = moveToString(opponentChoice);
        String winner;

        // Track the player's choice, increment on each choice made
        if (userChoice == 1) {
            setRockCount(getRockCount() + 1);
        } else if (userChoice == 2) {
            setPaperCount(getPaperCount() + 1);
        } else if (userChoice == 3) {
            setScissorsCount(getScissorsCount() + 1);
        }

        // Determine the winner or if a draw
        if (userChoice == opponentChoice) {
            winner = "Draw";
            setTotalDraws(getTotalDraws() + 1);
        } else if ((userChoice == 1 && opponentChoice == 3) || // Rock beats Scissors
                (userChoice == 2 && opponentChoice == 1) || // Paper beats Rock
                (userChoice == 3 && opponentChoice == 2)) { // Scissors beats Paper
            winner = "You";
            // Increment Player 1 (You) wins using the getter and setter
            setPlayer1Wins(getPlayer1Wins() + 1);
        } else {
            winner = "Opponent";
            // Increment Opponent wins using the getter and setter
            setOpponentWins(getOpponentWins() + 1);
        }

        //After establishing the winner & userChoice, increment the choices (R/P/S) individual win counts
        if (winner.equals("You")) {
            if (userChoice == 1) {
                setRockWins(getRockWins() + 1);
            } else if (userChoice == 2) {
                setPaperWins(getPaperWins() + 1);
            } else if (userChoice == 3) {
                setScissorsWins(getScissorsWins() + 1);
            }
        }

        // Create the result string
        String result = "\nGame " + getTotalGames() + ": You chose " + userMove +
                ", Opponent chose " + opponentMove +
                ". Score: You: " + getPlayer1Wins() +
                ", Opponent: " + getOpponentWins() + ", Winner: " + winner + "\n";

        // Add result to gameResults List using getter
        setGameResults(result);
        System.out.println(result);
    }

    // Convert the user input move number (int) to a string (Rock, Paper, or Scissors)
    String moveToString(int move) {
        switch (move) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            //Include a default for invalid choices
            default:
                return "Invalid Selection, Play Again";
        }
    }

    // Method to print results of the games
    private void printResults() {
        System.out.println("\nTotal games: " + getTotalGames());
        System.out.println("Your wins: " + getPlayer1Wins());
        System.out.println("Opponent's wins: " + getOpponentWins());
        System.out.println("Results:");
        for (String result : getGameResults()) {
            System.out.println(result);
        }
    }

    private void printFarewell() {
        System.out.println("\nThanks for using Rock, Paper, Scissors Simulator! See you again!");
    }

    private void printFileReady() {
        System.out.println("\nYou file can be found in the output folder within src.");
    }

    // Method to calculate the win rate
    void calculateWinRate() {
        // Calculate win rate and update using setter
        double winRate = (double) getPlayer1Wins() / getTotalGames() * 100;
        setWinRate(winRate);

    }

    // Method to calculate the draw rate
    void calculateDrawRate() {
        // Calculate win rate and update using setter
        double drawRate = (double) getTotalDraws() / getTotalGames() * 100;
        setDrawRate(drawRate);

    }

    // Method to output how often Player 1 chose Rock, Paper, or Scissors
    private void outputChoices() {
        String choicesResult = getChoicesString();
        System.out.println(choicesResult);
    }

    // Method to save the results to a Text file and append the calculated win rate and choices
    private void saveResultsToText() {
        File gameFile = new File("rock-paper-scissors-game/src/output/rockPaperScissorsResult.txt");

        // Prepare results to write, Establish a array list that will further be appended to
        ArrayList<String> resultsToWrite = new ArrayList<>();
        for (String result : getGameResults()) {
            resultsToWrite.add(result);
        }

        // Calculate the win rate once more before saving to file, The win rate may have changed
        calculateWinRate();
        calculateDrawRate();

        // Calculate percentages of wins/draws and cast them to the string
        String winDrawRate = getWinsDrawsString();

        // Calculate percentages of choices and cast them to the string
        String choicesResult = getChoicesString();

        //Append Win/Draw string & choices string to results that will go to file (winDrawRate choicesResult)
        resultsToWrite.add(winDrawRate);  // Append win rate to the results string
        resultsToWrite.add(choicesResult);  // Append choice percentages to the results string

        //Once results string finalized, try to save to file
        //include a IOException catch
        try {
            Files.write(gameFile.toPath(), resultsToWrite, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Results saved to rockPaperScissorsResult.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the results: " + e.getMessage());
            e.printStackTrace();
        }

    }

    //Method to write output strings for Choices
    //Returns the string to output
    String getChoicesString() {
        double rockPercentage = (double) getRockCount() / getTotalGames() * 100;
        double paperPercentage = (double) getPaperCount() / getTotalGames() * 100;
        double scissorsPercentage = (double) getScissorsCount() / getTotalGames() * 100;
        double rockWinPercentage = (double) getRockWins() / getTotalGames() * 100;
        double paperWinPercentage = (double) getPaperWins() / getTotalGames() * 100;
        double scissorsWinPercentage = (double) getScissorsWins() / getTotalGames() * 100;
        return "Your Choices: \n\tRock: " + rockPercentage + "% Rock Win Rate: " + rockWinPercentage + "%" +"\n\tPaper: " +
                paperPercentage + "% Paper Win Rate: " + paperWinPercentage + "%" +"\n\tScissors: " +
                scissorsPercentage + "% Scissors Win Rate: " + scissorsWinPercentage + "%\n";
    }

    //Method to write output strings for Win/Draw rates
    //Returns the string to output
    String getWinsDrawsString() {
        return "Your Win Rate: "+getWinRate()+"%\n"+"Your Draw Rate: "+getDrawRate()+"%\n";
    }

    //Main Method
    public static void main(String[] args) {
        // Create an instance of RockPaperScissorsGame
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        //Establish scanner for user input
        Scanner scanner = new Scanner(System.in);
        //Boolean value to trigger menu / stopping program
        boolean playing = true;
        // Greet the user, only once
        System.out.println("Welcome to Rock, Paper, Scissors Simulator! \n " +
                "This program will allow you to play as many games of Rock, Paper, Scissors as you want against a computer opponent. You can select your move, print results, save results to file, and more!\n" +
                "To play, use your keyboard to interact with the menu below:\n");


        //While loop to keep menu open so long as option 6 is not chosen, will continue until 6 is chosen
        while (playing) {
            System.out.println("1. Play Rock, Paper, Scissors");
            System.out.println("2. Print results");
            System.out.println("3. Calculate Win Rate");
            System.out.println("4. Output choices");
            System.out.println("5. Save results to Text File & Exit");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();

            //Switch statement to handle the menu option choice 1-6
            switch (choice) {
                case 1:
                    //Directions for user
                    System.out.println("\nSelect 1 for Rock, 2 for Paper, or 3 for Scissors:");
                    int userChoice = scanner.nextInt();
                    game.playGame(userChoice);
                    break;
                case 2:
                    //Print the game results so far
                    game.printResults();
                    break;
                case 3:
                    //Calculate the rates at the point this runs / the choice is input
                    game.calculateWinRate();
                    game.calculateDrawRate();
                    String winDrawRate = game.getWinsDrawsString();
                    System.out.println("\n" + winDrawRate + "\n");
                    break;
                case 4:
                    //Output player choices
                    game.outputChoices();
                    break;
                case 5:
                    //Save the results to file
                    game.saveResultsToText();
                    game.printFileReady();
                    game.printFarewell();
                    playing = false;
                    break;
                case 6:
                    //Set playing value to be false to exit the program
                    game.printFarewell();
                    playing = false;
                    break;
            }
        }
        // Close scanner at the end
        scanner.close();
    }
}
