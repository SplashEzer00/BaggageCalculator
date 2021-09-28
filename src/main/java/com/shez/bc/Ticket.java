package main.java.com.shez.bc;

public class Ticket {
    public static String[] Regional = {
            "区域一：美洲（除美国/加拿大外）/加勒比海地区与欧洲/非洲/中东/亚洲/西南太平洋之间的航线；",
            "区域二：欧洲/中东与非洲/亚洲/西南太平洋之间航线；日本与西南太平洋之间航线；\n" +
                    "日本/西南太平洋与亚洲（不含日本及西南太平洋）/非洲之间航线；",
            "区域三：加拿大与美洲（除美国/加拿大外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线；",
            "区域四：美国（含夏威夷）与美洲（除美国外）/加勒比海地区/欧洲/非洲/中东/亚洲/西南太平洋之间航线；",
            "区域五：非洲与亚洲（除日本外)之间航线；欧洲与中东之间航线；亚洲（除日本)内航线；美洲（除美国/加拿大）及加勒比海地区内航线；上述未列明的航线;",
            "区域六：中国"
    };
    public static String[] Country = {
            //IATA一区（TC1） 北美和南美大陆及其附近岛屿，格林兰， 百慕大、西印度群岛和加勒比海各岛屿，夏威夷岛(包括中途岛和巴尔米拉岛)0-44
            //北美0-3
            "CA加拿大","MX墨西哥","PM圣皮埃尔和密克隆岛","US美国",
            //中美4-9
            "BZ伯利兹","CR哥斯达黎加","GT危地马拉","HN洪都拉斯","NI尼加拉瓜","SV萨尔瓦多",
            //加勒比地区10-30
            "AI安圭拉","AN荷属安地列斯群岛","AG安提瓜和巴布达","AW阿鲁巴岛","BB巴巴多斯","CU古巴","DO多米尼亚共和国","DM多米尼亚","GD格林纳达",
            "GP瓜德罗普岛","JM牙买加","KN圣基茨-尼维斯","KY开曼群岛","LC圣卢西亚","MS蒙特塞拉特岛","MQ马提尼克","HT海地","TC特克斯岛和凯科斯岛",
            "TT特立尼达和多巴哥","VC圣文森特和格林纳丁斯","VG英属维尔京群岛",
            //南美31-44
            "AR阿根廷","BO玻利维亚","BR巴西","CL智利","CO哥伦比亚","EC厄瓜多尔","GF法属圭亚那","GY圭亚那","PA巴拿马","PE秘鲁","PY巴拉圭","SR苏里南",
            "UY乌拉圭","VE委内瑞拉",
            //IATA二区（TC2） 欧洲、非洲及其附属岛屿，阿森松岛和乌拉尔山以西的亚洲部分，包括伊朗和中东。45-161
            //欧洲45-96
            "AL阿尔巴尼亚","AD安道尔","AM亚美尼亚","AT奥地利","AZ阿塞拜疆","BA波斯尼亚-黑塞哥维那","BE比利时","BY白俄罗斯","BG保加利亚","CH瑞士","CY塞浦路斯",
            "CZ捷克","DE德国","DK丹麦","DZ阿尔及利亚","EE爱沙尼亚","ES西班牙(包括巴利阿里群岛和加那利群岛)","FI芬兰","FR法国","GB英国","GE格鲁吉亚","GI直布罗陀","GR希腊",
            "HU匈牙利","HR克罗地亚","IS冰岛","IE爱尔兰共和国","IT意大利","LV拉托维亚","LI列支敦士登","LT立陶宛","LU卢森堡","ME黑山","MK马其顿","MT马耳他","MD摩尔达维亚共和国",
            "MA摩洛哥","MC摩纳哥","NL荷兰","NO挪威","PL波兰","PT葡萄牙（包括亚速尔群岛和马得拉群岛）","RO罗马尼亚","RU俄罗斯(西)","SE瑞典","SM圣马力诺","SK斯洛伐克","SI斯洛文尼亚",
            "TR土耳其","RS塞尔维亚","TN突尼斯","UA乌克兰",
            //非洲97-146
            "MW马拉维","ZM赞比亚","ZW津巴布韦",
            "BI布隆迪","DJ吉布提","ER厄立特里亚","ET埃塞俄比亚","KE肯尼亚","RW卢旺达","SO索马里","TZ坦桑尼亚","UG乌干达",
            "BW博茨瓦纳","LS莱索托","MZ莫桑比克","NA纳米比亚","SZ斯威士兰","ZA南非",
            "KM科摩罗","MG马达加斯加","MU毛里求斯","RE法属留尼汪岛","SC塞舌尔","XM马约特岛",
            "AO安哥拉","BF布吉拉法索","BJ贝宁","CD刚果（金沙莎）","CM喀麦隆","CV佛得角","CF中非共和国","CG刚果（布拉柴维尔）","CI科特迪瓦","GA加蓬","GH加纳","GM冈比亚","GN几内亚",
            "GQ赤道几内亚","GW几内亚比绍","LR利比里亚","ML马里","MR毛里塔尼亚","NE尼日尔","NG尼日利亚","ST圣多美和普林西比","SL塞拉利昂","SN塞内加尔","TD乍得","TG多哥",
            "LY利比亚",
            //中东147-161
            "AE阿拉伯联合酋长国","BH巴林","EG埃及","IL以色列","IQ伊拉克","IR伊朗","JO约旦","KW科威特","LB黎巴嫩","OM阿曼",
            "QA卡塔尔","SA沙特阿拉伯","SD苏丹","SY叙利亚","YE也门共和国",
            //IATA三区（TC3） 亚洲及其附属岛屿(除去已包括在二区的部分)，东印度地区，澳大利亚，新西兰和太平洋岛屿(除去已包括在一区的部分)162-217
            //东南亚162-188
            "BN文莱","CN中国（不含香港、澳门特别行政区、中国台湾）","HK中国香港特别行政区","MO中国澳门特别行政区","TW中国台湾","FM密克罗尼西亚","GU关岛","ID印度尼西亚",
            "KG吉尔吉斯斯坦","KH柬埔寨","KZ哈萨克斯坦","LA老挝","MH马绍尔群岛",
            "MM缅甸","MN蒙古","MP北马里亚纳群岛","MY马来西亚","PH菲律宾","PW贝劳","RU俄罗斯（乌拉尔山以东）","SG新加坡",
            "TH泰国","TJ塔吉克斯坦","TL东帝汶","TM土库曼斯坦","UZ乌兹别克斯坦","VN越南",
            //南亚次大陆189-197
            "AF阿富汗","BD孟加拉","BT不丹","IN印度","MV马尔代夫","PK巴基斯坦","NP尼泊尔","LK斯里兰卡",
            //日本、韩国、朝鲜198-200
            "JP日本","KR大韩民国","KP朝鲜民主主义人民共和国",
            //西南太平洋201-217
            "AS萨摩亚","AU澳大利亚","CK库克群岛","FJ斐济","PF法属波利尼西亚","KI基里巴斯","NC新喀里多尼亚","NR瑙鲁",
            "NU纽埃","NZ新西兰","PG巴布亚新几内亚","SB所罗门群岛","TO汤加","TV图瓦卢","VU瓦努阿图",
            "WF瓦利斯岛和富图纳岛","WS萨摩亚独立州"
    };
    String start;   //起点
    String end;    //终点
    String area;   //区域
    float price;  //票价
    PassengerType passengerType;    //旅客的类型
    FlightType flightType;  //航班类型
    ClassType classType;    //机舱类型
    VIPType vipType; //会员类型

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public VIPType getVipType() {
        return vipType;
    }

