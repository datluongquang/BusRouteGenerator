import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeapCycle {
    public SetOfCycle[] heap;
    public int size=0;
    public int maxSize=1000;
    public MinHeapCycle(){
        heap= new SetOfCycle[maxSize];
    }
    public int parent(int i){
        return i/2;
    }
    private int left(int i)
    {
        return (2 * i);
    }
    private int right(int i)
    {
        return (2 * i) + 1;
    }
    public void swap(int i,int j){
        SetOfCycle dummy= heap[i];
        heap[i]=heap[j];
        heap[j]=dummy;
    }
    public void add(SetOfCycle s){
        if(size+1>maxSize){
            maxSize=maxSize*2;
            heap = Arrays.copyOf(heap, maxSize);
        }
        size++;
        int i= size-1;
        heap[i]= s;
        while (i!=0 && heap[parent(i)].calculate()>heap[i].calculate()){
            swap(i,parent(i));
            i= parent(i);
        }
    }
    public void MinHeapify(int i){
        int l= left(i);
        int r= right(i);
        int smallest=i;
        if(l<size&&heap[l].calculate()< heap[i].calculate()){
            smallest=l;
        }
        if(r<size&&heap[r].calculate()< heap[i].calculate()){
            smallest=r;
        }
        if (smallest!=i){
            swap(i,smallest);
            MinHeapify(smallest);
        }

    }
    public SetOfCycle extractMin(){
        SetOfCycle min= heap[0];
        if(size!=0) {
            heap[0] = heap[size - 1];
            size--;
            if (size > 0) {
                MinHeapify(0);
            }
        }
        else {
            heap[0]=null;
        }
        return min;
    }
    public SetOfCycle peek(){
        return heap[0];
    }
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
