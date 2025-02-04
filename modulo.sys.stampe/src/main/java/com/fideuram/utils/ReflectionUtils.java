package com.fideuram.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import javax.persistence.FetchType;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

/**
 * Created by
 * User: Giuseppe
 * Date: 29-gen-2010
 * Time: 14.57.12
 */
public abstract class ReflectionUtils {
    private static final String SETTER_PREFIX = "set";
    private static final String GETTER_PREFIX = "get";
    private static final String GETTER_BOOL_PREFIX = "is";

//    private static final String CACHE_PERSISTENT_FIELDS_KEY = "PERSISTENT_FIELDS";
    private static final String CACHE_FIELDS_KEY = "FIELDS";

    private static final Map<Class<?>, Map<String, List<String>>> cache = new HashMap<Class<?>, Map<String, List<String>>>();
    private static Map<Class<?>, Map<String, Method>> getterCache = new HashMap<Class<?>, Map<String, Method>>();
    private static Map<Class<?>, Map<String, Method>> setterCache = new HashMap<Class<?>, Map<String, Method>>();

//    public static boolean isLazyField(Class<?> clazz, String property) {
//    	if (!isPersistentField(clazz, property)) {
//    		return false;
//    	}
//        Field f;
//		try {
//			f = clazz.getDeclaredField(property);
//	    	for (Annotation a : f.getAnnotations()) {
//	    		if (a instanceof javax.persistence.Basic) {
//	    			javax.persistence.Basic ba = (javax.persistence.Basic)a;
//	    			if (FetchType.LAZY.equals(ba.fetch())) return true;
//	    		} else if (a instanceof OneToOne) {
//    				OneToOne ba = (OneToOne)a;
//	    			if (FetchType.LAZY.equals(ba.fetch())) return true;
//    			} else if (a instanceof OneToMany) {
//    				OneToMany ba = (OneToMany)a;
//	    			if (FetchType.LAZY.equals(ba.fetch())) return true;
//    			} else if (a instanceof ManyToOne) {
//    				ManyToOne ba = (ManyToOne)a;
//	    			if (FetchType.LAZY.equals(ba.fetch())) return true;
//    			} else if (a instanceof ManyToMany) {
//    				ManyToMany ba = (ManyToMany)a;
//	    			if (FetchType.LAZY.equals(ba.fetch())) return true;
//    			}
//	    	}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	return false;
//    }
//    public static boolean isPersistentField(Class<?> clazz, String property) {
//    	return getPersistentFields(clazz).contains(property);
//    }
//    public static List<String> getPersistentFields(Class<?> clazz) {
//
//    	List<String> rv = new ArrayList<String>();
//
//    	Map<String, List<String>> classData = cache.get(clazz);
//        if (classData != null) {
//        	List<String> pp = classData.get(CACHE_PERSISTENT_FIELDS_KEY);
//        	if (pp != null) {
//                rv.addAll(pp);
//        		return rv;
//        	}
//        } else {
//        	classData = new HashMap<String, List<String>>();
//        	cache.put(clazz, classData);
//        }
//
//        for (Field f : clazz.getDeclaredFields()) {
//        	for (Annotation a : f.getAnnotations()) {
//        		if (a.annotationType().equals(javax.persistence.Column.class) ||
//        				a.annotationType().equals(javax.persistence.OneToOne.class) ||
//        				a.annotationType().equals(javax.persistence.OneToMany.class) ||
//        				a.annotationType().equals(javax.persistence.ManyToOne.class) ||
//        				a.annotationType().equals(javax.persistence.ManyToMany.class)
//        		) {
//        			rv.add(f.getName());
//        		}
//        	}
//        }
//        if (!Object.class.equals(clazz.getSuperclass())) {
//        	rv.addAll(getPersistentFields(clazz.getSuperclass()));
//        }
//        Collections.sort(rv);
//        List<String> tc = new ArrayList<String>();
//        tc.addAll(rv);
//        classData.put(CACHE_PERSISTENT_FIELDS_KEY, tc);
//
//        return rv;
//    }

