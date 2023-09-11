package com.mycompany.MULTI;

/**
 *
 * @author El Sapo Perro
 */
public class TableNode {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    
    private String Name;
    private int Number;
    private TableNode NextNode;
    private PersonNode PersonPointer;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    
    public String GetName(){
        return this.Name;
    }
    
    public int GetID(){
        return this.Number;
    }
    
    public TableNode GetNextNode(){
        return this.NextNode;
    }
    
    public PersonNode GetPersonPointer(){
        return this.PersonPointer;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    
    public void SetName(String Name){
        this.Name = Name;
    }
    
    public void SetNumber(int Number){
        this.Number = Number;
    }
    
    public void SetNextNode(TableNode NextNode){
        this.NextNode = NextNode;
    }
    
    public void SetPersonPointer(PersonNode PersonPointer){
        this.PersonPointer = PersonPointer;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    
    public TableNode(String Name, int Number){
        this.Name = Name;
        this.Number = Number;
        this.NextNode = null;
        this.PersonPointer = null;
    }
    
    //</editor-fold>
}
