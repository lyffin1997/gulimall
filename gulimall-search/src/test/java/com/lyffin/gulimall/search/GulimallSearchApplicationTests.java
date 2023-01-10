package com.lyffin.gulimall.search;

import com.alibaba.fastjson.JSON;
import com.lyffin.gulimall.search.config.GulimallElasticSearchConfig;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class GulimallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    @Data
    static class Account {
        private int account_number;
        private int balance;
        private String firstname;
        private String lastname;
        private int age;
        private String gender;
        private String address;
        private String employer;
        private String email;
        private String city;
        private String state;
    }

    /**
     * 测试检索数据
     */
    @Test
    void searchData() throws IOException {
        //创建检索请求
        SearchRequest searchRequest = new SearchRequest();
        //指定索引
        searchRequest.indices("bank");
        //指定检索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));
        //按年龄的值分布进行聚合
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);
        //薪资平均值
        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");
        searchSourceBuilder.aggregation(balanceAvg);
        searchSourceBuilder.aggregation(ageAgg);
        System.out.println(searchSourceBuilder.toString());

        searchRequest.source(searchSourceBuilder);
        //执行检索
        SearchResponse searchResponse = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

        //分析结果
        System.out.println(searchResponse.toString());
        //Map map = JSON.parseObject(searchResponse.toString(), Map.class);
        //获取所有查到的数据
        SearchHits searchHits = searchResponse.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            //hit.getIndex();
            //hit.docId();
            String source = hit.getSourceAsString();
            Account account = JSON.parseObject(source, Account.class);
            System.out.println(account.toString());
        }
        //获取聚合信息
        Aggregations aggregations = searchResponse.getAggregations();
        Terms ageAgg1 = aggregations.get("ageAgg");
        for (Terms.Bucket bucket : ageAgg1.getBuckets()) {
            System.out.println("年龄：" + bucket.getKeyAsString()+"====》"+ bucket.getDocCount());
        }
        Avg balanceAvg1 = aggregations.get("balanceAvg");
        System.out.println("平均薪资：" + balanceAvg1.getValue());
    }

    /**
     * 测试存储数据到es
     */
    @Test
    void indexData() throws IOException {
        //设置索引
        IndexRequest indexRequest = new IndexRequest("users");
        //设置文档id
        indexRequest.id("1");
        //设置文档，key-value形式
        //indexRequest.source("userName","lyffin","age",18,"gender", "男");
        //设置文档，转成字符串形式
        User user = new User();
        user.setAge(18);
        user.setUserName("lyffin");
        user.setGender("m");
        String s = JSON.toJSONString(user);
        indexRequest.source(s, XContentType.JSON);
        //执行保存操作
        IndexResponse index = client.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);
        //提取需要到响应数据
        System.out.println(index);
    }

    @Data
    class User{
        private String userName;
        private String gender;
        private int age;
    }

}
