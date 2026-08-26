package test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class InvokeScriptFunction {
    public static void main(String[] args) throws Exception {
        // ScriptEngineManager manager = new ScriptEngineManager();
        // ScriptEngine engine = manager.getEngineByName("JavaScript");

        // JavaScript code in a String
        // String script = "function hello(name) { print('Hello, ' + name); }";
        // evaluate script
        // engine.eval(script);

        // javax.script.Invocable is an optional interface.
        // Check whether your script engine implements or not!
        // Note that the JavaScript engine implements Invocable interface.
        // Invocable inv = (Invocable) engine;
        // inv.invokeMethod("", "https://developers.google.com/", "helllllllll");

        // invoke the global function named "hello"
        // inv.invokeFunction("hello", "https://www.google.com" );


//        List<String> list = new ArrayList<String>();
//        list.add("start");
//        list.add("https://www.google.com");
//        ProcessBuilder build = new ProcessBuilder(list);
//        build.start();

        String url = "http://www.google.co.in";

        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
               // runtime.exec("xdg-open " + url);
                runtime.exec("x-www-browser " + url);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}