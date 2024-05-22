package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GourmetController {

    private static final Map<String, String[]> gourmetData = new HashMap<>();
    @Autowired
    PrifDataRepo repo;
    static {
        gourmetData.put("北海道", new String[]{"ジンギスカン","北海道ラーメン","スープカレー"});
        gourmetData.put("青森県", new String[]{"せんべい汁","貝焼き味噌","十和田バラ焼き"});
        gourmetData.put("岩手県", new String[]{"わんこそば","盛岡冷麺","じゃじゃ麺"});
        gourmetData.put("宮城県", new String[]{"牛タン","ずんだ餅","せり鍋"});
        gourmetData.put("秋田県", new String[]{"稲庭うどん","きりたんぽ","横手焼きそば"});
        gourmetData.put("山形県", new String[]{"芋煮","山形ラーメン","米沢牛"});
        gourmetData.put("福島県", new String[]{"喜多方ラーメン","いかにんじん","田楽"});
        gourmetData.put("茨城県", new String[]{"茨城の鯉","けんちんうどん","ほしいも"});
        gourmetData.put("栃木県", new String[]{"宇都宮餃子","佐野ラーメン","けんちん汁"});
        gourmetData.put("群馬県", new String[]{"水沢うどん","焼きまんじゅう","ひもかわうどん"});
        gourmetData.put("埼玉県", new String[]{"さといも","クワイ","深谷ねぎ"});
        gourmetData.put("千葉県", new String[]{"神戸レタス","こまち","ホワイト餃子"});
        gourmetData.put("東京都", new String[]{"月島もんじゃ","八王子ラーメン","くさや"});
        gourmetData.put("神奈川県", new String[]{"しらす","鯛めし","サンマーメン"});
        gourmetData.put("新潟県", new String[]{"いももち","めかぶ","へぎそば"});
        gourmetData.put("富山県", new String[]{"富山ブラックラーメン","氷見うどん","ますのすし"});
        gourmetData.put("石川県", new String[]{"金沢カレー","治部煮","ずいき"});
        gourmetData.put("福井県", new String[]{"黒龍","ボルガライス","甘エビ"});
        gourmetData.put("山梨県", new String[]{"ほうとう","吉田うどん","みみ"});
        gourmetData.put("長野県", new String[]{"そばがき","戸隠そば","野沢菜"});
        gourmetData.put("岐阜県", new String[]{"元気玉","飛騨牛","富有柿"});
        gourmetData.put("静岡県", new String[]{"浜松餃子","ひつまぶし","ニジマス"});
        gourmetData.put("愛知県", new String[]{"味噌煮込みうどん","手羽先","台湾ラーメン"});
        gourmetData.put("三重県", new String[]{"伊勢うどん","松坂牛","赤福氷"});
        gourmetData.put("滋賀県", new String[]{"じゅんじゅん","近江牛","近江ちゃんぽん"});
        gourmetData.put("京都府", new String[]{"京都ラーメン","湯豆腐","冬瓜"});
        gourmetData.put("大阪府", new String[]{"イカ焼き","ねぎ焼き","どて焼き"});
        gourmetData.put("兵庫県", new String[]{"明石焼き","揖保の糸","神戸牛"});
        gourmetData.put("奈良県", new String[]{"にゅうめん","奈良ラーメン","ほうれんそう"});
        gourmetData.put("和歌山県", new String[]{"和歌山ラーメン","クエ","めはり寿司"});
        gourmetData.put("鳥取県", new String[]{"岩牡蠣","モサエビ","ながいも"});
        gourmetData.put("島根県", new String[]{"芋煮","出雲そば","しじみ汁"});
        gourmetData.put("岡山県", new String[]{"岡山ラーメン","ぶっかけうどん","津山ホルモンうどん"});
        gourmetData.put("広島県", new String[]{"尾道ラーメン","汁なし担々麺","わけぎ"});
        gourmetData.put("山口県", new String[]{"獺祭","瓦そば","ウニ"});
        gourmetData.put("徳島県", new String[]{"徳島ラーメン","すだち","阿波尾鶏"});
        gourmetData.put("香川県", new String[]{"オリーブ","讃岐うどん","たこ飯"});
        gourmetData.put("愛媛県", new String[]{"すいか","ポポー","イワナ"});
        gourmetData.put("高知県", new String[]{"文旦","おくら","かつお"});
        gourmetData.put("福岡県", new String[]{"水炊き","博多ラーメン","ちまき"});
        gourmetData.put("佐賀県", new String[]{"春一番（たまねぎ）","アイスプラント","カマス"});
        gourmetData.put("長崎県", new String[]{"佐世保バーガー","長崎ちゃんぽん","トルコライス"});
        gourmetData.put("熊本県", new String[]{"ヤーコン","熊本ラーメン","菊芋"});
        gourmetData.put("大分県", new String[]{"すっぽん","サフラン","とり天"});
        gourmetData.put("宮崎県", new String[]{"チキン南蛮","肉巻きおにぎり","日向夏"});
        gourmetData.put("鹿児島県", new String[]{"白くま","鹿児島ラーメン","きびなご"});
        gourmetData.put("沖縄県", new String[]{"ゴーヤ","パイナップル","タコス"});
    }


    @GetMapping("/gourmet")
    public String getGourmet(@RequestParam String prefecture, Model model) {
        String[] gourmet = gourmetData.getOrDefault(prefecture, new String[]{});
        model.addAttribute("prefecture", prefecture);
        model.addAttribute("gourmet", gourmet);
        return "Gourmet"; // Gourmet.htmlを返す

    }
 
    @GetMapping("/add")
    public String getGourmets(Model model) {
    	PrifData data = new PrifData("オランダ","TULI"); //データ追加で日本語にするとエラーになる
    	repo.save(data);
        return "Check";

    }
}
