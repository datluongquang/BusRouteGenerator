import java.util.HashMap;
import java.util.List;

public class Graph {
    List<Route> routeList;
    List<BusStop> busStopList;
    HashMap<BusStop,List<BusStop>> adjv;
    public Graph(List<Route> routes, List<BusStop> busStops){
        this.routeList=routes;
        this.busStopList=busStops;
    }
}
