//objextive is to use and manipulate linked lise and gain experience with menue deiven programs. task you are to write a program for managing a playlist of songs. a playlist is simply list of songs for this it will be implemented as doubly linked lise eash song contains tewo pieces of information in title and the artist who peforms it each will be stored as strings. your pjava program must support the following features; add a song to the playlist. remove a song from the playlist, print the number of songs in the playlist, "play" the playlist, for our purpose this will just mean just printing out the songs from first to last. shuffle the list, you can do this any way you want so long as the list changes each time, and doesnt change the exact same way the shuffling should not be easly predictable. reverse the order of the playlist. save the playlist to a text file. load a preciously saved plaulist from a text file. quit 
public class exittask {

}
import java.util.*;
import java.io.*;

class Song {
    String title;
    String artist;
    Song prev;
    Song next;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.prev = null;
        this.next = null;
    }
}

class Playlist {
    private Song head = null;
    private Song tail = null;
    private int size = 0;

    // Add song to end
    public void addSong(String title, String artist) {
        Song newSong = new Song(title, artist);

        if (head == null) {
            head = tail = newSong;
        } else {
            tail.next = newSong;
            newSong.prev = tail;
            tail = newSong;
        }
        size++;
        System.out.println("Song added.");
    }

    // Remove song by title
    public void removeSong(String title) {
        Song current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;

                if (current.next != null)
                    current.next.prev = current.prev;
                else
                    tail = current.prev;

                size--;
                System.out.println("Song removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Song not found.");
    }

    // Count songs
    public void printCount() {
        System.out.println("Number of songs: " + size);
    }

    // Play playlist
    public void playPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Song current = head;
        while (current != null) {
            System.out.println(current.title + " - " + current.artist);
            current = current.next;
        }
    }

    // Reverse playlist
    public void reverse() {
        Song current = head;
        Song temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null)
            head = temp.prev;

        System.out.println("Playlist reversed.");
    }

    // Shuffle playlist
    public void shuffle() {
        if (size < 2) return;

        List<Song> songs = new ArrayList<>();
        Song current = head;

        while (current != null) {
            songs.add(current);
            current = current.next;
        }

        Collections.shuffle(songs);

        head = songs.get(0);
        head.prev = null;

        Song prev = head;

        for (int i = 1; i < songs.size(); i++) {
            Song s = songs.get(i);
            prev.next = s;
            s.prev = prev;
            prev = s;
        }

        tail = prev;
        tail.next = null;

        System.out.println("Playlist shuffled.");
    }

    // Save to file
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Song current = head;
            while (current != null) {
                writer.println(current.title + ";" + current.artist);
                current = current.next;
            }
            System.out.println("Playlist saved.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // Load from file
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            head = tail = null;
            size = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2)
                    addSong(parts[0], parts[1]);
            }
            System.out.println("Playlist loaded.");
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}

public class exittask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n=== PLAYLIST MENU ===");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Count Songs");
            System.out.println("4. Play Playlist");
            System.out.println("5. Shuffle Playlist");
            System.out.println("6. Reverse Playlist");
            System.out.println("7. Save Playlist");
            System.out.println("8. Load Playlist");
            System.out.println("9. Quit");
            System.out.print("Choose: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    playlist.addSong(title, artist);
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    playlist.removeSong(scanner.nextLine());
                    break;

                case 3:
                    playlist.printCount();
                    break;

                case 4:
                    playlist.playPlaylist();
                    break;

                case 5:
                    playlist.shuffle();
                    break;

                case 6:
                    playlist.reverse();
                    break;

                case 7:
                    System.out.print("Enter filename: ");
                    playlist.saveToFile(scanner.nextLine());
                    break;

                case 8:
                    System.out.print("Enter filename: ");
                    playlist.loadFromFile(scanner.nextLine());
                    break;

                case 9:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        scanner.close();
    }
}