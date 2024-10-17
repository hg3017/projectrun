package Utils;

public class AnnouncementPage {

	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		//전체 데이터 수를 pageSize로 나누어 총 몇 페이지가 필요한지 계산
		int totalPages = (int)(Math.ceil(((double)totalCount / pageSize))); 
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1; // 1, 11, 21, ...
		
		if(pageTemp != 1) {
			pagingStr += String.format("<a href=\"%s?pageNum=1\" class=\"first_paging\"></a>", reqUrl);
			pagingStr += String.format("<a href=\"%s?pageNum=%s\" class=\"prev_paging\"></a>&nbsp;&nbsp;", reqUrl, pageTemp-1);

		}
		int blockCount = 1;
		while(blockCount <= blockPage && pageTemp <= totalPages){
			if(pageNum == pageTemp ) {
				pagingStr += String.format("<span class=\"num active\">%s</span>&nbsp;&nbsp;", pageTemp);
			}else {
				pagingStr += String.format("<a class=\"num\" href=\"%s?pageNum=%s\">%s</a>", reqUrl,pageTemp,pageTemp);
			}
			pageTemp++;
			blockCount++;
		}
		if(pageTemp <= totalPages) {
			pagingStr += String.format("<a href=\"%s?pageNum=%s\" class=\"next_paging\"></a>", reqUrl, pageTemp);
			pagingStr += String.format("<a href=\"%s?pageNum=%s\" class=\"last_paging\"></a>", reqUrl, totalPages); 
		} 
	return pagingStr;
	}
}
