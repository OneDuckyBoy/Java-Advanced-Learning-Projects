//import java.util.ArrayList;
//import java.util.List;
//
//public class Guild {
//    private String name;
//    private int capacity;
//    private List<Player> roster;
//
//    public Guild(String name, int capacity) {
//        this.name = name;
//        this.capacity = capacity;
//        roster = new ArrayList<>();
//    }
//    public void addPlayer(Player player){
//        if (roster.size()<capacity){
//            roster.add(player);
//        }
//    }
//    public boolean removePlayer(String name){
//        return roster.removeIf(p -> p.getName().equals(name));
//    }
//
//    public void promotePlayer(String name){
//        roster.forEach(p -> {
//            if (p.getName().equals(name)){
//                p.setRank("Member");
//
//                return;
//            }
//        });
//    }
//    public void demotePlayer(String name){
//        roster.forEach(p -> {
//            if (p.getName().equals(name)){
//                p.setRank("Trial");
//
//                return;
//            }
//        });
//    }
//    public Player[] kickPlayersByClass(String clazz){
//        List<Player> list = new ArrayList<>();
//
//        roster.forEach(p -> {
//            if (p.getClazz().equals(clazz)){
//                list.add(p);
//                roster.remove(p);
//
//                return;
//            }
//    });
//    return (Player[]) list.toArray();
//    }
//    public int count(){
//        return roster.size();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public List<Player> getRoster() {
//        return roster;
//    }
//
//    public void setRoster(List<Player> roster) {
//        this.roster = roster;
//    }
//
//    public String report(){
//        StringBuilder report = new StringBuilder(String.format("Players in the guild: %s:%n",getName()));
//
//        for (Player player : roster) {
//            report.append(player.toString()).append(System.lineSeparator());
//        }
//        return report.toString();
//    }
//}
