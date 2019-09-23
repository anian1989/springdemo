package com.springdb.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.springdb.demo.mapper.SkuChannelSnapshotCompareMapper;
import com.springdb.demo.model.SkuChannelSnapshotCompare;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

	@Resource
	private SkuChannelSnapshotCompareMapper skuChannelSnapshotCompareMapper;
	@Test
	public void contextLoads() {
		Integer warehouseId =49;
		String skuType="10";
		String startDate="2019-09-04";
		DateTime now = DateTime.now();
//		now = now.minusDays(1);
		String string = now.toString("yyyy-MM-dd");
		DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(startDate);
		int days = Days.daysBetween(dt2, now).getDays();
		log.info("测试-时间差差值：{}天",JSONObject.toJSONString(days));

		List<SkuChannelSnapshotCompare> all = skuChannelSnapshotCompareMapper.getAll(49,"10",string);
		if (CollectionUtils.isNotEmpty(all)) {
			log.info("测试-差异总数："+all.size());
			ArrayList<SkuChannelSnapshotCompare> objects = Lists.newArrayList();

			for (SkuChannelSnapshotCompare skuChannelSnapshotCompare : all) {
				List<SkuChannelSnapshotCompare> detail = skuChannelSnapshotCompareMapper.getDetail(skuChannelSnapshotCompare.getDiffStock()
						, warehouseId
						,skuChannelSnapshotCompare.getSkuCode()
						, skuType, startDate, string);
				if (CollectionUtils.isNotEmpty(detail)&&detail.size()>=days) {
					objects.add(skuChannelSnapshotCompare);
				}
			}
			if (CollectionUtils.isNotEmpty(objects)) {
				log.info("测试-持续差异SKU总数："+objects.size());
				StringBuilder stringBuilder = new StringBuilder();
				for (SkuChannelSnapshotCompare object : objects) {
					System.out.println(object.getSkuCode()+"    "+object.getDiffStock());
					stringBuilder.append(object.getSkuCode()+","+object.getDiffStock()+"\n");
				}

				String fileName = "/Users/zhangjunshuai/库存差异查询/上海"+string+".csv";
				File file = new File(fileName);
				//还需处理路径不存在的问题
				try {
					Files.write(stringBuilder.toString(), file, Charsets.UTF_8);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}


	}

}
