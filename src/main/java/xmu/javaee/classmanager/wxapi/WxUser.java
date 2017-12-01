package xmu.javaee.classmanager.wxapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Sher
 */
@RestController
@RequestMapping("api/v1/user/")
public class WxUser {

    private final RestTemplate restTemplate;

    @Autowired
    public WxUser(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public String addCourse(@RequestParam String code) {
        System.out.println("===> " + code);
        getSession(code);
        return "received code";
    }

    private WxSession getSession(String code) {
        WxSession session = restTemplate.getForObject(
                "https://api.weixin.qq.com/sns/jscode2session?" +
                        "appid=wx6ab1e6c4ae4c17ef&" +
                        "secret=3404d5c3fcfd0c557378008628c7e0d6&" +
                        "js_code=" + code +
                        "&grant_type=authorization_code", WxSession.class);
        System.out.println(session);
        return session;
    }
}
