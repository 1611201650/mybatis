package org.apache.ibatis.mybatis;

public class UserInfo {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "用户信息:  "+id+" "+name+" "+age;
    }

    int id;
    String name;
    int age;

}
