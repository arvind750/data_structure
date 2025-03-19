class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagementSystem {
    private Movie head;
    private Movie tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            newMovie.prev = temp;
            temp.next.prev = newMovie;
            temp.next = newMovie;
        }
    }

    public void removeMovie(String title) {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }

        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Movie \"" + title + "\" removed.");
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("Found: " + temp.title + " (" + temp.year + "), Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by " + director);
    }

    public void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Found: " + temp.title + " (" + temp.year + "), Directed by: " + temp.director);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating);
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for " + title + " to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\nMovies (Forward Order):");
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("\nMovies (Reverse Order):");
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManager {
    public static void main(String[] args) {
        MovieManagementSystem movieList = new MovieManagementSystem();

        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addAtPosition("Pulp Fiction", "Quentin Tarantino", 1994, 8.9, 2);

        movieList.displayForward();
        movieList.displayReverse();

        System.out.println("\nSearching movies by Director:");
        movieList.searchByDirector("Christopher Nolan");

        System.out.println("\nSearching movies by Rating:");
        movieList.searchByRating(8.9);

        System.out.println("\nUpdating movie rating:");
        movieList.updateRating("Inception", 9.0);

        System.out.println("\nRemoving a movie:");
        movieList.removeMovie("The Godfather");

        movieList.displayForward();
    }
}
