package com.lcf.kzcfrx.provider.bean;


import com.lcf.kzcfrx.baselibrary.rx.ext.ResultModel;

import java.util.List;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/6/19
 * Description:
 **/
public class TestLoginBean {


    /**
     * data : {"list":[{"isReal":"0","WXCode":"","latitude":"","lastlogintime":"2017-11-08 08:55:35","gold":"0","unread_activity":"0","balance":"0","paymentpwd":"","integral":"0","nickname":"time","ctime":"2017-11-08 08:55:35","id":982904026830082001,"tag":"","vault":"0","invitationCode":"","longitude":"","unread_people":"0","finderID1":0,"openid":"oKKGgxKK3-aSrH1Ebi-JIF3tu--Y","sex":"男","scene_id":0,"face":"c5e96f4aa2ad087bcfddc87fb5c50c6c.png","QRCode":"","phone":"VQteri3z","unread_sys":"0","suppliersStoreLevei":"0","memLevel":"0","pwd":"sglWaEYt"},{"isReal":"0","WXCode":"","latitude":"","lastlogintime":"2018-03-08 00:10:15","gold":"0","unread_activity":"0","balance":"0","paymentpwd":"","integral":"0","nickname":"味精","ctime":"2018-03-08 00:10:15","id":982904026830082003,"tag":"","vault":"0","invitationCode":"","longitude":"","unread_people":"0","finderID1":0,"openid":"oKKGgxE6EE3EwiNIb6tKCmKiRkjw","sex":"男","scene_id":0,"face":"3d410b30c4f032ed8242ea2a5963342a.png","QRCode":"","phone":"phaurVvJ","unread_sys":"0","suppliersStoreLevei":"0","memLevel":"0","pwd":"sLn8pAUP"}],"people":{"phone":"1002","nickname":"测试Feign11529388756364","pwd":"test123"}}
     */


    private PeopleBean people;
    private List<ListBean> list;

    public PeopleBean getPeople() {
        return people;
    }

    public void setPeople(PeopleBean people) {
        this.people = people;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class PeopleBean {
        /**
         * phone : 1002
         * nickname : 测试Feign11529388756364
         * pwd : test123
         */

        private String phone;
        private String nickname;
        private String pwd;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }
    }

    public static class ListBean {
        /**
         * isReal : 0
         * WXCode :
         * latitude :
         * lastlogintime : 2017-11-08 08:55:35
         * gold : 0
         * unread_activity : 0
         * balance : 0
         * paymentpwd :
         * integral : 0
         * nickname : time
         * ctime : 2017-11-08 08:55:35
         * id : 982904026830082001
         * tag :
         * vault : 0
         * invitationCode :
         * longitude :
         * unread_people : 0
         * finderID1 : 0
         * openid : oKKGgxKK3-aSrH1Ebi-JIF3tu--Y
         * sex : 男
         * scene_id : 0
         * face : c5e96f4aa2ad087bcfddc87fb5c50c6c.png
         * QRCode :
         * phone : VQteri3z
         * unread_sys : 0
         * suppliersStoreLevei : 0
         * memLevel : 0
         * pwd : sglWaEYt
         */

        private String isReal;
        private String WXCode;
        private String latitude;
        private String lastlogintime;
        private String gold;
        private String unread_activity;
        private String balance;
        private String paymentpwd;
        private String integral;
        private String nickname;
        private String ctime;
        private long id;
        private String tag;
        private String vault;
        private String invitationCode;
        private String longitude;
        private String unread_people;
        private int finderID1;
        private String openid;
        private String sex;
        private int scene_id;
        private String face;
        private String QRCode;
        private String phone;
        private String unread_sys;
        private String suppliersStoreLevei;
        private String memLevel;
        private String pwd;

        public String getIsReal() {
            return isReal;
        }

        public void setIsReal(String isReal) {
            this.isReal = isReal;
        }

        public String getWXCode() {
            return WXCode;
        }

        public void setWXCode(String WXCode) {
            this.WXCode = WXCode;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLastlogintime() {
            return lastlogintime;
        }

        public void setLastlogintime(String lastlogintime) {
            this.lastlogintime = lastlogintime;
        }

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getUnread_activity() {
            return unread_activity;
        }

        public void setUnread_activity(String unread_activity) {
            this.unread_activity = unread_activity;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getPaymentpwd() {
            return paymentpwd;
        }

        public void setPaymentpwd(String paymentpwd) {
            this.paymentpwd = paymentpwd;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getVault() {
            return vault;
        }

        public void setVault(String vault) {
            this.vault = vault;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getUnread_people() {
            return unread_people;
        }

        public void setUnread_people(String unread_people) {
            this.unread_people = unread_people;
        }

        public int getFinderID1() {
            return finderID1;
        }

        public void setFinderID1(int finderID1) {
            this.finderID1 = finderID1;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getScene_id() {
            return scene_id;
        }

        public void setScene_id(int scene_id) {
            this.scene_id = scene_id;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getQRCode() {
            return QRCode;
        }

        public void setQRCode(String QRCode) {
            this.QRCode = QRCode;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUnread_sys() {
            return unread_sys;
        }

        public void setUnread_sys(String unread_sys) {
            this.unread_sys = unread_sys;
        }

        public String getSuppliersStoreLevei() {
            return suppliersStoreLevei;
        }

        public void setSuppliersStoreLevei(String suppliersStoreLevei) {
            this.suppliersStoreLevei = suppliersStoreLevei;
        }

        public String getMemLevel() {
            return memLevel;
        }

        public void setMemLevel(String memLevel) {
            this.memLevel = memLevel;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        @Override
        public String toString() {
            return "ListBean{" +
                    "isReal='" + isReal + '\'' +
                    ", WXCode='" + WXCode + '\'' +
                    ", latitude='" + latitude + '\'' +
                    ", lastlogintime='" + lastlogintime + '\'' +
                    ", gold='" + gold + '\'' +
                    ", unread_activity='" + unread_activity + '\'' +
                    ", balance='" + balance + '\'' +
                    ", paymentpwd='" + paymentpwd + '\'' +
                    ", integral='" + integral + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", ctime='" + ctime + '\'' +
                    ", id=" + id +
                    ", tag='" + tag + '\'' +
                    ", vault='" + vault + '\'' +
                    ", invitationCode='" + invitationCode + '\'' +
                    ", longitude='" + longitude + '\'' +
                    ", unread_people='" + unread_people + '\'' +
                    ", finderID1=" + finderID1 +
                    ", openid='" + openid + '\'' +
                    ", sex='" + sex + '\'' +
                    ", scene_id=" + scene_id +
                    ", face='" + face + '\'' +
                    ", QRCode='" + QRCode + '\'' +
                    ", phone='" + phone + '\'' +
                    ", unread_sys='" + unread_sys + '\'' +
                    ", suppliersStoreLevei='" + suppliersStoreLevei + '\'' +
                    ", memLevel='" + memLevel + '\'' +
                    ", pwd='" + pwd + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TestLoginBean{" +
                "people=" + people +
                ", list=" + list +
                '}';
    }
}
