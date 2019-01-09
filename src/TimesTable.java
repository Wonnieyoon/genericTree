import java.util.ArrayList;
import java.util.Vector;

public class TimesTable {

   private int nWithd;
   private int nHeight;
   private boolean bMintoMax;    
   private ArrayList<ArrayList<String>> al;
   
   public ArrayList<ArrayList<String>> getAl() {
      return al;
   }

   public void setAl(ArrayList<ArrayList<String>> al) {
      this.al = al;
   }

   public TimesTable()
   {
      this.nWithd = 3;
      this.nHeight = 3;
      this.bMintoMax = true;
      al = new ArrayList<>();      
   }
   
   public int getnWithd() {
      return nWithd;
   }

   public void setnWithd(int nWithd) {
      this.nWithd = nWithd;
   }
   
   public int getnHeight() {
      return nHeight;
   }

   public void setnHeight(int nHeight) {
      this.nHeight = nHeight;
   }
   
   public boolean isbMintoMax() {
      return bMintoMax;
   }

   public void setbMintoMax(boolean bMintoMax) {
      this.bMintoMax = bMintoMax;
   }
   
   //n X m 설정
   public void setNtoM(int n,int m)
   {
      this.nWithd = n;
      this.nHeight = m;      
   }
   
   public String getNtoM()
   {      
      return "N X M : "+ nWithd + " X " + nHeight + " 입니다."; 
   }   
   
   public String printNthAndMthTable(int n, int m) 
   {   
      int nWidth = getnWithd();
      int nHeight = getnHeight();
      DataFormatting(n,nWidth);
      DataFormatting(m,nWidth);
      
      String dataView;
      dataView = DataView(nHeight,nWidth);
      return dataView;
   }   
   
   //Data 배열 저장
   private void DataFormatting(int number,int nWidth)
   {      
      String printData="";
      ArrayList<String> s = new ArrayList<String>(10);
      
      int temp;
      for(int i=1;i<=9;i++)
      {
         temp = i*number;
         printData = String.format("\t%d X %d = %2d\t|",number,i,temp);
         s.add(printData.toString());
      }
      
         getAl().add(s);      
   }
   
   //Data String 합치기
   private String DataView(int nHeight,int nWidth)
   {
      String dataView="";
      int start=1;
      int last = nWidth;
      boolean check = true;
            
      while(check)
      {
         for(int i=0;i<2;i++)
         {
            for(int j=start;j<=last;j++)
            {
               if(j>9)
               {                 
                  check = false;
                  String str;
                  int nSize;
                  nSize = getAl().get(i).get(1).toString().length();
                  str = String.format("%"+(nSize+10)+"s", " ");
                  dataView += str;                 
               }
               else
               {
            	   if(isbMintoMax())
            		   dataView += getAl().get(i).get(j-1).toString();
            	   else
            		   dataView += getAl().get(i).get(9-j).toString();
               }
            }
            if(i==0)
            {
            	if(!check)
            		dataView += "|||";
            	else
            		dataView += "||";
            }
            
         }
         dataView +="\n";
         int temp;
         temp = last-start;
         start = last+1;       
         last = start+ temp;
         
         if(getnWithd()==3 && start==10)
        	 break;
      }
            
      return dataView;
   }
   

}