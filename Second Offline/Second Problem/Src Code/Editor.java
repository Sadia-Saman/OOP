package com.company;

public class Editor {
    private static Editor editor = new Editor() ;
    private Parser parser;
    private Aesthetics aesthetics;

    private  Editor(){}
    public void set(String string){
        if(string.contains(".py")) {
            parser = new PythonParser("Python");
            aesthetics = new PythonAesthetics();
        }
        else if(string.contains(".cpp")) {
            parser = new CPP_Parser("CPP");
            aesthetics = new CPPAesthetics();
        }
        else if(string.contains(".c")) {
            parser = new CParser("C");
            aesthetics = new CAesthetics();
        }else{
            parser =null;
            aesthetics =null;
        }
    }
    public static Editor getEditor(){
        return editor;
    }

    public void  show() {
        if(parser==null){
            System.out.println("File extension not allowed in this editor :( ");
            return;
        }
        System.out.println("Editor opens "+parser+ " file");
        parser.parse();
        aesthetics.font();
        aesthetics.color();
        aesthetics.style();
    }

}
