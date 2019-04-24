import java.util.Collections;
import java.util.List;

public class SetOfCycle {
    public List<Cycle> cycleList;
    public SetOfCycle(List<Cycle> cycles){
        for(Cycle c: cycles){
            cycleList.add(c);
        }
    }
    public SetOfCycle(SetOfCycle s){
        this(s.cycleList);
    }
    public int calculate(){
        int score=0;
        for(Cycle c: cycleList){
            score+=c.calculateScore();
        }
        return score;
    }
    public void simplify(){
        for (Cycle c1:cycleList){
            for(Cycle c2:cycleList){
                boolean isCommon = Collections.disjoint(c1.routeList,c2.routeList);
                if(!isCommon){
                    Cycle c= new Cycle(c1.xor(c2).routeList);
                    cycleList.remove(c1);
                    cycleList.remove(c2);
                    cycleList.add(c);
                }
            }
        }
    }
}
