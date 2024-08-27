import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class HygrtestQueue
{
    public static void main(String [] args)
    {
        DecimalFormat df=new DecimalFormat("0.00");
        OrderInfo hq;
        Queue hygrQueue = new Queue();
        Queue temp=new Queue();
        try {
            FileReader fr=new FileReader("tiktok.txt");
            BufferedReader br=new BufferedReader(fr);
            String s=br.readLine();
            while (s!=null){
                StringTokenizer st=new StringTokenizer(s,";");

                String custName=st.nextToken().trim();
                String custContact=st.nextToken().trim();
                String address=st.nextToken().trim();
                int numLipstick=Integer.parseInt(st.nextToken().trim());
                int numDeo=Integer.parseInt(st.nextToken().trim());
                int numSunScreen=Integer.parseInt(st.nextToken().trim());
                String date=st.nextToken().trim();
                String paymentM=st.nextToken().trim();
                String shipCode=st.nextToken().trim();

                OrderInfo orderInfo=new OrderInfo(custName,custContact,address,numLipstick,numDeo,numSunScreen,date,paymentM,shipCode);
                hygrQueue.enqueue(orderInfo);
                s=br.readLine();
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("=====================================================================================================<3 HYGR CUSTOMER DATA INFORMATION <3====================================================================================================================================================================");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        int count =1;
        while (!hygrQueue.isEmpty())
        {
            hq=(OrderInfo) hygrQueue.dequeue();
            temp.enqueue(hq);
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                count,hq.getCustName(), hq.getContactNum(), hq.getAddress(),
                hq.getNumLipstick(), hq.getNumDeo(), hq.getNumSunScreen(),
                hq.getDate(), hq.getPaymentMethod(), hq.getShippingCode());
            count++;
        }
        while (!temp.isEmpty())
        {
            hygrQueue.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        Scanner in=new Scanner (System.in);
        in.useDelimiter("\n");

        System.out.println("Do you want to change payment method?[true/false]");
        boolean ans = in.nextBoolean();
        boolean found=false;
        OrderInfo oF7;
        while (ans) {
            System.out.println("Enter shipping code: ");
            String search = in.next();

            while (!temp.isEmpty()) {
                hygrQueue.enqueue(temp.dequeue());
            }

            while (!hygrQueue.isEmpty()) {
                OrderInfo data = (OrderInfo) hygrQueue.dequeue();
                if (data.getShippingCode().equalsIgnoreCase(search)) {
                    System.out.println("Choose payment option:\n[1-TNG|2-COD|3-Card|4-Online transfer]");
                    int changePayment = in.nextInt();
                    found = true;
                    if (changePayment == 1) {
                        data.setPaymentMethod("TNG");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            data.getCustName(), data.getContactNum(), data.getAddress(),
                            data.getNumLipstick(), data.getNumDeo(), data.getNumSunScreen(),
                            data.getDate(), data.getPaymentMethod(), data.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    } else if (changePayment == 2) {
                        data.setPaymentMethod("COD");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            data.getCustName(), data.getContactNum(), data.getAddress(),
                            data.getNumLipstick(), data.getNumDeo(), data.getNumSunScreen(),
                            data.getDate(), data.getPaymentMethod(), data.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    } else if (changePayment == 3) {
                        data.setPaymentMethod("Card");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            data.getCustName(), data.getContactNum(), data.getAddress(),
                            data.getNumLipstick(), data.getNumDeo(), data.getNumSunScreen(),
                            data.getDate(), data.getPaymentMethod(), data.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");                    
                    } else if (changePayment == 4) {
                        data.setPaymentMethod("Online transfer");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            data.getCustName(), data.getContactNum(), data.getAddress(),
                            data.getNumLipstick(), data.getNumDeo(), data.getNumSunScreen(),
                            data.getDate(), data.getPaymentMethod(), data.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    } else {
                        System.out.println("You entered an invalid option!");
                    }
                }
                temp.enqueue(data);
            }
            if (!found) 
            {
                System.out.println("Data not found!");
            }
            System.out.println("Do you want to change payment method? [true/false]");
            ans = in.nextBoolean();
        }
        while (!temp.isEmpty()) {
            hygrQueue.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        // Search using shipping code and update customer address. User will input the shipping code.
        System.out.println("\nDo you want to change customer address? [true/false]");
        boolean ans1 = in.nextBoolean();
        boolean found1 = false;
        OrderInfo oF8;
        while (ans1) {
            System.out.println("Enter shipping code: ");
            String search1 = in.next();
            while (!temp.isEmpty()) {
                hygrQueue.enqueue(temp.dequeue());
            }

            while (!hygrQueue.isEmpty()) {
                OrderInfo update = (OrderInfo) hygrQueue.dequeue();
                temp.enqueue(update);
                if (update.getShippingCode().equalsIgnoreCase(search1)) {
                    System.out.println("Enter the updated address: ");
                    String changeAddress = in.next();
                    update.setAddress(changeAddress);
                    System.out.println("\n\n======================================================================================customer information that had been update(Address)=========================================================================================================================================");
                    System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                        "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                    System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                        update.getCustName(), update.getContactNum(), update.getAddress(),
                        update.getNumLipstick(), update.getNumDeo(), update.getNumSunScreen(),
                        update.getDate(), update.getPaymentMethod(), update.getShippingCode());
                    System.out.println("=======================================================================================================================================================================================================================================================================================================================");

                }
            }
            if (found1) {
                System.out.println("Data not found!");
            }
            System.out.println("\nDo you want to change customer address? [true/false]");
            ans1 = in.nextBoolean();
        }

        while (!temp.isEmpty()) {
            hygrQueue.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        //To Create a new linked list for order that had been shipped out and remove data that had been transfer. 
        Queue shippOut = new Queue();
        Queue shipp = new Queue();
        Queue tempQueue = new Queue();
        while (!hygrQueue.isEmpty())
        {
            OrderInfo data1=(OrderInfo)hygrQueue.dequeue();
            if(data1.getShippingCode().substring(0,2).equalsIgnoreCase("SM"))
            {
                shippOut.enqueue(data1);
            }
            else
            {
                shipp.enqueue(data1);
            }
            tempQueue.enqueue(data1);
        }
        while (!tempQueue.isEmpty())
        {
            hygrQueue.enqueue(tempQueue.dequeue());
        }

        System.out.println("\n\n======================================================================================customer information that had been shipped out=========================================================================================================================================");
        System.out.println("Parcel had been Shipped Out!!!");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        int count2=1,count1=1;
        while (!shippOut.isEmpty())
        {
            OrderInfo hq1=(OrderInfo) shippOut.dequeue();
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                count1,hq1.getCustName(), hq1.getContactNum(), hq1.getAddress(),
                hq1.getNumLipstick(), hq1.getNumDeo(), hq1.getNumSunScreen(),
                hq1.getDate(), hq1.getPaymentMethod(), hq1.getShippingCode());
            count1++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        System.out.println("\n\n======================================================================================customer information that still in prepare=========================================================================================================================================");
        System.out.println("Parcel still Prepare!!!");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        while (!shipp.isEmpty())
        {
            OrderInfo hq2=(OrderInfo) shipp.dequeue();
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                count2,hq2.getCustName(), hq2.getContactNum(), hq2.getAddress(),
                hq2.getNumLipstick(), hq2.getNumDeo(), hq2.getNumSunScreen(),
                hq2.getDate(), hq2.getPaymentMethod(), hq2.getShippingCode());
            count2++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        //Copy all the customer order info that brought product that month into new linked list. Remove 
        //all customer order info that had been insert into new linked list.

        Queue month1 = new Queue();
        Queue month2 = new Queue();
        Queue month3 = new Queue();
        Queue month4 = new Queue();

        while (!hygrQueue.isEmpty()) {
            OrderInfo order = (OrderInfo) hygrQueue.dequeue();
            String date = order.getDate();
            if (date.length() >= 5) {
                String month = date.substring(3, 5);
                switch (month) {
                    case "01":
                        month1.enqueue(order);
                        break;
                    case "02":
                        month2.enqueue(order);
                        break;
                    case "03":
                        month3.enqueue(order);
                        break;
                    case "04":
                        month4.enqueue(order);
                        break;
                        // Add more cases for other months if needed
                }
            }
            temp.enqueue(order);
        }
        while (!temp.isEmpty())
        {
            hygrQueue.enqueue(temp.dequeue());
        }

        // ... (existing code to print customer data for each month)

        System.out.println("\n\n");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("\n\n======================================================================================Customer that buy the product in January========================================================================================================================================");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        int count3 =1;
        while (!month1.isEmpty())
        {
            OrderInfo hq3=(OrderInfo)month1.dequeue();
            temp.enqueue(hq3);
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                count3,hq3.getCustName(), hq3.getContactNum(), hq3.getAddress(),
                hq3.getNumLipstick(), hq3.getNumDeo(), hq3.getNumSunScreen(),
                hq3.getDate(), hq3.getPaymentMethod(), hq3.getShippingCode());
            count3++;
        }
        while (!temp.isEmpty())
        {
            month1.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        System.out.println("\n\n");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("\n\n======================================================================================Customer that buy the product in February========================================================================================================================================");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        int count4 =1;
        while (!month2.isEmpty())
        {
            OrderInfo hq4=(OrderInfo) month2.dequeue();
            temp.enqueue(hq4);
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                count4,hq4.getCustName(), hq4.getContactNum(), hq4.getAddress(),
                hq4.getNumLipstick(), hq4.getNumDeo(), hq4.getNumSunScreen(),
                hq4.getDate(), hq4.getPaymentMethod(), hq4.getShippingCode());
            count4++;
        }
        while (!temp.isEmpty())
        {
            month2.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        System.out.println("\n\n");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("\n\n======================================================================================Customer that buy the product in March========================================================================================================================================");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        int count5 =1;
        while (!month3.isEmpty())
        {
            OrderInfo hq5=(OrderInfo) month3.dequeue();
            temp.enqueue(hq5);
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                count5,hq5.getCustName(), hq5.getContactNum(), hq5.getAddress(),
                hq5.getNumLipstick(), hq5.getNumDeo(), hq5.getNumSunScreen(),
                hq5.getDate(), hq5.getPaymentMethod(), hq5.getShippingCode());
            count5++;
        }
        while (!temp.isEmpty())
        {
            month3.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        System.out.println("\n\n");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("\n\n======================================================================================Customer that buy the product in April========================================================================================================================================");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        int count6 =1;
        while (!month4.isEmpty())
        {
            OrderInfo hq6=(OrderInfo) month4.dequeue();
            temp.enqueue(hq6);
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                count6,hq6.getCustName(), hq6.getContactNum(), hq6.getAddress(),
                hq6.getNumLipstick(), hq6.getNumDeo(), hq6.getNumSunScreen(),
                hq6.getDate(), hq6.getPaymentMethod(), hq6.getShippingCode());
            count6++;
        }
        while (!temp.isEmpty())
        {
            month4.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        System.out.println("\n\n");
        double totalmonth1= 0.00;
        while (!month1.isEmpty())
        {
            OrderInfo sales =(OrderInfo)month1.dequeue();
            temp.enqueue(sales);
            totalmonth1 += sales.calcPrice();
        }
        while (!temp.isEmpty())
        {
            month1.enqueue(temp.dequeue());
        }
        System.out.println("Total Price had been collected for the Whole Month(January)\t:RM"+ df.format(totalmonth1));

        double totalmonth2= 0.00;
        while (!month2.isEmpty())
        {
            OrderInfo sales2 =(OrderInfo)month2.dequeue();
            tempQueue.enqueue(sales2);
            totalmonth2 += sales2.calcPrice();
        }
        while (!tempQueue.isEmpty())
        {
            month2.enqueue(tempQueue.dequeue());
        }
        System.out.println("Total Price had been collected for the Whole Month(February)\t:RM"+ df.format(totalmonth2));

        double totalmonth3= 0.00;
        while (!month3.isEmpty())
        {
            OrderInfo sales3 =(OrderInfo)month3.dequeue();
            tempQueue.enqueue(sales3);
            totalmonth3 += sales3.calcPrice();
        }
        while (!tempQueue.isEmpty())
        {
            month3.enqueue(tempQueue.dequeue());
        }
        System.out.println("Total Price had been collected for the Whole Month(March)\t:RM"+ df.format(totalmonth3));

        double totalmonth4= 0.00;
        while (!month4.isEmpty())
        {
            OrderInfo sales4 =(OrderInfo)month4.dequeue();
            tempQueue.enqueue(sales4);
            totalmonth4 += sales4.calcPrice();
        }
        while (!tempQueue.isEmpty())
        {
            month4.enqueue(tempQueue.dequeue());
        }
        System.out.println("Total Price had been collected for the Whole Month(April)\t:RM"+ df.format(totalmonth4));

        // Comparing monthly sales to determine highest monthly sales. 
        double largest=0.00;
        if (totalmonth1 > totalmonth2 && totalmonth1 > totalmonth3 && totalmonth1 > totalmonth4)
        {
            largest = totalmonth1;
        } else if (totalmonth2 > totalmonth3 && totalmonth2 > totalmonth4) {
            largest = totalmonth2;
        } else if (totalmonth3 > totalmonth4) 
        {
            largest = totalmonth3;
        } else 
        {
            largest = totalmonth4;
        }

        while (!tempQueue.isEmpty()) {
            hygrQueue.enqueue(tempQueue.dequeue());
        }
        while (!temp.isEmpty()) {
            hygrQueue.enqueue(temp.dequeue());
        }
        int totalLipstick = 0;
        int totalDeo = 0;
        int totalSunScreen = 0;
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("The highest for monthly sales\t\t\t\t\t:RM" + df.format(largest));
        
        //Ascertain total number of tax (5%) that had been collected for the whole year. 
        OrderInfo oF1;
        double totalTax= 0.00;
        while (!hygrQueue.isEmpty())
        {
            oF1 =(OrderInfo)hygrQueue.dequeue();
            temp.enqueue(oF1);
            totalTax += oF1.govTax();
        }
        while (!temp.isEmpty())
        {
            hygrQueue.enqueue(temp.dequeue());
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("Total tax had been collected for the Whole year\t:RM"+ totalTax);
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        
        while (!hygrQueue.isEmpty()) {
            OrderInfo order = (OrderInfo) hygrQueue.dequeue();
            temp.enqueue(order);
            totalLipstick += order.getNumLipstick();
            totalDeo += order.getNumDeo();
            totalSunScreen += order.getNumSunScreen();
        }

        while (!temp.isEmpty()) {
            hygrQueue.enqueue(temp.dequeue());
        }

        
        System.out.println("Total Lipstick sold for the whole year\t: " + totalLipstick);
        System.out.println("Total Deodorant sold for the whole year\t: " + totalDeo);
        System.out.println("Total Sunscreen sold for the whole year\t: " + totalSunScreen);
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        if (totalLipstick >= totalDeo && totalLipstick >= totalSunScreen)
        {
            System.out.println("The best-Selling Item for The Entire Year is\t: LipsStick with  " + totalLipstick + " Sold ");
        }
        // Comparing 2nd no with 1st and 3rd no
        else if (totalDeo >= totalLipstick && totalDeo >= totalSunScreen)
        {
            System.out.println("The best-Selling Item for The Entire Year is\t: Deodorant with  " + totalDeo + " Sold ");

        }
        else
            System.out.println("The best-Selling Item for The Entire Year is\t: Sun Screen with  " + totalSunScreen + " Sold ");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

    }
}
