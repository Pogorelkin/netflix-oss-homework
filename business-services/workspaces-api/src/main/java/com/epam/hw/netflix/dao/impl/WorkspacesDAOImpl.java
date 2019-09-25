package com.epam.hw.netflix.dao.impl;

import com.epam.hw.netflix.dao.WorkspacesDAO;
import com.epam.hw.netflix.domain.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkspacesDAOImpl implements WorkspacesDAO {
    @Autowired
    private MongoTemplate mongoTemplate;
    private static final String collectionName = "orders";

    @Override
    public void create(Workspace workspace) {
        mongoTemplate.insert(workspace, collectionName);
    }

    @Override
    public List<Workspace> findAll() {
        return mongoTemplate.findAll(Workspace.class, collectionName);
    }

    @Override
    public Workspace findById(String s) {
        return mongoTemplate.findById(s, Workspace.class, collectionName);
    }

    @Override
    public void update(Workspace workspace) {
        mongoTemplate.updateFirst(new Query().addCriteria((Criteria.where("id").is(workspace.getId()))),
                new Update(),
                Workspace.class, collectionName);
    }

    @Override
    public void delete(Workspace workspace) {
        mongoTemplate.remove(workspace, collectionName);
    }

    @Override
    public void deleteCollection() {
        mongoTemplate.dropCollection(collectionName);
    }
}
