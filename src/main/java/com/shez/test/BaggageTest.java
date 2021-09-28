package main.java.com.shez.test;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import main.java.com.shez.bc.*;

@RunWith(DataProviderRunner.class)
public class BaggageTest {
    /***
     * 测试 Baggage里面的IsCanConsign()函数，
     * 函数的功能：用于判断普通的行李是否能够托运
     */
    @DataProvider
    public static Object[][] IsCanConsignData() {
        return new Object[][]{
                //黑盒测试
                //国内托运行李尺寸以及重量均符合
                {new Baggage(50.f, 20.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国内托运行李长大于100厘米
                {new Baggage(110.f, 20.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李宽大于60厘米
                {new Baggage(50.f, 70.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李高大于40厘米
                {new Baggage(40.f, 20.f, 50.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李三边之和小于60厘米
                {new Baggage(20.f, 20.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李三边之和大于203厘米
                {new Baggage(100.f, 60.f, 43.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李重量小于2千克
                {new Baggage(50.f, 20.f, 10.f, 1.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李重量大于32千克
                {new Baggage(50.f, 20.f, 10.f, 33.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国际托运行李尺寸以及重量均符合
                {new Baggage(50.f, 20.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国际托运行李三边之和大于 158 厘米
                {new Baggage(70.f, 50.f, 40.f, 20.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国际托运行李三边之和小于60厘米
                {new Baggage(30.f, 10.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国际托运行李重量小于2千克
                {new Baggage(50.f, 20.f, 10.f, 1.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国际托运行李重量大于32千克
                {new Baggage(50.f, 20.f, 10.f, 33.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李长等于100厘米
                {new Baggage(100.f, 60.f, 30.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国内托运行李宽等于60厘米
                {new Baggage(70.f, 60.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国内托运行李高等于40厘米
                {new Baggage(40.f, 40.f, 40.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国内托运行李三边之和等于60厘米
                {new Baggage(30.f, 20.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国内托运行李三边之和等于203厘米
                {new Baggage(100.f, 60.f, 43.f, 20.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),false},
                //国内托运行李重量等于2千克
                {new Baggage(50.f, 20.f, 10.f, 2.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国内托运行李重量等于32千克
                {new Baggage(50.f, 20.f, 10.f, 32.f)
                        ,new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国际托运行李三边之和等于 158 厘米
                {new Baggage(70.f, 50.f, 38.f, 20.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国际托运行李三边之和等于60厘米
                {new Baggage(30.f, 20.f, 10.f, 20.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国际托运行李重量等于2千克
                {new Baggage(50.f, 20.f, 10.f, 2.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true},
                //国际托运行李重量等于32千克
                {new Baggage(50.f, 20.f, 10.f, 32.f)
                        ,new Ticket(Ticket.Regional[0],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary),true}
        };
    }
    @Test
    @UseDataProvider("IsCanConsignData")
    public void isCanConsign(Baggage baggage,Ticket ticket,boolean expectedResult) {
        Assert.assertEquals(Baggage.isCanConsign(baggage, ticket),expectedResult);
    }
}