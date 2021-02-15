import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.IOException;


public class ElectricalBills {

    private static JFrame address;
    private static JFrame greet;
    private static JFrame name;
    
    public static void main(String[] args) {
       
        greet=new JFrame();
         JOptionPane.showMessageDialog(greet, "Welcome to National Energy Company",
            "Hi, Welcome  ", JOptionPane.INFORMATION_MESSAGE);
        name=new JFrame();
          String  Name = JOptionPane.showInputDialog(name, "What's your name?");
          JOptionPane.showMessageDialog(name, "Welcome " + Name );
        
        address=new JFrame();
          String Address =JOptionPane.showInputDialog(address, "Fill in your address house?");
                JOptionPane.showMessageDialog(address, "Will be proceed with this address, "+Address +"" +Name);
                

        try
        {
            Scanner scan = new Scanner(System.in);
            char respond;
            
            int ratekWh[] = {200,100,300,300,901};
            String ratekWhDisplay[] = {"1-200","201-300","301-600","601-900",">901"};
            String input = JOptionPane.showInputDialog("Enter your kWh used: ");
            double First = Double.parseDouble(input);
            while(First > 200)
                {
                input = JOptionPane.showInputDialog("RE-Enter your first" +ratekWh[0]+ "kWh ("+ratekWhDisplay[0]+" kWh) per month: ");
                First = Double.parseDouble(input);
                }
            int count = 1;
            input = JOptionPane.showInputDialog("Do you want to continue? Y:YES @ N:NO :");
            respond = input.charAt(0);
            
            int electricity = 0;
            if(respond == 'Y')
            {
                for (int i=1; i<5; i++)
                {
                    input = JOptionPane.showInputDialog("Enter your first" +ratekWh[i]+ "kWh ("+ratekWhDisplay[i]+" kWh) per month: ");
                    electricity = Integer.parseInt(input);
                    
                        while(electricity > ratekWh[i])
                        {
                        input = JOptionPane.showInputDialog("RE-Enter your first" +ratekWh[i]+ "kWh ("+ratekWhDisplay[i]+" kWh) per month: "); 
                        electricity = Integer.parseInt(input);
                        }
                        
                    count++;
                    input = JOptionPane.showInputDialog("Do you want to continue? Y:YES @ N:NO :");
                    respond = input.charAt(0);
                    
                    if(respond == 'N')
                    break;
                }
            }
            
            else
            {
                System.out.print("WARNING! Insert incorrect ");
            }
            
            double pricePerUnit[] = {0.218,0.344,0.516,0.546,0.571};
            double estimatedBill = 0.0;
            double totalConsumption = 0;
            double SST = 0.0;
            if (count == 1)
            {
                System.out.println("Enter your first" +ratekWh[0]+ "kWh ("+ratekWhDisplay[0]+" kWh) per month: " +ratekWh[0]+"RM"+(First*pricePerUnit[0]));
                estimatedBill = First*pricePerUnit[0];
                totalConsumption = ratekWh[0];
            }
            else
            {
                for(int i=0; i<count-1; i++)
            {
                System.out.println("Enter your first" +ratekWh[i]+ "kWh ("+ratekWhDisplay[i]+" kWh) per month: " +ratekWh[i]+"RM"+(ratekWh[i]*pricePerUnit[i]));
                estimatedBill = estimatedBill + ratekWh[i]*pricePerUnit[i];
                totalConsumption = totalConsumption + ratekWh[i];
            }
                
            System.out.println("Enter your first" +ratekWh[count-1]+" kWh ("+ratekWhDisplay[count-1]+" kWh) per month: " +electricity+"RM"+(electricity*pricePerUnit[count-1]));
            estimatedBill = estimatedBill + (electricity*pricePerUnit[count-1]);
            totalConsumption = totalConsumption + (electricity);
            }
            System.out.println("Total Consumption (RM): " +estimatedBill);
            System.out.println("Total Electricity consumptions (kWh): " +totalConsumption);
            
            if (totalConsumption>700)
            SST = (totalConsumption - 700)*0.06;
            System.out.println("6% SST will be charge because Use >600kWh are used: " +SST);
            System.out.println("Total current bill is: " +(estimatedBill + SST));
            
            throw new IOException();
            }
            catch (IOException ioe)
            { 
                System.out.println(" Your Address  "  + Address + ""  + Name);
                System.out.println("...........!"
                        + "Thank You!........."+ Name );
            }
    }
    
}
