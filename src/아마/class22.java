package �Ƹ�;

import java.util.Scanner;

public class class22 {
public static void main(String[] args) {

	System.out.println("Input:");
	Scanner sc = new Scanner(System.in);
	String inputVal = sc.nextLine();
	
	System.out.println(inputVal);
	
	String [] spVal =inputVal.split("[\\+\\-\\*\\/\\=]");
	
	System.out.println(spVal.length);
	
	
	for (int cnt=0; cnt<spVal.length; cnt++){
		System.out.println(spVal[cnt]);
	}
	
	int [] num= {9,9,9,9,9};
	for (int cnt=0; cnt<spVal.length; cnt++){
	    try{    	
		num[cnt] = Integer.parseInt(spVal[cnt]);
		System.out.println(num[cnt]);
	    }catch(java.lang.NumberFormatException e){
	    	  System.out.println("�Է¹����ʰ�:-2147483647");
	    }
	}
System.out.println(num[0]);
   
   String [] signArray = {"+","-","*","/"};
   char sign = '+';
   for(int cnt=0; cnt<signArray.length; cnt++){
        int signorder = inputVal.indexOf(signArray[cnt]);
        if(signorder < 0){
           continue;
        }
        System.out.println(signorder);
        sign = inputVal.charAt(signorder);
        System.out.println(sign);
    }
	
if(num[2]== 0 && sign == '/') {
	System.out.println("0���� ������� �Ұ����մϴ�.�ٽ� �Է����ּ���.");
	return;
}
   
  
   switch(sign){
   case '+': 
	   long result=(long)num[0]+(long)num[1];
	   System.out.println(result);
	   break;
   case '-':
	   long result2=(long)num[0]-(long)num[1];
	   System.out.println(result2);
	   break;
   case '/':
	   double result3=(double)num[0]/(double)num[1];
	   System.out.println(result3);
	   break;
   case '*':
	   long result4=(long)num[0]*(long)num[1];
	   System.out.println(result4);
	   break;
   default:
	   break;
   
   }
   System.out.println(sign);
}

}

 
 
/*   switch(c){
	 case '+':
	   System.out.println((a+b));
	  break;
	 case '-':
	   System.out.println( (a-b));
	   break;
	 case '*':
	   System.out.println((a*b));
	   break;
	 case '/':
	   System.out.println((a/b));
	   break;	  
*/
 
/*
if(c=='+'){
	  System.out.println(a+b);
	  
}
if(c=='-'){
	  System.out.println(a-b);
	  
}
if(c=='*'){
	  System.out.println(a*b);
	  
}
if(c=='/'){
	  System.out.println(a/b);
*/



