import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Fixture {
    
    Random random = new Random();
    int round;
    int matchNum;
    ArrayList<int[]> matchs = new ArrayList<>();
    ArrayList<Integer> excludeNumber = new ArrayList<>();
    ArrayList<int[]> allMatchs = new ArrayList<>();

    public void createFixture(String[] teams){
        round = (teams.length-1)*2;
        matchNum = teams.length/2;
        for(int j=0; j<round; j++){
            
            generateRound(teams);
            
            Iterator<int[]> itr = matchs.iterator();
            
            System.out.println("== Round " + j + " ==");
            while(itr.hasNext()){
                int[] temp = (int[]) itr.next();
                System.out.println(teams[temp[0]] + " - "+ teams[temp[1]]);
            }
            matchs.clear();
            excludeNumber.clear();
            System.out.println("-------------");
            System.out.println("");
        }
    }

    public void generateRound(String[] teams){
        
        for(int i=0; i<matchNum; i++){
            int[] match = new int[2];
            match[0] = generateMatch(teams.length, excludeNumber);
            excludeNumber.add(match[0]);
            match[1] = generateMatch(teams.length, excludeNumber);
            excludeNumber.add(match[1]);      
            int[] match2 = new int[]{match[1], match[0]};
            if(!containsAllMatchs(match, allMatchs)){
                matchs.add(match);
                allMatchs.add(match);
                
            }
            else if(!containsAllMatchs(match2, allMatchs)){
                matchs.add(match2);
                allMatchs.add(match2);
            }
            else if(matchNum-i>1){
                excludeNumber.remove(Integer.valueOf(match[0]));
                excludeNumber.remove(Integer.valueOf(match[1]));
                i--;
            }
            else{
                matchs.clear();
                excludeNumber.clear();
                for(int j=0; j<i; j++){
                    allMatchs.remove(allMatchs.size()-1);
                }
                i=-1;
            }
        }
    }

    public int generateMatch(int range, ArrayList<Integer> excludeNumber) {
        Random rand = new Random();
        int random = rand.nextInt(range);
        if(!excludeNumber.contains(random)){
            return random;
        }else{
            return generateMatch(range, excludeNumber);
        }
    }

    public boolean containsAllMatchs(int[] arr, ArrayList<int[]> al){
        for(int[] itr : al){
            if(Arrays.equals(itr,arr)) return true;
        }
        return false;
    }
}