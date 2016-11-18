package 아마;

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
	    	  System.out.println("입력범위초과:-2147483647");
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
	System.out.println("0으로 나누기는 불가능합니다.다시 입력해주세요.");
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
      inputVal = inputVal.replace(" ", "");// 나중에 회원가입때 공백줄때 응용!!!!!!!!
          return inputVal;//return은 그냥 메소드에 저장되있다고 생각하면 간단하다 예를 들어서 int a b를 선언하고 10+20을하면 메소드 저장은 1020 이런식으로 문자로 저장이된다
      }//inputVal은 String로 정의되어 있으니까 반환형도 void가 아닌 String 으로 받아준다
   
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
            num[i] = Integer.parseInt(splitValue[i]);// int범위가 20억이 넘어가면실행이 안되니까 try로 예외처리를 해주고넘어갔을때는 안된다고계산기 사용자한테알려준다
         } catch (java.lang.NumberFormatException e) {// 위에 내용과 마찬가지로 이제저런 오류가 컴파일했을때 나오면 catch의 출력부분을 사용자한테 알려준다
            System.out.println("입력범위초과");// int 범위만큼
         }
      }//4
      return num;
      
   }

   
   public static char PopSign(String inputVal){
   
   int i;
   String[] signArray = { "+", "-", "*", "/" };
   char sign = '+';// 지역변수(로컬변수)는 초기화를 시켜야된다 값을 아무거나 정해서 넣어줘야된다.!!!!!!!
   for (i = 0; i < signArray.length; i++) {
      int indexValue = inputVal.indexOf(signArray[i]);// indexOf 는 정규화표현식에서 지원하지않는다.
      if (indexValue < 0) {
         continue;// 멈추지 말고 for 문에 위로 올라가라 break를 하면 멈추거나 밑으로 내려가는데continue 를 해주면 위로올라간다
      }
      //System.out.println(indexValue);
      sign = inputVal.charAt(indexValue);
      //System.out.println(sign);
   }
   return sign;
   }//5

   
   public static boolean blockDivideByZero(int num, char sign){
      if (num == 0 && sign == '/') {
         System.out.println("0으로 나누기는 불가능합니다.");
         return true;//0으로 나누는 상황: true, 아니면 : false
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
      
         inputVal=inputValcheck(inputVal);// 공백제거 메소드를 생성 1
          if(startWithNotNumeric(inputVal)){
             System.out.println("음수는 입력되지 않습니다.");//-기호로 시작하면 true를 반환하는 메소드2
             continue;
          }
          String [] splitValue=splitWithSign(inputVal);//잘라서 담아두는 메소드인 split을 하는방법3
         
         System.out.println(inputVal);
         
         int i;
         int[] num = new int[splitValue.length];// 문자열을 숫자로 바꾸는 
         num = StringArrToInterArr(splitValue);//4

          char sign = PopSign(inputVal);//연산기호를 추출하는 코드5
          
          //0으로 나누기를 방지하기 위한코드 블록
          if(blockDivideByZero(num[1], sign)) continue;//6
         long result = 0;
         double result2 = 0.0;
         switch (sign) {
         case '+':
            result = (long) num[0] + (long) num[1];
            System.out.println(result);// num[i]=Integer.parseInt(splitValue[i]); num에 값을 넣어줬다
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
          

         switch (inputVal) {// 원래는 문자열 지원이 안됬는데 이제는 문자열이 지원이된다
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
      System.out.println("종료되었습니다.");

   }
   
      
   }*/