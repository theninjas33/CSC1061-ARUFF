import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Playlist {

    Node head;
    Node tail;
    int size;

    public void addSong(String title, String artist) {

        Song s = new Song(title, artist);
        Node newNode = new Node(s);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void removeSong(String title, String artist) {

        Node current = head;

        while (current != null) {

            if (current.song.title.equalsIgnoreCase(title) &&
                current.song.artist.equalsIgnoreCase(artist)) {

                if (current == head)
                    head = head.next;

                if (current == tail)
                    tail = tail.prev;

                if (current.prev != null)
                    current.prev.next = current.next;

                if (current.next != null)
                    current.next.prev = current.prev;

                size--;
                return;
            }

            current = current.next;
        }
    }

    public int getCount() {
        return size;
    }

    public void play() {

        Node current = head;

        while (current != null) {
            System.out.println(current.song.artist + " - " + current.song.title);
            current = current.next;
        }
    }

    public void reverse() {

        Node current = head;
        Node temp = null;

        while (current != null) {

            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        if (temp != null)
            head = temp.prev;
    }

    public void shuffle() {

        ArrayList<Song> songs = new ArrayList<>();

        Node current = head;

        while (current != null) {
            songs.add(current.song);
            current = current.next;
        }

        Collections.shuffle(songs);

        head = tail = null;
        size = 0;

        for (Song s : songs)
            addSong(s.title, s.artist);
    }

    public void save(String filename) {

        try {

            PrintWriter out = new PrintWriter(filename);

            Node current = head;

            while (current != null) {
                out.println(current.song.artist + "," + current.song.title);
                current = current.next;
            }

            out.close();

        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }
}