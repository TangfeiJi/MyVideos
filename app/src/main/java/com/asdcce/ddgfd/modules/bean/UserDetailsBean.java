package com.asdcce.ddgfd.modules.bean;

public class UserDetailsBean {

    /**
     * user_id : 1
     * identity : 1dac8e6ac6e6d26f1dd3311104010f1f
     * head_portrait : 20200326184048034634939971220977.png
     * nickname : 查哥
     * phone : 185****2050
     * vip : 1
     * vip_expire_time : 2020-09-03
     * is_have_vip_friend : 2
     */

    private int user_id;
    private String identity;
    private String head_portrait;
    private String nickname;
    private String phone;
    private int vip;
    private String vip_expire_time;
    private int is_have_vip_friend;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public String getVip_expire_time() {
        return vip_expire_time;
    }

    public void setVip_expire_time(String vip_expire_time) {
        this.vip_expire_time = vip_expire_time;
    }

    public int getIs_have_vip_friend() {
        return is_have_vip_friend;
    }

    public void setIs_have_vip_friend(int is_have_vip_friend) {
        this.is_have_vip_friend = is_have_vip_friend;
    }
}
