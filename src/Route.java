public class Route {
    public BusStop v1;
    public BusStop v2;
    public double timeTravel;
    public Route(BusStop v1,BusStop v2, double timeTravel){
        this.v1= v1;
        this.v2 =v2;
        this.timeTravel= timeTravel;
    }

    @Override
    public boolean equals(Object obj) {
        Route dummy= (Route)obj;
        return (dummy.v1.equals(v1) && dummy.v2.equals(v2))||(dummy.v2.equals(v1) && dummy.v1.equals(v2));
    }

    @Override
    public String toString() {
        return "("+v1+","+v2+")";
    }

    @Override
    public int hashCode() {
        return v1.id*37+v2.id;
    }
}
