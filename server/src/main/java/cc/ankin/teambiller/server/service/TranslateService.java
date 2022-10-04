package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.service.SettingService;
import cc.ankin.teambiller.server.utils.exception.ClientException;
import com.aliyun.alimt20181012.Client;
import com.aliyun.alimt20181012.models.TranslateGeneralRequest;
import com.aliyun.alimt20181012.models.TranslateGeneralResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TranslateService {
    @Resource
    private SettingService settingService;
    String endpoint = "mt.aliyuncs.com";
    String sourceLanguage = "en";
    String targetLanguage = "zh";
    Integer limit = 256; // 0 means no limit

    public Client createClient() throws Exception {
        String accessKeyId = settingService.getString("aliyun.accessKeyId");
        String accessKeySecret = settingService.getString("aliyun.accessKeySecret");

        Config config = new com.aliyun.teaopenapi.models.Config().setAccessKeyId(accessKeyId).setAccessKeySecret(accessKeySecret);
        config.endpoint = endpoint;
        return new Client(config);
    }

    public String translate(String source) throws RuntimeException {
        if (source.length() > limit && limit != 0) {
            throw new ClientException("翻译文本长度不能超过" + limit + "个字符");
        }
        if (source.length() == 0) {
            throw new ClientException("翻译文本不能为空");
        }

        try {
            Client client = createClient();
            TranslateGeneralRequest request = new com.aliyun.alimt20181012.models.TranslateGeneralRequest()
                    .setFormatType("text")
                    .setSourceLanguage(sourceLanguage)
                    .setTargetLanguage(targetLanguage)
                    .setSourceText(source)
                    .setScene("general");
            com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();

            TranslateGeneralResponse response = client.translateGeneralWithOptions(request, runtime);
            return response.body.data.translated;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
