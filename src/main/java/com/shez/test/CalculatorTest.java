package main.java.com.shez.test;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import main.java.com.shez.bc.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class CalculatorTest {

    /***
     * 测试 Calculator里面的 CalculateDomestic()函数，
     * 函数的功能：计算国内行李托运需要的费用
     */
    @DataProvider
    public static Object[][] calculateDomesticData() {
        //白盒测试
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages1 = new ArrayList<Baggage> ();
        baggages1.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages1=new ArrayList<SpecialBaggage>();
        specialBaggages1.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        specialBaggages1.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket1 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages2 = new ArrayList<Baggage> ();
        baggages2.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages2=new ArrayList<SpecialBaggage>();
        specialBaggages2.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket2 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,特殊行李参数不符合规则
        List<Baggage> baggages3 = new ArrayList<Baggage> ();
        baggages3.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages3=new ArrayList<SpecialBaggage>();
        specialBaggages3.add(new SpecialBaggage(1, SpecialBaggage.AllType[2]));
        Ticket ticket3 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,
        List<Baggage> baggages4 = new ArrayList<Baggage> ();
        baggages4.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages4=new ArrayList<SpecialBaggage>();
        Ticket ticket4 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages5 = new ArrayList<Baggage> ();
        baggages5.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages5=new ArrayList<SpecialBaggage>();
        specialBaggages5.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        specialBaggages5.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket5 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages6 = new ArrayList<Baggage> ();
        baggages6.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages6=new ArrayList<SpecialBaggage>();
        specialBaggages6.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket6 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,特殊行李参数不符合规则
        List<Baggage> baggages7 = new ArrayList<Baggage> ();
        baggages7.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages7=new ArrayList<SpecialBaggage>();
        specialBaggages7.add(new SpecialBaggage(1, SpecialBaggage.AllType[2]));
        Ticket ticket7 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,没有特殊行李
        List<Baggage> baggages8 = new ArrayList<Baggage> ();
        baggages8.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages8=new ArrayList<SpecialBaggage>();
        Ticket ticket8 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages9 = new ArrayList<Baggage> ();
        baggages9.add(new Baggage(30.f, 20.f, 10.f, 24.f));
        List<SpecialBaggage>specialBaggages9=new ArrayList<SpecialBaggage>();
        specialBaggages9.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        specialBaggages9.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket9 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages10 = new ArrayList<Baggage> ();
        baggages10.add(new Baggage(30.f, 20.f, 10.f, 24.f));
        List<SpecialBaggage>specialBaggages10=new ArrayList<SpecialBaggage>();
        specialBaggages10.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket10 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,特殊行李参数不符合规则
        List<Baggage> baggages11 = new ArrayList<Baggage> ();
        baggages11.add(new Baggage(30.f, 20.f, 10.f, 24.f));
        List<SpecialBaggage>specialBaggages11=new ArrayList<SpecialBaggage>();
        specialBaggages11.add(new SpecialBaggage(1, SpecialBaggage.AllType[2]));
        Ticket ticket11 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,没有特殊行李
        List<Baggage> baggages12 = new ArrayList<Baggage> ();
        baggages12.add(new Baggage(30.f, 20.f, 10.f, 24.f));
        List<SpecialBaggage>specialBaggages12=new ArrayList<SpecialBaggage>();
        Ticket ticket12 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且还有普通行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages13 = new ArrayList<Baggage> ();
        baggages13.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages13.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages13=new ArrayList<SpecialBaggage>();
        specialBaggages13.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        specialBaggages13.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket13 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且还有普通行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages14 = new ArrayList<Baggage> ();
        baggages14.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages14.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages14=new ArrayList<SpecialBaggage>();
        specialBaggages14.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket14 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且还有普通行李,特殊行李参数不符合规则
        List<Baggage> baggages15 = new ArrayList<Baggage> ();
        baggages15.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages15.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages15=new ArrayList<SpecialBaggage>();
        specialBaggages15.add(new SpecialBaggage(1, SpecialBaggage.AllType[2]));
        Ticket ticket15 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且还有普通行李,没有特殊行李
        List<Baggage> baggages16 = new ArrayList<Baggage> ();
        baggages16.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages16.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages16=new ArrayList<SpecialBaggage>();
        Ticket ticket16 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且还有普通行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages17 = new ArrayList<Baggage> ();
        baggages17.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages17.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages17=new ArrayList<SpecialBaggage>();
        specialBaggages17.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        specialBaggages17.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket17 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且还有普通行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages18 = new ArrayList<Baggage> ();
        baggages18.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages18.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages18=new ArrayList<SpecialBaggage>();
        specialBaggages18.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket18 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且还有普通行李,特殊行李参数不符合规则
        List<Baggage> baggages19 = new ArrayList<Baggage> ();
        baggages19.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages19.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages19=new ArrayList<SpecialBaggage>();
        specialBaggages19.add(new SpecialBaggage(1, SpecialBaggage.AllType[2]));
        Ticket ticket19 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且还有普通行李,没有特殊行李
        List<Baggage> baggages20 = new ArrayList<Baggage> ();
        baggages20.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages20.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages20=new ArrayList<SpecialBaggage>();
        Ticket ticket20 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但为经济舱超重加价且还有普通行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages21 = new ArrayList<Baggage> ();
        baggages21.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages21.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages21=new ArrayList<SpecialBaggage>();
        specialBaggages21.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        specialBaggages21.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket21 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但为经济舱超重加价且还有普通行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages22 = new ArrayList<Baggage> ();
        baggages22.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages22.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages22=new ArrayList<SpecialBaggage>();
        specialBaggages22.add(new SpecialBaggage(20, SpecialBaggage.AllType[2]));
        Ticket ticket22 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但为经济舱超重加价且还有普通行李,特殊行李参数不符合规则
        List<Baggage> baggages23 = new ArrayList<Baggage> ();
        baggages23.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages23.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages23=new ArrayList<SpecialBaggage>();
        specialBaggages23.add(new SpecialBaggage(40, SpecialBaggage.AllType[2]));
        Ticket ticket23 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但为经济舱超重加价且还有普通行李,没有特殊行李
        List<Baggage> baggages24 = new ArrayList<Baggage> ();
        baggages24.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        baggages24.add(new Baggage(78.f, 50.f, 30.f, 24.f));
        List<SpecialBaggage>specialBaggages24=new ArrayList<SpecialBaggage>();
        Ticket ticket24 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //没有普通行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages25 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages25=new ArrayList<SpecialBaggage>();
        specialBaggages25.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        specialBaggages25.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket25 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //没有普通行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages26 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages26=new ArrayList<SpecialBaggage>();
        specialBaggages22.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket26 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //没有普通行李,特殊行李参数不符合规则
        List<Baggage> baggages27 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages27=new ArrayList<SpecialBaggage>();
        specialBaggages27.add(new SpecialBaggage(1, SpecialBaggage.AllType[2]));
        Ticket ticket27 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //没有普通行李,没有特殊行李,有票
        List<Baggage> baggages28 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages28=new ArrayList<SpecialBaggage>();
        Ticket ticket28 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //三个对象都为空
        List<Baggage> baggages29 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages29=new ArrayList<SpecialBaggage>();
        Ticket ticket29 = null;


        return new Object[][]{
                {baggages1,specialBaggages1,ticket1,5275.f},
                {baggages2,specialBaggages2,ticket2,2675.f},
                {baggages3,specialBaggages3,ticket3,-1.f},
                {baggages4,specialBaggages4,ticket4,75.f},
                {baggages5,specialBaggages5,ticket5,5200.f},
                {baggages6,specialBaggages6,ticket6,2600.f},
                {baggages7,specialBaggages7,ticket7,-1.f},
                {baggages8,specialBaggages8,ticket8,0.f},
                {baggages9,specialBaggages9,ticket9,5275.f},
                {baggages10,specialBaggages10,ticket10,2675.f},
                {baggages11,specialBaggages11,ticket11,-1.f},
                {baggages12,specialBaggages12,ticket12,75.f},
                {baggages13,specialBaggages13,ticket13,5650.f},
                {baggages14,specialBaggages14,ticket14,3050.f},
                {baggages15,specialBaggages15,ticket15,-1.f},
                {baggages16,specialBaggages16,ticket16,450.f},
                {baggages17,specialBaggages17,ticket17,5650.f},
                {baggages18,specialBaggages18,ticket18,3050.f},
                {baggages19,specialBaggages19,ticket19,-1.f},
                {baggages20,specialBaggages20,ticket20,450.f},
                {baggages21,specialBaggages21,ticket21,5650.f},
                {baggages22,specialBaggages22,ticket22,5650.f},
                {baggages23,specialBaggages23,ticket23,5650.f},
                {baggages24,specialBaggages24,ticket24,450.f},
                {baggages25,specialBaggages25,ticket25,5200.f},
                {baggages26,specialBaggages26,ticket26,0.f},
                {baggages27,specialBaggages27,ticket27,-1.f},
                {baggages28,specialBaggages28,ticket28,0.f},
                {baggages29,specialBaggages29,ticket29,-1.f}
        };
    }

    /***
     * 测试 Calculator里面的 calculateInterbational()函数，
     * 函数的功能：计算国际行李托运所需要的费用
     */
    @DataProvider
    public static Object[][] calculateInterbationalData() {
        //白盒测试
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages1 = new ArrayList<Baggage> ();
        baggages1.add(new Baggage(30.f,20.f, 10.f, 2.f));
        baggages1.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages1=new ArrayList<SpecialBaggage>();
        specialBaggages1.add(new SpecialBaggage(1,SpecialBaggage.AllType[0]));
        specialBaggages1.add(new SpecialBaggage(1, SpecialBaggage.AllType[0]));
        Ticket ticket1 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages2 = new ArrayList<Baggage> ();
        baggages2.add(new Baggage(30.f,20.f, 10.f, 2.f));
        baggages2.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages2=new ArrayList<SpecialBaggage>();
        specialBaggages2.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket2 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,特殊行李参数不符合规则
        List<Baggage> baggages3 = new ArrayList<Baggage> ();
        baggages3.add(new Baggage(30.f,20.f, 10.f, 2.f));
        baggages3.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages3=new ArrayList<SpecialBaggage>();
        specialBaggages3.add(new SpecialBaggage(1,SpecialBaggage.AllType[2]));
        Ticket ticket3 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价同时为经济舱计算超重加价且为最后一件行李,
        List<Baggage> baggages4 = new ArrayList<Baggage> ();
        baggages4.add(new Baggage(30.f,20.f, 10.f, 2.f));
        baggages4.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages4=new ArrayList<SpecialBaggage>();
        Ticket ticket4 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages5 = new ArrayList<Baggage> ();
        baggages5.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages5=new ArrayList<SpecialBaggage>();
        specialBaggages5.add(new SpecialBaggage(1, SpecialBaggage.AllType[0]));
        specialBaggages5.add(new SpecialBaggage(1, SpecialBaggage.AllType[0]));
        Ticket ticket5 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages6 = new ArrayList<Baggage> ();
        baggages6.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages6=new ArrayList<SpecialBaggage>();
        specialBaggages6.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket6 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,特殊行李参数不符合规则
        List<Baggage> baggages7 = new ArrayList<Baggage> ();
        baggages7.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages7=new ArrayList<SpecialBaggage>();
        specialBaggages7.add(new SpecialBaggage(1, SpecialBaggage.AllType[2]));
        Ticket ticket7 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李超过尺寸加价但不为经济舱加价且为最后一件行李,没有特殊行李
        List<Baggage> baggages8 = new ArrayList<Baggage> ();
        baggages8.add(new Baggage(30.f,20.f, 10.f, 2.f));
        List<SpecialBaggage>specialBaggages8=new ArrayList<SpecialBaggage>();
        specialBaggages8.add(new SpecialBaggage(100,SpecialBaggage.AllType[2]));
        Ticket ticket8 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Business_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,特殊行李符合规则按照规则加价且还有行李
        List<Baggage> baggages9 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages9=new ArrayList<SpecialBaggage>();
        specialBaggages9.add(new SpecialBaggage(1, SpecialBaggage.AllType[0]));
        specialBaggages9.add(new SpecialBaggage(1, SpecialBaggage.AllType[0]));
        Ticket ticket9 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,特殊行李符合规则按照规则加价且为最后一件行李
        List<Baggage> baggages10 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages10=new ArrayList<SpecialBaggage>();
        specialBaggages10.add(new SpecialBaggage(2, SpecialBaggage.AllType[2]));
        Ticket ticket10 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,特殊行李参数不符合规则
        List<Baggage> baggages11 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages11=new ArrayList<SpecialBaggage>();
        specialBaggages11.add(new SpecialBaggage(1,SpecialBaggage.AllType[2]));
        Ticket ticket11 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);
        //普通行李没超过尺寸但为经济舱超重加价且为最后一件行李,没有特殊行李
        List<Baggage> baggages12 = new ArrayList<Baggage> ();
        List<SpecialBaggage>specialBaggages12=new ArrayList<SpecialBaggage>();
        Ticket ticket12 =new Ticket(Ticket.Regional[5],1000,PassengerType.ADULT,ClassType.Economy_Class,VIPType.Ordinary);

        return new Object[][]{
                {baggages1,specialBaggages1,ticket1,5380.f},
                {baggages2,specialBaggages2,ticket2,2780.f},
                {baggages3,specialBaggages3,ticket3,5215.f},
                {baggages4,specialBaggages4,ticket4,15.f},
                {baggages5,specialBaggages5,ticket5,0.f},
                {baggages6,specialBaggages6,ticket6,2600.f},
                {baggages7,specialBaggages7,ticket7,-1.f},
                {baggages8,specialBaggages8,ticket8,-1.f},
                {baggages9,specialBaggages9,ticket9,0.f},
                {baggages10,specialBaggages10,ticket10,2600.f},
                {baggages11,specialBaggages11,ticket11,-1.f},
                {baggages12,specialBaggages12,ticket12,0.f}
        };
    }

    /***
     * 测试 Calculator里面的 calculateInterbational()函数，
     * 函数的功能：计算国际行李托运所需要的费用
     */
    @DataProvider
    public static Object[][] excessCalculateData() {
        return new Object[][]{
                //符合标准
                {new Baggage(30.f, 20.f, 10.f, 2.f),0,0.f},
                //超重类型1但不超尺寸
                {new Baggage(30.f, 20.f, 10.f, 23.f),0,0.f},
                //超重类型2但不超尺寸
                {new Baggage(30.f, 20.f, 10.f, 28.f),0,380.f},
                //不超重量但超尺寸
                {new Baggage(70.f, 50.f, 38.f,  2.f),0,0.f},
                //超重且超尺寸
                {new Baggage(70.f, 50.f, 38.f, 23.f),0,980.f},
                //重量不符w<2||w>32
                {new Baggage(30.f, 20.f, 10.f, 1.f),0,-1.f},
                //三边之和不符sumofLong<60||sumofLong>203
                {new Baggage(1.f, 1.f, 1.f, 1.f),0,-1.f},
                //区域号不符regionIndex<0||regionIndex>=5
                {new Baggage(30.f, 20.f, 10.f, 1.f),6,-1.f},
        };
    }

    @Test
    @UseDataProvider("calculateDomesticData")
    public void calculateDomestic(List<Baggage> baggages, List<SpecialBaggage>specialBaggages, Ticket ticket,float expectedResult) {
        System.out.println (Calculator.CalculateDomestic(baggages, specialBaggages,ticket));
        Assert.assertEquals(Calculator.CalculateDomestic(baggages, specialBaggages,ticket),expectedResult,0);
    }

    @Test
    @UseDataProvider("calculateInterbationalData")
    public void calculateInterbational(List<Baggage> baggages, List<SpecialBaggage>specialBaggages, Ticket ticket,float expectedResult) {
        System.out.println (Calculator.CalculateInterbational(baggages, specialBaggages,ticket));
        Assert.assertEquals(Calculator.CalculateInterbational(baggages, specialBaggages,ticket),expectedResult,0);
    }

    @Test
    @UseDataProvider("excessCalculateData")
    public void excessCalculate(Baggage baggage,int regionIndex,float expectedResult) {
        System.out.println (Calculator.excessCalculate(baggage, regionIndex));
        Assert.assertEquals(Calculator.excessCalculate(baggage, regionIndex),expectedResult,0);
    }
}