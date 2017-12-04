package xmu.javaee.classmanager.coursems.controller;

import org.springframework.web.bind.annotation.*;
import xmu.javaee.classmanager.coursems.vo.output.Group;
import xmu.javaee.classmanager.coursems.vo.output.Topic;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GroupController {
    @RequestMapping(value = "/group/{groupID}")
    public Group getGroupWithID(@PathVariable Integer groupID, HttpServletRequest request) {
        Group group = MockDb.getGroupWithID(groupID, request.getHeader("id"));
        return group;
    }

    @PutMapping(value = "/group/{groupID}")
    public void modifyGroup(@PathVariable Integer groupID, @RequestBody Group group) {
        boolean success = MockDb.modifyGroup(groupID, group);
    }

    @PostMapping(value = "/group/{groupID}/topic")
    public void chooseToopic(@PathVariable Integer groupID, @RequestBody Topic topic) {
        boolean success = MockDb.chooseTopic(groupID, topic);
    }
}
