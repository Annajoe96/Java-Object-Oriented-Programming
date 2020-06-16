import java.util.*;

class Team{

  String name;
  String manager;
  HashMap<String, Player> teamMembers = new HashMap<String, Player>();

  public Team(String name, String mgr){
    this.name = name;
    this.manager = mgr;
  }
  //method to add player to hash teamMembers
  public void addPlayer(String id, String name, Double height, Double weight){
  
    // creating player object with id, name, height and weight as params
    Player player = new Player(id, name, height, weight);
    teamMembers.put(id, player);
  }

  public void printTeam() {
    System.out.println(name.toUpperCase());
    System.out.println("manager : " + manager);
    for (HashMap.Entry<String,Player> entry : teamMembers.entrySet()){
      System.out.println("ID: " + entry.getKey() + "  NAME:  " + entry.getValue().name + "  HEIGHT:  " + entry.getValue().height + "  WEIGHT  " + entry.getValue().weight);
    }
  }
  
  //to print players only above given weight
  public void aboveWeight(double weight){
    
    for(HashMap.Entry<String,Player> entry : teamMembers.entrySet()){
      if(entry.getValue().weight > weight){
        System.out.println(entry.getValue().name);
      }
    }
  }

  // to remove players
  public void removePlayer(String id){
    if(teamMembers.get(id) == null) return;
    teamMembers.remove(id);
  }
  //to update weight of given player
  public void updateWeight(String id, Double weightnew){

    if(teamMembers.get(id) == null) return;

    teamMembers.get(id).weight = weightnew;

  }
  
  //to sort players according to weight
  public LinkedList sortWeight(){

    LinkedList<Player> sorted_weight = new LinkedList<Player>();

    for(HashMap.Entry<String,Player> entry: teamMembers.entrySet()){
      Player current_player = entry.getValue();

      ListIterator list_Iter = sorted_weight.listIterator();

      int index = 0;
      for (int i = 0; i < sorted_weight.size(); i++) {
        Player linked_list_player = sorted_weight.get(i);

        if(linked_list_player.weight > current_player.weight) {
          index = i;
          break;
        }
      }

      sorted_weight.add(index, current_player);
    }

    return sorted_weight;
  }


}


class Player{

  String id;
  String name;
  Double height;
  Double weight;

  public Player(String id, String name , Double height, Double weight){
    this.id = id;
    this.name = name;
    this.height = height;
    this.weight = weight;
  }

}

public class Game{

  public static void main(String[] args){

    Team teamA = new Team("manchester ", "Olegona");

    teamA.addPlayer("45", "ronaldo", 6.0, 65.0);
    teamA.addPlayer("56", "annajoe", 5.7, 65.5);
    teamA.addPlayer("478", "johnpaul",5.9, 62.7);
    teamA.addPlayer("438", "danielpaul",5.9, 25.0);
    teamA.addPlayer("100", "messi",5.7, 61.1);
    teamA.addPlayer("234", "lordsugar",5.5, 78.0);
    teamA.addPlayer("478", "neymar",6.1, 63.4);
    teamA.addPlayer("118", "pique",6.3, 75.9);
    teamA.addPlayer("408", "ronaldinho",5.8, 61.0);
    teamA.addPlayer("289", "Salah",5.8, 60.0);

    

  }
}
