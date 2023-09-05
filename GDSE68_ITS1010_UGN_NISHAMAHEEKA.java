import java.util.*;
class test {
    public static Scanner input = new Scanner(System.in);
    public static String[][] suppliers = new String[0][2];
    public static String[][] items =new String[0][6];
    public static String[] category =new String [0];
    public static void main(String[] args) {
        printLoginPage();
    }
    public static String name = "Maheeka";
    public static String password = "1234";
    public static void printLoginPage() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                         LOGIN PAGE                                           |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true) {
            System.out.print("User name : ");
            String Inputname = input.next();
            if (Inputname.equals(name)) {
                break;
            }
            System.out.println("User name invalid. please try again! ");
        }
        while (true) {
            System.out.print("password : ");
            String Inputpassword = input.next();
            if (Inputpassword.equals(password)) {
                break;
            }
            System.out.println("password is incorrect. please try again! ");
        }
        homePage();
    }
    public static void homePage() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                           WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                            |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("[1] Change the Credentials                       [2] Supplier Manage");
        System.out.println("[3] Stock Manage                                 [4] Log out");
        System.out.println("[5] Exit the System");
        System.out.print("Enter an option to continue > ");
        int options = input.nextInt();
        switch (options) {
            case 1:
                System.out.println("Changing the Credentials.");
                credentialManage();
                break;
            case 2:
                System.out.println("Supplier Managing.");
                supplierManage();
                break;
            case 3:
                System.out.println("Stock Managing.");
                stockManage();
                break;
            case 4:
                System.out.println("Log out");
                logOut();
                break;
            case 5:
                System.out.println("Exit the System");
                exit();
                break;
            default:
                System.out.println("Invalid Option. Please Try again");
        }
    }
    public static void credentialManage() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                     CREDENTIAL MANAGE                                        |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true) {
            System.out.print("Please enter the user name to verify it's you: ");
            String Inputname = input.next();
            if (Inputname.equals(name)) {
                System.out.println("Hay " + Inputname);
                break;
            }
            System.out.println("Invalid user name. Try again! ");
            System.out.println();
        }
        while (true) {
            System.out.print("Enter your current password: ");
            String Inputpasswords = input.next();
            if (Inputpasswords.equals(password)) {
                break;
            }
            System.out.println("Incorrect password.try again!");
            System.out.println();
        }
        System.out.print("Enter your New password:");
        password = input.next();
        System.out.print("password changed successfully! ");
        while (true) {
            System.out.println("Do you want to go home Page (Y/N)?");
            char option = input.next().charAt(0);
            if (option == 'Y' || option == 'y') {
                homePage();
            } else if (option == 'N' || option == 'n') {
                System.exit(0);
            } else {
                System.out.println("Wrong Character");
            }
        }
    }
    public static void logOut() {
        printLoginPage();
    }
    public static void exit(){
        System.exit(0);
    }
    public static void supplierManage() {
        clearConsole();
        while (true){
            System.out.println("+----------------------------------------------------------------------------------------------+");
            System.out.println("|                                      SUPPLIER MANAGE                                         |");
            System.out.println("+----------------------------------------------------------------------------------------------+");
            System.out.println("[1] Add Supplier                       [2] Update Supplier");
            System.out.println("[3] Delete Supplier                    [4] View suppliers");
            System.out.println("[5] Search Supplier                    [6] Home Page");
            System.out.print("Enter an option to continue > ");
            int options = input.nextInt();
            switch (options) {
                case 1:
                    addingSuppliers();
                    break;
                case 2:
                    updateSupplier();
                    break;
                case 3:
                    deleteSupplier();
                    break;
                case 4:
                    viewSupplier();
                    break;
                case 5:
                    searchSupplier();
                    break;
                case 6:
                    homePage();
                    break;
                default:
                    System.out.println("Invalid Option. Please Try again");
            }
        }
    }

    public static void addingSuppliers() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                        ADD SUPPLIER                                          |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true) {
            System.out.print("Supplier ID     :  ");
            String id = input.next();
            boolean flag = false;
            for (int i = 0; i < suppliers.length; i++) {
                if (id.equals(suppliers[i][0])) {
                    System.out.println("already exists. try another supplier id! ");
                    System.out.println();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                grow();
                suppliers[suppliers.length - 1][0] = id;
                System.out.print("Supplier name   :  ");
                suppliers[suppliers.length - 1][1] = input.next();
                while(true) {
                    System.out.print("added Successfully! Do you want to add another Supplier(Y/N)?");
                    System.out.println();
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        supplierManage();
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            }
        }
    }
    public static void grow() {
        String[][] temp = new String[suppliers.length + 1][2];
        for (int i = 0; i < suppliers.length; i++) {
            for (int j = 0; j < suppliers[i].length; j++) {
                temp[i][j] = suppliers[i][j];
            }
        }
        suppliers = temp;
    }
    public static void updateSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                     UPDATE SUPPLIER                                          |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true) {
            System.out.print("Supplier ID   : ");
            String id = input.next();
            int index = -1;
            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(id)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.println("Supplier name   : "+ suppliers[index][1]);
                System.out.println();
                System.out.print("Enter the new Supplier name : ");
                suppliers[index][1] = input.next();
                System.out.print("Updated Successfully! ");
                System.out.print("Do you want to Update another Supplier(Y/N)?");
                char option = input.next().charAt(0);
                if (option =='N' || option=='n'){
                    supplierManage();
                    break;
                }
            } else {
                System.out.println("Can't find supplier id.try again!");
                System.out.println();
            }
        }
    }
    public static void deleteSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                     DELETE SUPPLIER                                          |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true) {
            System.out.print("Supplier ID    : ");
            String id = input.next();
            int index = -1;
            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(id)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                suppliers[index][0] = "null";
                removeSupplier();
                System.out.print("Deleted Successfully!");
                while (true) {
                    System.out.print("Do you want to Delete another Supplier(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'N' || option == 'n') {
                        supplierManage();
                        break;
                    } else if (option == 'Y' || option == 'y') {
                        deleteSupplier();
                        break;
                    } else {
                        System.out.println("wrong character.try again!");
                    }
                }
            }
            else{
                System.out.println("can't find supplier id");
            }
        }
    }
    public static void viewSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                     VIEW SUPPLIER                                            |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("+----------------------------+------------------------------+");
        System.out.println("|        SUPPLIER ID         |         SUPPLIER NAME        |");
        System.out.println("+----------------------------+------------------------------+");
        for (int i = 0; i < suppliers.length; i++) {
            System.out.printf("|%15S             |%19S           |%n" ,suppliers[i][0],suppliers[i][1]);
        }
        System.out.println("+----------------------------+------------------------------+");
        while (true) {
            System.out.print("Do you want to go Supplier manage page(Y/N)?");
            char option = input.next().charAt(0);
            if (option == 'Y' || option == 'y') {
                supplierManage();
                break;
            } else if (option == 'N' || option == 'n') {
                System.exit(0);
            } else {
                System.out.println("Can't find supplier id.try again!");
            }
        }
    }
    public static void searchSupplier() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                     SEARCH SUPPLIER                                          |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true) {
            System.out.print("Supplier ID   : ");
            String id = input.next();
            int index = -1;

            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(id)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.println("Supplier name : " + suppliers[index][1]);
                suppliers[index][1] = name;

                while (true) {
                    System.out.print("Search Successfully! Do you want to add another find(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    } else if (option == 'N' || option == 'n') {
                        supplierManage();
                        break;
                    }
                }
            }else {
                System.out.println("Can't find supplier id.try again!");
            }
        }
    }
    public static void stockManage(){
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                    STOCK MANAGEMENT                                          |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("[1] Manage Item Categories                              [2] Add Item");
        System.out.println("[3] Get Items Supplier Wise                             [4] View Items");
        System.out.println("[5] Rank Items Per Unit Price                           [6] Home Page");
        System.out.print("Enter an option to continue > ");
        int options = input.nextInt();
        switch (options) {
            case 1:
                manageItems();
                break;
            case 2:
                addItem();
                break;
            case 3:
                getItemsupplierWise();
                break;
            case 4:
                viewItems();
                break;
            case 5:
                rankItemsPerUnitPrice();
                break;
            case 6:
                homePage();
                break;
            default:
                System.out.println("Invalid Option. Please Try again");
        }
    }
    public static void manageItems() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                  MANAGE ITEM CATEGORY                                        |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("[1] Add New Item Category                               [2] Delete Item Category");
        System.out.println("[3] Update Item Category                                [4] Stock Management");
        System.out.print("Enter an option to continue > ");
        int options = input.nextInt();
        switch (options) {
            case 1:
                addItemCategory();
                break;
            case 2:
                deleteItemCategory();
                break;
            case 3:
                updateItemsCategory();
                break;
            case 4:
                stockManage();
                break;
            default:
                System.out.println("Invalid Option. Please Try again");
        }
    }
    public static void addItemCategory() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                    ADD ITEM CATEGORY                                         |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true){
            System.out.print("Enter the new item category: ");
            String item = input.next();
            boolean flag = false;
            for (int i = 0; i < category.length; i++) {
                if(item.equals(category[i])){
                    System.out.println("already exists. try another item category! ");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                growcategory();
                category[category.length-1] = item;
                while (true) {
                    System.out.print("added Successfully! Do you want to add another item category(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    } else if (option == 'N' || option == 'n') {
                        manageItems();
                        break;
                    } else {
                        System.out.println("Can't find supplier id.try again!");
                    }
                }
            }
        }
    }
    public static void deleteItemCategory() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                    DELETE ITEM CATEGORY                                      |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while(true){
            System.out.print("Enter category to Delete : ");
            String categoryId = input.next();
            int index = -1;

            for (int i = 0; i < category.length; i++) {
                if (category[i].equals(categoryId)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                category[index]="null";
                removeCategory();
                System.out.print("Deleted Successfully!");
                while(true) {
                    System.out.println("Do you want to Delete another Category(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        manageItems();
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            } else{
                System.out.println("can't find category");
            }
        }
    }
    public static void updateItemsCategory() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                  UPDATE ITEM CATEGORY                                        |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while(true) {
            System.out.print("Enter category to Update : ");
            String Item = input.next();
            int index = -1;
            for (int i = 0; i < category.length; i++) {
                if (category[i].equals(Item)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.print("Updated New Item name :");
                String name = input.next();
                category[index] = name;
                System.out.print("Updated Successfully!");
                while(true) {
                    System.out.print("Do you want to Update another Category(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        manageItems();
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            } else {
                System.out.println("Can't find category.try again!");
            }
        }
    }
    public static void addItem() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                         ADD ITEM                                             |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        if(category.length==0) {
            System.out.print("OOPS! It seems that you don't have any item categories in the System.");
            while(true) {
                System.out.print("Do you want to add a new item category?(Y/N)");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    addItemCategory();
                    //return;
                }else if (option =='N' || option=='n'){
                    stockManage();
                }else {
                    System.out.println("Wrong Character");
                }
            }
        }
        if(suppliers.length==0) {
            System.out.print("OOPS! It seems that you don't have any suppliers in the System.");
            while(true) {
                System.out.print("Do you want to add a new Supplier?(Y/N)");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    addingSuppliers();
                    //return;
                }else if (option =='N' || option=='n'){
                    stockManage();
                }else {
                    System.out.println("Wrong Character");
                }
            }
        }
        while (true) {
            boolean flag = false;
            System.out.print("Item Code   : " );
            String code = input.next();
            for (int i = 0; i < items.length; i++) {
                if(items[i][0].equals(code)){
                    flag = true;
                    System.out.println(" Item is already Exists" );
                    break;
                }
            }
            if(!flag){
                growItem();
                items[items.length-1][0] = code;
                System.out.println( );
                System.out.println("suppliers List : ");
                System.out.println("+---------------+----------------------+-----------------------+");
                System.out.println("|       #       |       SUPPLIER ID    |      SUPPLIER NAME    |");
                System.out.println("+---------------+----------------------+-----------------------+");
                for (int i = 0; i < suppliers.length; i++) {
                    System.out.printf("|%8S       |%15S       |%16S       |%n",(i+1),suppliers[i][0],suppliers[i][1]);
                }
                System.out.println("+---------------+----------------------+-----------------------+");
                System.out.print("Enter the Supplier Number > ");
                int index = input.nextInt();
                items[items.length-1][1] = suppliers[index-1][0];

                System.out.println("Item Categories: ");
                // System.out.println(Arrays.toString(category));
                System.out.println("+---------------+---------------------------+");
                System.out.println("|         #     |      CATEGORY NAME        |");
                System.out.println("+---------------+---------------------------+");
                for (int i = 0; i < category.length; i++) {
                    System.out.printf("|%8S       |%18S         |%n",(i+1),category[i]);
                }System.out.println("+---------------+---------------------------+");
                System.out.print("Enter the Category Number > ");
                index = input.nextInt();
                items[items.length-1][2] = category[index-1];

                System.out.print("Description : ");
                items[items.length-1][3] = input.next();
                
                System.out.print("Unit Price : ");
                items[items.length-1][4] = input.next();

                System.out.print("QTY on Hand : ");
                items[items.length-1][5] = input.next();
                while(true) {
                    System.out.print("added Successfully! Do you want to add another item(Y/N)?");
                    char option = input.next().charAt(0);
                    if (option == 'Y' || option == 'y') {
                        break;
                    }else if (option =='N' || option=='n'){
                        stockManage();
                        break;
                    }else {
                        System.out.println("Wrong Character");
                    }
                }
            }
        }
    }
    public static void growItem() {
        String[][] temp = new String[items.length + 1][6];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                temp[i][j] = items[i][j];
            }
        }
        items = temp;
    }
    public static void growcategory() {
        String[] temp = new String[category.length + 1];
        for (int i = 0; i < category.length; i++) {
            temp[i] = category[i];
        }
        category = temp;
    }
    public static void getItemsupplierWise() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                    SEARCH SUPPLIER                                           |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        while (true) {
            System.out.print("Enter Supplier Id: ");
            String ID = input.next();
            int index = -1;

            for (int i = 0; i < suppliers.length; i++) {
                if (suppliers[i][0].equals(ID)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.println("Supplier Name :"+suppliers[index][1]);

                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                System.out.println("|       ITEM CODE       |       DESRIPTION      |       UNIT PRICE      |      QTY ON HAND      |        CATEGORY       |");
                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
                for (int i = 0; i < items.length; i++) {
                    if (ID.equals(items[i][1])) {
                        System.out.printf("|%13S          |%15S        |%13S          |%14S         |%14S         |%n",items[i][0],items[i][3],items[i][4],items[i][5],items[i][2]);
                    }
                }
                System.out.println("+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+");
            } else {
                System.out.println("Supplier ID not found.");
            }
            while (true) {
                System.out.print("Search Successfully! Do you want to another search(Y/N)?");
                char option = input.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    break;
                } else if (option == 'N' || option == 'n') {
                    stockManage();
                } else {
                    System.out.println("Wrong Character");
                }
            }
        }
    }
    public static void viewItems() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                          VIEW ITEMS                                                       |");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < category.length; i++) {
            System.out.println(category[i]);
            System.out.println("+-----------------------+----------------------+------------------------+--------------------------+--------------------------+");
            System.out.println("|           SID         |         CODE         |           DESC         |           PRICE          |             QTY          |");
            System.out.println("+-----------------------+----------------------+------------------------+--------------------------+--------------------------+");
            for (int j = 0; j < items.length; j++) {
                if (category[i].equals(items[j][2])) {
                    System.out.printf("|%13S          |%15S       |%13S           |%14S            |%14S            |%n",items[j][1],items[j][0], items[j][3],items[j][4],items[j][5]);
                }
            }
            System.out.println("+-----------------------+----------------------+------------------------+--------------------------+--------------------------+");
        }
        while (true) {
            System.out.print("Do you want to go stock manage page(Y/N)?");
            char option = input.next().charAt(0);
            if (option == 'Y' || option == 'y') {
                stockManage();
            } else if (option == 'N' || option == 'n') {
                System.exit(0);
            } else {
                System.out.println("Wrong Character");
            }
        }
    }
    public static void rankItemsPerUnitPrice() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                    RANKED UNIT PRICE                                         |");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        int[] temp=new int[items.length];
        for (int i = 0; i < items.length; i++) {
            temp[i]=Integer.parseInt(items[i][4]);
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length-1; j++) {
                if (temp[j]>temp[j+1]){
                    int x=temp[j];
                    temp[j]=temp[j+1];
                    temp[j+1]=x;
                }
            }
        }
        System.out.println("+---------------------+-------------------------+----------------------------+------------------------------+------------------------------+---------------------------+");
        System.out.println("|         SID         |            CODE         |               DESC         |               PRICE          |                 QTY          |               CAT         |");
        System.out.println("+---------------------+-------------------------+----------------------------+------------------------------+------------------------------+---------------------------+");

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (temp[i]==Integer.parseInt(items[j][4])){
                    System.out.printf("|%12S        |%17S         |%15S             |%17S             |%20S          |%20S       |%n",items[j][1],items[j][0],items[j][3],items[j][4],items[j][5],items[j][2]);
                }
            }
        }
        System.out.println("+---------------------+-------------------------+----------------------------+------------------------------+------------------------------+---------------------------+");
        while (true) {
            System.out.print("Do you want to go stock manage page(Y/N)?");
            char option = input.next().charAt(0);
            if (option == 'Y' || option == 'y') {
                break;
            } else if (option == 'N' || option == 'n') {
                stockManage();
            } else {
                System.out.println("Wrong Character");
            }
        }
    }
    public static void removeSupplier(){
        String [][] temp = new String[suppliers.length-1][2];
        for (int i = 0,k = 0; i < temp.length; i++) {
            if(suppliers[i][0].equals("null")){
                k++;
            }
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = suppliers[i+k][j];
            }
        }
        suppliers=temp;
    }
    public static void removeCategory(){
        String [] temp = new String[category.length-1];
        for (int i = 0,k = 0; i < temp.length; i++) {
            if(category[i].equals("null")){
                k++;
            }
            temp[i] = category[i+k];
        }
        category=temp;
    }
    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            //handle the exception
            System.err.println(e.getMessage());
        }
    }
}
