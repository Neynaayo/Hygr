import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.BufferedReader;
import java.text.DecimalFormat;
import java.util.Iterator;

public class HygrLinkedList
{
    public static void main(String [] args)
    {
        DecimalFormat df=new DecimalFormat("0.00");
        LinkedList hygrLL = new LinkedList();
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
                hygrLL.insertAtBack(orderInfo);
                s=br.readLine();
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //Tabular format for displaying All customer information
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.println("=====================================================================================================<3 HYGR CUSTOMER DATA INFORMATION <3====================================================================================================================================================================");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        int customerNumber = 1;
        OrderInfo obj = (OrderInfo)hygrLL.getFirst();
        while (obj != null) {
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                customerNumber,obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
            obj = (OrderInfo)hygrLL.getNext();
            customerNumber++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        //System.out.println("length for Hygr Linked list: " + hygrLL.length());
        //hygrLL.display();

        //changing the payment method by user inpput 
        Scanner in=new Scanner (System.in);
        in.useDelimiter("\n");

        System.out.println("Do you want to change payment method?[true/false]");
        boolean ans = in.nextBoolean();
        boolean found=false;

        while(ans){
            System.out.println("Enter shipping code: ");
            String search=in.next();

            obj = (OrderInfo)hygrLL.getFirst();
            while(obj !=null){
                if(obj.getShippingCode().equalsIgnoreCase(search)){
                    System.out.println("Choose payment option:\n[1-TNG|2-COD|3-Card|4-Online transfer]");
                    int changePayment=in.nextInt();
                    found=true;
                    if (changePayment==1){
                        obj.setPaymentMethod("TNG");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                            obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                            obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    }
                    else if (changePayment==2){
                        obj.setPaymentMethod("COD");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                            obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                            obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    }
                    else if (changePayment==3){
                        obj.setPaymentMethod("Card");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                            obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                            obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    }
                    else if (changePayment==4){
                        obj.setPaymentMethod("Online transfer");
                        System.out.println("\n\n======================================================================================customer information that had been update(Payment)=========================================================================================================================================");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                        System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                            obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                            obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                            obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
                        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    }
                    else 
                        System.out.println("you key in wrong choice!!");
                }
                obj = (OrderInfo)hygrLL.getNext();
            }
            if (!found){
                System.out.println("Data not found!");
            }
            System.out.println("Do you want to change payment method?[true/false]");
            ans = in.nextBoolean();

        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        //Search using shipping code and update customer address. User will input the shipping code. 
        System.out.println("Do you want to change Address customer?[true/false]");
        boolean addUpdate = in.nextBoolean();
        while(addUpdate){
            System.out.println("Enter shipping code: ");
            String search=in.next();

            obj = (OrderInfo)hygrLL.getFirst();
            while (obj!=null)
            {
                if (obj.getShippingCode().equalsIgnoreCase(search))
                {
                    System.out.println("Enter your Address(Update) :");
                    String changeAddress=in.next();
                    obj.setAddress(changeAddress);
                    System.out.println("\n\n======================================================================================customer information that had been update(Address)=========================================================================================================================================");
                    System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                        "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
                    System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                    System.out.printf("|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                        obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                        obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                        obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
                    System.out.println("=======================================================================================================================================================================================================================================================================================================================");
                }
                obj = (OrderInfo)hygrLL.getNext();
            }
            if (!found){
                System.out.println("Data not found!");
            }
            System.out.println("Do you want to change Address customer?[true/false]");
            addUpdate = in.nextBoolean();
        }        
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        //to copy hygrLL into temp hygrLL for manipulate data easier
        LinkedList temp1HygrLL = new LinkedList();
        obj = (OrderInfo)hygrLL.getFirst();
        while (obj!=null)
        {
            temp1HygrLL.insertAtBack(obj);
            obj = (OrderInfo)hygrLL.getNext();
        }

        //To Create a new linked list for order that had been shipped out and remove data that had been transfer. 
        LinkedList shippOutLL = new LinkedList();
        obj = (OrderInfo)temp1HygrLL.getFirst();
        while (obj!=null)
        {
            if(obj.getShippingCode().substring(0,2).equalsIgnoreCase("SM"))
            {
                shippOutLL.insertAtBack(obj);
                temp1HygrLL.remove(obj);
            }
            obj = (OrderInfo)temp1HygrLL.getNext();
        }

        customerNumber = 1;
        //Tabular format for displaying customer information that had been shipped out
        System.out.println("\n\n======================================================================================customer information that had been shipped out=========================================================================================================================================");
        System.out.println("Parcel had been Shipped Out!!!");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        OrderInfo objSO = (OrderInfo)shippOutLL.getFirst();
        while (objSO != null) {
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                customerNumber,objSO.getCustName(), objSO.getContactNum(), objSO.getAddress(),
                objSO.getNumLipstick(), objSO.getNumDeo(), objSO.getNumSunScreen(),
                objSO.getDate(), objSO.getPaymentMethod(), objSO.getShippingCode());
            objSO = (OrderInfo)shippOutLL.getNext();
            customerNumber++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        customerNumber = 1;
        System.out.println("\n\n======================================================================================customer information that still in prepare=======================================================================================================");
        //Tabular format for displaying All customer information
        System.out.println("Parcel still Prepare!!!");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        obj = (OrderInfo)temp1HygrLL.getFirst();
        while (obj != null) {
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                customerNumber,obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
            obj = (OrderInfo)temp1HygrLL.getNext();
            customerNumber++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        //Copy all the customer order info that brought product that month into new linked list. Remove 
        //all customer order info that had been insert into new linked list.

        LinkedList month1LL = new LinkedList();
        LinkedList month2LL = new LinkedList();
        LinkedList month3LL = new LinkedList();
        LinkedList month4LL = new LinkedList();

        //to copy hygrLL into temp hygrLL for manipulate data easier
        LinkedList temp2HygrLL = new LinkedList();
        obj = (OrderInfo)hygrLL.getFirst();
        while (obj!=null)
        {
            temp2HygrLL.insertAtBack(obj);
            obj = (OrderInfo)hygrLL.getNext();
        }

        while (!temp2HygrLL.isEmpty()) {
            OrderInfo monthR = (OrderInfo)temp2HygrLL.removeFirst();
            String month = monthR.getDate().substring(3, 5);
            switch (month) {
                case "01":
                    month1LL.insertAtBack(monthR);
                    break;
                case "02":
                    month2LL.insertAtBack(monthR);
                    break;
                case "03":
                    month3LL.insertAtBack(monthR);
                    break;
                case "04":
                    month4LL.insertAtBack(monthR);
                    break;
                    // Add more cases for other months if needed
            }
        }

        // The rest of your code remains the same

        /* IteIrate over the original list to categorize items by month
        OrderInfo monthR = (OrderInfo)temp2HygrLL.removeFromFront();
        while (monthR != null) {
            String month = monthR.getDate().substring(3, 5);
            switch (month) {
                case "01":
                    month1LL.insertAtBack(monthR);
                    break;
                case "02":
                    month2LL.insertAtBack(monthR);
                    break;
                case "03":
                    month3LL.insertAtBack(monthR);
                    break;
                case "04":
                    month4LL.insertAtBack(monthR);
                    break;
                    // Add more cases for other months if needed
            }
            monthR = (OrderInfo)temp2HygrLL.removeFromFront();
        }*/

        customerNumber = 1;
        System.out.println("\n\n=======================================================================================Customer that buy the product in January===========================================================================================================================");
        //Tabular format for displaying All customer information
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        obj = (OrderInfo)month1LL.getFirst();
        while (obj != null) {
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                customerNumber,obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
            obj = (OrderInfo)month1LL.getNext();
            customerNumber++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        customerNumber = 1;
        System.out.println("\n\n========================================================================================Customer that buy the product in February=======================================================================================================================");
        //Tabular format for displaying All customer information
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        obj = (OrderInfo)month2LL.getFirst();
        while (obj != null) {
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                customerNumber,obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
            obj = (OrderInfo)month2LL.getNext();
            customerNumber++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        customerNumber = 1;
        System.out.println("\n\n=========================================================================================Customer that buy the product in March==============================================================================================================================");
        //Tabular format for displaying All customer information
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        obj = (OrderInfo)month3LL.getFirst();
        while (obj != null) {
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                customerNumber,obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
            obj = (OrderInfo)month3LL.getNext();
            customerNumber++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        customerNumber = 1;
        System.out.println("\n\n======================================================================================Customer that buy the product in April========================================================================================================================================");
        //Tabular format for displaying All customer information
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
            "No.", "Customer Name", "Contact Number", "Address", "Lipstick", "Deodorent", "Sun Screen", "Date", "Payment Method", "Shipping Code");
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");
        obj = (OrderInfo)month4LL.getFirst();
        while (obj != null) {
            System.out.printf("|%-5s|%-45s|%-15s|%-90s|%-10s|%-10s|%-10s|%-15s|%-15s|%-20s|\n",
                customerNumber,obj.getCustName(), obj.getContactNum(), obj.getAddress(),
                obj.getNumLipstick(), obj.getNumDeo(), obj.getNumSunScreen(),
                obj.getDate(), obj.getPaymentMethod(), obj.getShippingCode());
            obj = (OrderInfo)month4LL.getNext();
            customerNumber++;
        }
        System.out.println("=======================================================================================================================================================================================================================================================================================================================");

        //Calculate the accumulated sales by month(not deducted by gov tax)
        //Month January
        double totalmonth1= 0.00;
        OrderInfo salesM = (OrderInfo) month1LL.getFirst();
        while (salesM !=null)
        {
            totalmonth1 += salesM.calcPrice();
            salesM = (OrderInfo) month1LL.getNext();
        }
        System.out.println("\nTotal Price had been collected for the Whole Month(January)\t:RM "+ df.format(totalmonth1));
        //Month February
        double totalmonth2= 0.00;
        salesM = (OrderInfo) month2LL.getFirst();
        while (salesM !=null)
        {
            totalmonth2 += salesM.calcPrice();
            salesM = (OrderInfo) month2LL.getNext();
        }
        System.out.println("Total Price had been collected for the Whole Month(February)\t:RM "+ df.format(totalmonth2));
        //Month March
        double totalmonth3= 0.00;
        salesM = (OrderInfo) month3LL.getFirst();
        while (salesM !=null)
        {
            totalmonth3 += salesM.calcPrice();
            salesM = (OrderInfo) month3LL.getNext();
        }
        System.out.println("Total Price had been collected for the Whole Month(March)\t:RM "+ df.format(totalmonth3));
        //Month April
        double totalmonth4= 0.00;
        salesM = (OrderInfo) month4LL.getFirst();
        while (salesM !=null)
        {
            totalmonth4 += salesM.calcPrice();
            salesM = (OrderInfo) month4LL.getNext();
        }
        System.out.println("Total Price had been collected for the Whole Month(April)\t:RM "+ df.format(totalmonth4));

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

        System.out.println("\nThe highest for monthly sales\t:RM " + df.format(largest));

        //Establish the best-selling item for the entire year.
        int totalLipstick= 0;
        OrderInfo bestSellingP = (OrderInfo)hygrLL.getFirst();
        while (bestSellingP !=null)
        {
            totalLipstick += bestSellingP.getNumLipstick();
            bestSellingP = (OrderInfo)hygrLL.getNext();
        }
        System.out.println("\nTotal Lipstick had been sold for the Whole year\t :"+ totalLipstick);

        int totalDeo= 0;
        bestSellingP = (OrderInfo)hygrLL.getFirst();
        while (bestSellingP !=null)
        {
            totalDeo += bestSellingP.getNumDeo();
            bestSellingP = (OrderInfo)hygrLL.getNext();
        }
        System.out.println("Total Deoderant had been sold for the Whole year :"+ totalDeo);

        int totalSunScreen= 0;
        bestSellingP = (OrderInfo)hygrLL.getFirst();
        while (bestSellingP !=null)
        {
            totalSunScreen += bestSellingP.getNumSunScreen();
            bestSellingP = (OrderInfo)hygrLL.getNext();
        }
        System.out.println("Total SunScreen had been sold for the Whole year :"+ totalSunScreen);

        if (totalLipstick >= totalDeo && totalLipstick >= totalSunScreen)
        {
            System.out.println("\nThe best-Selling Item for The Entire Year is\t: LipsStick with " + totalLipstick + " Sold ");
        }
        // Comparing 2nd no with 1st and 3rd no
        else if (totalDeo >= totalLipstick && totalDeo >= totalSunScreen)
        {
            System.out.println("\nThe best-Selling Item for The Entire Year is\t: Deodorant with " + totalDeo + " Sold ");

        }
        else
            System.out.println("\nThe best-Selling Item for The Entire Year is\t: Sun Screen with " + totalSunScreen + " Sold ");

        //Ascertain total number of tax (5%) that had been collected for the whole year. 
        obj = (OrderInfo)hygrLL.getFirst();
        double totalTax= 0.00;
        while(obj !=null){
            totalTax += obj.govTax();
            obj = (OrderInfo)hygrLL.getNext();
        }
        System.out.println("\nTotal tax had been collected for the Whole year\t:RM "+ df.format(totalTax));

    }
}

