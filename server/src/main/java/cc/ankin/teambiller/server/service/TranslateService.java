package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.service.SettingService;
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

    public Client createClient() throws Exception {
        String accessKeyId = settingService.getString("aliyun.accessKeyId");
        String accessKeySecret = settingService.getString("aliyun.accessKeySecret");

        Config config = new com.aliyun.teaopenapi.models.Config().setAccessKeyId(accessKeyId).setAccessKeySecret(accessKeySecret);
        config.endpoint = endpoint;
        return new Client(config);
    }

    public String translate(String text) throws Exception {
        Client client = createClient();
        TranslateGeneralRequest request = new com.aliyun.alimt20181012.models.TranslateGeneralRequest()
                .setFormatType("text")
                .setSourceLanguage(sourceLanguage)
                .setTargetLanguage(targetLanguage)
                .setSourceText(text)
                .setScene("general");
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            TranslateGeneralResponse response = client.translateGeneralWithOptions(request, runtime);
            return response.body.data.translated;
        } catch (TeaException e) {
            return "ERROR: " + e.message;
        }catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }
}
