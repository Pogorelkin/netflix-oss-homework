package com.epam.hw.netflix.controllers

import com.epam.hw.netflix.api.WorkspaceAPI
import com.epam.hw.netflix.services.EmployeeService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employees")
class EmployeeAPIController {
    org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeAPIController.class)

    @Autowired
    EmployeeService employeeService

    @Autowired
    WorkspaceAPI workspaceAPIClient

    @RequestMapping("/{id}")
    def describeEmployee(@PathVariable("id") String id) {
        def employee = employeeService.findEmployee(id)
        logger.info("employee service found employee " + employee.toString())
        [
                id       : employee.id,
                firstName: employee.firstName,
                lastName : employee.lastName,
                email    : employee.email,
                workspace: workspaceAPIClient.getWorkspaceById(id)
        ]
    }

    @RequestMapping("/max")
    def findMax() {
        def employee = employeeService.findMaxEmployee()
        [
                id       : employee.id,
                firstName: employee.firstName,
                lastName : employee.lastName,
                email    : employee.email,
                workspace: workspaceAPIClient.getWorkspaceById(id)
        ]
    }

    @RequestMapping("find/{id}/{name}")
    def findByIdAndName(@PathVariable("id") String id, @PathVariable("name") String name) throws RuntimeException {
        def employee = employeeService.findByIdAndName(id, name)
        [
                id       : employee.id,
                firstName: employee.firstName,
                lastName : employee.lastName,
                email    : employee.email,
                workspace: workspaceAPIClient.getWorkspaceById(id)
        ]
    }

    @RequestMapping("/avg")
    def findAvg() {
        [avgEmployeeId: employeeService.findAvgId()]
    }

    @RequestMapping("/all")
    def findAll(){
        return employeeService.findAll();
    }
}
