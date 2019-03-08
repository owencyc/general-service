package owenc.springboot.apigate.dao;
import java.io.Serializable;
import java.util.List;

/**
 * 持久化接口实现类
 * @author
 */
public class PageList<T> implements Serializable{

	private static final long serialVersionUID = -4474534635082387980L;

	public PageList() {
	}

	/**
	 * 返回记录列表
	 */
	private List<T> data;

	/**
	 * 返回分页相关信息
	 */
	private long totalCount;
	private int currentPage;
	private int pageSize;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

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
