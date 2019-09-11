
import java.util.*;

public class Main {
    public static Queue<Route> Equeue= new LinkedList<>();
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        List<Route> routes= new ArrayList<>();
        List<BusStop> busStops= new ArrayList<>();
//        BusStop b5= new BusStop(5,0,1,5);
//        BusStop b1= new BusStop(1,0,4,10);
//        BusStop b2= new BusStop(2,4,4,5);
//        BusStop b3= new BusStop(3,7,2,10);
//        BusStop b4= new BusStop(4,4,1,5);
//        BusStop b6= new BusStop(6,0,5,10);
//        Route r1= new Route(b1,b2,4);
//        Route r2= new Route(b1,b4,5);
//        Route r3= new Route(b1,b5,3);
//        Route r4= new Route(b2,b3,5);
//        Route r5= new Route(b2,b4,3);
//        Route r6= new Route(b4,b3,5);
//        Route r7= new Route(b4,b5,4);
//        Route r8= new Route(b4,b6,3);
//        Route r9= new Route(b5,b6,5);
//        Route r10= new Route(b3,b6,6);
//        busStops.add(b1);busStops.add(b2);busStops.add(b3);busStops.add(b4);busStops.add(b5);busStops.add(b6);
//        routes.add(r1); routes.add(r2); routes.add(r3); routes.add(r4); routes.add(r5); routes.add(r6); routes.add(r7); routes.add(r8); routes.add(r9); routes.add(r10);
        BusStop b1= new BusStop(1,5,10,100);
        BusStop b2= new BusStop(2,8,10,100);
        BusStop b3= new BusStop(3,11,10,100);
        BusStop b4= new BusStop(4,13,10,100);
        BusStop b5= new BusStop(5,13,8,100);
        BusStop b6= new BusStop(6,13,6,100);
        BusStop b7= new BusStop(7,16,6,100);
        BusStop b8= new BusStop(8,16,4,100);
        BusStop b9= new BusStop(9,16,3,100);
        BusStop b10= new BusStop(10,17,2,100);
        BusStop b11= new BusStop(11,16,0,100);
        BusStop b12= new BusStop(12,15,2,100);
        BusStop b13= new BusStop(13,14,4,100);
        BusStop b14= new BusStop(14,14,2,100);
        BusStop b15= new BusStop(15,14,0,100);
        BusStop b16= new BusStop(16,12,2,100);
        BusStop b17= new BusStop(17,12,5,100);
        BusStop b18= new BusStop(18,11,7,100);
        BusStop b19= new BusStop(19,9,6,100);
        BusStop b20= new BusStop(20,9,5,100);
        BusStop b21= new BusStop(21,8,3,100);
        BusStop b22= new BusStop(22,9,4,100);
        BusStop b23= new BusStop(23,9,0,100);
        BusStop b24= new BusStop(24,5,0,100);
        BusStop b25= new BusStop(25,5,2,100);
        BusStop b26= new BusStop(26,3,2,100);
        BusStop b27= new BusStop(27,0,3,100);
        BusStop b28= new BusStop(28,2,4,500);
        BusStop b29= new BusStop(29,5,4,100);
        BusStop b31= new BusStop(31,7,6,100);
        BusStop b32= new BusStop(32,7,8,100);
        BusStop b33= new BusStop(33,5,8,100);
        busStops.add(b1);busStops.add(b2);busStops.add(b3);busStops.add(b4);busStops.add(b5);busStops.add(b6);busStops.add(b7);busStops.add(b8);busStops.add(b9);busStops.add(b10);busStops.add(b11);busStops.add(b12);busStops.add(b13);busStops.add(b14);busStops.add(b15);busStops.add(b16);busStops.add(b17);busStops.add(b18);busStops.add(b19);busStops.add(b20);busStops.add(b21);busStops.add(b22);busStops.add(b23);busStops.add(b24);busStops.add(b25);busStops.add(b26);busStops.add(b27);busStops.add(b28);busStops.add(b29);busStops.add(b31);busStops.add(b32);busStops.add(b33);
        Route r1=new Route(b1,b2,3);
        Route r2=new Route(b1,b33,2);
        Route r3=new Route(b2,b3,3);
        Route r4=new Route(b33,b32,2);
        Route r5=new Route(b3,b4,2);
        Route r6=new Route(b32,b31,2);
        Route r7=new Route(b4,b5,2);
        Route r8=new Route(b31,b19,2);
        Route r9=new Route(b31,b28,7);
        Route r10=new Route(b5,b6,3);
        Route r11= new Route(b5,b18,4);
        Route r12=new Route(b19,b18,2);
        Route r13=new Route(b19,b20,1);
        Route r15=new Route(b6,b7,2);
        Route r16=new Route(b6,b13,2);
        Route r17=new Route(b20,b22,2);
        Route r18=new Route(b28,b27,3);
        Route r19=new Route(b28,b29,3);
        Route r20=new Route(b7,b8,2);
        Route r21=new Route(b13,b8,2);
        Route r22=new Route(b13,b17,2);
        Route r23=new Route(b13,b9,3);
        Route r24=new Route(b13,b12,3);
        Route r25=new Route(b13,b14,2);
        Route r26=new Route(b17,b16,3);
        Route r27=new Route(b17,b22,3);
        Route r28=new Route(b22,b21,1);
        Route r29=new Route(b22,b23,4);
        Route r30=new Route(b27,b26,4);
        Route r31=new Route(b29,b21,3);
        Route r32=new Route(b9,b10,2);
        Route r33=new Route(b12,b11,3);
        Route r34=new Route(b14,b15,2);
        Route r35=new Route(b16,b15,4);
        Route r36=new Route(b16,b23,5);
        Route r37=new Route(b23,b24,4);
        Route r38=new Route(b26,b25,2);
        Route r39=new Route(b10,b11,3);
        Route r40=new Route(b24,b25,2);
        routes.add(r1);routes.add(r2);routes.add(r3);routes.add(r4);routes.add(r5);routes.add(r6);routes.add(r7);routes.add(r8);routes.add(r9);routes.add(r10);routes.add(r11);routes.add(r12);routes.add(r13);routes.add(r15);routes.add(r16);routes.add(r17);routes.add(r18);routes.add(r19);routes.add(r20);routes.add(r21);routes.add(r22);routes.add(r23);routes.add(r24);routes.add(r25);routes.add(r26);routes.add(r27);routes.add(r28);routes.add(r29);routes.add(r30);routes.add(r31);routes.add(r32);routes.add(r33);routes.add(r34);routes.add(r35);routes.add(r36);routes.add(r37);routes.add(r38);routes.add(r39);routes.add(r40);
        Graph g= new Graph(routes,busStops);
        SetOfCycle ret= GenSetOfCycle(g);
        ret.simplify();
        System.out.println("Final set of circle is: "+ret);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
    public static SetOfCycle GenSetOfCycle(Graph g){
        List<Route> routes= g.routeList;
        List<BusStop> busStops= g.busStopList;
        List<Cycle> SimpleCycle= GenCycle(g);
        HashMap<Cycle,List<Cycle>> Adjv= GenAdjCycle(SimpleCycle);
        MinHeapCycle Q= new MinHeapCycle();
        List<Cycle> dummy= new ArrayList<>();
        dummy.add(SimpleCycle.get(0));
        SetOfCycle s= new SetOfCycle(dummy);
        Q.add(s);
        int count=0;
        while (!Q.isEmpty()&&Q.peek().numVertex()<busStops.size()&&count<2000){
            count++;
            s=Q.extractMin();
            List<Cycle> adjacent= Adjv.get(s.cycleList.get(s.cycleList.size()-1));
            for(Cycle c:adjacent){
                if(!s.contains(c)){
                    SetOfCycle newSet= new SetOfCycle(s);
                    newSet.cycleList.add(c);

                    Q.add(newSet);
                }
            }
        }
        for(int i=0;i<Q.size;i++){
            if(Q.heap[i].numVertex()==busStops.size()){
                return Q.heap[i];
            }
        }
        return Q.peek();
    }
    public static List<Cycle> GenCycle(Graph g){
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
                            CombinedCycle= CombinedCycle.cXor(c);
                        }
                    }
                }
                if(CombinedCycle!=null) {
                    cyc = cyc.cXor(CombinedCycle);
                }
            }
            SimpleCycle.add(cyc);
        }
        return SimpleCycle;
    }
    public static HashMap<BusStop,Path> bfs(Route[] routes,BusStop root){
        HashMap<BusStop,Path> map= new HashMap<>();
        Queue<Route> queue= new LinkedList<>();
        HashMap<BusStop,List<Route>> adjv= new HashMap<>(); //List of route around a busstop in st
        List<Route> visited= new ArrayList<>();
        for(int i=0;i<routes.length;i++){
            if(!adjv.isEmpty()&&adjv.containsKey(routes[i].v1)){
                    adjv.get(routes[i].v1).add(routes[i]);
            }
            else{
                List<Route> dummy= new ArrayList<>();
                dummy.add(routes[i]);
                adjv.put(routes[i].v1,dummy);
            }
            if(!adjv.isEmpty()&&adjv.containsKey(routes[i].v2)){
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
            for(Route next:adjv.get(r.v2)){
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
    public static HashMap<Cycle,List<Cycle>> GenAdjCycle(List<Cycle> simpleCycle){
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
    public static boolean sharedVertex(Cycle c1,Cycle c2){
        for(BusStop b1:c1.busStopList){
            for (BusStop b2:c2.busStopList){
                if(b1.equals(b2)){
                    return true;
                }
            }
        }
        return false;
    }
    public static Route[] GST(Graph g){
        List<Route> routes= g.routeList;
        List<BusStop> busStops= g.busStopList;
        HashMap<BusStop,List<BusStop>> adjv= g.adjv;
        Route[] spanTree= new Route[busStops.size()-1];
        int cur=0;
        Queue<BusStop> visited= new LinkedList<>();
        Queue<BusStop> queue= new LinkedList<>();
        Set<Integer> st= new HashSet<>();
        Set<Route> duplicate= new HashSet<>();
        st.add(busStops.get(0).id);
        queue.add(busStops.get(0));
        visited.add(busStops.get(0));
        while (!queue.isEmpty()){
            BusStop v=queue.poll();
            for(BusStop u: adjv.get(v)){
                if(!visited.contains(u)){
                    queue.add(u);
                    visited.add(u);
                }
                Route copy1= new Route(u,v,0);
                Route copy2= new Route(v,u,0);
                if(duplicate.contains(copy1)||duplicate.contains(copy2)){
                    continue;
                }
                else{
                    duplicate.add(copy1);
                    duplicate.add(copy2);
                }
                Route route= getRoute(u,v,routes);
                if(!st.contains(u.id)){
                    spanTree[cur]=route;
                    cur++;
                    st.add(u.id);
                }
                else{
                    Equeue.add(route);
                }
            }
        }
        return spanTree;
    }
    public static Route getRoute(BusStop v1, BusStop v2,List<Route> routes){
        for(Route r:routes){
            if((v1.equals(r.v1)&&v2.equals(r.v2))||(v1.equals(r.v2)&&v2.equals(r.v1))){
                return r;
            }
        }
        return new Route(v1,v2,0);
    }
    public static Cycle merge(Path p1, Path p2, Route e){
        Cycle dummy= p1.cXor(p2);
        dummy.routeList.add(e);
        return dummy;

    }
}
