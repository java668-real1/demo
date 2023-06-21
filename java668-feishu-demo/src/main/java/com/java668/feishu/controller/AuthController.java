package com.java668.feishu.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry.chen
 * @desc
 * @date 2023/06/15 17:16
 **/
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping
public class AuthController {

    @RequestMapping("/get_appid")
    public ResponseEntity<Map<String, Object>> getAppid() {
        Map<String, Object> result = new HashMap<>();
        result.put("appid", "cli_a400c7b3bbff500e");
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/callback")
    public ResponseEntity<JSONObject> callback(@RequestParam("code") String code) {
        return ResponseEntity.ok(access_token(code));
    }

    // https://open.feishu.cn/open-apis/auth/v3/app_access_token/internal
    // {
    //     "code": 0,
    //     "msg": "success",
    //     "app_access_token": "a-6U1SbDiM6XIH2DcTCPyeub",
    //     "expire": 7140
    // }
    private String internalToken() {
        Map<String, Object> result = new HashMap<>();
        result.put("app_id", "cli_a400c7b3bbff500e");
        result.put("app_secret", "dlaqyQ1ctl4LhnjjPzDPmg6pk7HDRVki");
        String app_access_token = HttpRequest.post("https://open.feishu.cn/open-apis/auth/v3/app_access_token/internal")
                .body(JSONUtil.toJsonStr(result))
                .execute().body();
        JSONObject parse = JSONUtil.parseObj(app_access_token);
        String app_access_token1 = parse.getStr("app_access_token");
        return app_access_token1;
    }
//    https://open.feishu.cn/open-apis/authen/v1/access_token
//    {
//        "grant_type":"authorization_code",
//            "code":"xMSldislSkdK"
//    }
//{
//    "code": 0,
//        "msg": "success",
//        "data": {
//    "access_token": "u-Q7JWnaIM_kRChuLfreHmpArjOEayt.5XUBJcZr.V0Gst4FdQCtvrd9sAViLXQnQgkpL19brGOjKZQTxb",
//            "token_type": "Bearer",
//            "expires_in": 7140,
//            "name": "zhangsan",
//            "en_name": "Three Zhang",
//            "avatar_url": "www.feishu.cn/avatar/icon",
//            "avatar_thumb": "www.feishu.cn/avatar/icon_thumb",
//            "avatar_middle": "www.feishu.cn/avatar/icon_middle",
//            "avatar_big": "www.feishu.cn/avatar/icon_big",
//            "open_id": "ou_caecc734c2e3328a62489fe0648c4b98779515d3",
//            "union_id": "on_d89jhsdhjsajkda7828enjdj328ydhhw3u43yjhdj",
//            "email": "zhangsan@feishu.cn",
//            "enterprise_email": "demo@mail.com",
//            "user_id": "5d9bdxxx",
//            "mobile": "+86130002883xx",
//            "tenant_key": "736588c92lxf175d",
//            "refresh_expires_in": 2591940,
//            "refresh_token": "ur-oQ0mMq6MCcueAv0pwx2fQQhxqv__CbLu6G8ySFwafeKww2Def2BJdOkW3.9gCFM.LBQgFri901QaqeuL"
//}
//}

    private JSONObject access_token(String code) {
        Map<String, Object> result = new HashMap<>();
        result.put("grant_type", "authorization_code");
        result.put("code", code);
        String app_access_token = HttpRequest.post("https://open.feishu.cn/open-apis/authen/v1/access_token")
                .header("Authorization", "Bearer " + internalToken())
                .body(JSONUtil.toJsonStr(result))
                .execute().body();
        JSONObject parse = JSONUtil.parseObj(app_access_token);
        return parse.getJSONObject("data");
    }

}