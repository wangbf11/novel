package com.read.booklibrary.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONUtil {
    private static Gson gson = (new GsonBuilder()).create();

    public JSONUtil() {
    }

    public static <T> T parseJSON(String json, Class<T> cls)  {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return gson.fromJson(json, cls);
            } catch (Exception var3) {
                ToastUtils.show(var3.getMessage());
                return null;
            }
        }
    }

    public static <T> T parseJSON(String json, Type type){
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return gson.fromJson(json, type);
            } catch (Exception var3) {
                ToastUtils.show(var3.getMessage());
                return null;
            }
        }
    }

    public static String toJSON(Object entity) {
        if (entity == null) {
            return null;
        } else {
            try {
                return gson.toJson(entity);
            } catch (Exception var3) {
                ToastUtils.show(var3.getMessage());
                return null;
            }
        }
    }

    public static <T> T mapToBean(Map<String, Object> param, Class<T> cls) {
        if (param == null) {
            return null;
        } else {
            try {
                return parseJSON(toJSON(param), cls);
            } catch (Exception var3) {
                ToastUtils.show(var3.getMessage());
                return null;
            }
        }
    }

    public static Map<String, String> BeanToMap(Object entity)  {
        if (entity == null) {
            return null;
        } else {
            try {
                Type typeToken = (new TypeToken<Map<String, String>>() {
                }).getType();
                return (Map)gson.fromJson(toJSON(entity), typeToken);
            } catch (Exception var2) {
                ToastUtils.show(var2.getMessage());
                return null;
            }
        }
    }

    public static List<Map<String, String>> BeanToList(Object entity) {
        if (entity == null) {
            return null;
        } else {
            try {
                Type typeToken = (new TypeToken<List<Map<String, String>>>() {
                }).getType();
                return (List)gson.fromJson(toJSON(entity), typeToken);
            } catch (Exception var2) {
                ToastUtils.show(var2.getMessage());
                return null;
            }
        }
    }

    public static <T> List<T> ListToBean(List<Map<String, Object>> obj, Class<T> cls) {
        if (obj == null) {
            return null;
        } else {
            try {
                List<T> result = new ArrayList();
                Iterator var4 = obj.iterator();

                while(var4.hasNext()) {
                    Map<String, Object> p = (Map)var4.next();
                    result.add(mapToBean(p, cls));
                }
                return result;
            } catch (Exception var5) {
                ToastUtils.show(var5.getMessage());
                return null;
            }
        }
    }
}
