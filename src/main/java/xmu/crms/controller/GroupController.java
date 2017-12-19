package xmu.crms.controller;

import org.springframework.web.bind.annotation.*;
import xmu.crms.coursems.vo.output.Group;
import xmu.crms.coursems.vo.output.Topic;

import javax.servlet.http.HttpServletRequest;

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
