package owenc.springboot.apigate.dao;

/**
 * 分页工具类
 */
public class Page {
    /**
     * 当前页数  默认从0开始
     */
    private int currentPage;
    /**
     * 分页数量
     */
    private int pageSize;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
