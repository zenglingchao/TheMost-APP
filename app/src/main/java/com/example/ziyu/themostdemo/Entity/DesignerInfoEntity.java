package com.example.ziyu.themostdemo.Entity;

import java.util.List;

/**
 * Created by Ziyu on 2016/10/31.
 */

public class DesignerInfoEntity {

    @Override
    public String toString() {
        return "DesignerInfoEntity{" +
                "data=" + data +
                ", result=" + result +
                '}';
    }

    /**
     * follow_num : 572
     * city : 纽约
     * concept : 我们的设计融合了无铺张无虚饰的北欧美学
     * article_num : 0
     * name : Nathan Gryszowka & Hunter Craighill
     * product_num : 7
     * label : M&U Co. 联合创始人
     * introduce_images : ["http://dstatic.zuimeia.com/common/image/2016/10/8/494e25c4-01de-4bc5-a0b7-ae8291cf197a_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/2e865d7e-04e7-455c-86e8-fae79c545023_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/d8337470-e9f5-47dc-a715-a031c1370f01_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/2d5e42d0-f167-4f33-be2a-588fbe4dd797_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/7c9871e3-bb53-48b1-b335-5a24bd72b78a_1000x1000.jpeg"]
     * avatar_url : http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg
     * is_followed : 0
     * id : 130
     * categories : [{"id":2,"name":"配饰"},{"id":12,"name":"极简"},{"id":13,"name":"实用"},{"id":17,"name":"纽约"},{"id":27,"name":"家居"},{"id":30,"name":"独立设计师"}]
     * description : Nathan Gryszowka 和 Hunter Craighill 在 2007 年开始了设计事业。最开始是从一个简单的钱包开始，直到现在“无缝双折叠”钱包依然是保有最初的样式。Maxx & Unicorn 一直致力于为日常生活设计有艺术感的作品，并且他们始终坚持美国本土制造。
     */

    private DataBean data;
    /**
     * data : {"follow_num":572,"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","article_num":0,"name":"Nathan Gryszowka & Hunter Craighill","product_num":7,"label":"M&U Co. 联合创始人","introduce_images":["http://dstatic.zuimeia.com/common/image/2016/10/8/494e25c4-01de-4bc5-a0b7-ae8291cf197a_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/2e865d7e-04e7-455c-86e8-fae79c545023_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/d8337470-e9f5-47dc-a715-a031c1370f01_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/2d5e42d0-f167-4f33-be2a-588fbe4dd797_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/7c9871e3-bb53-48b1-b335-5a24bd72b78a_1000x1000.jpeg"],"avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","is_followed":0,"id":130,"categories":[{"id":2,"name":"配饰"},{"id":12,"name":"极简"},{"id":13,"name":"实用"},{"id":17,"name":"纽约"},{"id":27,"name":"家居"},{"id":30,"name":"独立设计师"}],"description":"Nathan Gryszowka 和 Hunter Craighill 在 2007 年开始了设计事业。最开始是从一个简单的钱包开始，直到现在\u201c无缝双折叠\u201d钱包依然是保有最初的样式。Maxx & Unicorn 一直致力于为日常生活设计有艺术感的作品，并且他们始终坚持美国本土制造。"}
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "follow_num=" + follow_num +
                    ", city='" + city + '\'' +
                    ", concept='" + concept + '\'' +
                    ", article_num=" + article_num +
                    ", name='" + name + '\'' +
                    ", product_num=" + product_num +
                    ", label='" + label + '\'' +
                    ", avatar_url='" + avatar_url + '\'' +
                    ", is_followed=" + is_followed +
                    ", id=" + id +
                    ", description='" + description + '\'' +
                    ", introduce_images=" + introduce_images +
                    ", categories=" + categories +
                    '}';
        }

        private int follow_num;
        private String city;
        private String concept;
        private int article_num;
        private String name;
        private int product_num;
        private String label;
        private String avatar_url;
        private int is_followed;
        private int id;
        private String description;
        private List<String> introduce_images;
        /**
         * id : 2
         * name : 配饰
         */

        private List<CategoriesBean> categories;

        public int getFollow_num() {
            return follow_num;
        }

        public void setFollow_num(int follow_num) {
            this.follow_num = follow_num;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getConcept() {
            return concept;
        }

        public void setConcept(String concept) {
            this.concept = concept;
        }

        public int getArticle_num() {
            return article_num;
        }

        public void setArticle_num(int article_num) {
            this.article_num = article_num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProduct_num() {
            return product_num;
        }

        public void setProduct_num(int product_num) {
            this.product_num = product_num;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getIs_followed() {
            return is_followed;
        }

        public void setIs_followed(int is_followed) {
            this.is_followed = is_followed;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getIntroduce_images() {
            return introduce_images;
        }

        public void setIntroduce_images(List<String> introduce_images) {
            this.introduce_images = introduce_images;
        }

        public List<CategoriesBean> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBean> categories) {
            this.categories = categories;
        }

        public static class CategoriesBean {
            private int id;
            private String name;

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
