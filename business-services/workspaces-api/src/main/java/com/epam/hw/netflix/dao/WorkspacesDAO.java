package com.epam.hw.netflix.dao;

import com.epam.hw.netflix.domain.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkspacesDAO extends MongoRepository<Workspace, String> {

}
