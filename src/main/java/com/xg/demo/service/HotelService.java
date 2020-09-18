package com.xg.demo.service;

import com.xg.demo.Utils.HttpUtils;
import com.xg.demo.api.ResponseCode;
import com.xg.demo.api.ResponseServer;
import com.xg.demo.mapper.HotelRepository;
import com.xg.demo.model.Hotels;
import com.xg.demo.model.request.HotelsRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Transactional(rollbackFor = Exception.class)
    public ResponseServer AddHotel(HotelsRequest hotelsRequest) {

        Hotels hotels=new Hotels();
        hotels.setCity(hotelsRequest.getCity());
        hotels.setDimensionality(hotelsRequest.getDimensionality());
        hotels.setHotelname(hotelsRequest.getHotelname());
        hotels.setLongitude(hotelsRequest.getLongitude());
        hotels.setPhone(hotelsRequest.getPhone());
        hotels.setStreet(hotelsRequest.getStreet());
        hotels.setProvince(hotelsRequest.getProvince());
        Hotels save = hotelRepository.save(hotels);
        if (save==null){
            return ResponseServer.createByErrorCodeMessage(500, ResponseCode.ERROR.getDesc()) ;
        }
        return ResponseServer.createBySuccess(200,ResponseCode.SUCCESS.getDesc(),save);
    }

    public ResponseServer getHotels() {
        List<Hotels> all = hotelRepository.findAll();
        return ResponseServer.createBySuccess(200,"成功",all);
    }

    /*public ResponseServer getHotels(String ip) {

        String host = "https://ips.market.alicloudapi.com";
        String path = "/iplocaltion";
        String method = "GET";
        String appcode = "e8858baed80647e8be95587141bab993";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ip",ip);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            return ResponseServer.createBySuccess(response);
            *//*  System.out.println(EntityUtils.toString(response.getEntity()));*//*
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
