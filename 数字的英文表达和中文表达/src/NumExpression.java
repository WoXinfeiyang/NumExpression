import java.util.Scanner;


public class NumExpression {
	
	/**1~9的中文表达
	 * @param num--数字1~9
	 * @return 数字1~9的中文表达字符串
	 * */
	public static String numChiExp1to9(int num){
		if(num<1||num>9){
			return "";
		}
		String[]names={"一","二","三","四","五","六","七","八","九"};
		return names[num-1];
	}
	/**1~99的中文表达
	 * @param num--数字1~99
	 * @return 数字1~99的中文表达字符串
	 * */
	public static String numChiExp1to99(int num){
		if(num<1||num>99){
			return "";
		}
		if(num<10){
			return numChiExp1to9(num);
		}
		int shi=num/10;
		return numChiExp1to9(shi)+"十"+numChiExp1to9(num%10);
	}
	
	/**1~999的中文表达
	 * @param num--数字1~999
	 * @return 数字1~999的中文表达字符串
	 * */
	public static String numChiExp1to999(int num){
		if(num<1||num>999){
			return "";
		}
		if(num<100){
			return numChiExp1to99(num);
		}
		String resultStr=numChiExp1to9(num/100)+"百";
		int restNum=num%100;
		if(restNum==0){
			return resultStr;
		}
		if(restNum>10){
			resultStr+=numChiExp1to99(restNum);
		}else{
			resultStr+="零"+numChiExp1to9(restNum);
		}
		return resultStr;
	}
	
	/**1~9999的中文表达
	 * @param num--数字1~9999
	 * @return 数字1~9999的中文表达字符串
	 * */
	public static String numChiExp1to9999(int num){
		if(num<1||num>9999){
			return "";
		}
		if(num<1000){
			return numChiExp1to999(num);
		}
		String resultStr=numChiExp1to9(num/1000)+"千";
		int restNum=num%1000;
		if(restNum==0){
			return resultStr;
		}
		if(restNum>100){
			resultStr+=numChiExp1to999(restNum);
		}else{
			resultStr+="零"+numChiExp1to99(restNum);
		}
		return resultStr;
	}
	

	/**1~9999的中文表达
	 * @param num--数字1~9999
	 * @return 数字1~9999的中文表达字符串
	 * */
	public static String numChiExp1to99999999(int num){
		if(num<1||num>99999999){
			return "";
		}
		int wan=num/10000;
		int restNum=num%10000;
		if(wan==0){
			return numChiExp1to9999(restNum);
		}
		String resultStr=numChiExp1to9999(wan)+"万";
		if(restNum==0){
			return resultStr;
		}
		if(restNum>1000){
			resultStr+=numChiExp1to9999(restNum);
		}else{
			resultStr+="零"+numChiExp1to999(restNum);
		}
		return resultStr;
	}

	
	/**数字的中文表达完整方法,
	 * @param num--数字
	 * @return 数字的中文表达字符串
	 * */
	public static String numChiExp(int num){
		if(num==0){
			return "零";
		}
		String resultStr=num<0?"负":"";
		int yi=Math.abs(num/100000000);
		int restNum=Math.abs(num%100000000);
		if(yi==0){
			return resultStr+numChiExp1to99999999(restNum);
		}
		resultStr+=numChiExp1to9999(yi)+"亿";
		if(restNum==0){
			return resultStr;
		}else{
			if(restNum>10000000){
				resultStr+=numChiExp1to99999999(restNum);
			}else{
				resultStr+="零"+numChiExp1to99999999(restNum);
			}
			return resultStr;
		}
	}
	
	/**1~9的英文表达
	 * @param num--数字1~9
	 * @return 数字1~9的英文表达字符串
	 * */
	public static String numEngExp1to19(int num){
		if(num<1||num>19){
			return "";
		}
		String[] names={"One ","Two ","Three ","Four ","Five ","Six ","Seven ",
				"Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ",
				"Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
		return names[num-1];
	}
	
	/**1~99的英文表达
	 * @param num--数字1~99
	 * @return 数字1~99的英文表达字符串
	 * */
	public static String numEngExp1to99(int num){
		if(num<1||num>99){
			return "";
		}
		if(num<20){
			return numEngExp1to19(num);
		}
		int shi=num/10;
		String[] tyNames={"Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
		return tyNames[shi-2]+numEngExp1to19(num%10);
	}	
	
	
	/**1~999的英文表达
	 * @param num--数字1~999
	 * @return 数字1~999的英文表达字符串
	 * */
	public static String numEngExp1to999(int num){
		if(num<1||num>999){
			return "";
		}
		if(num<100){
			return numEngExp1to99(num);
		}
		int bai=num/100;
		
		return numEngExp1to19(bai)+"Hundred "+numEngExp1to99(num%100);
	}
	
	/**数字的英文表达完整方法
	 * @param num--数字
	 * @return 数字的英文表达字符串
	 * */
	public static String numEngExp(int num){
		if(num==0){
			return "Zero";
		}
		String resultStr="";
		if(num<0){
			resultStr+="Negitive, ";
		}
		if(num==Integer.MIN_VALUE){
			resultStr+="Two Billion, ";
			num%=-2000000000;
		}
		num=Math.abs(num);
		int high=1000000000;
		int highIndex=0;
		String[] names={"Billion","Million","Thousand",""};
		while(num!=0){
			int cur=num/high;
			num%=high;
			if(cur!=0){
				resultStr+=numEngExp1to999(cur);
				resultStr+=names[highIndex]+(num==0?" ":",");
			}
			high/=1000;
			highIndex++;
		}
		return resultStr;
	}	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int num=in.nextInt();
			System.out.println(numEngExp(num));
			System.out.println(numChiExp(num));
		}
	}

}
