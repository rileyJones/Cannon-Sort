public class CannonWords {
    public static String[] sort(String[] words){
        //*
        int scalar=10;       //Memory size compared to input
        double slide=1.000001;   //Value between 1 and 2: 1=High risk, Slower with higher numbers
        int highPow=words[0].length();
        double[] values = new double[words.length];
        for(int x=0;x<values.length;x++){
            //System.out.println(x);
            for(int y=0;y<words[x].length();y++){
                values[x]+=((int)(words[x].charAt(y))-97)*Math.pow(26,highPow-y-1);
            }
        }
        double[] large=new double[values.length*scalar];
        String[] wordLarge=new String[values.length*scalar];
        String[] sorted=new String[values.length];
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
        String tempString;
        double valueB;
        String tempStringB;
        int temp;
        for(int x=0;x<values.length;x++){
            //System.out.println(x);
            temp=(int)((values[x]-min)/(slide*range)*values.length*scalar);
            done=true;
            value=values[x];
            tempString=words[x];
            while(done) {
                //System.out.println(temp);
                if (large[temp] == 0) {
                    large[temp] = value;
                    wordLarge[temp]=tempString;
                    done=false;
                } else {
                    if(large[temp]>value){
                        valueB=large[temp];
                        tempStringB=wordLarge[temp];
                        large[temp]=value;
                        wordLarge[temp]=tempString;
                        value=valueB;
                        tempString=tempStringB;
                    }
                    temp++;
                }
            }
        }
        temp=0;
        for(int x=0;x<values.length*scalar;x++){
            //System.out.println(x);
            if(large[x]!=0){
                sorted[temp]=wordLarge[x];
                temp++;
            }
        }
        //*/
        return sorted;
    }
}
class wordgenerator{
    public static void main(String[] args){
        String[] values = new String[5000000];
        //*
        for(int x=0;x<values.length;x++){
            //System.out.println(x);
            values[x]=""+(char)((int)(Math.random()*26)+97);
            for(int y=1;y<20;y++){
                values[x]+=(char)((int)(Math.random()*26)+97);
            }
        }//*/
        //System.out.println(((char)97));
        //*
        long startTime = System.currentTimeMillis();
        String[] sorted=CannonWords.sort(values);
        long stopTime = System.currentTimeMillis();
        boolean isSorted=values.length==sorted.length;
        for(int x=0;x<values.length-1;x++){
            //System.out.println(x);
            isSorted=isSorted&&(sorted[x+1].compareTo(sorted[x])>0);
        }

        if(isSorted) {
            for(String value:sorted){
                //System.out.println(value);
            }
            System.out.println("Time: "+(stopTime - startTime));    //Time stopped immediately after sort
        }else{
            System.out.println("failed");
        }

        //*/
    }
}