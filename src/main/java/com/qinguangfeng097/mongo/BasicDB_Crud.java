package com.qinguangfeng097.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/7.
 */
public class BasicDB_Crud {
    private MongoClient mongoClient;
    private MongoClientURI mongoClientURI;

    private MongoDatabase mongoDatabase;

    private MongoCollection<BasicDBObject> mongoCollection;

    @Before
    public void init() {
        mongoClientURI = new MongoClientURI("mongodb://127.0.0.1:27017/admin");
        mongoClient = new MongoClient(mongoClientURI);

        mongoDatabase = mongoClient.getDatabase("test1");
        mongoCollection = mongoDatabase.getCollection("pra", BasicDBObject.class);

    }

    /**
     * 用BasicDBOject单加一条，
     * 顺序 别搞反
     */
    @Test
    public void testInsert() {
        BasicDBObject basicDBObject = new BasicDBObject("name","妮妮");
        mongoCollection.insertOne(basicDBObject);
    }


}
