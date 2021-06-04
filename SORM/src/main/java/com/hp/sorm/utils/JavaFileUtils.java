package com.hp.sorm.utils;

import com.hp.sorm.bean.ColumInfo;
import com.hp.sorm.bean.JavaFieldGetSet;
import com.hp.sorm.bean.TableInfo;
import com.hp.sorm.core.DBManager;
import com.hp.sorm.core.MysqlTypeConvertor;
import com.hp.sorm.core.TableContext;
import com.hp.sorm.core.TypeConvertor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 封装了生成java源文件的常用操作
 * @author huangpan
 */
public class JavaFileUtils {
    /**
     * 根据字段信息生成java属性信息，如var username--->private String username;以及相应的get，set方法
     * @param column
     * @param convertor
     * @return
     */
    public static JavaFieldGetSet createFieldGetSetSRC(ColumInfo column, TypeConvertor convertor){
        JavaFieldGetSet jfgs=new JavaFieldGetSet();
//        System.out.println(column.getDataType());
//        System.out.println(column.getDataType().toLowerCase());
        String javaFieldType =convertor.databaseType2JavaType(column.getDataType().toLowerCase());
//        System.out.println(javaFieldType);
        jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
        //生成get方法源码
        StringBuilder getSrc =new StringBuilder();
        getSrc.append("\tpublic "+javaFieldType+" get"+StringUtils.firstChar2UpperCase(column.getName())+"(){\n");
        getSrc.append("\t\treturn "+column.getName()+";"+"\n");
        getSrc.append("\t}\n");
        jfgs.setGetInfo(getSrc.toString());
        //生成set方法源码
        StringBuilder setSrc=new StringBuilder();
        setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+"(");
        setSrc.append(javaFieldType+" "+column.getName()+"){\n");
        setSrc.append("\t\tthis."+column.getName()+"="+column.getName()+";\n");
        setSrc.append("\t}\n");
        jfgs.setSetInfo(setSrc.toString());
        return jfgs;
    }

    /**
     * 根据表信息生成java类的源码
     * @param tableInfo
     * @param convertor
     * @return
     */
    public static String createJavaSrc(TableInfo tableInfo,TypeConvertor convertor){
        StringBuilder str=new StringBuilder();
        Map<String, ColumInfo> columns = tableInfo.getColumns();
        List<JavaFieldGetSet> javaFields=new ArrayList<>();
        for (ColumInfo c:columns.values()){
            javaFields.add(createFieldGetSetSRC(c,convertor));
        }
        //生成package语句
        str.append("package "+ DBManager.getConf().getPoPackage()+";\n\n");
        //生成import语句
        str.append("import java.sql.*;\n");
        str.append("import java.util.*;\n\n");
        //生成类声明语句
        str.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+"{\n");
        //生成属性
        for (JavaFieldGetSet f:javaFields){
            str.append(f.getFieldInfo());
        }
        //生成get方法
        for (JavaFieldGetSet f:javaFields){
            str.append(f.getGetInfo());
        }
        str.append("\n\n");
        //生成set方法
        for (JavaFieldGetSet f:javaFields){
            str.append(f.getSetInfo());
        }
        //生成类结束语句
        str.append("}\n");
//        System.out.println(str);
        return str.toString();
    }

    public static void createJavaPOFile(TableInfo tableInfo,TypeConvertor convertor){

        String src=createJavaSrc(tableInfo,convertor);
        String srcPath=DBManager.getConf().getSrcPath()+"/";
        String poPackage=DBManager.getConf().getPoPackage().replaceAll("\\.","/");
//        System.out.println(poPackage);
        File f=new File(srcPath+poPackage);
//        System.out.println(f.getAbsolutePath()+"**************************");

        if (!f.exists()){
            f.mkdirs();
        }

        BufferedWriter bw=null;
        try {
            bw=new BufferedWriter(new FileWriter(f.getAbsoluteFile()+"/"+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java"));
            bw.write(src);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (bw!=null){
                    bw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        Map<String, TableInfo> tables = TableContext.tables;
        TableInfo actor = tables.get("actor");
        TableInfo country=tables.get("country");
        TableInfo city=tables.get("city");
        TableInfo language=tables.get("language");
        TableInfo store=tables.get("store");

        createJavaPOFile(actor,new MysqlTypeConvertor());
        createJavaPOFile(country,new MysqlTypeConvertor());
        createJavaPOFile(city,new MysqlTypeConvertor());
        createJavaPOFile(language,new MysqlTypeConvertor());
        createJavaPOFile(store,new MysqlTypeConvertor());

    }
}
