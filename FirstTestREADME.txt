RUN THIS IN DATABASE MANAGER BY ITSELF (SHIFT F6 in netbeans) to create first two profile
after Running once to set Root File

    


public static void main(String[] args) throws IOException{
        DatabaseManager dm =new DatabaseManager(new FolderManager(false));
        TableList user = dm.getTable(Tables.USER);
        User admin = new Admin();
        User productManager = new ProductManager();
        try{
        admin.setLogin(new LoginInfo("admin","password")); //Login as Admin
        productManager.setLogin(new LoginInfo("pm","password")); //Login as PM
        }
        catch(Exception e){
            System.out.println(e);
        }
        user.add(admin);
        user.add(productManager);
        System.out.println(user.toString());
        dm.serialize(user);
    }