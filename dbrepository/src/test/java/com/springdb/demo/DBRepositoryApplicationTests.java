package com.springdb.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.springdb.demo.mapper.SkuChannelSnapshotCompareMapper;
import com.springdb.demo.model.SkuChannelSnapshotCompare;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
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
import java.util.Map;
//https://blinkfox.github.io/2019/03/02/hou-duan/spring/springboot2.x-dan-yuan-ce-shi/
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("hsqldb")
//@RunWith(MockitoJUnitRunner.class) Service层测试
//@WebMvcTest(BlogController.class) Controller层测试
@Slf4j
public class DBRepositoryApplicationTests extends BaseTest{

	@Resource
	private SkuChannelSnapshotCompareMapper skuChannelSnapshotCompareMapper;
	@Test
	public void contextLoads() {
		Integer warehouseId =40;
		String skuType="10";
		String startDate="2019-09-29";
		DateTime now = DateTime.now();
//		now = now.minusDays(1);
		String string = now.toString("yyyy-MM-dd");
		DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(startDate);
		int days = Days.daysBetween(dt2, now).getDays();
		log.info("测试-时间差差值：{}天",JSONObject.toJSONString(days));

		List<SkuChannelSnapshotCompare> all = skuChannelSnapshotCompareMapper.getAll(warehouseId,"10",string);
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
				ArrayList<Long> useSkuList = Lists.newArrayList();
				for (SkuChannelSnapshotCompare object : objects) {
					if (useSkuList.contains(object.getSkuCode())) {
						continue;
					}
					useSkuList.add(object.getSkuCode());
					if (object.getDiffStock()<0){
						System.out.println(object.getSkuId()+","+warehouseId+","+object.getDiffStock());
					}
					stringBuilder.append(object.getSkuId()+","+warehouseId+","+object.getSkuCode()+","+object.getDiffStock()+"\n");
				}

				String fileName = "/Users/zhangjunshuai/库存差异查询/北京"+string+".csv";
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
