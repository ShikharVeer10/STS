import java.util.*;
public class MaxHeap{
    int[] h;
    int size;
    int cap;
    MaxHeap(int c){
        cap=c;
        h=new int[c];
        size=0;
    }
    int p(int i){
        return (i-1)/2;
    }
    int l(int i){
        return 2*i+1;
    }
    int r(int i){
        return 2*i+2;
    }
    void insert(int x){
        if(size==cap){
            System.out.println("Heap Full");
            return;
        }
        h[size]=x;
        int i=size;
        size++;
        while(i!=0 && h[p(i)]<h[i]){
            int t=h[i];
            h[i]=h[p(i)];
            h[p(i)]=t;
            i=p(i);
        }
    }
    void heapify(int i){
        int l=l(i);
        int r=r(i);
        int largest=i;

        if(l<size && h[l]>h[largest])
            largest=l;

        if(r<size && h[r]>h[largest])
            largest=r;

        if(largest !=i){
            int t=h[i];
            h[i]=h[largest];
            h[largest]=t;
            heapify(largest);
        }
    }
    int extractMax(){
        if(size<=0) return -1;
        int root=h[0];
        h[0]=h[size-1];
        size--;
        heapify(0);

        return root;
    }
    void print(){
        for(int i=0;i<size;i++){
            System.out.println(h[i]+" ");
        System.out.println();
        }
    }
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n=sc.nextInt();
        MaxHeap mh=new MaxHeap(n);
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            mh.insert(x);
        }
        System.out.println("Heap Elements");
        mh.print();
        System.out.println("Extracted Max: "+mh.extractMax());
        System.out.println("Heap after extraction:");
        mh.print();
        System.out.println("Extracted Max:"+mh.extractMax());
        System.out.println("Heap after extraction");
        mh.print();
    }
}
}
