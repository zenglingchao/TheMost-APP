package com.example.ziyu.themostdemo;

/**
 * Created by Ziyu on 2016/10/24.
 */

public interface Constants {

    //画报
    String MAGAZINE_URL = "http://design.zuimeia.com/api/v1/articles/daily/simple/?page=%d&is_new_user=false&page_size=30&user_id=0&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //画报详情（88--id）
    String MAGAZINE_DETAIL = "http://design.zuimeia.com/api/v1/article/%d/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //有物--头部数据分类
    String DISCOVER_HEAD = "http://design.zuimeia.com/api/v1/product/categories/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //有物--Daily
    String DISCOVER_DAILY = "http://design.zuimeia.com/api/v1/products/daily/?timestamp=1476892800000&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    String DAILY = "Daily";
    String MYDESIGNERS = "设计师动态";
    String ILIKE = "我喜欢的";
    //有物内容(依据ID)
    String DISCOVER_CONTENT= "http://design.zuimeia.com/api/v1/products/category/%d/?page=%d&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //有物详情(1402 -- id)(article==代表画报)(product 代表有物）
    String PRODUCT_INFO = "http://design.zuimeia.com/api/v1/product/%d/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";
    //设计师--推荐  recommend
    String DESIGNER_RECOMEND= "http://design.zuimeia.com/api/v1/designers/recommend/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    //设计师--最受欢迎 mostfavor
    String DESIGNER_MOSTFAVOR ="http://design.zuimeia.com/api/v1/designers/mostfavor/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    //设计师--大牌设计师
    String DESIGNER_FAMOUS ="http://design.zuimeia.com/api/v1/designers/category/31/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    //设计师--独立设计师Independent
    String DESIGNER_INDEPENDENT ="http://design.zuimeia.com/api/v1/designers/category/30/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    //设计师详情 130--id
    String DESIGNER = "http://design.zuimeia.com/api/v1/designer/%d/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    //设计师作品
   String DESIGNER_PRODUCT ="http://design.zuimeia.com/api/v1/products/designer/%d/?page=1&page_size=30&user_id=0&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    //设计师店铺
    String DESIGNER_SHOP="http://design.zuimeia.com/api/v1/shops/designer/%d/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld";

    /*

//画报更多评论
    http://design.zuimeia.com/api/v1/comments/article/86/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//有物--首饰
    http://design.zuimeia.com/api/v1/products/category/3/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//有物--包袋(category 对应分类里的id)
    http://design.zuimeia.com/api/v1/products/category/1/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//有物详情(1402 -- id)(article==代表画报)(product 代表有物）
    http://design.zuimeia.com/api/v1/product/1402/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//大牌设计师 .独立设计师 的标签
    http://design.zuimeia.com/api/v1/designer/categories/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//设计师标签下的子类别(1--首饰，2--配饰，.... ，30--独立设计师，31--大牌设计师
    http://design.zuimeia.com/api/v1/designers/category/1/?page=1&page_size=30&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

    //设计师详情 130--id
    http://design.zuimeiakkkkkkkkkkkkkkkkkkkk.com/api/v1/designer/130/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//设计师作品
    http://design.zuimeia.com/api/v1/products/designer/130/?page=1&page_size=30&user_id=0&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//设计师店铺
    http://design.zuimeia.com/api/v1/shops/designer/130/?device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld

//设计师画报
    http://design.zuimeia.com/api/v1/articles/designer/57/?page=1&page_size=30&user_id=0&device_id=864394010080028&platform=android&lang=zh&appVersion=1.2.2&appVersionCode=10220&systemVersion=19&countryCode=CN&user_id=0&token=&package_name=com.zuiapps.zuiworld
*/
}
