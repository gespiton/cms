package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmu.javaee.classmanager.coursems.vo.output.Group;

import javax.servlet.http.HttpServletRequest;

@RestController
public class GroupController {
    @RequestMapping(value = "/group/{groupID}")
    public Group getGroupWithID(@PathVariable Integer groupID, HttpServletRequest request) {


        Group group = MockDb.getGroupWithID(groupID, request.getHeader("id"));
        return group;
    }

}
