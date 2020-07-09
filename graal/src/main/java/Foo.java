public class Foo{
    public static void main(String args[]){

        Foo foo = new Foo();
        
        int i = 0;
        while(true){
            if(i%1000==0){
                //System.out.println(i);
                try{
                    Thread.sleep(100);
                }catch(Exception e){}
            }

            i++;

            // add(i, i+1);
            add1(i, i+1);
            // addmemory(i, i, i, i, i, i, i, i+1);
            // addMemory(i);
            // foo.atLeastTen(i%20);
            // foo.add(i,i+1);
            // foo.add2();
            // foo.doif2(i, i+1);
            // foo.constantFolding(i);
            // foo.strengthReduction(i, 10);
            // foo.negneg(i);
            // foo.gvn(i,3);
            // foo.inlining2(i);
            // foo.escapeTest(i%100);
            // foo.add3(i);
            // average(i, 10);
            // triple(i,5);
        }
    }

    int x = 3;
    int y = 4;
    final int z = 2; 

    final public int getX(){
        return x;
    }

    final public int getY(){
        return y;
    }

    int getZ(){
        return z + 1;
    }


    public static int add(int x, int y){
        return x + y;
    }

    public static int add1(int x, int y){
        return x + y + 10;
    }

    // public int addmemory(int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8){
    //     return x1*2;
    // } 


    static int m = 3;
    public static int addMemory(int a){
            return m + a;
    } 

    public int addAll(int max){
        int sum = 0;
        for (int i = 0; i< max; i++){
            sum = add(sum, i);
        }
        return sum;
    }

    public int add2(){
        return getX() + getY();
    }

    public int doif(int x, int y){
        if (x > 2){
            return x+y;
        }
        else{
            return x*y;
        }
    }

    public int doif2(int x, int y){
        int z;
        if (x < 2)
            z=x+y;
        else
            z=x*y;
        return z;
    }

    public int add3(int a){
        return getX() + doif(a, getY());
    }

    public int doDouble(int a){
        return 2*a;
    }

    public int[] strengthReduction(int a, int N){
        int[] y = new int[N];
        for (int i = 0; i < N; i++)
        {
            y[i] =  a * i;
        }
        return y;
    }

    public int negneg(int a){
        return -(-a);
    }

    public int gvn(int a, int b){
        return (a+b) * (a+3);
    }

    public int inlining(int a){
        return atLeastTen(3);
    }

    //至少返回10
    public int atLeastTen(int a){
        if (a < 10)
            return 10;
        else
            return a;    
    }

    public float average(float x, float y){
        return (x + y)/2;
    }

    public int triple(int x, int y){
        return (x + y)*3;
    }

    public int average2(int[] values) {
        int sum = 0;
        for (int n = 0; n < values.length; n++) {
          sum += values[n];
        }
        return sum / values.length;
    }

    public int escapeTest(int age){
        Person p = new Person(age);
        return p.ageSegment();
    }

    public class Person{
        private int age;
        private float weight;

        public Person(int age){
           this.age = age;     
        }

        final public int ageSegment(){
            if (age < 20)
                return 1;
            else
                return 2;        
        } 

        public void setWeight(float weight){
            this.weight = weight;
        }

        public float getWeidht(){
            return weight;
        }
    }

}