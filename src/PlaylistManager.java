import java.util.Scanner;

public class PlaylistManager {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Playlist playlist = new Playlist();

        System.out.println("*** Playlist Manager! ***");

        String command = "";

        while (!command.equals("quit")) {

            System.out.println("\nCommands:");
            System.out.println("add");
            System.out.println("remove");
            System.out.println("count");
            System.out.println("play");
            System.out.println("shuffle");
            System.out.println("reverse");
            System.out.println("save");
            System.out.println("quit");

            System.out.print("\n: ");
            command = input.nextLine().toLowerCase();

            switch (command) {

                case "add":

                    System.out.print("Enter artist: ");
                    String artist = input.nextLine();

                    System.out.print("Enter title: ");
                    String title = input.nextLine();

                    playlist.addSong(title, artist);
                    break;

                case "remove":

                    System.out.print("Enter artist: ");
                    String rArtist = input.nextLine();

                    System.out.print("Enter title: ");
                    String rTitle = input.nextLine();

                    playlist.removeSong(rTitle, rArtist);
                    break;

                case "count":
                    System.out.println(playlist.getCount());
                    break;

                case "play":
                    playlist.play();
                    break;

                case "shuffle":
                    playlist.shuffle();
                    break;

                case "reverse":
                    playlist.reverse();
                    break;

                case "save":

                    System.out.print("Enter file: ");
                    String file = input.nextLine();

                    playlist.save(file);
                    break;

                case "quit":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}