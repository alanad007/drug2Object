package org.aa.util;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Misc {


    public static void print(Object msg)
    {
        if(msg==null)return;


        if( msg.getClass().isArray())
        {
            print("=====================ARRAY==============================");
            Object[] array=(Object[])msg;
            for(Object  t: array){
                print(t);
            }
            print("=====================ARRAY==============================");
            return;
        }

        if (msg instanceof Collection<?>){
            print("=====================COLLECTION==============================");
            ((Collection)( msg)).forEach(msgs->print(msgs));
            print("=====================COLLECTION==============================");
            return;
        }

        if (msg instanceof Map<?,?>){
            print("=====================MAP==============================");
            Map map=(Map)msg;

            for ( Object key : map.keySet() ) {

                print(key+" :  "+map.get(key));
            }
            print("=====================MAP==============================");
            return;
        }
        PrintStream ps = null;
        try {
            ps = new PrintStream(System.out, true, "Cp850");
            ps.println(msg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println(msg);
        }


    }


    public static void printUpdate(Object msg)
    {
        if(msg==null)return;


        if (msg instanceof Collection<?>){
            print("=====================COLLECTION==============================");
            ((Collection)( msg)).forEach(msgs->print(msgs));
            print("=====================COLLECTION==============================");
            return;
        }

        if (msg instanceof Map<?,?>){
            print("=====================MAP==============================");
            Map map=(Map)msg;

            for ( Object key : map.keySet() ) {
                print(key);
                print(map.get(key));
            }
            print("=====================MAP==============================");
            return;
        }

        System.out.print("\r"+msg);
    }


    static int HOLD_NUM=1000;
    /**
     * buffer console logs until  buffer is full
     * @param msg
     */
    public static void printHOLD(Object msg)
    {
        List<String> lines=new ArrayList<String>();
        if(msg==null)return;
        if (msg instanceof Collection<?>){
            print("=====================COLLECTION==============================");
            ((Collection)( msg)).forEach(msgs->print(msgs));
            print("=====================COLLECTION==============================");
            return;
        }

        if (msg instanceof Map<?,?>){
            print("=====================MAP==============================");
            Map map=(Map)msg;

            for ( Object key : map.keySet() ) {
                print(key);
                print(map.get(key));
            }
            print("=====================MAP==============================");
            return;
        }

        if(lines.size()<HOLD_NUM)
        {
            lines.add("\r"+msg);
        }
        else
        {
            print(lines);
            lines.clear();

        }
    }



}