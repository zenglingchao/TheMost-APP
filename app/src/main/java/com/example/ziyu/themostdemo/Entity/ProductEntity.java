package com.example.ziyu.themostdemo.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ziyu on 2016/11/9.
 */

public class ProductEntity implements Serializable {


    /**
     * has_next : 0
     * products : [{"unlike_user_num":38,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 黄铜嵌皮男士手镯","cover_images":["http://dstatic.zuimeia.com/common/image/2016/11/6/231074fb-8ff0-4e16-902c-d552a349b6dc_900x900.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/aa342487-9b72-4d99-ae34-8fc7ffb7c454_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/0171e7e2-cc59-48a8-b56c-22cb5cf3b1c7_1000x1000.jpeg"],"price":500,"brief":"M&U CO. | 黄铜嵌皮男士手镯","like_user_num":200,"mark_user_num":31,"images":["http://dstatic.zuimeia.com/common/image/2016/11/6/c0f7f774-ab30-4a45-9e0e-de4b1596f241_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/88f126d6-821a-47f8-acee-bdf32fef8ac5_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/0171e7e2-cc59-48a8-b56c-22cb5cf3b1c7_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/4ada1d97-1d04-4d31-91ee-7726e9cc4b4d_1000x1000.jpeg"],"publish_at":1478448000000,"id":1476},{"unlike_user_num":94,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 牛皮束带花盆套","cover_images":["http://dstatic.zuimeia.com/common/image/2016/11/3/ea471ba8-49aa-472e-af16-1fc63e789db2_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/3/67a80c05-5530-4b16-99cb-46ecfe188735_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/3/873b3828-02ff-436f-ba86-5dc6a675d2cb_800x800.jpeg"],"price":300,"brief":"M&U CO. | 牛皮束带花盆套","like_user_num":274,"mark_user_num":14,"images":["http://dstatic.zuimeia.com/common/image/2016/11/3/7589ce79-b721-42ff-9b0f-50e12dac851f_911x911.jpeg"],"publish_at":1478188800000,"id":1465},{"unlike_user_num":90,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 'D' 形钥匙环","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/31/726f15a2-17b1-46d4-909c-3cd6977bd82b_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/5b86545b-8b42-4ddb-a6d7-37fe3d4fb38b_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/9119d709-5745-4918-89c0-52ba55dcfbcf_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/591376ec-9716-4615-a429-8734e8f2b44b_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/0f9ba150-f875-4b28-9bd9-70bf352f0932_1000x1000.jpeg"],"price":200,"brief":"M&U CO. | 'D' 形钥匙环","like_user_num":278,"mark_user_num":17,"images":["http://dstatic.zuimeia.com/common/image/2016/10/31/0848a730-3a74-482b-8d41-9b52f2e69e36_1000x999.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/02de1546-b927-4ddc-8563-9e8d55a8ca3d_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/335a1454-93e2-4733-925e-b4dcc38c911c_1000x1000.jpeg"],"publish_at":1477929600000,"id":1448},{"unlike_user_num":93,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 实木拼接六角收纳盘","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/26/632cc800-7c5f-44cb-9343-ddef790e57fe_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/26/f8d9e347-ed73-463d-8bdf-a2c0006270c5_1000x1000.jpeg"],"price":630,"brief":"M&U CO. | 实木拼接六角收纳盘","like_user_num":348,"mark_user_num":14,"images":["http://dstatic.zuimeia.com/common/image/2016/10/26/be418cfd-0206-4213-ae99-841d727975f9_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/26/40b6e560-5957-4eda-8125-3bbab07e7abf_1000x1000.jpeg"],"publish_at":1477497600000,"id":1433},{"unlike_user_num":116,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 黑色扭纹男士手镯","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/19/f88373d6-ff54-469d-8dea-2acc92f8e98e_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/19/56c5fa71-c343-4be7-9895-26de5878bab5_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/19/20ff5187-c18f-4d82-a914-3db0e8cb0247_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/19/668073d2-39a3-4eb4-b8b8-224478f576a9_1000x1000.jpeg"],"price":500,"brief":"M&U CO. | 黑色扭纹男士手镯","like_user_num":718,"mark_user_num":155,"images":["http://dstatic.zuimeia.com/common/image/2016/10/19/54381741-1ac8-4396-80a7-e39dd0814bfb_1000x1000.jpeg"],"publish_at":1476892800000,"id":1401},{"unlike_user_num":116,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 红木色牛皮卡包","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/17/ccee45dd-7b14-4eb5-a152-cebe4db08cb3_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/ffe1b350-c52b-4277-9eec-46d4cb41e228_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/5594c2fc-0761-4883-8569-48d356adb415_1080x1080.jpeg"],"price":370,"brief":"M&U CO. | 红木色牛皮卡包","like_user_num":294,"mark_user_num":15,"images":["http://dstatic.zuimeia.com/common/image/2016/10/17/d6ef74d4-81ae-4330-a65e-190992ec0fa6_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/5b76cef2-36f6-4e32-bbe4-31d9faa99711_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/ffe1b350-c52b-4277-9eec-46d4cb41e228_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/5ba1824c-ada7-41b9-9de8-7ca1833b73ee_1000x1000.jpeg"],"publish_at":1476720000000,"id":1392},{"unlike_user_num":112,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 实木拼接方形收纳盘","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/13/688e6173-8696-40fa-86f0-897b643180de_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/13/d1150a93-2f47-4afd-bb39-1948f975537f_1000x1000.jpeg"],"price":580,"brief":"M&U CO. | 实木拼接方形收纳盘","like_user_num":446,"mark_user_num":21,"images":["http://dstatic.zuimeia.com/common/image/2016/10/13/5588fd89-a9dd-4e71-9ae0-b7a1333b1a07_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/13/d1150a93-2f47-4afd-bb39-1948f975537f_1000x1000.jpeg"],"publish_at":1476374400000,"id":1382},{"unlike_user_num":90,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 水平地貌线笔记本","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/10/2f8788e1-92f0-49a1-abe5-3917350566cb_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/f5b1177c-a009-4ba0-a0e4-9527d6cd3b75_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/32c0d932-50f1-4682-8c4f-d08a33876508_1000x1000.jpeg"],"price":67,"brief":"M&U CO. | 水平地貌线笔记本","like_user_num":570,"mark_user_num":97,"images":["http://dstatic.zuimeia.com/common/image/2016/10/10/abb44a68-7574-4af0-9641-7cc16fadb69a_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/32c0d932-50f1-4682-8c4f-d08a33876508_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/bcb9e6b3-30a7-4d98-8c49-6046f33891d9_1000x1000.jpeg"],"publish_at":1476115200000,"id":1369},{"unlike_user_num":98,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 胡桃木六角收纳盘","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/9/dde9326b-7707-413f-84bf-a106e8613d5a_1024x1024.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/9/45553fd5-1867-43f7-b5a4-c696e9d59a10_1000x1000.jpeg"],"price":450,"brief":"M&U CO. | 胡桃木六角收纳盘","like_user_num":381,"mark_user_num":31,"images":["http://dstatic.zuimeia.com/common/image/2016/10/9/f3808ba3-7a8f-446a-9409-bcb1f38a8b1a_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/9/90a468fc-4c28-4fd0-b76f-44b59b9afd23_1024x1024.jpeg"],"publish_at":1476028800000,"id":1365},{"unlike_user_num":130,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 黑色牛皮三角笔袋","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/8/811c4e96-9782-470c-a00e-d58abe47e0cd_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/b6057b60-8112-404a-9eb4-4cb4a72ef668_1000x1000.jpeg"],"price":370,"brief":"M&U CO. | 黑色牛皮三角笔袋","like_user_num":325,"mark_user_num":47,"images":["http://dstatic.zuimeia.com/common/image/2016/10/8/811c4e96-9782-470c-a00e-d58abe47e0cd_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/b6057b60-8112-404a-9eb4-4cb4a72ef668_1000x1000.jpeg"],"publish_at":1475942400000,"id":1360}]
     */

