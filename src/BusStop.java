public class BusStop {
    public int id;
    public int x;
    public int y;
    public int people;
    public BusStop(int id, int x, int y, int people){
        this.id=id;
        this.x=x;
        this.y=y;
        this.people=people;
    }

    @Override
    public boolean equals(Object obj) {
        BusStop dummy= (BusStop)obj;
        return dummy.id == id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
