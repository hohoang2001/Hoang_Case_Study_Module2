package Sv;

import Models.Module;
import Utils.FileUtils;

import java.util.List;

public class ModuleList {
    static List<Module> moduleList= FileUtils.readFile("/Users/mac/Hoang_Case_Study_Module2/Case Study Module2/src/Data/Module.csv",Module.class);

   public static boolean searchCheckModule(int id){
       for (Module module:moduleList) {
           if (module.getIdModule() == id){
               return true;
           }
       }
       return false;
   }
}
