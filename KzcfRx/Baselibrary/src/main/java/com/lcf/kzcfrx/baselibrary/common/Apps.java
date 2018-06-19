package com.lcf.kzcfrx.baselibrary.common;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public class Apps {


    //推送id
    public static String userJpushId = "";

    //权限
    public static String RIGHT="RIGHT";
    //历史搜索记录
    public static String SEARCH_HOT="SEARCH_HOT";

    //客户历史搜索记录
    public static String SEARCH_HOT_CUSTOMER="SEARCH_HOT_CUSTOMER";

    //供应商历史搜索记录
    public static String SEARCH_HOT_PROVIDER="SEARCH_HOT_PROVIDER";

    public  static  String USER_LOGIN="USER_LOGIN";

    public  static  String SID="SID";
    public  static  String UID="UID";

    public  static  String USERNAME="USERNAME";
    public  static  String PWD="PWD";

    public  static  String Name="Name";

    public  static  String SESSION_ID="SESSION_ID";
    public  static  String API_TOKEN="api_token";


    public  static String device="";
    public  static  String uid="";


    public  static  String Mobile="Mobile";
    //入库仓库名字
    public  static  String LOCATIONNAME="LOCATIONNAME";
    //入库仓库ID
    public  static  String LOCATIONID="LOCATIONID";
    //列表请求数据
    public static int Page = 0;

    public static  int LIMIT=10;
    public static String contact_id="";//新增销售单选择的客户id

    private static InputFilter emojiFilter = new InputFilter() {


        Pattern emoji = Pattern.compile(


                "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",


                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);


        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                                   int dstart, int dend) {
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {




                return "";


            }
            return null;


        }
    };


    public static InputFilter[] emojiFilters = {emojiFilter};
}
