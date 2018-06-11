package pers.gengq.code.generator.swagger.model;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by gengqing on 6/11/2018
 **/
public class PropertiesConvertor {

    public static List<Property> convert(Map<String, io.swagger.models.properties.Property> map) {
        List<Property> list = new ArrayList<>();
        map.forEach((s, property) -> {
            Property p = new Property();
            p.setName(s);
            p.setType(convertType(property.getType()));
            p.setDescription(property.getDescription());
            list.add(p);
        });
        return list;
    }

    public static String convertType(String org) {
        switch (org) {
            case "ref":
                return "Object";
            case "array":
                return "List";
            case "integer":
                return "int";
            case "string":
                return "String";
            default:
                return org;
        }


    }
}
