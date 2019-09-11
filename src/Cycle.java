import java.util.ArrayList;
import java.util.List;

public class Cycle extends Path{
    public Cycle(List<Route> routes){
        super(routes);
    }
    public boolean contains( Cycle c){
        for(BusStop v: c.busStopList){
            if(busStopList.contains(v)){
                continue;
            }
            if(!contains(v)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "bus stop:" + busStopList+",route:"+routeList.toString();
    }

    public int calculateScore(){
        int totalPath=0;
        int totalVertex=0;
        for(Route r: routeList){
            totalPath+=r.timeTravel;
        }
        for(BusStop b: busStopList){
            totalVertex+=b.people;
        }
        return totalPath*totalVertex;
    }
    public boolean contains(BusStop b){
        BusStop extreme = new BusStop(-1,1000000,b.y,0);
        int count = 0, i = 0;
        do
        {
            int next = (i+1)% busStopList.size();

            if (intersect(busStopList.get(i), busStopList.get(next), b, extreme))
            {
                if (arrange(busStopList.get(i), b, busStopList.get(next)) == 0)
                    return liesOn(busStopList.get(i), b, busStopList.get(next));
                count++;
            }
            i = next;
        } while (i != 0);
        return (count & 1) == 1;
    }
    boolean liesOn(BusStop p, BusStop q, BusStop r)
    {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y))
            return true;
        return false;
    }
    int arrange(BusStop p, BusStop q, BusStop r)
    {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0)
            return 0;
        else if (val >0 )
            return 1;
        else
            return 2;
    }
    boolean intersect(BusStop p1, BusStop q1, BusStop p2, BusStop q2)
    {
        int o1 = arrange(p1, q1, p2);
        int o2 = arrange(p1, q1, q2);
        int o3 = arrange(p2, q2, p1);
        int o4 = arrange(p2, q2, q1);
        if (o1 != o2 && o3 != o4)
            return true;

        if (o1 == 0 && liesOn(p1, p2, q1))
            return true;

        if (o2 == 0 && liesOn(p1, q2, q1))
            return true;

        if (o3 == 0 && liesOn(p2, p1, q2))
            return true;

        if (o4 == 0 && liesOn(p2, q1, q2))
            return true;

        return false;
    }
}
