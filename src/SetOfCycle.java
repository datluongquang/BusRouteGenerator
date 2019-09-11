import java.util.*;

public class SetOfCycle {
    public List<Cycle> cycleList= new ArrayList<>();
    public List<Cycle> copy= new ArrayList<>();
    public SetOfCycle(List<Cycle> cycles){
        cycleList.addAll(cycles);
        copy.addAll(cycles);
    }
    public SetOfCycle(SetOfCycle s){
        this(s.cycleList);
        copy= new ArrayList<>();
        copy.addAll(s.copy);
    }
    public boolean contains(Cycle c){
        for(Cycle x:cycleList){
            if(x.contains(c)){
                return true;
            }
        }
        return false;
    }
    public int calculate(){
        int score=0;
        for(Cycle c: cycleList){
            score+=c.calculateScore();
        }
        return score;
    }
    public void simplify(){
        for (int i=0;i<cycleList.size();i++){
            for(int j=i+1;j<cycleList.size();j++){
                Cycle c1=cycleList.get(i);
                Cycle c2=cycleList.get(j);
                boolean isCommon = Collections.disjoint(c1.routeList,c2.routeList);
                if(!isCommon){
                    Cycle c= new Cycle(c1.xor(c2).routeList);
                    cycleList.remove(c1);
                    cycleList.remove(c2);
                    j--;
                    cycleList.add(c);
                }
            }
        }
    }
    public int numVertex(){
        Set<BusStop> set= new HashSet<>();
        for(Cycle c:cycleList){
            set.addAll(c.busStopList);
        }
        return set.size();
    }

    @Override
    public String toString() {
        String ret="";
        for(Cycle c: cycleList){
            ret+="\n"+c;
        }
        return ret;
    }
}
