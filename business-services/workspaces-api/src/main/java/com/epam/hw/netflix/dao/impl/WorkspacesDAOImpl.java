package com.epam.hw.netflix.dao.impl;

import com.epam.hw.netflix.dao.WorkspacesDAO;
import com.epam.hw.netflix.domain.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public class WorkspacesDAOImpl implements WorkspacesDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public <S extends Workspace> S save(S entity) {
        return mongoTemplate.save(entity, "workplaces");
    }

    @Override
    public <S extends Workspace> List<S> saveAll(Iterable<S> entities) {
        return saveAll(entities);
    }

    @Override
    public Optional<Workspace> findById(String s) {
        return Optional.of(mongoTemplate.findById(s, Workspace.class));
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Workspace> findAll() {
        return mongoTemplate.findAll(Workspace.class);
    }

    @Override
    public Iterable<Workspace> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(s)), Workspace.class);
    }

    @Override
    public void delete(Workspace entity) {
        mongoTemplate.remove(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends Workspace> entities) {

    }

    @Override
    public void deleteAll() {
        mongoTemplate.dropCollection(Workspace.class);
    }

    @Override
    public List<Workspace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Workspace> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Workspace> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Workspace> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Workspace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Workspace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Workspace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Workspace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Workspace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Workspace> boolean exists(Example<S> example) {
        return mongoTemplate.exists(Query.query(Criteria.where("id").is(example.getProbe().getId())), Workspace.class);
    }
}
