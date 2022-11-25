package io.github.lyk98.fast;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗益宽
 * @date 2022/11/25 13:46
 */
@RestController
public class Index {
    @GetMapping("/")
    public String index() {
        return "嗨!";
    }
}
