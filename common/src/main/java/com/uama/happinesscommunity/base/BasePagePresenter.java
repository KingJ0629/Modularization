package com.uama.happinesscommunity.base;

/**
 * Created by Jin on 2017/6/7.
 * Description Presenter的基类
 */
public abstract class BasePagePresenter<T> extends BasePresenter<T> {
	
	// 分页每页数量
	public final static int PAGE_SIZE = 20;
	// 页码
	protected int curPage = 1;
	
	/**
	 * 完成加载下一页后调用更新页码等数据事务
	 */
	protected void nextPageTransaction() {
		curPage++;
	}
	
	/**
	 * 刷新或者加载第一页后调用更新页码等数据事务
	 */
	protected void refreshPageTransaction() {
		curPage = 1;
	}
	
	protected int getCurPage() {
		return curPage;
	}
}
