import java.util.Scanner;

public class Solution {
	static String operStr ="+-*/";
	static boolean check(String node, String oper, String left){
		if(!operStr.contains(oper)) return false;
		try{
			int nodeNum = Integer.parseInt(node);
			int leftNum = Integer.parseInt(left);
			if((nodeNum * 2) != leftNum) return false;
		}
		catch(Exception e){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int flag = 0, ret = 1;
			int n = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < n; i++){
				String str = sc.nextLine();
				String[] parts = str.split(" ");
				if(parts.length == 2){
					String c = parts[parts.length - 1];
					try{
						Integer.parseInt(c);
					}catch(Exception e){
						ret = 0;
					}
				}
				else{
					String node= parts[0];
    				String oper = parts[1];
    				String left = parts[2];
    				if(!check(node, oper, left)){
    					ret = 0;
    				}
				}
			}
			System.out.println("#" + tc + " " + ret);
		}
	}
}