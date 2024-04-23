package prob5;

public class Prob5 {

	public static void main(String[] args) {
		String s;
		for (int i=1;i<=99 ;i++ ) {
            String str1 = Integer.toString(i);
            s="";
            for(int j=0;j<str1.length();j++){
                if (str1.charAt(j) == '3' || str1.charAt(j) == '6' || str1.charAt(j) == '9'){
                    s+="짝";
                }
            }

            if(s!=""){
                System.out.print(i);
                System.out.print(" ");
                System.out.println(s);
            }

        }
	}
}
