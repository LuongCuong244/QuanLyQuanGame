package data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Computer;
import models.ComputerGroup;
import models.ProductCategory;
import models.TransactionHistoryItem;
import models.User;

public abstract class Data {

    private static final String rootPath = System.getProperty("user.dir") + File.separator + "data";
    private static final String computerGroupPath = rootPath + File.separator + "computer_group.json";
    private static final String computerPath = rootPath + File.separator + "computer.json";
    private static final String userPath = rootPath + File.separator + "user.json";
    private static final String productPath = rootPath + File.separator + "product.json";
    private static final String transactionHistoryPath = rootPath + File.separator + "transaction_history.json";

    public static ArrayList<ComputerGroup> computerGroups = new ArrayList<>();
    public static ArrayList<Computer> listComputers = new ArrayList<>();
    public static ArrayList<User> listUsers = new ArrayList<>();
    public static ArrayList<ProductCategory> listProductCategories = new ArrayList<>();
    public static ArrayList<TransactionHistoryItem> listTransactionHistoryItems = new ArrayList<>();

    public static void getData() {
        if (!new File(rootPath).exists()) {
            try {
                throw new Exception("Data folder not found!");
            } catch (Exception ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        setUpComputerGroups();
        setUpListComputers();
        setUpListUsers();
        setUpListProductCategories();
        setUpListTransactionHistoryItems();
    }

    public static void saveData() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        File file;
        FileWriter fw;
        if (!new File(rootPath).exists()) {
            new File(rootPath).mkdir();
        }

        try {
            file = new File(computerGroupPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            String computerGroupJson = gson.toJson(computerGroups);
            fw.write(computerGroupJson);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            file = new File(computerPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            String computerJson = gson.toJson(listComputers);
            fw.write(computerJson);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            file = new File(userPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            String userJson = gson.toJson(listUsers);
            fw.write(userJson);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            file = new File(productPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            String productJson = gson.toJson(listProductCategories);
            fw.write(productJson);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            file = new File(transactionHistoryPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            String transactionHistoryJson = gson.toJson(listTransactionHistoryItems);
            fw.write(transactionHistoryJson);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void setUpComputerGroups() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            File file = new File(computerGroupPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String json = new String(data, "UTF-8");
            Type listType = new TypeToken<ArrayList<ComputerGroup>>() {
            }.getType();
            computerGroups = gson.fromJson(json, listType);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (computerGroups == null) {
            try {
                throw new Exception("No computer group has found!");
//                ArrayList<UserGroup> userGroups2 = new ArrayList<>();
//                userGroups2.add(new UserGroup("Guest", 5000));
//                userGroups2.add(new UserGroup("Member", 5000));
//                computerGroups.add(new ComputerGroup("Default", "M???c ?????nh", userGroups2));
//
//                ArrayList<UserGroup> userGroups = new ArrayList<>();
//                userGroups.add(new UserGroup("Guest", 6000));
//                userGroups.add(new UserGroup("Member", 5500));
//                computerGroups.add(new ComputerGroup("NEW", "M??y m???i", userGroups));
//
//                ArrayList<UserGroup> userGroups1 = new ArrayList<>();
//                userGroups1.add(new UserGroup("Guest", 4500));
//                userGroups1.add(new UserGroup("Member", 4000));
//                computerGroups.add(new ComputerGroup("OLD", "M??y c??", userGroups1));
            } catch (Exception ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void setUpListComputers() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            File file = new File(computerPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String json = new String(data, "UTF-8");
            Type listType = new TypeToken<ArrayList<Computer>>() {
            }.getType();
            listComputers = gson.fromJson(json, listType);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (listComputers == null) {
            listComputers = new ArrayList<>();
            try {
                throw new Exception("No computer has found!");
//            listComputers.add(new Computer("MAY01", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY02", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY03", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY04", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY05", computerGroups.get(2)));
//            listComputers.add(new Computer("MAY06", computerGroups.get(2)));
//            listComputers.add(new Computer("MAY07", computerGroups.get(2)));
//            listComputers.add(new Computer("MAY08", computerGroups.get(2)));
//            listComputers.add(new Computer("MAY09", computerGroups.get(0)));
//            listComputers.add(new Computer("MAY10", computerGroups.get(0)));
//            listComputers.add(new Computer("MAY11", computerGroups.get(0)));
//            listComputers.add(new Computer("MAY12", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY13", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY15", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY16", computerGroups.get(1)));
//            listComputers.add(new Computer("MAY17", computerGroups.get(0)));
//            listComputers.add(new Computer("MAY18", computerGroups.get(0)));
//            listComputers.add(new Computer("MAY19", computerGroups.get(0)));
//            listComputers.add(new Computer("MAY20", computerGroups.get(0)));
            } catch (Exception ex) {
                Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            for (int i = 0; i < listComputers.size(); i++) {
                listComputers.get(i).setListProductsOrdered(new ArrayList<>());
                listComputers.get(i).setListTransactionsTransfer(new ArrayList<>());
            }
        }
    }

    private static void setUpListUsers() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            File file = new File(userPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String json = new String(data, "UTF-8");
            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();
            listUsers = gson.fromJson(json, listType);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (listUsers == null) {
            try {
                throw new Exception("Can't read user.json!");
//                listUsers.add(new User("NLcuong", "1", "Member"));
//                listUsers.get(listUsers.size() - 1).setRemainingAmount(10000);
//                listUsers.add(new User("User1", "1", "Member"));
//                listUsers.get(listUsers.size() - 1).setRemainingAmount(15000);
//                listUsers.add(new User("User2", "1", "Member"));
//                listUsers.add(new User("User3", "1", "Member"));
//                listUsers.add(new User("User4", "1", "Member"));
//                listUsers.add(new User("User5", "1", "Member"));
//                listUsers.add(new User("User6", "1", "Member"));
//                listUsers.add(new User("User7", "1", "Member"));
            } catch (Exception e) {
            }
        }
    }

    private static void setUpListProductCategories() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            File file = new File(productPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String json = new String(data, "UTF-8");
            Type listType = new TypeToken<ArrayList<ProductCategory>>() {
            }.getType();
            listProductCategories = gson.fromJson(json, listType);
        } catch (Exception e) {
            System.out.println(e);
        }

        if (listProductCategories == null) {
            try {
                throw new Exception("Can't read product.json");
//                listProductCategories.add(new ProductCategory("????? V???T"));
//                listProductCategories.get(0).addProductItem(new ProductItem("BIM TH?????NG", 5000, "VN??", "????? V???T"));
//                listProductCategories.get(0).addProductItem(new ProductItem("BIM POCA", 7000, "VN??", "????? V???T"));
//                listProductCategories.get(0).addProductItem(new ProductItem("BIM MIX", 12000, "VN??", "????? V???T"));
//                listProductCategories.get(0).addProductItem(new ProductItem("?????U PH???NG", 15000, "VN??", "????? V???T"));
//
//                listProductCategories.add(new ProductCategory("M?? T??M"));
//                listProductCategories.get(1).addProductItem(new ProductItem("1 M?? 1 TR???NG 1 X??C X??CH", 30000, "VN??", "M?? T??M"));
//                listProductCategories.get(1).addProductItem(new ProductItem("2 M?? 1 TR???NG 1 X??C X??CH", 35000, "VN??", "M?? T??M"));
//                listProductCategories.get(1).addProductItem(new ProductItem("X??C X??CH R??N", 10000, "VN??", "M?? T??M"));
//                listProductCategories.get(1).addProductItem(new ProductItem("M?? TR???NG X??C X??CH RAU", 30000, "VN??", "M?? T??M"));
//
//                listProductCategories.add(new ProductCategory("N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("B?? H??C", 15000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C C2", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C D???A", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C STING ?????", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C STING ??EN", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C STING V??NG", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C L???C", 5000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C TR?? ????O", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C Y???N", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C ?? LONG", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C COCA", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C PEPSI", 10000, "VN??", "N?????C"));
//                listProductCategories.get(2).addProductItem(new ProductItem("N?????C 7 UP", 10000, "VN??", "N?????C"));
            } catch (Exception e) {
            }
        }
    }

    private static void setUpListTransactionHistoryItems() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try {
            File file = new File(transactionHistoryPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String json = new String(data, "UTF-8");
            Type listType = new TypeToken<ArrayList<TransactionHistoryItem>>() {
            }.getType();
            ArrayList<TransactionHistoryItem> list = gson.fromJson(json, listType);
            if (list != null) {
                listTransactionHistoryItems = list;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        if(listTransactionHistoryItems == null){
            listTransactionHistoryItems = new ArrayList<>();
            System.out.println("A error occurred when read the file 'TransactionHistory.json'!");
        }
    }

    public static User getUserByUserName(String userName) {

        // bad structure: M???i m???t class ch??? n??n th???c hi???n m???t ch???c n??ng nh???t ?????nh
        for (int i = 0; i < Data.listUsers.size(); i++) {
            if (Data.listUsers.get(i).getUserName().equals(userName)) {
                return Data.listUsers.get(i);
            }
        }
        return null;
    }

    public static Computer getComputerByComputerName(String computerName) {

        // bad structure: M???i m???t class ch??? n??n th???c hi???n m???t ch???c n??ng nh???t ?????nh
        for (int i = 0; i < Data.listComputers.size(); i++) {
            if (Data.listComputers.get(i).getComputerName().equals(computerName)) {
                return Data.listComputers.get(i);
            }
        }
        return null;
    }

    public static ComputerGroup getComputerGroupByName(String groupName) {

        // bad structure: M???i m???t class ch??? n??n th???c hi???n m???t ch???c n??ng nh???t ?????nh
        for (int i = 0; i < Data.computerGroups.size(); i++) {
            if (Data.computerGroups.get(i).getGroupName().equals(groupName)) {
                return Data.computerGroups.get(i);
            }
        }
        return null;
    }
}
