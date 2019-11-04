package i.algorithm;

public class RL {
	public static int out(String []a)
	{   int i=0;
	    int l=a.length;
	    while(i<a.length-1)
	    {
	    if("R"==a[i]&&"L"==a[i+1])
	     {
	    	if(i>1&&a[i-1]=="R")
	    	{l--;}
	            a[i+1]="R";//只有RL才能使一个人出局
	             l--; 
	        
	             
	     }
	   
	    i++;
	   
	    }
	    return l;
	    
	     }
public static void main(String []args) {
	String []a= {"R","R","R","L","L","L","R","R"};
	System.out.println(out(a));
}
}
