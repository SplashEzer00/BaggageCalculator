package main.java.com.shez.bc;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    static RegionalCharges []regionalCharges = new RegionalCharges[]{
      new RegionalCharges(new int[]{380,980,980,1400,1400,2000,3000}),//区域一：超重23-28 超重28-32 超长158-203 超重超长 超数1 超数2 超数3
      new RegionalCharges(new int[]{280,690,690,1100,1100,1100,1590}),//区域二：超重23-28 超重28-32 超长158-203 超重超长 超数1 超数2 超数3
      new RegionalCharges(new int[]{520,520,520,520,1170,1170,1590}),//区域三：超重超长 超重超长 超重超长 超重超长 超数1 超数2 超数3
      new RegionalCharges(new int[]{690,1040,1040,2050,1380 ,1380 ,1590}),//区域四：超重23-28 超重28-32 超长158-203 超重超长 超数1 超数2 超数3
      new RegionalCharges(new int[]{210 ,520,520,830,830,1100 ,1590}),//区域五：超重23-28 超重28-32 超长158-203 超重超长 超数1 超数2 超数3
    };

    /***
     * 计算托运行李费用
     * @param baggages   托运的行李
     * @param ticket    乘客的机票
     * @return  需要支付的费用，如果是 -0.1说明计算出现问题
     */
    public static float CalculateValue(List<Baggage> baggages,List<SpecialBaggage>specialBaggages, Ticket ticket){
        float cost = 0.f;
        //判断是国内托运还是国外托运
        if (ticket.getFlightType()==FlightType.DOMESTIC){
            //国内托运
            cost = CalculateDomestic(baggages,specialBaggages, ticket);
        }else if (ticket.getFlightType()==FlightType.INTERNATIONAL){
            //国外托运
            cost = CalculateInterbational(baggages,specialBaggages, ticket);
        }
        return cost;
    }

    /**
     * 计算国内行李托运需要的费用
     * @param baggages   需要计算的行李,这里默认行李是符合标准可以托运的
     * @param specialBaggages  需要计算的特殊行李,这里默认行李是符合标准可以托运的
     * @param ticket    乘客的机票
     * @return  需要支付的费用
     */
    public static float CalculateDomestic(List<Baggage> baggages,List<SpecialBaggage>specialBaggages, Ticket ticket){
        if (baggages==null||specialBaggages==null||ticket==null)
            return -1.f;
        float cost =0.f;
        float SumofWeight = 0.f;

        //普通行李
        for (Baggage baggage:baggages){
            //三边总和
            float s = baggage.getHeight()+baggage.getWidth()+baggage.getLength();
            //每件重量
            float w = baggage.getWeight();
            //超过尺寸
            if (158<s)
                cost+=0.015f*ticket.price;
            //悦享经济舱、超级经济舱、经济舱判断超重
            if(ticket.getClassType()==ClassType.Economy_Class.Leisure_Economy_Class||ticket.getClassType()==ClassType.Economy_Class.Super_Economy_Class||ticket.getClassType()==ClassType.Economy_Class.Economy_Class ){
                if (w>23)
                    cost +=0.015f*ticket.price;
            }
            //计算总重量
            SumofWeight += baggage.getWeight();
        }

        //特殊行李
        for (SpecialBaggage specialBaggage:specialBaggages){
            float w = specialBaggage.getWeight();
            if (SpecialBaggage.AllType[0].equals(specialBaggage.getType())) {
                //可免费运输的产品
            }else if (SpecialBaggage.AllType[1].equals(specialBaggage.getType())){
                //高尔夫球包、保龄球、滑翔伞/降落伞、滑雪/滑水用具（不包括雪橇/水撬）、轮滑/滑板用具、潜水用具、射箭用具、曲棍球用具、冰球用具、网球用具、登山用具、自行车
                SumofWeight+=w;
            }else if (SpecialBaggage.AllType[2].equals(specialBaggage.getType())){
                //皮划艇/独木舟、悬挂式滑翔运动用具、雪橇/水撬、冲浪板、风帆冲浪用具、橡皮艇或船
                if (2<=w && w<=23)
                    cost+=2600;
                else if (23<w && w<=32)
                    cost+=3900;
                else if (32<w && w<=45)
                    cost+=5200;
                else
                    return -1.f;
            }else if (SpecialBaggage.AllType[3].equals(specialBaggage.getType())){
                //撑杆、标枪、单独包装的划船用具或浆、骑马用具
                if (2<=w && w<=23)
                    cost+=1300;
                else if (23<w && w<=32)
                    cost+=2600;
                else if (32<w && w<=45)
                    cost+=3900;
                else
                    return -1.f;
            }else if (SpecialBaggage.AllType[4].equals(specialBaggage.getType())){
                //睡袋、背包、野营用具、渔具、乐器、辅助设备（非残疾、伤、病旅客托运）、可折叠婴儿床、可折叠婴儿车或婴儿摇篮或婴儿汽车安全座椅（非婴儿旅客托运）
                SumofWeight+=w;
            }else if (SpecialBaggage.AllType[5].equals(specialBaggage.getType())){
                //小型电器或仪器、媒体设备
                if (2<=w && w<=23)
                    cost+=490;
                else if (23<w && w<=32)
                    cost+=3900;
                else
                    return -1.f;
            }else if (SpecialBaggage.AllType[6].equals(specialBaggage.getType())){
                //可作为行李运输的枪支
                if (2<=w && w<=23)
                    cost+=1300;
                else if (23<w && w<=32)
                    cost+=2600;
                else
                    return -1.f;
            }else if (SpecialBaggage.AllType[7].equals(specialBaggage.getType())){
                //可作为行李运输的子弹
                if (2<=w && w<=5)
                    cost+=1300;
                else
                    return -1.f;
            }else if (SpecialBaggage.AllType[8].equals(specialBaggage.getType())){
                //小动物（仅限家庭驯养的猫、狗） 注：每个容器的总重量（包括其中的小动物及水与食物的重量）
                if (2<=w && w<=8)
                    cost+=3900;
                else if (8<w && w<=23)
                    cost+=5200;
                else if (23<w && w<=32)
                    cost+=7800;
                else
                    return -1.f;
            }
        }

        //免费总重量
        float allowWeight = 0.f;
        //免费一：
        //判断成员是成人或者儿童
        if (ticket.getPassengerClass()==PassengerType.ADULT||ticket.getPassengerClass()==PassengerType.CHILDREN){
            if (ticket.getClassType()==ClassType.First_Class||ticket.getClassType()==ClassType.Deluxe_First_Class)//头等舱
                allowWeight+=40.f;
            else if(ticket.getClassType()==ClassType.Business_Class)//公务舱
                allowWeight+=30.f;
            else if (ticket.getClassType()==ClassType.Economy_Class||ticket.getClassType()==ClassType.Super_Economy_Class||ticket.getClassType()==ClassType.Leisure_Economy_Class)//经济舱
                allowWeight+=20.f;
        }else{
            //说明为婴儿票
            allowWeight +=10.f;
        }

        //免费二：
        switch (ticket.getVipType()){
            case Phoenix_CompanionLifetime_Platinum_Card://凤凰知音终身白金卡
            case Platinum_Card://白金卡旅客
                allowWeight+=30.f;
                break;
            case Phoenix_Companion_Gold_Card://凤凰知音金卡
            case Star_Alliance_Gold_Card://星空联盟金卡
            case Silver_Card://银卡
                allowWeight+=20.f;
                break;
        }
        if (SumofWeight>allowWeight)
            cost+= ticket.getPrice()*(SumofWeight-allowWeight)*0.015f;
        return cost;
    }

    /***
     * 计算国际行李托运所需要的费用
     * @param baggages   需要计算的行李,这里默认行李是符合标准可以托运的
     * @param specialBaggages  需要计算的特殊行李,这里默认行李是符合标准可以托运的
     * @param ticket    乘客的机票
     * @return  需要支付的费用
     */
    public static float CalculateInterbational(List<Baggage> baggages,List<SpecialBaggage>specialBaggages, Ticket ticket){
        if (baggages==null||specialBaggages==null||ticket==null)
            return -1.f;

        int allowCount = 0;//允许行李数量
        float allweight = 0.f;//总重量
        float cost = 0.f;//总花费
        int regionIndex = judgeRegionalType(ticket);//区域
        switch (ticket.getClassType()){
            //持成人或儿童客票的头等舱、公务舱
            case Deluxe_First_Class:
            case First_Class:
            case Business_Class:
                if (ticket.getPassengerClass()==PassengerType.ADULT||ticket.getPassengerClass()==PassengerType.CHILDREN) {
                    allowCount += 2;
                    allweight += 32.f;
                }
                break;
            //悦享经济舱、超级经济舱
            case Leisure_Economy_Class:
            case Super_Economy_Class:
                allowCount += 2;
                allweight += 23.f;
                break;
            //经济舱
            case Economy_Class:
                allweight+=23.f;
                //分地区进行免费件数的设置
                if (regionIndex==0 || regionIndex==4){
                    allowCount+=1;
                }else if (regionIndex==1 || regionIndex==2 || regionIndex==3){
                    allowCount+=2;
                }
                break;
        }

        int i=0;
        for (Baggage baggage:baggages) {
            if (i<allowCount){
                //在允许的免费额度中
                if (baggage.getWeight()>allweight){
                    cost+=excessCalculate(baggage, regionIndex);
                }
            }else if (i<allowCount+1){
                //超过1件
                cost+=regionalCharges[regionIndex].getCharges()[4];
                cost+=excessCalculate(baggage, regionIndex); //超尺寸或超重量需另行支付并叠加计算费用
            }else if (i<allowCount+2){
                //超过两件
                cost+=regionalCharges[regionIndex].getCharges()[5];
                cost+=excessCalculate(baggage, regionIndex);
            }else {
                //超出的第三件及以上行李
                cost+=regionalCharges[regionIndex].getCharges()[6];
                cost+=excessCalculate(baggage, regionIndex);
            }
            i++;
        }

        //特殊行李
        for (SpecialBaggage specialBaggage:specialBaggages){
            float w = specialBaggage.getWeight();
            if (SpecialBaggage.AllType[0].equals(specialBaggage.getType())) {
                //可免费运输的特殊行李
            }else if (SpecialBaggage.AllType[1].equals(specialBaggage.getType())){
                //高尔夫球包、保龄球、滑翔伞/降落伞、滑雪/滑水用具（不包括雪橇/水撬）、轮滑/滑板用具、潜水用具、射箭用具、曲棍球用具、冰球用具、网球用具、登山用具、自行车
                if (i<allowCount){
                    if (specialBaggage.getWeight()>allweight){
                        cost+=excessCalculate(specialBaggage, regionIndex);
                    }
                }else if (i==allowCount){
                    //超过1件
                    cost+=regionalCharges[regionIndex].getCharges()[4];
                    cost+=excessCalculate(specialBaggage, regionIndex); //(超尺寸或超重量需另行支付并叠加计算费用
                }else if (i==allowCount+1){
                    //超过2件
                    cost+=regionalCharges[regionIndex].getCharges()[5];
                    cost+=excessCalculate(specialBaggage, regionIndex); //(超尺寸或超重量需另行支付并叠加计算费用
                }else{
                    //超出的第3件及以上行李
                    cost+=regionalCharges[regionIndex].getCharges()[6];
                    cost+=excessCalculate(specialBaggage, regionIndex); //(超尺寸或超重量需另行支付并叠加计算费用
                }
                i++;
            }else if (SpecialBaggage.AllType[2].equals(specialBaggage.getType())){
                //皮划艇/独木舟、悬挂式滑翔运动用具、雪橇/水撬、冲浪板、风帆冲浪用具、橡皮艇或船
                if (2<=w && w<=23)
                    cost+=2600;
                else if (23<w && w<=32)
                    cost+=3900;
                else if (32<w && w<=45)
                    cost+=5200;
                else
                    return -1;
            }else if (SpecialBaggage.AllType[3].equals(specialBaggage.getType())){
                //撑杆、标枪、单独包装的划船用具或浆、骑马用具
                if (2<=w && w<=23)
                    cost+=1300;
                else if (23<w && w<=32)
                    cost+=2600;
                else if (32<w && w<=45 )
                    cost+=3900;
                else
                    return -1;
            }else if (SpecialBaggage.AllType[4].equals(specialBaggage.getType())){
                //睡袋、背包、野营用具、渔具、乐器、辅助设备（非残疾、伤、病旅客托运）、可折叠婴儿床、可折叠婴儿车或婴儿摇篮或婴儿汽车安全座椅（非婴儿旅客托运）
                if (i<allowCount){
                    if (specialBaggage.getWeight()>allweight){
                        cost+=excessCalculate(specialBaggage, regionIndex);
                    }
                }else if (i==allowCount){
                    //超过1件
                    cost+=regionalCharges[regionIndex].getCharges()[4];
                    cost+=excessCalculate(specialBaggage, regionIndex); //(超尺寸或超重量需另行支付并叠加计算费用
                }else if (i==allowCount+1){
                    //超过2件
                    cost+=regionalCharges[regionIndex].getCharges()[5];
                    cost+=excessCalculate(specialBaggage, regionIndex); //(超尺寸或超重量需另行支付并叠加计算费用
                }else{
                    //超出的第3件及以上行李
                    cost+=regionalCharges[regionIndex].getCharges()[6];
                    cost+=excessCalculate(specialBaggage, regionIndex); //(超尺寸或超重量需另行支付并叠加计算费用
                }
                i++;
            }else if (SpecialBaggage.AllType[5].equals(specialBaggage.getType())){
                //小型电器或仪器、媒体设备
                if (2<=w && w<=23)
                    cost+=490;
                else if (23<w && w<=32)
                    cost+=3900;
                else
                    return -1;
            }else if (SpecialBaggage.AllType[6].equals(specialBaggage.getType())){
                //可作为行李运输的枪支
                if (2<=w && w<=23)
                    cost+=1300;
                else if (23<w && w<=32)
                    cost+=2600;
                else
                    return -1;
            }else if (SpecialBaggage.AllType[7].equals(specialBaggage.getType())){
                //可作为行李运输的子弹
                if (2<=w && w<=5)
                    cost+=1300;
                else
                    return -1;
            }else if (SpecialBaggage.AllType[8].equals(specialBaggage.getType())){
                //小动物（仅限家庭驯养的猫、狗） 注：每个容器的总重量（包括其中的小动物及水与食物的重量）
                if (2<=w && w<=8)
                    cost+=3900;
                else if (8<w && w<=23)
                    cost+=5200;
                else if (23<w && w<=32)
                    cost+=7800;
                else
                    return -1;
            }
        }
        return cost;
    }

    /***
     * 划分区域
     * @param ticket
     * @return 区域号
     */
    static int judgeRegionalType(Ticket ticket){
        if (Ticket.Regional[0].equals(ticket.getArea())) {
            return 0;
        } else if (Ticket.Regional[1].equals(ticket.getArea())) {
            return 1;
        } else if (Ticket.Regional[2].equals(ticket.getArea())) {
            return 2;
        } else if (Ticket.Regional[3].equals(ticket.getArea())) {
            return 3;
        } else if (Ticket.Regional[4].equals(ticket.getArea())) {
            return 4;
        }
        return -1;
    }

    /***
     * 国际托运计算额外价格
     * @param baggage
     * @param regionIndex   地区下标
     * @return  需要缴纳的费用
     */
    public static float excessCalculate(Baggage baggage,int regionIndex){
        //三边总和
        float sumofLong = baggage.getHeight()+baggage.getWidth()+baggage.getLength();
        //每件重量
        float w = baggage.getWeight();
        if (23<baggage.getWeight() && baggage.getWeight()<=28 && 60<=sumofLong && sumofLong<=158){
            //超重类型1但不超尺寸
            return regionalCharges[regionIndex].getCharges()[0];
        }else if (28<baggage.getWeight() && baggage.getWeight()<=32 && 60<=sumofLong && sumofLong<=158){
            //超重类型2但不超尺寸
            return regionalCharges[regionIndex].getCharges()[1];
        }else if (2<baggage.getWeight() && baggage.getWeight()<=23 && 158<=sumofLong && sumofLong<=203){
            //不超重量但超尺寸
            return regionalCharges[regionIndex].getCharges()[2];
        }else if (23<baggage.getWeight() && baggage.getWeight()<=32 && 158<=sumofLong && sumofLong<=203){
            //超重且超尺寸
            return regionalCharges[regionIndex].getCharges()[3];
        }

        //几种特殊情况
        if (w<2||w>32)
            return -1.f;
        if (sumofLong<60||sumofLong>203)
            return -1.f;
        if (regionIndex<0||regionIndex>=5)
            return -1.f;
        return 0.f;
    }

    public static void main(String[] args) {
        List<Baggage> baggages2 = new ArrayList<Baggage>();
        baggages2.add(new Baggage(60,38,60,24));
        List<SpecialBaggage>specialBaggages2=new ArrayList<SpecialBaggage>();
        specialBaggages2.add(new SpecialBaggage(5, SpecialBaggage.AllType[0]));
        Ticket ticket2 =new Ticket(Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Leisure_Economy_Class,VIPType.Ordinary);
        CalculateDomestic(baggages2, specialBaggages2, ticket2);
    }
}

