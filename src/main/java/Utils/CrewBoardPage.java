package Utils;

public class CrewBoardPage {
	
	public static String pagingStr(int totalCount, int pageSize,int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		
		int totalPages = (int)(Math.ceil(((double)totalCount / pageSize)));
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
		
		if(pageTemp != 1) {
			pagingStr += String.format("", reqUrl);
			pagingStr += String.format("", reqUrl,pageTemp-1);
		}
		int blockCount = 1;
		while(blockCount <= blockPage && pageTemp <= totalPages) {
			if(pageNum == pageTemp) {
				pagingStr += String.format("", pageTemp);
			}else {
				pagingStr += String.format("", reqUrl,pageTemp, pageTemp);
			}
			pageTemp++;
			blockCount++;
		}
		if(pageTemp <= totalPages) {
			pagingStr += String.format("", reqUrl, pageTemp);
			pagingStr += String.format("", reqUrl, totalPages);
		}
		return pagingStr;
		
	}
}