    private DataBean data;
    /**
     * data : {"has_next":0,"products":[{"unlike_user_num":38,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 黄铜嵌皮男士手镯","cover_images":["http://dstatic.zuimeia.com/common/image/2016/11/6/231074fb-8ff0-4e16-902c-d552a349b6dc_900x900.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/aa342487-9b72-4d99-ae34-8fc7ffb7c454_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/0171e7e2-cc59-48a8-b56c-22cb5cf3b1c7_1000x1000.jpeg"],"price":500,"brief":"M&U CO. | 黄铜嵌皮男士手镯","like_user_num":200,"mark_user_num":31,"images":["http://dstatic.zuimeia.com/common/image/2016/11/6/c0f7f774-ab30-4a45-9e0e-de4b1596f241_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/88f126d6-821a-47f8-acee-bdf32fef8ac5_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/0171e7e2-cc59-48a8-b56c-22cb5cf3b1c7_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/4ada1d97-1d04-4d31-91ee-7726e9cc4b4d_1000x1000.jpeg"],"publish_at":1478448000000,"id":1476},{"unlike_user_num":94,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 牛皮束带花盆套","cover_images":["http://dstatic.zuimeia.com/common/image/2016/11/3/ea471ba8-49aa-472e-af16-1fc63e789db2_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/3/67a80c05-5530-4b16-99cb-46ecfe188735_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/3/873b3828-02ff-436f-ba86-5dc6a675d2cb_800x800.jpeg"],"price":300,"brief":"M&U CO. | 牛皮束带花盆套","like_user_num":274,"mark_user_num":14,"images":["http://dstatic.zuimeia.com/common/image/2016/11/3/7589ce79-b721-42ff-9b0f-50e12dac851f_911x911.jpeg"],"publish_at":1478188800000,"id":1465},{"unlike_user_num":90,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 'D' 形钥匙环","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/31/726f15a2-17b1-46d4-909c-3cd6977bd82b_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/5b86545b-8b42-4ddb-a6d7-37fe3d4fb38b_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/9119d709-5745-4918-89c0-52ba55dcfbcf_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/591376ec-9716-4615-a429-8734e8f2b44b_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/0f9ba150-f875-4b28-9bd9-70bf352f0932_1000x1000.jpeg"],"price":200,"brief":"M&U CO. | 'D' 形钥匙环","like_user_num":278,"mark_user_num":17,"images":["http://dstatic.zuimeia.com/common/image/2016/10/31/0848a730-3a74-482b-8d41-9b52f2e69e36_1000x999.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/02de1546-b927-4ddc-8563-9e8d55a8ca3d_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/31/335a1454-93e2-4733-925e-b4dcc38c911c_1000x1000.jpeg"],"publish_at":1477929600000,"id":1448},{"unlike_user_num":93,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 实木拼接六角收纳盘","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/26/632cc800-7c5f-44cb-9343-ddef790e57fe_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/26/f8d9e347-ed73-463d-8bdf-a2c0006270c5_1000x1000.jpeg"],"price":630,"brief":"M&U CO. | 实木拼接六角收纳盘","like_user_num":348,"mark_user_num":14,"images":["http://dstatic.zuimeia.com/common/image/2016/10/26/be418cfd-0206-4213-ae99-841d727975f9_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/26/40b6e560-5957-4eda-8125-3bbab07e7abf_1000x1000.jpeg"],"publish_at":1477497600000,"id":1433},{"unlike_user_num":116,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 黑色扭纹男士手镯","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/19/f88373d6-ff54-469d-8dea-2acc92f8e98e_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/19/56c5fa71-c343-4be7-9895-26de5878bab5_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/19/20ff5187-c18f-4d82-a914-3db0e8cb0247_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/19/668073d2-39a3-4eb4-b8b8-224478f576a9_1000x1000.jpeg"],"price":500,"brief":"M&U CO. | 黑色扭纹男士手镯","like_user_num":718,"mark_user_num":155,"images":["http://dstatic.zuimeia.com/common/image/2016/10/19/54381741-1ac8-4396-80a7-e39dd0814bfb_1000x1000.jpeg"],"publish_at":1476892800000,"id":1401},{"unlike_user_num":116,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 红木色牛皮卡包","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/17/ccee45dd-7b14-4eb5-a152-cebe4db08cb3_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/ffe1b350-c52b-4277-9eec-46d4cb41e228_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/5594c2fc-0761-4883-8569-48d356adb415_1080x1080.jpeg"],"price":370,"brief":"M&U CO. | 红木色牛皮卡包","like_user_num":294,"mark_user_num":15,"images":["http://dstatic.zuimeia.com/common/image/2016/10/17/d6ef74d4-81ae-4330-a65e-190992ec0fa6_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/5b76cef2-36f6-4e32-bbe4-31d9faa99711_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/ffe1b350-c52b-4277-9eec-46d4cb41e228_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/17/5ba1824c-ada7-41b9-9de8-7ca1833b73ee_1000x1000.jpeg"],"publish_at":1476720000000,"id":1392},{"unlike_user_num":112,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 实木拼接方形收纳盘","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/13/688e6173-8696-40fa-86f0-897b643180de_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/13/d1150a93-2f47-4afd-bb39-1948f975537f_1000x1000.jpeg"],"price":580,"brief":"M&U CO. | 实木拼接方形收纳盘","like_user_num":446,"mark_user_num":21,"images":["http://dstatic.zuimeia.com/common/image/2016/10/13/5588fd89-a9dd-4e71-9ae0-b7a1333b1a07_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/13/d1150a93-2f47-4afd-bb39-1948f975537f_1000x1000.jpeg"],"publish_at":1476374400000,"id":1382},{"unlike_user_num":90,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 水平地貌线笔记本","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/10/2f8788e1-92f0-49a1-abe5-3917350566cb_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/f5b1177c-a009-4ba0-a0e4-9527d6cd3b75_800x800.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/32c0d932-50f1-4682-8c4f-d08a33876508_1000x1000.jpeg"],"price":67,"brief":"M&U CO. | 水平地貌线笔记本","like_user_num":570,"mark_user_num":97,"images":["http://dstatic.zuimeia.com/common/image/2016/10/10/abb44a68-7574-4af0-9641-7cc16fadb69a_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/32c0d932-50f1-4682-8c4f-d08a33876508_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/10/bcb9e6b3-30a7-4d98-8c49-6046f33891d9_1000x1000.jpeg"],"publish_at":1476115200000,"id":1369},{"unlike_user_num":98,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 胡桃木六角收纳盘","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/9/dde9326b-7707-413f-84bf-a106e8613d5a_1024x1024.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/9/45553fd5-1867-43f7-b5a4-c696e9d59a10_1000x1000.jpeg"],"price":450,"brief":"M&U CO. | 胡桃木六角收纳盘","like_user_num":381,"mark_user_num":31,"images":["http://dstatic.zuimeia.com/common/image/2016/10/9/f3808ba3-7a8f-446a-9409-bcb1f38a8b1a_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/9/90a468fc-4c28-4fd0-b76f-44b59b9afd23_1024x1024.jpeg"],"publish_at":1476028800000,"id":1365},{"unlike_user_num":130,"designer":{"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130},"name":"M&U CO. | 黑色牛皮三角笔袋","cover_images":["http://dstatic.zuimeia.com/common/image/2016/10/8/811c4e96-9782-470c-a00e-d58abe47e0cd_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/b6057b60-8112-404a-9eb4-4cb4a72ef668_1000x1000.jpeg"],"price":370,"brief":"M&U CO. | 黑色牛皮三角笔袋","like_user_num":325,"mark_user_num":47,"images":["http://dstatic.zuimeia.com/common/image/2016/10/8/811c4e96-9782-470c-a00e-d58abe47e0cd_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/10/8/b6057b60-8112-404a-9eb4-4cb4a72ef668_1000x1000.jpeg"],"publish_at":1475942400000,"id":1360}]}
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

    public static class DataBean implements Serializable {
        private int has_next;
        /**
         * unlike_user_num : 38
         * designer : {"city":"纽约","concept":"我们的设计融合了无铺张无虚饰的北欧美学","name":"Nathan Gryszowka & Hunter Craighill","label":"M&U Co. 联合创始人","avatar_url":"http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg","id":130}
         * name : M&U CO. | 黄铜嵌皮男士手镯
         * cover_images : ["http://dstatic.zuimeia.com/common/image/2016/11/6/231074fb-8ff0-4e16-902c-d552a349b6dc_900x900.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/aa342487-9b72-4d99-ae34-8fc7ffb7c454_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/0171e7e2-cc59-48a8-b56c-22cb5cf3b1c7_1000x1000.jpeg"]
         * price : 500
         * brief : M&U CO. | 黄铜嵌皮男士手镯
         * like_user_num : 200
         * mark_user_num : 31
         * images : ["http://dstatic.zuimeia.com/common/image/2016/11/6/c0f7f774-ab30-4a45-9e0e-de4b1596f241_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/88f126d6-821a-47f8-acee-bdf32fef8ac5_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/0171e7e2-cc59-48a8-b56c-22cb5cf3b1c7_1000x1000.jpeg","http://dstatic.zuimeia.com/common/image/2016/11/6/4ada1d97-1d04-4d31-91ee-7726e9cc4b4d_1000x1000.jpeg"]
         * publish_at : 1478448000000
         * id : 1476
         */

