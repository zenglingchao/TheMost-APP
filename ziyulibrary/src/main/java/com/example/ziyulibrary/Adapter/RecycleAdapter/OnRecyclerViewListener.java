package com.example.ziyulibrary.Adapter.RecycleAdapter;

/**为RecycleView添加点击事件
 * @project OnRecyclerViewListener
 * @date 2016-03-03-16:39
 */
public interface OnRecyclerViewListener {
    void onItemClick(int position);
    boolean onItemLongClick(int position);
}
