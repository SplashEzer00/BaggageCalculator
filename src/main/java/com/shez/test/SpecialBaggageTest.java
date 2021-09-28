package main.java.com.shez.test;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import main.java.com.shez.bc.*;

@RunWith(DataProviderRunner.class)
public class SpecialBaggageTest {
    /***
     * 测试 SpecialBaggage里面的IsCanConsign()函数，
     * 函数的功能：用于判断特殊的行李是否能够托运
     */
    @DataProvider
    public static Object[][] IsCanConsignData() {
        return new Object[][]{
                //黑盒测试
                //免费托运特殊行李
                {new SpecialBaggage (100, SpecialBaggage.AllType[0]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //高尔夫球包、保龄球、滑翔伞/降落伞、滑雪/滑水用具（不包括雪橇/水撬）、轮滑/滑板用具、潜水用具、射箭用具、曲棍球用具、冰球用具、网球用具、登山用具、自行车
                {new SpecialBaggage (30, SpecialBaggage.AllType[1]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[1]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (33, SpecialBaggage.AllType[1]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //皮划艇/独木舟、悬挂式滑翔运动用具、雪橇/水撬、冲浪板、风帆冲浪用具、橡皮艇或船
                {new SpecialBaggage (2, SpecialBaggage.AllType[2]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[2]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (46, SpecialBaggage.AllType[2]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //撑杆、标枪、单独包装的划船用具或浆、骑马用具
                {new SpecialBaggage (2, SpecialBaggage.AllType[3]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[3]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (46, SpecialBaggage.AllType[3]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //睡袋、背包、野营用具、渔具、乐器、辅助设备（非残疾、伤、病旅客托运）、可折叠婴儿床、可折叠婴儿车或婴儿摇篮或婴儿汽车安全座椅（非婴儿旅客托运）
                {new SpecialBaggage (2, SpecialBaggage.AllType[4]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[4]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (33, SpecialBaggage.AllType[4]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //小型电器或仪器、媒体设备
                {new SpecialBaggage (2, SpecialBaggage.AllType[5]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[5]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (33, SpecialBaggage.AllType[5]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //可作为行李运输的枪支
                {new SpecialBaggage (2, SpecialBaggage.AllType[6]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[6]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (33, SpecialBaggage.AllType[6]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //可作为行李运输的子弹
                {new SpecialBaggage (2, SpecialBaggage.AllType[7]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[7]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (6, SpecialBaggage.AllType[7]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //小动物（仅限家庭驯养的猫、狗） 注：每个容器的总重量（包括其中的小动物及水与食物的重量
                {new SpecialBaggage (2, SpecialBaggage.AllType[8]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (1, SpecialBaggage.AllType[8]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                {new SpecialBaggage (33, SpecialBaggage.AllType[8]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},

                //边界值分析
                //高尔夫球包、保龄球、滑翔伞/降落伞、滑雪/滑水用具（不包括雪橇/水撬）、轮滑/滑板用具、潜水用具、射箭用具、曲棍球用具、冰球用具、网球用具、登山用具、自行车
                {new SpecialBaggage (2, SpecialBaggage.AllType[1]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (32, SpecialBaggage.AllType[1]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //皮划艇/独木舟、悬挂式滑翔运动用具、雪橇/水撬、冲浪板、风帆冲浪用具、橡皮艇或船
                {new SpecialBaggage (2, SpecialBaggage.AllType[2]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (45, SpecialBaggage.AllType[2]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //撑杆、标枪、单独包装的划船用具或浆、骑马用具
                {new SpecialBaggage (2, SpecialBaggage.AllType[3]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (45, SpecialBaggage.AllType[3]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //睡袋、背包、野营用具、渔具、乐器、辅助设备（非残疾、伤、病旅客托运）、可折叠婴儿床、可折叠婴儿车或婴儿摇篮或婴儿汽车安全座椅（非婴儿旅客托运）
                {new SpecialBaggage (2, SpecialBaggage.AllType[4]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (32, SpecialBaggage.AllType[4]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //小型电器或仪器、媒体设备
                {new SpecialBaggage (2, SpecialBaggage.AllType[5]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (32, SpecialBaggage.AllType[5]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //可作为行李运输的枪支
                {new SpecialBaggage (2, SpecialBaggage.AllType[6]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (32, SpecialBaggage.AllType[6]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //可作为行李运输的子弹
                {new SpecialBaggage (2, SpecialBaggage.AllType[7]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (5, SpecialBaggage.AllType[7]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //小动物（仅限家庭驯养的猫、狗） 注：每个容器的总重量（包括其中的小动物及水与食物的重量
                {new SpecialBaggage (2, SpecialBaggage.AllType[8]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                {new SpecialBaggage (32, SpecialBaggage.AllType[8]),
                        new Ticket (Ticket.Regional[5],Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
        };
    }

    @Test
    @UseDataProvider("IsCanConsignData")
    public void isCanConsign(SpecialBaggage specialBaggage,Ticket ticket,boolean expectedResult) {
        Assert.assertEquals(SpecialBaggage.isCanConsign(specialBaggage, ticket),expectedResult);
    }
}