        private List<ProductsBean> products;

        public int getHas_next() {
            return has_next;
        }

        public void setHas_next(int has_next) {
            this.has_next = has_next;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean implements Serializable {
            private int unlike_user_num;
            /**
             * city : 纽约
             * concept : 我们的设计融合了无铺张无虚饰的北欧美学
             * name : Nathan Gryszowka & Hunter Craighill
             * label : M&U Co. 联合创始人
             * avatar_url : http://dstatic.zuimeia.com/designer/avatar/2016/9/29/98a0be8e-a3f1-4035-aef7-7b76297be64c.jpg
             * id : 130
             */

            private DesignerBean designer;
            private String name;
            private int price;
            private String brief;
            private int like_user_num;
            private int mark_user_num;
            private long publish_at;
            private int id;
            private List<String> cover_images;
            private List<String> images;

            public int getUnlike_user_num() {
                return unlike_user_num;
            }

            public void setUnlike_user_num(int unlike_user_num) {
                this.unlike_user_num = unlike_user_num;
            }

            public DesignerBean getDesigner() {
                return designer;
            }

            public void setDesigner(DesignerBean designer) {
                this.designer = designer;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public int getLike_user_num() {
                return like_user_num;
            }

            public void setLike_user_num(int like_user_num) {
                this.like_user_num = like_user_num;
            }

            public int getMark_user_num() {
                return mark_user_num;
            }

            public void setMark_user_num(int mark_user_num) {
                this.mark_user_num = mark_user_num;
            }

            public long getPublish_at() {
                return publish_at;
            }

            public void setPublish_at(long publish_at) {
                this.publish_at = publish_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<String> getCover_images() {
                return cover_images;
            }

            public void setCover_images(List<String> cover_images) {
                this.cover_images = cover_images;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public static class DesignerBean implements Serializable {
                private String city;
                private String concept;
                private String name;
                private String label;
                private String avatar_url;
                private int id;

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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }
    }
}
