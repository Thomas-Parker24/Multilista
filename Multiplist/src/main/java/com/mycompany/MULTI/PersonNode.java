package com.mycompany.MULTI;

/**
 *
 * @author El Sapo Perro
 */
public class PersonNode {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    
    private String Name;
    private int ID;
    private PersonNode NextNode;
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    
    public String GetName(){
        return this.Name = Name;
    }
    
    public int GetID(){
        return this.ID = ID;
    }
    
    public PersonNode GetNextNode(){
        return this.NextNode;
    }
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    
    public void SetName(String Name){
        this.Name = Name;
    }
    
    public void SetID(int ID){
        this.ID = ID;
    }
    
    public void SetNextNode(PersonNode NextNode){
        this.NextNode = NextNode;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PersonNode(String Name, int ID){
        this.Name = Name;
        this.ID = ID;
    }
    
    //</editor-fold>
}
