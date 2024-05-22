package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpotController {

	private static final Map<String, String[]> spotData = new HashMap<>();

    static {
        spotData.put("北海道", new String[]{"大通公園・さっぽろテレビ塔","JRタワー展望室T38","北海道庁旧本庁舎","札幌市時計台","サッポロビール博物館"});
        spotData.put("青森県", new String[]{"弘前城","奥入瀬渓流","十和田湖","十二湖","八甲田樹氷（八甲田スキー場）"});
        spotData.put("岩手県", new String[]{"小岩井農場まきば園","浄土ヶ浜","中尊寺","花巻温泉","フラワー＆ガーデン森の風"});
        spotData.put("宮城県", new String[]{"定禅寺通","秋保大滝","瑞鳳殿","ユアテックスタジアム仙台","松島"});
        spotData.put("秋田県", new String[]{"田沢湖","角館 武家屋敷通り","乳頭温泉郷","なまはげ館","大湯環状列石"});
        spotData.put("山形県", new String[]{"山寺","蔵王温泉","銀山温泉","御釜","鶴岡市立加茂水族館"});
        spotData.put("福島県", new String[]{"大内宿","五色沼","花見山公園","鶴ヶ城","アクアマリンふくしま"});
        spotData.put("茨城県", new String[]{"国営ひたち海浜公園","筑波山","神磯の鳥居","袋田の滝","五浦海岸と六角堂"});
        spotData.put("栃木県", new String[]{"那須ハイランドパーク","那須ロープウェイ","那須どうぶつ王国","那須高原　りんどう湖ファミリー牧場","ハンターマウンテン塩原"});
        spotData.put("群馬県", new String[]{"湯畑（草津温泉）","河鹿橋","富岡製糸場","妙義神社","榛名神社"});
        spotData.put("埼玉県", new String[]{"三峯神社","川越氷川神社","メッツァビレッジ","ムーミンバレーパーク","角川武蔵野ミュージアム"});
        spotData.put("千葉県", new String[]{"東京ディズニーランド","木更津温泉　龍宮城スパ・ホテル三日月","鴨川シーワールド","成田山新勝寺","東京ドイツ村"});
        spotData.put("東京都", new String[]{"浅草寺・雷門・仲見世","今戸神社","東京スカイツリー","すみだ江戸切子館","江戸東京博物館"});
        spotData.put("神奈川県",new String[]{"横浜赤レンガ倉庫・赤レンガパーク","よこはまコスモワールド","横浜ランドマークタワー","横浜中華街","カップヌードルミュージアム 横浜"});
        spotData.put("新潟県", new String[]{"フォッサマグナミュージアム","道の駅 マリンドリーム能生","糸魚川　親不知海岸","上越五智　居多神社"});
        spotData.put("富山県", new String[]{"黒部ダム","立山黒部アルペンルート","雪の大谷","立山博物館","みくりが池"});
        spotData.put("石川県", new String[]{"兼六園","金沢21世紀美術館","金沢城公園","近江町市場","ひがし茶屋街"});
        spotData.put("福井県", new String[]{"大本山 永平寺","福井県立恐竜博物館","東尋坊","瓜割の滝","白山平泉寺"});
        spotData.put("山梨県", new String[]{"河口湖","富岳風穴・鳴沢氷穴","山中湖","忍野八海","富士山"});
        spotData.put("長野県", new String[]{"善光寺","地獄谷野猿公苑","松本城","上田城","軽井沢"});
        spotData.put("岐阜県", new String[]{"新穂高ロープウェイ","白川郷合掌造り集落","飛騨高山の古い町並","下呂温泉","徹夜おどり (郡上おどり)"});
        spotData.put("静岡県", new String[]{"熱海サンビーチ","來宮神社","大室山","伊豆シャボテン動物公園","伊豆ぐらんぱる公園"});
        spotData.put("愛知県", new String[]{"レゴランド®・ジャパン","金シャチ横丁","名古屋城","名古屋港水族館","国宝犬山城"});
        spotData.put("三重県", new String[]{"伊勢神宮","志摩スペイン村","鈴鹿サーキット","なばなの里","伊勢内宮前 おかげ横丁"});
        spotData.put("滋賀県", new String[]{"琵琶湖","比叡山延暦寺","近江八幡水郷めぐり","安土城跡","彦根城"});
        spotData.put("京都府", new String[]{"清水寺","二寧坂・産寧坂・清水坂","高台寺","八坂神社","八坂庚申堂"});
        spotData.put("大阪府", new String[]{"大阪城天守閣","大阪ステーションシティ","HEP FIVE","梅田スカイビル 空中庭園展望台","大阪天満宮"});
        spotData.put("兵庫県", new String[]{"城崎温泉","城崎マリンワールド","湯村温泉","竹田城跡","生野銀山"});
        spotData.put("奈良県", new String[]{"東大寺","奈良公園","興福寺","ならまち","元興寺"});
        spotData.put("和歌山県", new String[]{"和歌山城","ポルトヨーロッパ","友ヶ島","加太海水浴場","淡嶋神社"});
        spotData.put("鳥取県", new String[]{"鳥取砂丘","浦富海岸","とっとり花回廊","三徳山","三朝温泉"});
        spotData.put("島根県", new String[]{"出雲大社","日御碕神社","須佐神社","稲佐の浜","石見銀山遺跡"});
        spotData.put("岡山県", new String[]{"岡山城","岡山後楽園","吉備津神社","最上稲荷","おかやま魚島横丁"});
        spotData.put("広島県", new String[]{"嚴島神社","宮島水族館","宮浜温泉","原爆ドーム","おりづるタワー"});
        spotData.put("山口県", new String[]{"角島大橋","元乃隅神社","長門湯本温泉","錦帯橋","萩城下町"});
        spotData.put("徳島県", new String[]{"鳴門の渦潮","大塚国際美術館","四国八十八ヶ所1番札所 霊山寺","賀川豊彦記念館","妙見山公園"});
        spotData.put("香川県", new String[]{"金刀比羅宮","エンジェルロード","屋島","鬼ヶ島大洞窟","栗林公園"});
        spotData.put("愛媛県", new String[]{"道後温泉本館","来島海峡大橋","松山城","石鎚山","石手寺"});
        spotData.put("高知県", new String[]{"桂浜","高知城","はりまや橋","四万十川","足摺岬"});
        spotData.put("福岡県", new String[]{"糸島","太宰府天満宮・九州国立博物館","柳川","門司港レトロ","宮地嶽神社"});
        spotData.put("佐賀県", new String[]{"古湯温泉","三重津海軍所跡","呼子朝市","虹の松原","七ツ釜"});
        spotData.put("長崎県", new String[]{"ハウステンボス","平和公園、長崎原爆資料館","グラバー園、オランダ坂","稲佐山","軍艦島"});
        spotData.put("熊本県", new String[]{"熊本城","阿蘇山","大観峰","黒川温泉","イルカマリンワールド"});
        spotData.put("大分県", new String[]{"由布岳","金鱗湖","湯の坪街道","やまなみハイウェイ","COMICO ART MUSEUM YUFUIN"});
        spotData.put("宮崎県", new String[]{"高千穂峡","天安河原","サンメッセ日南","綾の照葉大吊橋","生駒高原"});
        spotData.put("鹿児島県", new String[]{"桜島","仙巌園","霧島神宮","丸尾の滝","パノラマパーク西原台"});
        spotData.put("沖縄県", new String[]{"万座毛","沖縄美ら海水族館","備瀬のフクギ並木","ナゴパイナップルパーク","識名園"});
    }


    @GetMapping("/spot")
    public String getSpot(@RequestParam String prefecture, Model model) {
        String[] spot = spotData.getOrDefault(prefecture, new String[]{});
        model.addAttribute("prefecture", prefecture);
        model.addAttribute("spot", spot);
        return "Spot"; // Gourmet.htmlを返す

    }
}
