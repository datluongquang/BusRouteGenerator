import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    List<Route> routeList;
    List<BusStop> busStopList;
    HashMap<BusStop,List<BusStop>> adjv= new HashMap<>();
    public Graph(List<Route> routes, List<BusStop> busStops){
        this.routeList=routes;
        this.busStopList=busStops;
        for(Route r:routeList){
            if(adjv.containsKey(r.v1)){
                adjv.get(r.v1).add(r.v2);
            }
            else{
                List<BusStop> dummy= new ArrayList<>();
                dummy.add(r.v2);
                adjv.put(r.v1,dummy);
            }
            if(adjv.containsKey(r.v2)){
                adjv.get(r.v2).add(r.v1);
            }
            else{
                List<BusStop> dummy= new ArrayList<>();
                dummy.add(r.v1);
                adjv.put(r.v2,dummy);
            }
        }
    }
}
