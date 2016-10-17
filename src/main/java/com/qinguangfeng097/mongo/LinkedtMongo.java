package com.qinguangfeng097.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public class LinkedtMongo {
    /**
     * 没授权
     */
    @Test
    public void testUnauth() {
        /**
         * 直接连接未授权的mongo数据库
         */
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);

        System.out.println(mongoClient);

    }

    /**
     * 授权方式1
     */
    @Test
    public void testAuth1() {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://xianyaoji:123456@192.168.0.110:27017/admin");

        MongoClient mongoClient = new MongoClient(mongoClientURI);

        System.out.println(mongoClient);

    }

    /**
     * 授权方式2
     */
    @Test
    public void testAuth2() {
        ServerAddress serverAddress = new ServerAddress("192.168.0.110");

        MongoCredential mongoCredential = MongoCredential.createCredential("xianyaoji", "admin", "123456".toCharArray());
        List<MongoCredential> list = new ArrayList<MongoCredential>();
        list.add(mongoCredential);
        MongoClient mongoClient = new MongoClient(serverAddress, list);

        System.out.println(mongoClient);

    }

    /**
     * 授权方式1，测试查询全部
     */
    @Test
    public void testFind() {

        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://xianyaoji:123456@192.168.0.110:27017/admin");
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test1");
        MongoCollection mongoCollection = mongoDatabase.getCollection("3test");
        FindIterable<Document> findIterable = mongoCollection.find();
        for (Document document : findIterable) {
            System.out.println(document.toJson());

        }

    }


}
