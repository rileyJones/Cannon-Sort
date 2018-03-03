public class Cannon {
    public static double[] sort(double[] values){
        int scalar=3;
        double[] large=new double[values.length*scalar];
        double[] sorted=new double[values.length];
        double min=values[0];
        double max=values[0];
        for(int x=1;x<values.length;x++){
            //System.out.println(x);
            min=Math.min(values[x],min);
            max=Math.max(values[x],max);
        }
        double range=max-min;
        boolean done;
        double value;
        double valueB;
        int temp;
        for(int x=0;x<values.length;x++){
            //System.out.println(x);
            temp=(int)((values[x]-min)/(range+1)*values.length*scalar);
            done=true;
            value=values[x];
            while(done) {
                //System.out.println(temp);
                if (large[temp] == 0) {
                    large[temp] = value;
                    done=false;
                } else {
                    if(large[temp]>value){
                        valueB=large[temp];
                        large[temp]=value;
                        value=valueB;
                    }
                    temp++;
                }
            }
        }
        temp=0;
        for(int x=0;x<values.length*scalar;x++){
            //System.out.println(x);
            if(large[x]!=0){
               sorted[temp]=large[x];
               temp++;
            }
        }
        return sorted;
    }
}
class generator{
    public static void main(String[] args){
        double[] values = new double[10000000];
        for(int x=0;x<values.length;x++){
            values[x]=Math.random()*100;
        }
        long startTime = System.currentTimeMillis();
        double[] sorted=Cannon.sort(values);
        long stopTime = System.currentTimeMillis();
        boolean isSorted=true;
        for(int x=0;x<values.length-1;x++){
            //System.out.println(x);
            isSorted=isSorted&&(sorted[x+1]>sorted[x]);
        }
        if(isSorted) {
            System.out.println("Time: "+(stopTime - startTime));
        }else{
            System.out.println("failed");
        }
    }
}