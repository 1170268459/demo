package com.xg.demo.controller;

import com.xg.demo.api.ResponseServer;
import com.xg.demo.model.Hotels;
import com.xg.demo.model.HotelsRequest;
import com.xg.demo.service.HotelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api
@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/addHotel")
    @ResponseBody
    @ApiOperation(value = "添加酒店",httpMethod = "POST")
    public ResponseEntity AddHotel(@RequestBody @Valid @ApiParam(value = "酒店所有",required = true) HotelsRequest hotels){
        ResponseServer responseServer = hotelService.AddHotel(hotels);
        return ResponseEntity.ok(responseServer);
    }

    @GetMapping("/hotels")
    @ResponseBody
    @ApiOperation(value = "酒店列表",httpMethod = "GET")
    public ResponseEntity getHotels(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        hotelService.getHotels(ip);
        return null;
    }


}
