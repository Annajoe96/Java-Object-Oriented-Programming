class ScreeningTime {
  String time;
  int screen;
  int available_seats;
  double cost;

// creating a screening time object with params time, screen, available time and cost
  public ScreeningTime(String time, int screen, int available_seats, double cost){
    this.time = time;
    this.screen = screen;
    this.available_seats = available_seats;
    this.cost = cost;
  }
}


class Movie {
  String name;
  List<ScreeningTime> times = new ArrayList<ScreeningTime>();

  public Movie(String name){
    this.name = name;
  }
  
  // adding screening to each times hash
  public void addScreening(String time, int screen, int available_seats, double cost) {
    ScreeningTime screening = new ScreeningTime(time, screen, available_seats, cost);

    times.add(screening);
  }

  public void printTimes() {
    for(ScreeningTime t : times) {
      System.out.println("Time: " + t.time + ", Screen: " + t.screen + ", Seats Available: " + t.available_seats + ", Cost: " + t.cost);
    }
  }

}


public class Cinema {
  static List<Movie> ourMovies = new ArrayList<Movie>();

  public static void main(String[] args){

    Movie spiderman = new Movie("The Spiderman 2");
    
    // adding screening time to movie object hash
    
    spiderman.addScreening("10:00", 1, 100, 15.99);
    spiderman.addScreening("11:00", 5, 50, 12.99);
    spiderman.addScreening("19:00", 1, 100, 14.99);

    ourMovies.add(spiderman);



    Movie knivesout = new Movie("Knives Out");

    knivesout.addScreening("10:00", 3, 100, 15.99);
    knivesout.addScreening("20:00", 2, 100, 14.99);

    ourMovies.add(knivesout);


    printOurMovies();
  }

  //printing out movies with screening times
  
  public static void printOurMovies() {
    for(Movie movie : ourMovies) {
      System.out.println(movie.name);
      movie.printTimes();
      System.out.println("");
    }
  }

}
