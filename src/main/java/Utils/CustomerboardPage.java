package Utils;

public class CustomerboardPage {
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		int totalPages = (int)(Math.ceil(((double)totalCount / pageSize)));
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) +1;
		
		if(pageTemp != 1) {
			pagingStr += String.format("<a href=\"%s?pageNUm=1\" class\"first_paging\"></a>", reqUrl);
			pagingStr += String.format("<a href=\"%s?pageNUm=1\" class\"first_paging\"></a>&nbsp;&nbsp;", reqUrl, pageTemp-1);
		}
		int blockcount = 1;
		while (blockcount <= blockPage && pageTemp <= totalPages) {
			if(pageNum == pageTemp) {
				pagingStr += String.format("<span class=\"num active\">%s</span>&nbsp;&nbsp;", pageTemp);
			} else {
				pagingStr += String.format("<a class=\"num href=\"%s?pageNum=%s</a>", reqUrl,pageTemp,pageTemp);
			}
			pageTemp++;
			blockcount++;	
		}
		if(pageTemp <= totalPages) {
			pagingStr += String.format("<a href=\"%s?pageNum=%s\" class=\"next_paging\"></a>", reqUrl, pageTemp);
			pagingStr += String.format("<a href=\"%s?pageNum=%s\" class=\"last_paging\"></a>", reqUrl, totalPages);
		}
		
		return pagingStr;
	}
}
