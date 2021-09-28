package main.java.com.shez.bc;
/***
 * 区域费用
 */
public class RegionalCharges{
    int [] Charges ;

    public int[] getCharges() {
        return Charges;
    }

    public void setCharges(int[] charges) {
        Charges = charges;
    }

    public RegionalCharges(int[] charges) {
        Charges = charges;
    }
}