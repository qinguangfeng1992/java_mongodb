package com.qinguangfeng097.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/7.
 */
public class Document_Crud {
    private MongoClient mongoClient;

    private MongoClientURI mongoClientURI;

    private MongoDatabase mongoDatabase;

    private MongoCollection mongoCollection;

    /**
     * 一些数据的初始化
     */
    @Before
    public void init() {
        //   mongoClientURI=new MongoClientURI("mongodb://127.0.0.1:27017/admin");
        mongoClientURI = new MongoClientURI("mongodb://xianyaoji:123456@192.168.0.110:27017/admin");
        mongoClient = new MongoClient(mongoClientURI);
        mongoDatabase = mongoClient.getDatabase("test1");
        mongoCollection = mongoDatabase.getCollection("3test");

    }

    /**
     * 插入一条数据
     */
    @Test
    public void testInsert() {
        Document document = new Document();
        document.append("name", "小王八");
        mongoCollection.insertOne(document);

    }


}
