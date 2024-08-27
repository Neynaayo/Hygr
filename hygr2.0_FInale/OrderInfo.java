import java.text.DecimalFormat;
public class OrderInfo
{
    DecimalFormat df=new DecimalFormat("0.00");
    private String custName;
    private String contactNum;
    private String address;
    private int numLipstick;
    private int numDeo;
    private int numSunScreen;
    private String date;
    private String paymentMethod;
    private String shippingCode;
    
    public OrderInfo(){
        custName=null;
        contactNum=null;
        address=null;
        numLipstick=0;
        numDeo=0;
        numSunScreen=0;
        date=null;
        paymentMethod=null;
        shippingCode=null;
    }
    
    public OrderInfo(String cN, String contact,String add,int l,int d,int s,String date,String payment,String code){
        custName=cN;
        contactNum=contact;
        address=add;
        numLipstick=l;
        numDeo=d;
        numSunScreen=s;
        this.date=date;
        paymentMethod=payment;
        shippingCode=code;
    }
    
    public void setCustName(String cN){custName=cN;}
    public void setContactNum(String c){contactNum=c;}
    public void setAddress(String add){address=add;}
    public void setDate(String date){this.date=date;}
    public void setPaymentMethod(String p){paymentMethod=p;}
    public void setShippingCode(String code){shippingCode=code;}
    public void setNumLipstick(int l){numLipstick=l;}
    public void setNumDeo(int d){numDeo=d;}
    public void setNumSunScreen(int s){numSunScreen=s;}
    
    public String getCustName(){return custName;}
    public String getContactNum(){return contactNum;}
    public String getAddress(){return address;}
    public String getDate(){return date;}
    public String getPaymentMethod(){return paymentMethod;}
    public String getShippingCode(){return shippingCode;}
    public int getNumSunScreen(){return numSunScreen;}
    public int getNumLipstick(){return numLipstick;}
    public int getNumDeo(){return numDeo;}
    
    public double calcPrice(){
        double totalP=0;
        if (numLipstick!=0)
            totalP+=numLipstick*29;
            
        if (numDeo!=0)
            totalP+=numDeo*49;
            
        if (numSunScreen!=0)
            totalP+=numSunScreen*38.90;
        return totalP;
    }
    
    public double govTax(){return calcPrice()*5/100;}
    
    public double finalPrice()
    {
        return calcPrice() + govTax();
    }
    
    
    public String toString(){
        return ("\nName\t\t:"+custName+
                "\nContact number\t:"+contactNum+
                "\nAddress\t\t:"+address+
                "\nLipstick\t:"+numLipstick+
                "\nDeodorent\t:"+numDeo+
                "\nSun Screen\t:"+numSunScreen+
                "\nPayment Method\t:"+paymentMethod+
                "\nShipping code\t:"+shippingCode+
                "\nTotal Price\t:RM"+df.format(calcPrice())+
                "\nTotal tax\t:RM"+df.format(govTax())+
                "\nTotal Price(tax):RM"+df.format(finalPrice()));
    }

}