/*
package com.silentpeople.ex1_2;

import java.util.Scanner;

public class calculatorMain {
   
   public static String inputValcheck(String inputVal) {
      inputVal = inputVal.replace(" ", "");// ���߿� ȸ�����Զ� �����ٶ� ����!!!!!!!!
          return inputVal;//return�� �׳� �޼ҵ忡 ������ִٰ� �����ϸ� �����ϴ� ���� �� int a b�� �����ϰ� 10+20���ϸ� �޼ҵ� ������ 1020 �̷������� ���ڷ� �����̵ȴ�
      }//inputVal�� String�� ���ǵǾ� �����ϱ� ��ȯ���� void�� �ƴ� String ���� �޾��ش�
   
   public static boolean startWithNotNumeric(String inputVal) {
      boolean a1 = inputVal.startsWith("-");
      return a1;
      }//2

   public static  String [] splitWithSign(String inputVal) {
      String [] a1= inputVal.split("[\\+\\-\\*\\/\\=]");
      return a1;
   }//3
   
   public static int [] StringArrToInterArr(String [] splitValue) {
      int [] num = new int[10];
      int i;
      for (i = 0; i < splitValue.length; i++) {
         try {
            num[i] = Integer.parseInt(splitValue[i]);// int������ 20���� �Ѿ������� �ȵǴϱ� try�� ����ó���� ���ְ�Ѿ������ �ȵȴٰ���� ��������׾˷��ش�
         } catch (java.lang.NumberFormatException e) {// ���� ����� ���������� �������� ������ ������������ ������ catch�� ��ºκ��� ��������� �˷��ش�
            System.out.println("�Է¹����ʰ�");// int ������ŭ
         }
      }//4
      return num;
      
   }

   
   public static char PopSign(String inputVal){
   
   int i;
   String[] signArray = { "+", "-", "*", "/" };
   char sign = '+';// ��������(���ú���)�� �ʱ�ȭ�� ���Ѿߵȴ� ���� �ƹ��ų� ���ؼ� �־���ߵȴ�.!!!!!!!
   for (i = 0; i < signArray.length; i++) {
      int indexValue = inputVal.indexOf(signArray[i]);// indexOf �� ����ȭǥ���Ŀ��� ���������ʴ´�.
      if (indexValue < 0) {
         continue;// ������ ���� for ���� ���� �ö󰡶� break�� �ϸ� ���߰ų� ������ �������µ�continue �� ���ָ� ���οö󰣴�
      }
      //System.out.println(indexValue);
      sign = inputVal.charAt(indexValue);
      //System.out.println(sign);
   }
   return sign;
   }//5

   
   public static boolean blockDivideByZero(int num, char sign){
      if (num == 0 && sign == '/') {
         System.out.println("0���� ������� �Ұ����մϴ�.");
         return true;//0���� ������ ��Ȳ: true, �ƴϸ� : false
      }
      else{
         return false;
      }
      
   }//6
   

   
   
   
         
   public static void main(String[] args) {
      String inputVal;
      boolean yesno = true;
      do {
         
         System.out.println("Input:");
         Scanner scan = new Scanner(System.in);
         inputVal = scan.nextLine();
      
         inputVal=inputValcheck(inputVal);// �������� �޼ҵ带 ���� 1
          if(startWithNotNumeric(inputVal)){
             System.out.println("������ �Էµ��� �ʽ��ϴ�.");//-��ȣ�� �����ϸ� true�� ��ȯ�ϴ� �޼ҵ�2
             continue;
          }
          String [] splitValue=splitWithSign(inputVal);//�߶� ��Ƶδ� �޼ҵ��� split�� �ϴ¹��3
         
         System.out.println(inputVal);
         
         int i;
         int[] num = new int[splitValue.length];// ���ڿ��� ���ڷ� �ٲٴ� 
         num = StringArrToInterArr(splitValue);//4

          char sign = PopSign(inputVal);//�����ȣ�� �����ϴ� �ڵ�5
          
          //0���� �����⸦ �����ϱ� �����ڵ� ���
          if(blockDivideByZero(num[1], sign)) continue;//6
         long result = 0;
         double result2 = 0.0;
         switch (sign) {
         case '+':
            result = (long) num[0] + (long) num[1];
            System.out.println(result);// num[i]=Integer.parseInt(splitValue[i]); num�� ���� �־����
            break;
         case '-':
            result = (long) num[0] - (long) num[1];
            System.out.println(result);
            break;
         case '*':
            result = (long) num[0] * (long) num[1];
            System.out.println(result);
            break;
         case '/':
            result2 = (double) num[0] / (double) num[1];
            System.out.println(result2);
            break;
         default:
            break;
         }
         System.out.println("yes(y) or no(n)");
         inputVal = scan.nextLine();
         
           if(inputVal.equals("y") || inputVal.equals("Y")){ 
           continue;
           
           } 
           else if(inputVal.equals("n") || inputVal.equals("N")){
           
          }
          

         switch (inputVal) {// ������ ���ڿ� ������ �ȉ�µ� ������ ���ڿ��� �����̵ȴ�
         case "y":case "Y":
            yesno = true;
            continue;
         // break;
         case "n":case "N":
            yesno = false;
            break;
         default:
            break;
         }
      } while (yesno);
      System.out.println("����Ǿ����ϴ�.");

   }
   
      
   }*/