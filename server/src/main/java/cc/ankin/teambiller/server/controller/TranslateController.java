package cc.ankin.teambiller.server.controller;

import cc.ankin.teambiller.server.dto.ResponseDto;
import cc.ankin.teambiller.server.service.TranslateService;
import cc.ankin.teambiller.server.utils.ResponseUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping("/api/translate")
public class TranslateController {
    @Resource
    private TranslateService translateService;

    @RequestMapping("/translate")
    public ResponseDto translate(String source) throws RuntimeException {
        Object obj = translateService.translate(source);
        return ResponseUtils.ok(obj);
    }

}
