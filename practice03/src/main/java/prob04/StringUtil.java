package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		// TODO Auto-generated method stub
		String temp="";
		for(int i=0;i<strArr.length;i++) {
			temp+=strArr[i];
		}
		return temp;
	}
}
