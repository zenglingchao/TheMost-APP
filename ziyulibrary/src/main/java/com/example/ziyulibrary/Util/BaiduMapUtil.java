/*
package com.example.ziyulibrary.Util;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;

import java.util.List;

*/
/**
 * com.example.balloon
 * Created by ziyu on 2016/10/8 .
 *//*


public class BaiduMapUtil {

    */
/**
     * 定位到指定位置
     * @param baiduMap
     * @param latlan
     * @param zoom
     *//*

    public static void setPosition(BaiduMap baiduMap, LatLng latlan,int zoom){
        //设置地图显示的位置
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(latlan)//地图显示位置的中心点
                .zoom(zoom)
                .build();
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        baiduMap.setMapStatus(mMapStatusUpdate);
    }

    //---------BitmapDescriptorFactory 有多种方法返回bitmapDescriptor-------
    */
/**
     * 通过资源文件设置Maker
     * @param baiduMap
     * @param resId
     *//*

    public static void addMakerWithResource(BaiduMap baiduMap,int resId,LatLng latLng){
        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(resId);
                 //构建MarkerOption，用于在地图上添加Marker
        MarkerOptions option = new MarkerOptions()
                .position(latLng)
                .icon(bitmap)
                .draggable(true);//可拖拽
        // 生长动画
        option.animateType(MarkerOptions.MarkerAnimateType.grow);
                baiduMap.addOverlay(option);
        //在地图上添加Marker，并显示
        baiduMap.addOverlay(option);
    }

    */
/**
     * 通过View设置Maker childId设置为0则没有需要设值的子控件
     * @param baiduMap
     * @param view
     *//*

    public static void addMakerWithView(BaiduMap baiduMap,View view,int childTextId,String context,LatLng latLng){
       if(context != null && childTextId != 0){
           TextView textView = (TextView) view.findViewById(childTextId);
           textView.setText(context);
       }
        BitmapDescriptor bitmapDesc = BitmapDescriptorFactory.fromView(view);
        Log.d("print", "addMaker: " + bitmapDesc);
        MarkerOptions option = new MarkerOptions()
                .position(latLng)
                .icon(bitmapDesc)
                .draggable(true);

        //在地图上添加Marker，并显示
        baiduMap.addOverlay(option);
    }



    */
/**
     *绘制坐标连线
     * @param baiduMap
     * @param list
     *//*

    public static void showLine(BaiduMap baiduMap,List<LatLng> list){
        OverlayOptions ooPolyline = new PolylineOptions()
                .width(5)
                .color(Color.RED)
                .points(list);
        //添加在地图中
        Polyline mPolyline = (Polyline) baiduMap.addOverlay(ooPolyline);
        baiduMap.addOverlay(ooPolyline);
    }

    */
/**
     * 显示弹出窗
     * @param baiduMap
     * @param view
     * @param latLng
     * @param offset
     *//*

    public static void showWindow(BaiduMap baiduMap,View view, LatLng latLng,int offset){
        //创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
        InfoWindow mInfoWindow = new InfoWindow(view,latLng,offset);
        //显示InfoWindow
        baiduMap.showInfoWindow(mInfoWindow);
    }

}
*/
