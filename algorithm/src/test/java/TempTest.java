import com.alibaba.fastjson.JSONObject;
import com.fanhanfei.common.collections.StringListUtils;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangjunshuai
 * @date 2020/2/10
 * @description
 **/
@DisplayName("临时测试类")
public class TempTest {

    public static String logisticsOrders = "";

    public static String orderNos = "";


    @Test
    @DisplayName("测试stream的sum")
    public void testStreamSum() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 3, 5, 6);
        Long reduce = integers.stream().filter(k -> k > 6).map(Integer::longValue).reduce(0L, Long::sum);
        System.out.println(reduce);

    }

    @DisplayName("打印SQL")
    @Test
    public void test() {
        String sql = "UPDATE logistics_order_item SET logistics_order_no = CONCAT(logistics_order_no,'R') WHERE  logistics_order_no='%s' AND sku_code NOT IN(21018216,21018218,21015687,21015685,21015686);";
        String sql2 = "UPDATE logistics_order SET logistics_order_no = CONCAT(logistics_order_no,'R'),`status`=1 WHERE logistics_order_no='%s';";
//        String s = logisticsOrders.replaceAll("\n", "");
        String[] split = logisticsOrders.split("\n");
        for (String temp : split) {
            System.out.println(String.format(sql, temp));
            System.out.println(String.format(sql2, temp));
        }
    }

    @DisplayName("d订单")
    @Test
    public void test1() {
        String sql = "UPDATE wms_task SET `status` = 0 WHERE refer_id='%s' AND task_type =10;";
//        String s = orderNos.replaceAll("\n", "");
        String[] split = orderNos.split("\n");
        for (String temp : split) {
            System.out.println(String.format(sql, temp));
        }
    }

    @Test
    public void testColl() {
        ArrayList<String> list = Lists.newArrayList();
        ArrayList<String> list1 = Lists.newArrayList("1");
        if (CollectionUtils.isNotEmpty(list) ^ CollectionUtils.isNotEmpty(list1)) {
            System.out.println("+++++++++++++++++++++");
            list.addAll(list1);
            System.out.println(list.size());
        } else {
            System.out.println("---------------------");
        }

    }

    @Test
    public void testFormat() {
        final String tr = "%s种%s件";
        String format = String.format(tr, 12, 34);
        System.out.println(format);
    }


    @DisplayName("测试emptyList 循环问题")
    @Test
    public void TestEmptyList() {
        List<String> objects = Collections.emptyList();
        objects.forEach(kk -> System.out.println(kk));
        for (String object : objects) {
            System.out.println(1);
        }
        System.out.println(2);


    }

    @Test
    @DisplayName("获取SKuCOde")
    public void testString() {
        String str ="";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);

        List<String> list = StringListUtils.stringToListWithDistinct(stringBuilder.toString(), "\n", Lists.newArrayList("#N/A"));
        for (String s : list) {
            System.out.println(s);
        }

    }

    @Test
    @DisplayName("对比")
    public void compare(){

        String str1 ="";
        String str2="";

        List<String> list1 = StringListUtils.stringToListWithDistinct(str1, "\n", Lists.newArrayList("#N/A"));
        List<String> list2 = StringListUtils.stringToListWithDistinct(str2, "\n", Lists.newArrayList("#N/A"));

        for (String s : list1) {
            if (!list2.contains(s)){
                System.out.println(s);
            }
        }

    }

    @Test
    @DisplayName("去重")
    public void distinct(){
        String str ="";

        String[] split = str.split("\n");
        ArrayList<String> list = Lists.newArrayList(split);
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s+",");
        }


    }


}

