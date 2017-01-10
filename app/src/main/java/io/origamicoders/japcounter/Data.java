package io.origamicoders.japcounter;

import java.util.ArrayList;

import io.origamicoders.japcounter.Classes.Header;
import io.origamicoders.japcounter.Classes.JapCounter;
import io.origamicoders.japcounter.Classes.JapWord;
import io.origamicoders.japcounter.Classes.Word;

/**
 * Created by DM036497 on 1/3/2017.
 */

public class Data {

    public static ArrayList<JapCounter> japCounters = new ArrayList<>();

    public static ArrayList<JapCounter> getJapCounters(){
        System.out.println(Data.japCounters.size());

        if (Data.japCounters.size() != 0){
            return Data.japCounters;
        }

        ArrayList<JapCounter> japCounters = new ArrayList<>();

        Header header1 = new Header("Living Things");
        JapWord example = new JapWord("はやくて あかい ねこ は あおい いぬ を たべました", "",
                "hayakute akai neko ha aoi inu wo tabemashita", "The quick red cat ate the blue dog.");

        Word japW = new Word("ば", "場",  "ba");
        ArrayList<String> uses = new ArrayList<>();
        uses.add(0, "Scene of a play");
        JapCounter jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ばい", "倍",  "bai");
        uses = new ArrayList<>();
        uses.add(0, "Multiples");
        uses.add(0, " -fold as in \"twofold\"");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ばん", "晩",  "ban");
        uses = new ArrayList<>();
        uses.add(0, "Nights (see also: ya)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ばん", "番",  "ban");
        uses = new ArrayList<>();
        uses.add(0, "Position");
        uses.add(0, " platform for a train line");
        uses.add(0, " turn");
        uses.add(0, " sports matches");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("び", "尾",  "bi");
        uses = new ArrayList<>();
        uses.add(0, "Small fish and shrimps (used in the fish trade; most people say hiki instead)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ぶ", "部",  "bu");
        uses = new ArrayList<>();
        uses.add(0, "Copies of a magazine or newspaper");
        uses.add(0, " or other packets of papers");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ぶん", "文",  "bun");
        uses = new ArrayList<>();
        uses.add(0, "Sentences");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("びょう", "秒",  "byou");
        uses = new ArrayList<>();
        uses.add(0, "Seconds");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ちゃく", "着",  "chaku");
        uses = new ArrayList<>();
        uses.add(0, "Suits of clothing (see also: mai)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ちょう", "挺",  "chou");
        uses = new ArrayList<>();
        uses.add(0, "Guns");
        uses.add(0, " sticks of ink");
        uses.add(0, " palanquins");
        uses.add(0, " rickshaws");
        uses.add(0, " violins");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ちょう", "丁",  "chou");
        uses = new ArrayList<>();
        uses.add(0, "Tools");
        uses.add(0, " scissors");
        uses.add(0, " saws");
        uses.add(0, " trousers");
        uses.add(0, " pistols");
        uses.add(0, " cakes of tofu");
        uses.add(0, " town blocks");
        uses.add(0, " servings at a restaurant");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ちょう", "町",  "chou");
        uses = new ArrayList<>();
        uses.add(0, "Town blocks");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("だい", "代",  "dai");
        uses = new ArrayList<>();
        uses.add(0, "Generations");
        uses.add(0, " historical periods");
        uses.add(0, " reigns");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("だい", "台",  "dai");
        uses = new ArrayList<>();
        uses.add(0, "Cars");
        uses.add(0, " bicycles");
        uses.add(0, " machines");
        uses.add(0, " mechanical devices");
        uses.add(0, " household appliances");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("だん", "段",  "dan");
        uses = new ArrayList<>();
        uses.add(0, "levels");
        uses.add(0, " ranks");
        uses.add(0, " steps (of stairs).");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("だんらく", "段落",  "danraku");
        uses = new ArrayList<>();
        uses.add(0, "Paragraphs");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ど/also", "度",  "do/たび");
        uses = new ArrayList<>();
        uses.add(0, "Occurrences");
        uses.add(0, " number of times");
        uses.add(0, " degrees of temperature or angle (see also: kai).");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ふで", "筆",  "fude");
        uses = new ArrayList<>();
        uses.add(0, "Sequences of letters or drawings that you write or draw without removing your pen off the paper. Not to be confused with \"hitsu\" (筆) below.");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ふく/ぷく", "服",  "fuku/puku");
        uses = new ArrayList<>();
        uses.add(0, "Bowls of matcha (powdered green tea); packets or doses of powdered medicine; puffs (of");
        uses.add(0, " e.g.");
        uses.add(0, " a cigarette); rests or breaks");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ふく/ぷく", "幅",  "fuku/puku");
        uses = new ArrayList<>();
        uses.add(0, "Hanging scrolls (kakejiku)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ふん/ぷん", "分",  "fun/pun");
        uses = new ArrayList<>();
        uses.add(0, "Minutes");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ふり", "振",  "furi");
        uses = new ArrayList<>();
        uses.add(0, "Swords");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("がっきゅう", "学級",  "gakkyuu");
        uses = new ArrayList<>();
        uses.add(0, "Classes (in pre-university education)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("がつ/also", "月",  "gatsu/つき");
        uses = new ArrayList<>();
        uses.add(0, "Months of the year. Month-long periods when read tsuki (see also: kagetsu)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ご", "語",  "go");
        uses = new ArrayList<>();
        uses.add(0, "Words");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ごん/also", "言",  "gon/こと");
        uses = new ArrayList<>();
        uses.add(0, "Words");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ぐ", "具",  "gu");
        uses = new ArrayList<>();
        uses.add(0, "Suits of armour");
        uses.add(0, " sets of furniture");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ぎょう", "行",  "gyou");
        uses = new ArrayList<>();
        uses.add(0, "Lines of text");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("はく", "泊",  "haku");
        uses = new ArrayList<>();
        uses.add(0, "Nights of a stay");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("はい/ぱい/ばい", "杯",  "hai/pai/bai");
        uses = new ArrayList<>();
        uses.add(0, "Cups and glasses of drink");
        uses.add(0, " spoonfuls");
        uses.add(0, " cuttlefish");
        uses.add(0, " octopuses");
        uses.add(0, " crabs");
        uses.add(0, " squid");
        uses.add(0, " abalone");
        uses.add(0, " boats (slang)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("はい", "敗",  "hai");
        uses = new ArrayList<>();
        uses.add(0, "Losses (sports bouts)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("はこ", "箱",  "hako");
        uses = new ArrayList<>();
        uses.add(0, "Boxes");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("はり", "張",  "hari");
        uses = new ArrayList<>();
        uses.add(0, "Umbrellas");
        uses.add(0, " parasols");
        uses.add(0, " tents");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("はしら", "柱",  "hashira");
        uses = new ArrayList<>();
        uses.add(0, "gods");
        uses.add(0, " memorial tablets");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("はつ/ぱつ", "発",  "hatsu/patsu");
        uses = new ArrayList<>();
        uses.add(0, "Gunshots");
        uses.add(0, " bullets");
        uses.add(0, " aerial fireworks; orgasms");
        uses.add(0, " sex acts");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ひき/ぴき", "匹",  "hiki/piki");
        uses = new ArrayList<>();
        uses.add(0, "Small animals");
        uses.add(0, " insects");
        uses.add(0, " fish");
        uses.add(0, " reptiles");
        uses.add(0, " amphibians");
        uses.add(0, " oni (ogres)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ひん/ぴん", "品",  "hin/pin");
        uses = new ArrayList<>();
        uses.add(0, "Parts of a meal");
        uses.add(0, " courses (see also: shina)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ひつ/ぴつ", "筆",  "hitsu/pitsu");
        uses = new ArrayList<>();
        uses.add(0, "Pieces of land");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ほ/ぽ", "歩",  "ho/po");
        uses = new ArrayList<>();
        uses.add(0, "Number of (foot)steps");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ほん/ぽん/ぼん", "本",  "hon/pon/bon");
        uses = new ArrayList<>();
        uses.add(0, "Long");
        uses.add(0, " thin objects: rivers");
        uses.add(0, " roads");
        uses.add(0, " train tracks");
        uses.add(0, " ties");
        uses.add(0, " pencils");
        uses.add(0, " bottles");
        uses.add(0, " guitars; also");
        uses.add(0, " metaphorically");
        uses.add(0, " telephone calls (see also: tsuuwa)");
        uses.add(0, " train or bus routes");
        uses.add(0, " movies");
        uses.add(0, " home runs");
        uses.add(0, " points or bounds[clarification needed] in sports events. Although 本 also means \"book\"");
        uses.add(0, " the counter for books is satsu.");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ひょう/ぴょう", "票",  "hyou/pyou");
        uses = new ArrayList<>();
        uses.add(0, "Votes");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ひょうし/びょうし", "拍子",  "hyoushi/byoushi");
        uses = new ArrayList<>();
        uses.add(0, "Musical beats");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("じ", "字",  "ji");
        uses = new ArrayList<>();
        uses.add(0, "Letters");
        uses.add(0, " kanji");
        uses.add(0, " kana");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("じ", "児",  "ji");
        uses = new ArrayList<>();
        uses.add(0, "Children. As in \"father of two (children)\"");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("じ", "時",  "ji");
        uses = new ArrayList<>();
        uses.add(0, "Hours of the day");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("じかん", "時間",  "jikan");
        uses = new ArrayList<>();
        uses.add(0, "Hour-long periods");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("じょう", "畳",  "jou");
        uses = new ArrayList<>();
        uses.add(0, "Tatami mats. The kanji 畳 is also read tatami and is the same one used for the mats. The room size of a washitsu in Japan is given as a number of mats");
        uses.add(0, " for example 4½ yo jou han");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("じょう", "錠",  "jou");
        uses = new ArrayList<>();
        uses.add(0, "Pills/capsules");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("じょう", "条",  "jou");
        uses = new ArrayList<>();
        uses.add(0, "Articles of law");
        uses.add(0, " thin objects");
        uses.add(0, " rays or streams of light");
        uses.add(0, " streaks of smoke or lightning");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("か", "日",  "ka");
        uses = new ArrayList<>();
        uses.add(0, "Day of the month");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("か", "架",  "ka");
        uses = new ArrayList<>();
        uses.add(0, "Frames");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("か", "課",  "ka");
        uses = new ArrayList<>();
        uses.add(0, "Lessons");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かぶ", "株",  "kabu");
        uses = new ArrayList<>();
        uses.add(0, "Stocks; nursery trees");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かげつ", "ヶ月, 箇月",  "kagetsu");
        uses = new ArrayList<>();
        uses.add(0, "Month-long periods (see also: gatsu). 箇 is normally abbreviated using a small katakana ヶ in modern Japanese. Alternatively 個");
        uses.add(0, " hiragana か");
        uses.add(0, " small katakana ヵ and full-size katakana カ & ケ can also be seen");
        uses.add(0, " although only か is similarly frequent.");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かい", "回",  "kai");
        uses = new ArrayList<>();
        uses.add(0, "Occurrences");
        uses.add(0, " number of times (see also: do)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かい/がい", "階",  "kai/gai");
        uses = new ArrayList<>();
        uses.add(0, "Number of floors");
        uses.add(0, " storeys");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かこく", "ヶ国, 箇国",  "kakoku");
        uses = new ArrayList<>();
        uses.add(0, "Countries");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かこくご", "ヶ国語, 箇国語",  "kakokugo");
        uses = new ArrayList<>();
        uses.add(0, "(National) languages");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かく", "画",  "kaku");
        uses = new ArrayList<>();
        uses.add(0, "Strokes in kanji");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かん", "貫",  "kan");
        uses = new ArrayList<>();
        uses.add(0, "Pieces of nigiri-zushi");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("かん", "艦",  "kan");
        uses = new ArrayList<>();
        uses.add(0, "Warships");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("けいとう", "系統",  "keitou");
        uses = new ArrayList<>();
        uses.add(0, "Bus routes");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("けん", "件",  "ken");
        uses = new ArrayList<>();
        uses.add(0, "Abstract matters and cases");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("けん/げん", "軒",  "ken/gen");
        uses = new ArrayList<>();
        uses.add(0, "Houses");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("き", "機",  "ki");
        uses = new ArrayList<>();
        uses.add(0, "Aircraft");
        uses.add(0, " machines");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("き", "基",  "ki");
        uses = new ArrayList<>();
        uses.add(0, "Graves");
        uses.add(0, " wreaths");
        uses.add(0, " CPUs");
        uses.add(0, " reactors");
        uses.add(0, " elevators");
        uses.add(0, " dams");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("きん", "斤",  "kin");
        uses = new ArrayList<>();
        uses.add(0, "Loaves of bread");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("きれ", "切れ",  "kire");
        uses = new ArrayList<>();
        uses.add(0, "Slices (of bread");
        uses.add(0, " cake");
        uses.add(0, " sashimi etc.)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("こ", "個, 箇, 个, or ヶ",  "ko");
        uses = new ArrayList<>();
        uses.add(0, "General measure word");
        uses.add(0, " used when there is no specific counter. 個 is also used for military units.");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("こ", "戸",  "ko");
        uses = new ArrayList<>();
        uses.add(0, "Houses (戸 means \"door\")");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("こう", "校",  "kou");
        uses = new ArrayList<>();
        uses.add(0, "Schools");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("こう", "稿",  "kou");
        uses = new ArrayList<>();
        uses.add(0, "Drafts of a manuscript");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("こう", "行",  "kou");
        uses = new ArrayList<>();
        uses.add(0, "Banks");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("こま", "齣, コマ",  "koma");
        uses = new ArrayList<>();
        uses.add(0, "Frames");
        uses.add(0, " panels. 齣 is virtually unused nowadays.");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("こん", "献",  "kon");
        uses = new ArrayList<>();
        uses.add(0, "shots (of drink)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("く", "区",  "ku");
        uses = new ArrayList<>();
        uses.add(0, "Sections");
        uses.add(0, " city districts");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("く", "句",  "ku");
        uses = new ArrayList<>();
        uses.add(0, "Haiku");
        uses.add(0, " senryuu");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("くち", "口",  "kuchi");
        uses = new ArrayList<>();
        uses.add(0, "(Bank) accounts");
        uses.add(0, " donations (口 means \"opening\" or \"entrance\")");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("くみ", "組",  "kumi");
        uses = new ArrayList<>();
        uses.add(0, "Groups");
        uses.add(0, " a pair of people (twins");
        uses.add(0, " a husband and a wife");
        uses.add(0, " dancers");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("くらす", "クラス",  "kurasu");
        uses = new ArrayList<>();
        uses.add(0, "School classes");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("きゃく", "脚",  "kyaku");
        uses = new ArrayList<>();
        uses.add(0, "Desks");
        uses.add(0, " chairs");
        uses.add(0, " long-stemmed glasses");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("きゃく", "客",  "kyaku");
        uses = new ArrayList<>();
        uses.add(0, "Pairs of cup and saucer");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("きょく", "曲",  "kyoku");
        uses = new ArrayList<>();
        uses.add(0, "Pieces of music");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("きょく", "局",  "kyoku");
        uses = new ArrayList<>();
        uses.add(0, "Board game matches (chess");
        uses.add(0, " igo");
        uses.add(0, " shogi");
        uses.add(0, " mahjong); radio stations");
        uses.add(0, " television stations");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("まい", "枚",  "mai");
        uses = new ArrayList<>();
        uses.add(0, "Thin");
        uses.add(0, " flat objects");
        uses.add(0, " sheets of paper");
        uses.add(0, " photographs");
        uses.add(0, " plates");
        uses.add(0, " articles of clothing (see also: chaku)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("まき", "巻",  "maki");
        uses = new ArrayList<>();
        uses.add(0, "Rolls");
        uses.add(0, " scrolls");
        uses.add(0, " kan for volumes of book");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("まく", "幕",  "maku");
        uses = new ArrayList<>();
        uses.add(0, "Theatrical acts");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("めい", "名",  "mei");
        uses = new ArrayList<>();
        uses.add(0, "People (polite) (名 means \"name\")");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("めん", "面",  "men");
        uses = new ArrayList<>();
        uses.add(0, "Mirrors");
        uses.add(0, " boards for board games (chess");
        uses.add(0, " igo");
        uses.add(0, " shogi)");
        uses.add(0, " stages of computer games");
        uses.add(0, " walls of a room");
        uses.add(0, " tennis courts");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("もん", "門",  "mon");
        uses = new ArrayList<>();
        uses.add(0, "Cannons");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("もん", "問",  "mon");
        uses = new ArrayList<>();
        uses.add(0, "Questions");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ねん", "年",  "nen");
        uses = new ArrayList<>();
        uses.add(0, "Years");
        uses.add(0, " school years (grades); not years of age");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("にち", "日",  "nichi");
        uses = new ArrayList<>();
        uses.add(0, "Days of the month (but see table of exceptions below)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("にん", "人",  "nin");
        uses = new ArrayList<>();
        uses.add(0, "People (but see table of exceptions below)");
        jap = new JapCounter(japW, uses);
        jap.addonetoten(new JapWord("ひとり", "一人", "hitori", "1 Person"));
        jap.addonetoten(new JapWord("ふたり", "二人", "futari", "2 Persons"));
        jap.addonetoten(new JapWord("さんにん", "三人", "sannin", "3 Persons"));
        jap.addonetoten(new JapWord("よにん", "四人", "yonin", "4 Persons"));
        jap.addonetoten(new JapWord("ごにん", "五人", "gonin", "5 Persons"));
        jap.addonetoten(new JapWord("ろくにん", "六人", "rokunin", "6 Persons"));
        jap.addonetoten(new JapWord("しちにん", "七人", "shichinin", "7 Persons"));
        jap.addonetoten(new JapWord("はちにん", "八人", "hachinin", "8 Persons"));
        jap.addonetoten(new JapWord("きゅうにん", "九人", "kyuunin", "9 Persons"));
        jap.addonetoten(new JapWord("じゅうにん", "十人", "juunin", "10 Persons"));
        japCounters.add(jap);


        japW = new Word("にんまえ", "人前",  "ninmae");
        uses = new ArrayList<>();
        uses.add(0, "Food portions (without exceptions");
        uses.add(0, " unlike nin above)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("おり", "折",  "ori");
        uses = new ArrayList<>();
        uses.add(0, "Boxes made of folded paper (compare to hako above");
        uses.add(0, " which refers to boxes in general)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ぺーじ", "ページ, 頁",  "pēji");
        uses = new ArrayList<>();
        uses.add(0, "Pages");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("れい", "例",  "rei");
        uses = new ArrayList<>();
        uses.add(0, "Cases");
        uses.add(0, " Examples");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("れい", "礼",  "rei");
        uses = new ArrayList<>();
        uses.add(0, "Bows during worship at a shrine");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("り", "り or 人",  "ri");
        uses = new ArrayList<>();
        uses.add(0, "People");
        uses.add(0, " used in the words 一人 (ひとり) and 二人 (ふたり).");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("りん", "輪",  "rin");
        uses = new ArrayList<>();
        uses.add(0, "Wheels");
        uses.add(0, " Flowers");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("りょう", "両",  "ryou");
        uses = new ArrayList<>();
        uses.add(0, "Railway cars");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("さい", "才 or 歳",  "sai");
        uses = new ArrayList<>();
        uses.add(0, "Years of age");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("さお", "棹",  "sao");
        uses = new ArrayList<>();
        uses.add(0, "Chests of drawers");
        uses.add(0, " flags");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("さつ", "冊",  "satsu");
        uses = new ArrayList<>();
        uses.add(0, "Books");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("せき", "席",  "seki");
        uses = new ArrayList<>();
        uses.add(0, "Seats");
        uses.add(0, " Rakugo shows");
        uses.add(0, " (drinking) parties");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("せき", "隻",  "seki");
        uses = new ArrayList<>();
        uses.add(0, "Ships");
        uses.add(0, " half of a pair (e.g.");
        uses.add(0, " half of a folding screen)");
        uses.add(0, " item carried in a bundle (fish");
        uses.add(0, " birds");
        uses.add(0, " arrows etc.)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("しな", "品",  "shina");
        uses = new ArrayList<>();
        uses.add(0, "Parts of a meal");
        uses.add(0, " courses (see also: hin)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("しゃ", "社",  "sha");
        uses = new ArrayList<>();
        uses.add(0, "used for businesses");
        uses.add(0, " i.e. 会社");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("しき", "式",  "shiki");
        uses = new ArrayList<>();
        uses.add(0, "Sets of things");
        uses.add(0, " such as documents or furniture");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("しょう", "勝",  "shou");
        uses = new ArrayList<>();
        uses.add(0, "Wins (sports bouts)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("しゅ", "首",  "shu");
        uses = new ArrayList<>();
        uses.add(0, "Tanka");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("しゅう", "週",  "shuu");
        uses = new ArrayList<>();
        uses.add(0, "Weeks");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("しゅるい", "種類 or 種",  "shurui");
        uses = new ArrayList<>();
        uses.add(0, "Kinds");
        uses.add(0, " species");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("そく", "足",  "soku");
        uses = new ArrayList<>();
        uses.add(0, "Pairs of footwear");
        uses.add(0, " pairs of socks");
        uses.add(0, " stockings");
        uses.add(0, " tabi");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("そう", "双",  "sou");
        uses = new ArrayList<>();
        uses.add(0, "Pairs");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("たば", "束",  "taba");
        uses = new ArrayList<>();
        uses.add(0, "bundles (of banknotes)");
        uses.add(0, " bunches (of flowers");
        uses.add(0, " vegetables)");
        uses.add(0, " sheaves");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("たい", "体",  "tai");
        uses = new ArrayList<>();
        uses.add(0, "Images");
        uses.add(0, " statues");
        uses.add(0, " person's remains");
        uses.add(0, " dolls");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("たわら", "俵",  "tawara");
        uses = new ArrayList<>();
        uses.add(0, "Bags of rice");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("てき", "滴",  "teki");
        uses = new ArrayList<>();
        uses.add(0, "Drops of liquid");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("てん", "点",  "ten");
        uses = new ArrayList<>();
        uses.add(0, "Points");
        uses.add(0, " dots");
        uses.add(0, " pieces of a set");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("とう", "頭",  "tou");
        uses = new ArrayList<>();
        uses.add(0, "Large animals");
        uses.add(0, " cattle");
        uses.add(0, " elephants");
        uses.add(0, " whales");
        uses.add(0, " dolphins");
        uses.add(0, " butterflies (頭 means \"head\")");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("とき", "時",  "toki");
        uses = new ArrayList<>();
        uses.add(0, "Time periods");
        uses.add(0, " a sixth of either day or night (in the traditional");
        uses.add(0, " obsolete way of telling time). See also: jikan");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("とおり", "通り",  "touri");
        uses = new ArrayList<>();
        uses.add(0, "Combinations");
        uses.add(0, " puzzle solutions");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("つ", "つ",  "tsu");
        uses = new ArrayList<>();
        uses.add(0, "Used as part of the indigenous Japanese numbers 一つ");
        uses.add(0, " 二つ");
        uses.add(0, " 三つ etc.");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("つう", "通",  "tsuu");
        uses = new ArrayList<>();
        uses.add(0, "Letters");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("つぼ", "坪",  "tsubo");
        uses = new ArrayList<>();
        uses.add(0, "Commonly used unit of area equal to 3.3 square metres.");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("つぶ", "粒",  "tsubu");
        uses = new ArrayList<>();
        uses.add(0, "Almonds");
        uses.add(0, " grain");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("つうわ", "通話",  "tsuuwa");
        uses = new ArrayList<>();
        uses.add(0, "Telephone calls (see also: hon)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("わ/ば/ぱ", "羽",  "wa/ba/pa");
        uses = new ArrayList<>();
        uses.add(0, "Birds");
        uses.add(0, " rabbits 羽 means \"feather\" or \"wing.\"");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("わ", "把",  "wa");
        uses = new ArrayList<>();
        uses.add(0, "Bundles");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("わ", "話",  "wa");
        uses = new ArrayList<>();
        uses.add(0, "Stories");
        uses.add(0, " episodes of TV series");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("や", "夜",  "ya");
        uses = new ArrayList<>();
        uses.add(0, "Nights (see also: ban)");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);

        japW = new Word("ぜん", "膳",  "zen");
        uses = new ArrayList<>();
        uses.add(0, "Pairs of chopsticks; bowls of rice");
        jap = new JapCounter(japW, uses);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        jap.addexample(example);
        japCounters.add(jap);        Data.japCounters = japCounters;
        return japCounters;
    }

    public static ArrayList<String> get_Num( int i){
        ArrayList<String> res = new ArrayList<>();
        switch(i){
            case 1:
                res.add("一");
                res.add("いち");
                res.add("ichi");
                return res;
            case 2:
                res.add("二");
                res.add("に");
                res.add("ni");
                return res;
            case 3:
                res.add("三");
                res.add("さん");
                res.add("san");
                return res;
            case 41:
                res.add("四");
                res.add("し/よん");
                res.add("shi/yon");
                return res;
            case 4:
                res.add("四");
                res.add("よん");
                res.add("yon");
                return res;
            case 5:
                res.add("五");
                res.add("ご");
                res.add("go");
                return res;
            case 6:
                res.add("六");
                res.add("ろく");
                res.add("roku");
                return res;
            case 71:
                res.add("七");
                res.add("なな/しち");
                res.add("nana/shichi");
                return res;
            case 7:
                res.add("七");
                res.add("なな");
                res.add("nana");
                return res;
            case 8:
                res.add("八");
                res.add("はち");
                res.add("hachi");
                return res;
            case 91:
                res.add("九");
                res.add("きゅう/く");
                res.add("kyuu/ku");
                return res;
            case 9:
                res.add("九");
                res.add("きゅう");
                res.add("kyuu");
                return res;
            case 10:
                res.add("十");
                res.add("じゅう");
                res.add("juu");
                return res;

            default:
                res.add("");
                res.add("");
                res.add("");
                return res;





        }


    }

    public static ArrayList<JapWord> getNumbers(){
        ArrayList<JapWord> Numbers = new ArrayList<>();
        for( int i = 1; i <100; i++){
            int start = i /10;
            int end = i % 10;
            String kanji = "";
            String kana = "";
            String romaji = "";
            String english = "" + i;
            if (start >= 1){
                if (start > 1){
                    ArrayList<String> s = get_Num(start);
                    kanji += s.get(0);
                    kana += s.get(1) + " ";
                    romaji += s.get(2) + " ";
                }
                ArrayList<String> s = get_Num(10);
                kanji += s.get(0);
                kana += s.get(1) + " ";
                romaji += s.get(2) + " ";

                s = get_Num(end);
                kanji += s.get(0);
                kana += s.get(1) + " ";
                romaji += s.get(2) + " ";

            } else {

                ArrayList<String> s;
                switch (end){
                    case 4:
                        s = get_Num(41);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                        break;
                    case 7:
                        s = get_Num(71);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                        break;
                    case 9:
                        s = get_Num(91);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                        break;
                    default:
                        s = get_Num(end);
                        kanji += s.get(0);
                        kana += s.get(1);
                        romaji += s.get(2);
                }
            }

            Numbers.add(new JapWord(kana, kanji, romaji, english));


        }
        Numbers.add(new JapWord("ひゃく","百","hyaku", "100"));

        return Numbers;

    }

}
