package com.github.zhuyiyi1990.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String uname;

    private int age;

    private Date birthday;//添加生日属性,java.util.Date类型

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

}
