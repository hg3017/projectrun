package Utils;

public class CustomerboardPage {
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl,String searchField, String searchWord) {
		String pagingStr = "";
		
		int totalPages = (int)(Math.ceil(((double)totalCount / pageSize)));
		
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) +1;
		
		if(pageTemp != 1) {
			pagingStr += String.format("<a href=\"%s?pageNum=1&searchField=%s&searchWord=%s\" class=\"first_paging\"></a>", reqUrl, searchField, searchWord);
			pagingStr += String.format("<a href=\"%s?pageNum=%s&searchField=%s&searchWord=%s\" class=\"prev_paging\"></a>&nbsp;&nbsp;", reqUrl, pageTemp-1, searchField, searchWord);

		}
		int blockCount = 1;
		
		while(blockCount <= blockPage && pageTemp <= totalPages){
			if(pageNum == pageTemp ) {
				pagingStr += String.format("<span class=\"num active\">%s</span>&nbsp;&nbsp;", pageTemp);
			}else {
				pagingStr += String.format("<a class=\"num\" href=\"%s?pageNum=%s&searchField=%s&searchWord=%s\">%s</a>", reqUrl,pageTemp,pageTemp, searchField, searchWord, pageTemp);
			}
			pageTemp++;
			blockCount++;
		}
		if(pageTemp <= totalPages) {
			pagingStr += String.format("<a href=\"%s?pageNum=%s&searchField=%s&searchWord=%s\" class=\"next_paging\"></a>", reqUrl, pageTemp, searchField, searchWord);
			pagingStr += String.format("<a href=\"%s?pageNum=%s&searchField=%s&searchWord=%s\" class=\"last_paging\"></a>", reqUrl, totalPages, searchField, searchWord); 
		} 
	return pagingStr;
	}
}