    public void setVipType(VIPType vipType) {
        this.vipType = vipType;
    }

    public Ticket(String start, String end, float price, PassengerType passengerType, ClassType classType, VIPType vipType) {
        this.start = start;
        this.end = end;
        this.price = price;
        this.passengerType = passengerType;
        this.classType = classType;
        this.vipType = vipType;

        if (start.equals(Regional[5])&&end.equals(Regional[5])){
            this.flightType = FlightType.DOMESTIC;
        }else {
            this.flightType = FlightType.INTERNATIONAL;
        }
    }
    //区域，价格，旅客类型，机舱类型，VIP类型
    public Ticket(String area, float price, PassengerType passengerType, ClassType classType, VIPType vipType) {
        this.area = area;
        this.price = price;
        this.passengerType = passengerType;
        this.classType = classType;
        this.vipType = vipType;

        if (area.equals(Regional[5])){
            this.flightType = FlightType.DOMESTIC;
        }else {
            this.flightType = FlightType.INTERNATIONAL;
        }
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public float getPrice() {
        return price;
    }

    public PassengerType getPassengerClass() {
        return passengerType;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPassengerClass(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "area='" + area +
                ", price=" + price +
                ", PassengerType=" + passengerType +
                ", flightType=" + flightType +
                ", ClassType=" + classType +
                ", vipType=" + vipType +
                '}';
    }
}



