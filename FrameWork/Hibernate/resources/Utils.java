package com;

/**
 * Created by xiongping on 2018/2/1.
 */
public class Utils {
    public static String convert2Camel_Case(String alias){
        if (!alias.contains("_")){
            return alias.toLowerCase();
        }else {
            String result = "";
            String[] aliases = alias.split("_");
            for (int i = 0,len = aliases.length; i < len; i++) {
                if (i == 0) {
                    result += aliases[i].toLowerCase();
                } else {
                    String aliasMeta = aliases[i];
                    if (aliasMeta.length() > 1) {
                        result += aliasMeta.substring(0, 1).toUpperCase();
                        result += aliasMeta.substring(1, aliasMeta.length()).toLowerCase();
                    }else {
                        result += aliasMeta.toUpperCase();
                    }
                }
            }
            return result;
        }
    }
}
