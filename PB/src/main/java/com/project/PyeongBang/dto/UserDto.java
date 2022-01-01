package com.project.PyeongBang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String name;
    private String pwd;
    private String major;

    public void AddMemberDto(String id, String name, String pwd, String major){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.major = major;
    }

    public void LoginDto(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }
}
