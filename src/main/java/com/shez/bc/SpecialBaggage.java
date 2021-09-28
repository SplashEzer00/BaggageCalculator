package main.java.com.shez.bc;
/**
 * 特殊包裹，继承自普通包裹
 * 但是由于特殊包裹的尺寸不计入计算，所以都设置为一个为60，其他的设置为0
 */
public class SpecialBaggage extends Baggage{

    public static String[] AllType ={
            "可免费运输的特殊行李",
            "高尔夫球包、保龄球、滑翔伞/降落伞、滑雪/滑水用具（不包括雪橇/水撬）、轮滑/滑板用具、潜水用具、射箭用具、曲棍球用具、冰球用具、网球用具、登山用具、自行车",
            "皮划艇/独木舟、悬挂式滑翔运动用具、雪橇/水撬、冲浪板、风帆冲浪用具、橡皮艇或船",
            "撑杆、标枪、单独包装的划船用具或浆、骑马用具",
            "睡袋、背包、野营用具、渔具、乐器、辅助设备（非残疾、伤、病旅客托运）、可折叠婴儿床、可折叠婴儿车或婴儿摇篮或婴儿汽车安全座椅（非婴儿旅客托运）",
            "小型电器或仪器、媒体设备",
            "可作为行李运输的枪支",
            "可作为行李运输的子弹",
            "小动物（仅限家庭驯养的猫、狗） 注：每个容器的总重量（包括其中的小动物及水与食物的重量）"
    };

    private String type;
    public SpecialBaggage(float weight, String type) {

        super(60.f, 0.f, 0.f, weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "特殊行李：" + type +
                ", " + weight +
                "kg \n";
    }

    /**
     * 判断特殊行李是否能够托运
     * @param specialBaggage  需要进行托运的行李
     * @param ticket  乘客的机票
     * @return boolean 类型，如果为true则为能够托运，否则为不能托运
     */
   public static boolean isCanConsign(SpecialBaggage specialBaggage,Ticket ticket){
       float w = specialBaggage.getWeight();

       if (SpecialBaggage.AllType[0].equals(specialBaggage.getType())) {
            //可免费运输的产品,不需要管重量
            return true;
       }else if (SpecialBaggage.AllType[1].equals(specialBaggage.getType())){
            //高尔夫球包、保龄球、滑翔伞/降落伞、滑雪/滑水用具（不包括雪橇/水撬）、轮滑/滑板用具、潜水用具、射箭用具、曲棍球用具、冰球用具、网球用具、登山用具、自行车
           if (2<=w && w<=32)
               return true;
       }else if (SpecialBaggage.AllType[2].equals(specialBaggage.getType())){
            //皮划艇/独木舟、悬挂式滑翔运动用具、雪橇/水撬、冲浪板、风帆冲浪用具、橡皮艇或船
           if (2<=w && w<=45)
               return true;
       }else if (SpecialBaggage.AllType[3].equals(specialBaggage.getType())){
           //撑杆、标枪、单独包装的划船用具或浆、骑马用具
           if (2<=w && w<=45)
               return true;
       }else if (SpecialBaggage.AllType[4].equals(specialBaggage.getType())){
           //睡袋、背包、野营用具、渔具、乐器、辅助设备（非残疾、伤、病旅客托运）、可折叠婴儿床、可折叠婴儿车或婴儿摇篮或婴儿汽车安全座椅（非婴儿旅客托运）
           if (2<=w && w<=32)
               return true;
       }else if (SpecialBaggage.AllType[5].equals(specialBaggage.getType())){
            //小型电器或仪器、媒体设备
           if (2<=w && w<=32)
               return true;
       }else if (SpecialBaggage.AllType[6].equals(specialBaggage.getType())){
            //可作为行李运输的枪支
           if (2<=w && w<=32)
               return true;
       }else if (SpecialBaggage.AllType[7].equals(specialBaggage.getType())){
            //可作为行李运输的子弹
           if (2<=w && w<=5)
               return true;
       }else if (SpecialBaggage.AllType[8].equals(specialBaggage.getType())){
           //小动物（仅限家庭驯养的猫、狗） 注：每个容器的总重量（包括其中的小动物及水与食物的重量）
           if (2<=w && w<=32)
               return true;
       }
       return false;
    }
}
