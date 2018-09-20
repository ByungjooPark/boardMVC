package kr.itedu.boardmvc.common;

public class Utils {
	//정수 파라미터 값 가져오기(이상있으면 -1)
	public static int getParamInt(String p) {
		int r = -1;
		if(p !=null && !p.equals("")) {
			try {
				r = Integer.parseInt(p);
			} catch (Exception e) {
				
			}
		}
		return r;
	}
	
	public static int getOneParamInt(String p) {
		int r = 1;
		if(p !=null && !p.equals("")) {
			try {
				r = Integer.parseInt(p);
			} catch (Exception e) {
				
			}
		}
		return r;
	}
}
