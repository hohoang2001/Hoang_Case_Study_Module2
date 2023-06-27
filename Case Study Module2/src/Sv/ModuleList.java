package Sv;

import Models.Clazz;
import Models.Module;
import Utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class ModuleList {
    static String Path = "/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/data/Module.txt";
    public static List<Module> moduleList;
    public ModuleList() throws IOException, ClassNotFoundException {
        moduleList = (List<Module>) FileUtils.deserialize(Path);
    }

   public static boolean searchCheckModule(int id){
       for (Module module:moduleList) {
           if (module.getIdModule() == id){
               return true;
           }
       }
       return false;
   }
}
