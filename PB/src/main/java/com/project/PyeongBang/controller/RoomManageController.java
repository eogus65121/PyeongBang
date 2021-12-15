package com.project.PyeongBang.controller;

import com.project.PyeongBang.dto.DetailResponseDto;
import com.project.PyeongBang.dto.RoomDetailsDto;
import com.project.PyeongBang.dto.RoomInfoDto;
import com.project.PyeongBang.dto.RoomOptionsDto;
import com.project.PyeongBang.service.RoomSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class RoomManageController {
    private final RoomSvc roomSvc;

    @PostMapping("/postroominfo")
    public void addRoomInfo(@RequestBody RoomInfoDto roomInfoDto) {roomSvc.addRoomInfo(roomInfoDto);}

    @PostMapping("/roomdetails")
    public void addRoomDetails(@RequestBody RoomDetailsDto roomDetailsDto) {roomSvc.addRoomDetails(roomDetailsDto);}

    @PostMapping("/roomOptions")
    public void addRoomOptions(@RequestBody RoomOptionsDto roomOptionsDto) {roomSvc.addRoomOptions(roomOptionsDto);}

    @PostMapping("/responseInfo")
    public DetailResponseDto selectRoomInfo(HttpServletRequest httpServletRequest){
        int num = Integer.parseInt(httpServletRequest.getParameter("num"));
        int room_id = Integer.parseInt(httpServletRequest.getParameter("room_id"));
        return roomSvc.selectRoomInfo(num, room_id);
    }

    @PostMapping("/searchBuildingName") // 빌딩 이름으로 검색
    public List<RoomInfoDto> selectBuildingName(HttpServletRequest httpServletRequest){
        String building_name = httpServletRequest.getParameter("building_name");
        return roomSvc.selectBuildingNameInfo(building_name);
    }

    @PostMapping("/searchAddress") // 주소로 검색
    public List<RoomInfoDto> selectAddress(HttpServletRequest httpServletRequest){
        String address = httpServletRequest.getParameter("address");
        return roomSvc.selectAddress(address);
    }
}
