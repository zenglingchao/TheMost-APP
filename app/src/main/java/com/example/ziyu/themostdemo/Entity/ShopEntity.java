package com.example.ziyu.themostdemo.Entity;

import java.util.List;

/**
 * Created by Ziyu on 2016/11/9.
 */

public class ShopEntity {

    /**
     * shop_image : http://dstatic.zuimeia.com/brand/shop/2016/10/27/07106275-37e8-49e2-b6b9-0ad895751e55.jpg
     * shops : [{"city":"柏林","address":"Alpha Cruxis Inh. Rebecca Martin Karl-Marx-Strasse 18 12043, Berlin","id":194,"name":"Alpha Cruxis"}]
     * online_shop_image : http://dstatic.zuimeia.com/brand/shop/2016/10/27/45608dde-1448-4965-9dc9-7c96dfa35e54.jpg
     * online_shops : [{"link_url":"http://alpha-cruxis.com/","id":159,"name":"Alpha Cruxis 网上商店"}]
     */

    private DataBean data;
    /**
     * data : {"shop_image":"http://dstatic.zuimeia.com/brand/shop/2016/10/27/07106275-37e8-49e2-b6b9-0ad895751e55.jpg","shops":[{"city":"柏林","address":"Alpha Cruxis Inh. Rebecca Martin Karl-Marx-Strasse 18 12043, Berlin","id":194,"name":"Alpha Cruxis"}],"online_shop_image":"http://dstatic.zuimeia.com/brand/shop/2016/10/27/45608dde-1448-4965-9dc9-7c96dfa35e54.jpg","online_shops":[{"link_url":"http://alpha-cruxis.com/","id":159,"name":"Alpha Cruxis 网上商店"}]}
     * result : 1
     */

    private int result;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataBean {
        private String shop_image;
        private String online_shop_image;
        /**
         * city : 柏林
         * address : Alpha Cruxis Inh. Rebecca Martin Karl-Marx-Strasse 18 12043, Berlin
         * id : 194
         * name : Alpha Cruxis
         */

        private List<ShopsBean> shops;
        /**
         * link_url : http://alpha-cruxis.com/
         * id : 159
         * name : Alpha Cruxis 网上商店
         */

        private List<OnlineShopsBean> online_shops;

        public String getShop_image() {
            return shop_image;
        }

        public void setShop_image(String shop_image) {
            this.shop_image = shop_image;
        }

        public String getOnline_shop_image() {
            return online_shop_image;
        }

        public void setOnline_shop_image(String online_shop_image) {
            this.online_shop_image = online_shop_image;
        }

        public List<ShopsBean> getShops() {
            return shops;
        }

        public void setShops(List<ShopsBean> shops) {
            this.shops = shops;
        }

        public List<OnlineShopsBean> getOnline_shops() {
            return online_shops;
        }

        public void setOnline_shops(List<OnlineShopsBean> online_shops) {
            this.online_shops = online_shops;
        }

        public static class ShopsBean {
            private String city;
            private String address;
            private int id;
            private String name;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class OnlineShopsBean {
            private String link_url;
            private int id;
            private String name;

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
