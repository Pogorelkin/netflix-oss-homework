package com.epam.hw.netflix.services;

import com.epam.hw.netflix.dao.WorkspacesDAO;
import com.epam.hw.netflix.domain.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.epam.hw.netflix.domain.OSFamily.*;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.UUID.randomUUID;

@Service
public class WorkplaceService {
    @Autowired
    WorkspacesDAO workspacesDAO;

    private final List<Workspace> workspaces = newArrayList(
            new Workspace("0000001", 1, 1, randomUUID().toString(), WINDOWS),
            new Workspace("0000002", 1, 2, randomUUID().toString(), WINDOWS),
            new Workspace("0000003", 1, 3, randomUUID().toString(), WINDOWS),
            new Workspace("0000004", 1, 4, randomUUID().toString(), OSX),
            new Workspace("0000005", 1, 5, randomUUID().toString(), OSX),
            new Workspace("0000006", 1, 6, randomUUID().toString(), OSX),
            new Workspace("0000007", 1, 7, randomUUID().toString(), WINDOWS),
            new Workspace("0000008", 2, 1, randomUUID().toString(), WINDOWS),
            new Workspace("0000009", 2, 2, randomUUID().toString(), WINDOWS),
            new Workspace("0000010", 2, 3, randomUUID().toString(), OSX),
            new Workspace("0000011", 2, 4, randomUUID().toString(), OSX),
            new Workspace("0000012", 2, 5, randomUUID().toString(), WINDOWS),
            new Workspace("0000013", 2, 6, randomUUID().toString(), WINDOWS),
            new Workspace("0000014", 2, 7, randomUUID().toString(), LINUX),
            new Workspace("0000015", 2, 9, randomUUID().toString(), LINUX)
    );

    public Workspace findWorkspace(String id) {
        return workspacesDAO.findById(id);
    }

    @PostConstruct
    private void init() {
        System.out.println("insert init values");
        workspacesDAO.deleteCollection();
        workspaces.forEach(e -> workspacesDAO.create(e));
    }
}
