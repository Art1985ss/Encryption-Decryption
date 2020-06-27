import java.util.*;

/**
 * Observable
 */

interface Observable {
    Observable addObserver(Observer observer);

    Observable remove(Observer observer);

    void notifyObservers();
}

/**
 * Concrete Observable
 */
class RockstarGames implements Observable {

    public String releaseGame;

    List<Observer> observers = new ArrayList<>();

    public void release(String game) {
        this.releaseGame = game;
        this.notifyObservers();
    }

    @Override
    public Observable addObserver(Observer observer) {
        observers.add(observer);
        return this;
    }

    @Override
    public Observable remove(Observer observer) {
        observers.remove(observer);
        return this;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Inform message to : " + observer);
            observer.update(releaseGame);
        }
    }
}

/**
 * Observer
 */
interface Observer {
    void update(String gameName);
}

/**
 * Concrete Observer
 */
class Gamer implements Observer {

    private String name;
    private String reaction;
    private Observable observable;

    private Set<String> games = new HashSet<>();

    public Gamer(String name, String reaction, Observable observable) {
        this.reaction = reaction;
        this.observable = observable;
        this.name = name;
    }

    @Override
    public void update(String gameName) {
        if (games.contains(gameName)) {
            return;
        }
        games.add(gameName);
        buyGame(gameName);
    }

    public void buyGame(String game) {
        games.add(game);
        System.out.println(this + " say: " + reaction);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/**
 * Main Class
 */

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        String game = null;

        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose", "I want to pre-order", rockstarGames);
        Gamer peter = new Gamer("Peter Johnston", "Pinch me...", rockstarGames);
        Gamer helen = new Gamer("Helen Jack", "Jesus, it's new game from Rockstar!", rockstarGames);

        rockstarGames.addObserver(garry)
                .addObserver(peter)
                .addObserver(helen);

        game = scanner.nextLine();
        System.out.println("It's happened! RockstarGames releases new game - " + game + "!");

        rockstarGames.release(game);

        scanner.close();
    }
}
