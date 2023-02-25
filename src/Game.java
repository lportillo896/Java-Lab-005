/**
 *
 * @Author Trevor Hartman
 * @Author Logan Portillo
 *
 * @since Version 1.0
 *
 */

import java.util.Scanner;

public class Game {
    private Player p1;
    private Player p2;
    private Dice die;

    public Game(Player p1,Player p2,Dice die){
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }

    public void play() {
        Player current = p1;
        takeTurn(p1);
        current = nextPlayer(current);
        takeTurn(current);

        System.out.println(announceWinner());
    }

    public Player nextPlayer(Player current) {
        if(current == this.p1){
            return this.p2;
        }else{
            return this.p1;
        }
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        System.out.printf("%s rolled %d%n%s rolled %d%n", p1.getName(), p1.getScore(), p2.getName(), p2.getScore());

        if(this.p1.getScore() > this.p2.getScore()) {
            return String.format("%s won", p1.getName());
        }else if(this.p2.getScore() > this.p1.getScore()){
            return String.format("%s won",p2.getName());
        }else{
            return String.format("%s and %s tied", p1.getName(),p2.getName());
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Player 1's Name: ");
        String playerName = s.nextLine();
        Player p1 = new Player(playerName);
        System.out.println("Enter Player 2's Name: ");
        playerName = s.nextLine();
        Player p2 = new Player(playerName);
        System.out.println("What sided die are we playing with? ");
        int sides = Integer.parseInt(s.nextLine());

        Game g = new Game(p1, p2, new Dice(sides));
        g.play();
    }
}
