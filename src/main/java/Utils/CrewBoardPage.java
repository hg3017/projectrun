package Utils;

public class CrewBoardPage {
	
	public static String pagingStr(int totalCount, int pageSize,int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		
		int totalPage = (int)(Math.ceil(((double)totalCount / pageSize)));
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
		
		if(pageTemp != 1) {
			pagingStr += String.format("<a hraf=\"%s?pageNum=1\">[First]</a>", reqUrl);
			pagingStr += String.format("<a hraf=\"%s?pageNum=%s\">[Prev]</a>", reqUrl,pageTemp-1);
		}
		int blockCount = 1;
		while(blockCount <= blockPage && pageTemp <= totalPage) {
			if(pageNum == pageTemp) {
				pagingStr += String.format("[%s]", pageTemp);
			}else {
				pagingStr += String.format("<a href=\"%s?pageNum=%s\">[%s]</a>", reqUrl,pageTemp, pageTemp);
			}
			pageTemp++;
			blockCount++;
		}
		if(pageTemp <= totalPage) {
			pagingStr += String.format("<a hraf=\"%s?pageNum=%s\">[Next]</a>", reqUrl, pageTemp+1);
			pagingStr += String.format("<a hraf=\"%s?pageNum=%s\">[End]</a>", reqUrl, totalPage);
		}
		return pagingStr;
		
	}
}
