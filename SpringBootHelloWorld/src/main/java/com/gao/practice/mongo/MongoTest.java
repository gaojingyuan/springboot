package com.gao.practice.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jionglu on 17/4/10.
 */
public class MongoTest {
    public static void main(String[] args) {
        try {
            // //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            // //ServerAddress()两个参数分别为 服务器地址 和 端口
            // ServerAddress serverAddress = new ServerAddress("localhost",27017);
            // List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            // addrs.add(serverAddress);
            //
            // //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            // MongoCredential credential = MongoCredential.createScramSha1Credential("gao", "admin",
            // "1234".toCharArray());
            // List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            // credentials.add(credential);
            //
            // //通过连接认证获取MongoDB连接
            // MongoClient mongoClient = new MongoClient(addrs,credentials);
            //
            // //连接到数据库
            // MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");

            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");

            // mongoDatabase.createCollection("hello");

            MongoCollection<Document> collection = mongoDatabase.getCollection("hello");
            // 插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式 2. 创建文档集合List<Document> 3. 将文档集合插入数据库集合中
             * mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             */
            Document document = new Document("title", "MongoDB").append("description", "database").append("likes", 100)
                    .append("by", "Fly");
            List<Document> documents = new ArrayList<Document>();
            documents.add(document);
            collection.insertMany(documents);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
