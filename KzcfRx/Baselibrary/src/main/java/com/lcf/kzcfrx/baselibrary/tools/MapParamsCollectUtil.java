package com.lcf.kzcfrx.baselibrary.tools;

import com.google.gson.Gson;
import com.lcf.kzcfrx.baselibrary.common.APIService;
import com.lcf.kzcfrx.baselibrary.common.Apps;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author ：Create by lichunfu
 * @Date : 2018/5/30
 * Description:
 **/
public  class MapParamsCollectUtil {

    public  static  HashMap<String, String> getMap(HashMap<String, String> map) {

        // 字母排序规则
        Comparator<Object> cmp = Collator.getInstance(java.util.Locale.ENGLISH);

        map.put("targetCode", "SMH");
        map.put("reqCode", "APP");

        map.put("device", "41DE46F1605A7465BA7B2CBC2EAC1542");
        map.put("uid","307");

        String[] arr = new String[map.size()];//新建一个int类型数组
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        int z = 0;
        while (iterator.hasNext()) {
            Map.Entry mapentry = (Map.Entry) iterator.next();
            System.out.println(mapentry.getKey());

            arr[z] = mapentry.getKey().toString();
            z++;

        }
        Arrays.sort(arr, cmp);
        String x = "";
        for (int i = 0; i < map.size(); i++) {
            x += arr[i] + "=" + map.get(arr[i]) + "&";
        }
        x = x.substring(0, x.length() - 1);
        String hash = StrMd5.md5(x);
        String hash2 = StrMd5.md5(hash + "&kztoken=" + APIService.TOKEN);

        map.put("data", new Gson().toJson(map));
        map.put("sign", hash2);

        return map;
    }
}
