package Models;

public class Module implements IModel {
    private int idModule;
    private String nameModule;
    public Module(){

    }

    public Module(int idModule, String nameModule) {
        this.idModule = idModule;
        this.nameModule = nameModule;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getNameModule() {
        return nameModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule;
    }

    @Override
    public String toString() {
        return
                idModule + "," +
                        nameModule
                ;
    }

    @Override
    public void parseData(String line) {
        String[] item = line.split(",");
        this.idModule = Integer.parseInt(item[0]);
        this.nameModule = item[1];
    }
}
