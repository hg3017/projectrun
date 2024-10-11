package Utils;

public class AnnouncementPage {

	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		System.out.println("AnnouncementPage-pagingStr-CheckPoint");
		
		int totalPages = (int)(Math.ceil(((double)totalCount / pageSize)));
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1; // 1, 11, 21, ...
		
		if(pageTemp != 1) {
			pagingStr += String.format("<a href=\"%s?pageNum=1\">[First]</a>", reqUrl);
			pagingStr += String.format("<a href=\"%s?pageNum=%s\">[Prev]</a>", reqUrl, pageTemp-1);

		}
		System.out.println("AnnouncementPage-pagingStr-CheckPoint1");
		int blockCount = 1;
		while(blockCount <= blockPage && pageTemp <= totalPages){
			if(pageNum == pageTemp ) {
				pagingStr += String.format("[%s]", pageTemp);
			}else {
				pagingStr += String.format("<a href=\"%s?pageNum=%s\">[%s]</a>", reqUrl,pageTemp,pageTemp);
			}
			pageTemp++;
			blockCount++;
		}
		System.out.println("AnnouncementPage-pagingStr-CheckPoint2");
		if(pageTemp <= totalPages) {
			pagingStr += String.format("<a href=\"%s?pageNum=%s\">[Next]</a>", reqUrl, pageTemp);
//			pagingStr += String.format("<a href=\"%s?pageNum=%s\">[End]</a>", reqUrl, totalPages); 
		} 
	return pagingStr;
	}
}
