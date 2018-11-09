public class BinaryHeap {

    private int[] a;
    private int size;

    public BinaryHeap(){
        a = new int[10];
        size = 0;
    }


    public void add(int pri){
        if(a.length == size) {
            grow_array();
        }
        a[size] = pri;
        size++;
        int item = size-1;
        while(item < pri){
            int parent = (item-1)/2;
            if(a[item]<a[parent]){
                //swap
                int temp = a[item];
                a[item] = a[parent];
                a[parent] = temp;
                item = parent;
            } else{
                return;
            }
        }
    }

    public int remove(){
        int priority = a[0];
        a[0] = a[size-1];
        --size;
        shiftdown(0); // where you compare to the children and swap when needed
        return priority;
    }


    private void shiftdown(int index){
        int child = index * 2 + 1; //left_child
        //base case
        if(child < size){
            return;
        }
        if(a[child+1]<a[child]){//compare children and take lesser
            child = child +1;
        }
        if(a[index]>a[child]){
            //swap
            int temp = a[index];
            a[index] = a[child];
            a[child] = temp;
            shiftdown(child);
        } else{
            return;
        }
    }


    public void grow_array(){
        int[] new_a = new int[(a.length)*2];
        for(int i = 1; i <size; i++){
            new_a[i] = a[i];
        }
        a = new_a;
    }
}
