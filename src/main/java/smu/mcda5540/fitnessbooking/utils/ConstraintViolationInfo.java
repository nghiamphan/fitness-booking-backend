package smu.mcda5540.fitnessbooking.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConstraintViolationInfo {
    public static List<String> getUniqueConstraintAttributes(String tableName) {
        List<String> uniqueFields=new ArrayList<>();
        switch (tableName) {
            case "Person":
                uniqueFields.add("email");
                uniqueFields.add("username");
                break;
            case "Instructor":
                uniqueFields.add("email");
                uniqueFields.add("username");
                uniqueFields.add("businessPhone");
                break;
            case "Location":
            case "Program":
                uniqueFields.add("name");
                break;
            default:
                break;
        }
        return uniqueFields;
    }

    public static String getViolatedAttribute(String errorMessage, Object obj, String tableName) throws IllegalAccessException {
        int startValue=errorMessage.indexOf("'",errorMessage.indexOf("Duplicate entry"))+1;
        int endValue=errorMessage.indexOf("'",startValue);
        String errorValue=errorMessage.substring(startValue, endValue);
        List<String> uniqueFields=getUniqueConstraintAttributes(tableName);
        if(tableName.equals("Instructor")) {
            for(Field f: obj.getClass().getSuperclass().getDeclaredFields()) {
                f.setAccessible(true);
                if(uniqueFields.contains(f.getName())) {
                    if(f.get(obj)!=null && f.get(obj).equals(errorValue))
                        return f.getName();
                }
                f.setAccessible(false);
            }
        }
        for(Field f: obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if(uniqueFields.contains(f.getName())) {
                if(f.get(obj)!=null && f.get(obj).equals(errorValue))
                    return f.getName();
            }
            f.setAccessible(false);
        }
        return null;
    }
}