    public static List<String> getClassProperties(Class<?> clazz) {
    	List<String> rv = new ArrayList<String>();
        
    	Map<String, List<String>> classData = cache.get(clazz);
        if (classData != null) {
        	List<String> pp = classData.get(CACHE_FIELDS_KEY);
        	if (pp != null) {
                rv.addAll(pp);
        		return rv;
        	}
        } else {
        	classData = new HashMap<String, List<String>>();
        	cache.put(clazz, classData);
        }

        for (Method m : clazz.getMethods()) {
            if (m.getName().startsWith(SETTER_PREFIX)) {
                String prop = m.getName().substring(SETTER_PREFIX.length());
                if (getGetterMethod(prop, clazz) != null && getSetterMethod(prop, clazz) != null) {
                    prop = prop.substring(0, 1).toLowerCase() + prop.substring(1);
                    rv.add(prop);
                }
            }
        }
        if (!Object.class.equals(clazz.getSuperclass())) {
        	rv.addAll(getClassProperties(clazz.getSuperclass()));        	
        }
        Collections.sort(rv);
        List<String> tc = new ArrayList<String>();
        tc.addAll(rv);
        classData.put(CACHE_FIELDS_KEY, tc);
        
        return rv;
    }

    public static Method getSetterMethod(String property, Class<?> clazz) {
        Map<String, Method> classData = setterCache.get(clazz);
        if (classData != null) {
            Method m = classData.get(property);
            if (m != null) {
                return m;
            }
        } else {
            classData = new HashMap<String, Method>();
            setterCache.put(clazz, classData);
        }

        Method[] met = clazz.getMethods();
        for (Method m : met) {
            if (Modifier.isPublic(m.getModifiers()) &&
                    m.getName().equalsIgnoreCase(SETTER_PREFIX + property) &&
                    m.getParameterTypes().length == 1
                    ) {

                classData.put(property, m);
                return m;
            }
        }
        return null;
    }

    public static List<Method> getSetterMethods(Class<?> clazz) {
        List<Method> rv = new ArrayList<Method>();
        List<String> ps = getClassProperties(clazz);
        for (String p : ps) {
            rv.add(getSetterMethod(p, clazz));
        }
        return rv;
    }

    public static Method getGetterMethod(String property, Class<?> clazz) {
        Map<String, Method> classData = getterCache.get(clazz);
        if (classData != null) {
            Method m = classData.get(property);
            if (m != null) {
                return m;
            }
        } else {
            classData = new HashMap<String, Method>();
            getterCache.put(clazz, classData);
        }

        Method[] met = clazz.getMethods();
        for (Method m : met) {
            if (Modifier.isPublic(m.getModifiers()) &&
                    m.getParameterTypes().length == 0 &&
                    (
                            m.getName().equalsIgnoreCase(GETTER_PREFIX + property) ||
                                    (
                                            m.getName().equalsIgnoreCase(GETTER_BOOL_PREFIX + property) &&
                                                    implementaEstende(m.getReturnType(), Boolean.class)
                                    )
                    )
                    ) {
                classData.put(property, m);
                return m;
            }
        }
        return null;
    }

    public static List<Method> getGetterMethods(Class<?> clazz) {
        List<Method> rv = new ArrayList<Method>();
        List<String> ps = getClassProperties(clazz);
        for (String p : ps) {
            rv.add(getGetterMethod(p, clazz));
        }
        return rv;
    }

    public static boolean implementaEstende(Class<?> t, Class<?> s) {
        boolean rv = false;
        if (t != null && s != null) {
            if (t.equals(s) || implementaEstende(t.getSuperclass(), s)) {
                rv = true;
            } else {
                Class<?>[] ss = t.getInterfaces();
                if (ss != null && ss.length > 0) {
                    for (Class<?> c : ss) {
                        if (implementaEstende(c, s)) {
                            rv = true;
                            break;
                        }
                    }
                }
            }
        }
        return rv;
    }

}
