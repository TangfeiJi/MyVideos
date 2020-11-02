package com.asdcce.ddgfd.modules.bean;

public class FriendsBean {


    /**
     * user_id : 1
     * friend_nickname : 11
     * head_portrait : default9.png
     * device_power : 25
     * is_share : 1
     * position : {"lat":108.9495236664,"lon":34.2598766768,"created_at":1591262223}
     */

    private int user_id;
    private String friend_nickname;
    private String head_portrait;
    private int device_power;
    private int is_share;
    private PositionBean position;
    private int is_oneself;

    public FriendsBean(int is_oneself,int user_id, String friend_nickname, String head_portrait,  PositionBean position) {
        this.is_oneself=is_oneself;
        this.user_id = user_id;
        this.friend_nickname = friend_nickname;
        this.head_portrait = head_portrait;

        this.position = position;
    }

    public int getIs_oneself() {
        return is_oneself;
    }

    public void setIs_oneself(int is_oneself) {
        this.is_oneself = is_oneself;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFriend_nickname() {
        return friend_nickname;
    }

    public void setFriend_nickname(String friend_nickname) {
        this.friend_nickname = friend_nickname;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public int getDevice_power() {
        return device_power;
    }

    public void setDevice_power(int device_power) {
        this.device_power = device_power;
    }

    public int getIs_share() {
        return is_share;
    }

    public void setIs_share(int is_share) {
        this.is_share = is_share;
    }

    public PositionBean getPosition() {
        return position;
    }

    public void setPosition(PositionBean position) {
        this.position = position;
    }

    public static class PositionBean {
        /**
         * lat : 108.9495236664
         * lon : 34.2598766768
         * created_at : 1591262223
         */

        private double lat;
        private double lon;
        private int created_at;

        public PositionBean(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }
    }
}
