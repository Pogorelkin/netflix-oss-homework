package com.epam.hw.netflix.dao;

import com.epam.hw.netflix.domain.Workspace;

import java.util.List;

public interface WorkspacesDAO {
    void create(Workspace workspace);

    List<Workspace> findAll();

    Workspace findById(String s);

    void update(Workspace workspace);

    void delete(Workspace workspace);

    void deleteCollection(String collection);
}
