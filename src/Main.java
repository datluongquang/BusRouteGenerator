
import java.util.*;

public class Main {
    Queue<Route> Equeue= new LinkedList<>();
    public static void main(String[] args) {

    }
    public SetOfCycle GenSetOfCycle(Graph g){
        List<Route> routes= g.routeList;
        List<BusStop> busStops= g.busStopList;
        List<Cycle> SimpleCycle= GenCycle(g);
        HashMap<Cycle,List<Cycle>> Adjv= GenAdjCycle(SimpleCycle);
        MinHeapCycle Q= new MinHeapCycle();
        List<Cycle> dummy= new ArrayList<>();
        dummy.add(SimpleCycle.get(0));
        SetOfCycle s= new SetOfCycle(dummy);
        Q.add(s);
        HashMap<Cycle,Boolean> visited= new HashMap<>();
        for(Cycle c:SimpleCycle){
            visited.put(c,false);
        }
        visited.put(SimpleCycle.get(0),true);
        while (Q.peek().numVertex()<busStops.size()){
            s=Q.extractMin();
            List<Cycle> adjacent= Adjv.get(s.cycleList.get(s.cycleList.size()-1));
            for(Cycle c:adjacent){
                if(!visited.get(c)){
                    SetOfCycle newSet= new SetOfCycle(s.cycleList);
                    newSet.cycleList.add(c);
                    Q.add(newSet);
                }
            }
        }
        return Q.peek();
    }
    public List<Cycle> GenCycle(Graph g){
        List<Route> routes= g.routeList;
        List<BusStop> busStops= g.busStopList;
        HashMap<BusStop,List<BusStop>> adjv= g.adjv;
        List<Cycle> SimpleCycle= new ArrayList<>();
        Route[] st= GST(g);
        HashMap<BusStop,Path> routeToBS= bfs(st,busStops.get(0));
        while (!Equeue.isEmpty()){
            Route e= Equeue.poll();
            Path p1= routeToBS.get(e.v1);
            Path p2= routeToBS.get(e.v2);
            Cycle cyc= merge(p1,p2,e);
            if(SimpleCycle.size()>0) {
                Cycle CombinedCycle = null;
                for (Cycle c : SimpleCycle) {
                    if(cyc.contains(c)){
                        if(CombinedCycle==null){
                            CombinedCycle=c;
                        }
                        else {
                            CombinedCycle= (Cycle)CombinedCycle.xor(c);
                        }
                    }
                }
                cyc= (Cycle)cyc.xor(CombinedCycle);
            }
            SimpleCycle.add(cyc);
        }
        return SimpleCycle;
    }
    public HashMap<BusStop,Path> bfs(Route[] routes,BusStop root){
        HashMap<BusStop,Path> map= new HashMap<>();
        Queue<Route> queue= new LinkedList<>();
        HashMap<BusStop,List<Route>> adjv= new HashMap<>();
        List<Route> visited= new ArrayList<>();
        for(int i=0;i<routes.length;i++){
            if(adjv.containsKey(routes[i].v1)){
                adjv.get(routes[i].v1).add(routes[i]);
            }
            else{
                List<Route> dummy= new ArrayList<>();
                dummy.add(routes[i]);
                adjv.put(routes[i].v1,dummy);
            }
            if(adjv.containsKey(routes[i].v2)){
                adjv.get(routes[i].v2).add(routes[i]);
            }
            else{
                List<Route> dummy= new ArrayList<>();
                dummy.add(routes[i]);
                adjv.put(routes[i].v2,dummy);
            }
            if(routes[i].v1.equals(root)){
                List<Route> dummy= new ArrayList<>();
                dummy.add(routes[i]);
                map.put(routes[i].v2,new Path(dummy));
                queue.add(routes[i]);
                visited.add(routes[i]);
            }
            else if(routes[i].v2.equals(root)){
                List<Route> dummy= new ArrayList<>();
                dummy.add(routes[i]);
                map.put(routes[i].v1,new Path(dummy));
                queue.add(routes[i]);
                visited.add(routes[i]);
            }
        }
        while (map.size()<routes.length){
            Route r= queue.poll();
            for(Route next:adjv.get(r.v1)){
                if(!visited.contains(next)){
                    if(!map.containsKey(next.v2)){
                        Path routeToBusStop= new Path(map.get(next.v1).routeList);
                        routeToBusStop.busStopList.add(next.v2);
                        routeToBusStop.routeList.add(next);
                        map.put(next.v2,routeToBusStop);
                    }
                }
                queue.add(next);
            }
        }
        return map;
    }
    public HashMap<Cycle,List<Cycle>> GenAdjCycle(List<Cycle> simpleCycle){
        HashMap<Cycle,List<Cycle>> AdjcCycle= new HashMap<>();
        for(int i=0;i<simpleCycle.size();i++){
            for(int j=i+1;j<simpleCycle.size();j++){
                if(sharedVertex(simpleCycle.get(i),simpleCycle.get(j))){
                    if(AdjcCycle.containsKey(simpleCycle.get(i))){
                        AdjcCycle.get(simpleCycle.get(i)).add(simpleCycle.get(j));
                    }
                    else{
                        List<Cycle> dummy= new ArrayList<>();
                        dummy.add(simpleCycle.get(j));
                        AdjcCycle.put(simpleCycle.get(i),dummy);
                    }
                    if(!AdjcCycle.containsKey(simpleCycle.get(j))){
                        List<Cycle> dummy= new ArrayList<>();
                        dummy.add(simpleCycle.get(j));
                        AdjcCycle.put(simpleCycle.get(j),dummy);
                    }
                    else{
                        AdjcCycle.get(simpleCycle.get(j)).add(simpleCycle.get(i));
                    }
                }
            }
        }
        return AdjcCycle;
    }
    public boolean sharedVertex(Cycle c1,Cycle c2){
        for(BusStop b1:c1.busStopList){
            for (BusStop b2:c2.busStopList){
                if(b1.equals(b2)){
                    return true;
                }
            }
        }
        return false;
    }
    public Route[] GST(Graph g){
        List<Route> routes= g.routeList;
        List<BusStop> busStops= g.busStopList;
        HashMap<BusStop,List<BusStop>> adjv= g.adjv;
        Route[] spanTree= new Route[busStops.size()];
        int cur=0;
        Queue<BusStop> visited= new LinkedList<>();
        Queue<BusStop> queue= new LinkedList<>();
        Set<Integer> st= new HashSet<>();
        queue.add(busStops.get(0));
        visited.add(busStops.get(0));
        while (!queue.isEmpty()){
            BusStop v=queue.poll();
            for(BusStop u: adjv.get(v)){
                if(!visited.contains(u)){
                    queue.add(u);
                    visited.add(u);
                }
                Route route= getRoute(u,v,routes);
                if(!st.contains(u.id)){
                    spanTree[cur]=route;
                    cur++;
                }
                else{
                    Equeue.add(route);
                }
            }
        }
        return spanTree;
    }
    public Route getRoute(BusStop v1, BusStop v2,List<Route> routes){
        for(Route r:routes){
            if((v1.equals(r.v1)&&v2.equals(r.v2))||(v1.equals(r.v2)&&v2.equals(r.v1))){
                return r;
            }
        }
        return new Route(v1,v2,0);
    }
    public Cycle merge(Path p1, Path p2, Route e){
        Cycle dummy= (Cycle)p1.xor(p2);
        dummy.routeList.add(e);
        return dummy;
    }
}
