public class Main {
    public static void main(String[] args) throws Exception {
        String[] teams = {"Fenerbahçe", "Galatasaray", "Beşiktaş", "KonyaSpor","Gençlerbirliği"};
        String[] teams2 = new String[teams.length+1];
        if(teams.length%2==1){
            for(int i=0; i<teams.length; i++){
                teams2[i]=teams[i];
            }
            teams2[teams2.length-1]="Bay";
        }
        Fixture fixture = new Fixture();
        fixture.createFixture(teams2);
    }
}
