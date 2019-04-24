
import java.util.ArrayList;
import java.util.List;

public class Path {
    public List<BusStop> busStopList;
    public List<Route> routeList;
    public Path(List<Route> routes){
        busStopList= new ArrayList<>();
        routeList= new ArrayList<>();
        for( Route r: routes){
            routeList.add(r);
            if(!busStopList.contains(r.v1)){
                busStopList.add(r.v1);
            }
            if(!busStopList.contains(r.v2)){
                busStopList.add(r.v2);
            }
        }
    }
    public boolean contains(BusStop b){
        return busStopList.contains(b);
    }
    public boolean contains(Route r){
        return routeList.contains(r);
    }
    public Path xor(Path p){
        List<Route> finalPath= new ArrayList<>();
        for(Route r: routeList){
            if(!p.contains(r)){
                finalPath.add(r);
            }
        }
        for (Route r:p.routeList){
            if(!finalPath.contains(r)&&!contains(r)){
                finalPath.add(r);
            }
        }
        Path fin= new Path(finalPath);
        return fin;
    }
}
