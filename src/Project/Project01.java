package Project;

import java.util.Scanner;

public class Project01 {
    public static void main(String[] args) {

        int itemNumber, invalidCounter = 0;
        double itemPrice = 0;
        double GRateInput, GRate, QRateInput, QRate, subTotalPrice = 0, totalPrice = 0, GST, QST;
        final int ITEM_NUMBER_MIN = 1, ITEM_NUMBER_MAX = 10;
        final double ITEM_PRICE_MIN = 0, ITEM_PRICE_MAX = 1000;
        final double GST_MIN = 0, GST_MAX = 14;
        final double QST_MIN = 0, QST_MAX = 17;

        Scanner scanner = new Scanner(System.in);

        // number of items
        do{
            System.out.print("Please enter the number of items bought [1...10]: ");
            itemNumber = scanner.nextInt();
            if(itemNumber < ITEM_NUMBER_MIN || itemNumber > ITEM_NUMBER_MAX)
                invalidCounter++;
        }
        while(itemNumber < ITEM_NUMBER_MIN || itemNumber > ITEM_NUMBER_MAX);
//        System.out.println("invalidCounter: " + invalidCounter);

        // the price for each item
        for (int i = 1; i <= itemNumber; i++) {

            do{
                System.out.print("Please enter the price of item " + i + " [1...1000]: ");
                itemPrice = scanner.nextDouble();
                if(itemPrice < ITEM_PRICE_MIN || itemPrice > ITEM_PRICE_MAX)
                    invalidCounter++;
            }
            while(itemPrice < ITEM_PRICE_MIN || itemPrice > ITEM_PRICE_MAX);
        }
//        System.out.println("invalidCounter: " + invalidCounter);

        // the GRate
        do{
            System.out.print("Please enter the tax rate of GST in % [0...14]: ");
            GRateInput = scanner.nextDouble();
            if(GRateInput < GST_MIN || GRateInput > GST_MAX)
                invalidCounter++;
        }
        while(GRateInput < GST_MIN || GRateInput > GST_MAX);
        GRate = GRateInput / 100;
//        System.out.println("GRate is: " + GRate);
//        System.out.println("invalidCounter: " + invalidCounter);


        // the QRate
        do{
            System.out.print("Please enter the tax rate of QST in % [0...17]:");
            QRateInput = scanner.nextDouble();
            if(QRateInput < QST_MIN || QRateInput > QST_MAX)
                invalidCounter++;
        }
        while(QRateInput < QST_MIN || QRateInput > QST_MAX);
        QRate = QRateInput /100;
//        System.out.println("QRate is: " + QRate);
//        System.out.println("invalidCounter: " + invalidCounter);

        scanner.close();

        subTotalPrice = itemPrice * itemNumber;
        GST = subTotalPrice * GRate;
        QST = (subTotalPrice + GST) * QRate;
        totalPrice = subTotalPrice + GST +QST;


        if(invalidCounter > 0) {
            System.out.printf("You have entered " + invalidCounter + " invalid inputs.%n");
        }

        System.out.printf("Sub Total: $ %.2f", subTotalPrice);
        System.out.printf("%n");
        System.out.printf("GST: $ %.2f", GST);
        System.out.printf("%n");
        System.out.printf("QST: $ %.2f", QST);
        System.out.printf("%n");
        System.out.printf("Total: $ %.2f", totalPrice);
        System.out.printf("%n");
    }
}
